package com.mockitotutorial.happyhotel.booking;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import java.time.LocalDate;
import java.util.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class Sample01UnitTesting {

	@InjectMocks private BookingService bookingService;
	
	@Mock private PaymentService paymentServiceMock;
	
	@Mock private RoomService roomServiceMock;
	
	@Spy private BookingDAO bookingDAOMock;
	
	@Mock private MailSender mailSenderMock;
	
	@Captor private ArgumentCaptor<Double> argumentCaptor;

	@Test
	void should_PayCorrectPrice_When_InputOK() {
		// given
		BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2020, 1, 1),
				LocalDate.of(2020, 1, 5), 2, true);
		
		// when
		bookingService.makeBooking(bookingRequest);		
		
		// then
		verify(paymentServiceMock, times(1)).pay(eq(bookingRequest), argumentCaptor.capture());
		double capturedArgument = argumentCaptor.getValue();
		
		assertEquals(400.0, capturedArgument);
	}
	
	@Test
	void should_PayCorrectPrices_When_MultipleCalls() {
		// given
		BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2020, 1, 1),
				LocalDate.of(2020, 1, 5), 2, true);
		BookingRequest bookingRequest2 = new BookingRequest("1", LocalDate.of(2020, 1, 1),
				LocalDate.of(2020, 1, 2), 2, true);
		List<Double> expectedPrices = Arrays.asList(400.0, 100.0);
		
		// when
		bookingService.makeBooking(bookingRequest);		
		bookingService.makeBooking(bookingRequest2);	
		
		// then
		verify(paymentServiceMock, times(2)).pay(any(), argumentCaptor.capture());
		List<Double> capturedArgumentPrices = argumentCaptor.getAllValues();
		
		assertEquals(expectedPrices, capturedArgumentPrices);
	}
		

}
