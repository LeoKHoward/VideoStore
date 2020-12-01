package com.example.videorentalstore.store;

import com.example.videorentalstore.store.members.Member;
import com.example.videorentalstore.store.video.Video;

import java.time.LocalDate;
import java.time.Period;

public class MemberVideoRental {

    private Member member;
    private Video video;
    private LocalDate dateOfRental;
    private int daysRentedFor;


    public MemberVideoRental(Member member, Video video, LocalDate dateOfRental, int daysRentedFor) {
        this.member = member;
        this.video = video;
        this.dateOfRental = dateOfRental;
        this.daysRentedFor = daysRentedFor;
        checkIfCustomerIsOldEnough();
        video.setAvailable(false);
    }

    private void checkIfCustomerIsOldEnough() {

        Period period = Period.between(member.getDateOfBirth(), LocalDate.now());

        if (period.getYears() < video.getVideoDetail().getAgeCertificate()) {
            throw new RuntimeException("You are too young to rent this movie!");
        }
    }

    private void checkThatMembershipIsInDate() {

    }


    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public LocalDate getDateOfRental() {
        return dateOfRental;
    }

    public void setDateOfRental(LocalDate dateOfRental) {
        this.dateOfRental = dateOfRental;
    }

    public int getDaysRentedFor() {
        return daysRentedFor;
    }

    public void setDaysRentedFor(int daysRentedFor) {
        this.daysRentedFor = daysRentedFor;
    }

    public LocalDate getDateOfReturn() {
        return dateOfRental.plusDays(daysRentedFor);
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
    }

}
