package com.mockitotutorial.happyhotel.booking.user;
import java.time.LocalDate;

public class User{
    private int userId;
    private String firstname;
    private String lastname;
    private String address;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private Guardian guardian;

    public User() {
    }

    public User(int userId, String firstname, String lastname, String address, String phoneNumber, LocalDate dateOfBirth, Guardian guardiang) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.guardian = guardian;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }


    public Guardian getGuardiang() {
        return guardian;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", guardian=" + guardian +
                '}';
    }
}
