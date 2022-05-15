package com.mockitotutorial.happyhotel.booking.user;

public class UserRequestDTO{

    private String firstname;
    private String lastname;
    private String address;
    private String guardian;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String firstname, String lastname, String address, String guardian) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.guardian = guardian;
    }

    public UserRequestDTO convert(User user) {
       firstname  = user.getFirstname();
       lastname = user.getLastname();
       address = user.getAddress();
       guardian = user.getGuardiang().getFullName();
       return new UserRequestDTO(firstname, lastname, address, guardian);
    }

    @Override
    public String toString() {
        return "UserRequestDTO{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", guardian='" + guardian + '\'' +
                '}';
    }
}
