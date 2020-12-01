package com.example.videorentalstore.store;

import com.example.videorentalstore.store.members.Member;
import com.example.videorentalstore.store.video.Video;
import com.example.videorentalstore.store.video.VideoDetail;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VideoRentalStoreTest {

    private Video testVideo;

    private Member testMember;

    private VideoDetail testVideoDetail;

    private void setUpMemberTestData(VideoRentalStore videoRentalStore) {
        LocalDate dateOfBirthMember1 = LocalDate.of(1990, 4, 23);

        LocalDate membershipStartDateMember1 = LocalDate.of(2011, 12, 25);

        LocalDate membershipEndDateMember1 = LocalDate.of(2021, 12, 25);

        testMember = new Member(1001, "Mr", "Testy", "Test",
                "2 Test House", "Test Street", "Test Town", "XX10 XXX",
                "07123456789", dateOfBirthMember1, membershipStartDateMember1, membershipEndDateMember1);

        videoRentalStore.addMember(testMember);
    }

    private void testSetUpVideoTestData(VideoRentalStore videoRentalStore) {
        testVideoDetail = new VideoDetail("Terminator", "James Cameron",
                1984, "English", "Action", 108, 18);

        testVideo = new Video(testVideoDetail, true, 5.99);

        videoRentalStore.addVideo(testVideo);
    }

    private void testSetUpMemberVideoRentalTestData(VideoRentalStore videoRentalStore) {
        MemberVideoRental testMemberVideoRental = new MemberVideoRental(testMember, testVideo, LocalDate.now().minusDays(12),
                10);

        videoRentalStore.addMemberVideoRental(testMemberVideoRental);
    }

    @Test
    void testFindAllAvailableVideos() {
        VideoRentalStore testVideoRentalStore = new VideoRentalStore();

        testSetUpVideoTestData(testVideoRentalStore);

        List<Video> allAvailableVideos = testVideoRentalStore.findAllAvailableVideos();

        assertThat(allAvailableVideos.get(0)).isEqualTo(testVideo);


    }

    @Test
    void testFindAllMembers() {
        VideoRentalStore testVideoRentalStore = new VideoRentalStore();

        setUpMemberTestData(testVideoRentalStore);

        List<Member> allMembers = testVideoRentalStore.findAllMembers();

        assertThat(allMembers.get(0)).isEqualTo(testMember);


    }

    @Test
    void testFindVideosWithCertainWordInMovieTitle() {
        VideoRentalStore testVideoRentalStore = new VideoRentalStore();

        testSetUpVideoTestData(testVideoRentalStore);

        List<Video> searchResults = testVideoRentalStore.findVideosWithCertainWordInMovieTitle("terminator");

        assertThat(searchResults.get(0).getVideoDetail().getMovieTitle()).isEqualTo(testVideoDetail.getMovieTitle());
    }

    @Test
    void testFindVideosByGenre() {
        VideoRentalStore testVideoRentalStore = new VideoRentalStore();

        testSetUpVideoTestData(testVideoRentalStore);

        List<Video> genreSearchResultsAction = testVideoRentalStore.findVideosByGenre("action");

        assertThat(genreSearchResultsAction.get(0).getVideoDetail().getMovieTitle()).
                isEqualTo(testVideoDetail.getMovieTitle());
    }

    @Test
    void testNoVideosFoundWithMatchingGenre() {
        VideoRentalStore testVideoRentalStore = new VideoRentalStore();

        testSetUpVideoTestData(testVideoRentalStore);

        List<Video> genreSearchResultsComedy = testVideoRentalStore.findVideosByGenre("comedy");

        assertThat(genreSearchResultsComedy).isEmpty();
    }

    @Test
    void testFindOverdueRentals() {
        VideoRentalStore testVideoRentalStore = new VideoRentalStore();

        testSetUpVideoTestData(testVideoRentalStore);

        setUpMemberTestData(testVideoRentalStore);

        testSetUpMemberVideoRentalTestData(testVideoRentalStore);

        List<MemberVideoRental> testOverdueRentals = testVideoRentalStore.findOverdueRentals();

        assertThat(testOverdueRentals.get(0).getVideo().getVideoDetail().getMovieDirector()).isEqualTo("James Cameron");
    }

    @Test
    void addMember() {
    }

    @Test
    void addVideo() {
    }

    @Test
    void addMemberVideoRental() {
    }
}