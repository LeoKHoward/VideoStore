package com.example.videorentalstore.store.members;

import java.time.LocalDate;

public class Member {

    private int memberId;
    private String title;
    private String forename;
    private String surname;
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String postcode;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private LocalDate membershipStartDate;
    private LocalDate membershipEndDate;

    public Member(int memberId, String title, String forename, String surname, String addressLine1, String addressLine2,
                  String town, String postcode, String phoneNumber, LocalDate dateOfBirth,
                  LocalDate membershipStartDate, LocalDate membershipEndDate) {

        this.memberId = memberId;
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.town = town;
        this.postcode = postcode;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.membershipStartDate = membershipStartDate;
        this.membershipEndDate = membershipEndDate;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(LocalDate membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public LocalDate getMembershipEndDate() {
        return membershipEndDate;
    }

    public void setMembershipEndDate(LocalDate membershipEndDate) {
        this.membershipEndDate = membershipEndDate;
    }

}
