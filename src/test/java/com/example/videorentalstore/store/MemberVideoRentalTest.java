package com.example.videorentalstore.store;

import com.example.videorentalstore.store.members.Member;
import com.example.videorentalstore.store.video.Video;
import com.example.videorentalstore.store.video.VideoDetail;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberVideoRentalTest {

    private Video testVideo;

    private Member testMember;

    private void setUpMemberTestData(Integer memberDateOfBirthYear) {
        LocalDate memberDateOfBirth = LocalDate.of(memberDateOfBirthYear, 4, 23);

        LocalDate membershipStartDate = LocalDate.of(2011, 12, 25);

        LocalDate membershipEndDate = LocalDate.of(2019, 12, 25);

        testMember = new Member(1001, "Mr", "Testy", "Test",
                "2 Test House", "Test Street", "Test Town", "XX10 XXX",
                "07123456789", memberDateOfBirth, membershipStartDate, membershipEndDate);

    }

    private void setUpVideoTestData() {
        VideoDetail testVideoDetail = new VideoDetail("Terminator", "James Cameron",
                1984, "English", "Action", 108, 18);

        testVideo = new Video(testVideoDetail, true, 5.99);

    }


    @Test
    void testCheckMessageIsThrownWhenMemberIsTooYoungToRentMovie() {

        setUpMemberTestData(2010);

        setUpVideoTestData();

        try {
            new MemberVideoRental(testMember, testVideo, LocalDate.now(), 3);
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("You are too young to rent this movie!");
        }

    }

    @Test
    void testCheckMessageIsThrownWhenMembershipIsOutOfDate() {

        setUpMemberTestData(1990);

        setUpVideoTestData();

        try {
            new MemberVideoRental(testMember, testVideo, LocalDate.now(), 3);
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("Your membership has expired!");
        }

    }
}