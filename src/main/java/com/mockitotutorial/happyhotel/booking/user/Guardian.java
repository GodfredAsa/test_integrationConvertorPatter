package com.mockitotutorial.happyhotel.booking.user;

public class Guardian {
    private int guardianId;
    private String fullName;
    private String phone;
    private String typeOfWork;
    private String employer;

    public Guardian(int guardianId, String fullName, String phone, String typeOfWork, String employer) {
        this.guardianId = guardianId;
        this.fullName = fullName;
        this.phone = phone;
        this.typeOfWork = typeOfWork;
        this.employer = employer;
    }

    public int getGuardianId() {
        return guardianId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getTypeOfWork() {
        return typeOfWork;
    }

    public String getEmployer() {
        return employer;
    }

    @Override
    public String toString() {
        return "Guardian{" +
                "guardianId=" + guardianId +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", typeOfWork='" + typeOfWork + '\'' +
                ", employer='" + employer + '\'' +
                '}';
    }
}
