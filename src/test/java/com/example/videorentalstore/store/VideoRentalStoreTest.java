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

    private MemberVideoRental testMemberVideoRental;


    private void setUpMasterTestData(VideoRentalStore videoRentalStore) {

        setUpMemberTestData(videoRentalStore);

        setUpVideoTestData(videoRentalStore);

    }

    private void setUpMemberTestData(VideoRentalStore videoRentalStore) {
        LocalDate memberDateOfBirth = LocalDate.of(1990, 4, 23);

        LocalDate membershipStartDate = LocalDate.of(2011, 12, 25);

        LocalDate membershipEndDate = LocalDate.of(2021, 12, 25);

        testMember = new Member(1001, "Mr", "Testy", "Test",
                "2 Test House", "Test Street", "Test Town", "XX10 XXX",
                "07123456789", memberDateOfBirth, membershipStartDate, membershipEndDate);

        videoRentalStore.addMember(testMember);
    }

    private void setUpVideoTestData(VideoRentalStore videoRentalStore) {
        testVideoDetail = new VideoDetail("Terminator", "James Cameron",
                1984, "English", "Action", 108, 18);

        testVideo = new Video(testVideoDetail, true, 5.99);

        videoRentalStore.addVideo(testVideo);
    }

    private void setUpMemberVideoRentalTestData(VideoRentalStore videoRentalStore) {
        testMemberVideoRental = new MemberVideoRental(testMember, testVideo,
                LocalDate.now().minusDays(12), 10);

        videoRentalStore.addMemberVideoRental(testMemberVideoRental);
    }

    @Test
    void testFindAllAvailableVideos() {
        VideoRentalStore testVideoRentalStore = new VideoRentalStore();

        setUpMasterTestData(testVideoRentalStore);

        List<Video> allAvailableVideos = testVideoRentalStore.findAllAvailableVideos();

        assertThat(allAvailableVideos.get(0)).isEqualTo(testVideo);

    }

    @Test
    void testFindAllMembers() {
        VideoRentalStore testVideoRentalStore = new VideoRentalStore();

        setUpMasterTestData(testVideoRentalStore);

        List<Member> allMembers = testVideoRentalStore.findAllMembers();

        assertThat(allMembers.get(0)).isEqualTo(testMember);

    }

    @Test
    void testFindVideosWithCertainWordInMovieTitle() {
        VideoRentalStore testVideoRentalStore = new VideoRentalStore();

        setUpMasterTestData(testVideoRentalStore);

        List<Video> searchResults = testVideoRentalStore.findVideosWithCertainWordInMovieTitle("terminator");

        assertThat(searchResults.get(0).getVideoDetail().getMovieTitle()).isEqualTo(testVideoDetail.getMovieTitle());
    }

    @Test
    void testFindVideosByGenre() {
        VideoRentalStore testVideoRentalStore = new VideoRentalStore();

        setUpMasterTestData(testVideoRentalStore);

        List<Video> genreSearchResultsAction = testVideoRentalStore.findVideosByGenre("action");

        assertThat(genreSearchResultsAction.get(0).getVideoDetail().getMovieTitle()).
                isEqualTo(testVideoDetail.getMovieTitle());
    }

    @Test
    void testNoVideosFoundWithMatchingGenre() {
        VideoRentalStore testVideoRentalStore = new VideoRentalStore();

        setUpMasterTestData(testVideoRentalStore);

        List<Video> genreSearchResultsComedy = testVideoRentalStore.findVideosByGenre("comedy");

        assertThat(genreSearchResultsComedy).isEmpty();
    }

    @Test
    void testFindOverdueRentals() {
        VideoRentalStore testVideoRentalStore = new VideoRentalStore();

        setUpMasterTestData(testVideoRentalStore);

        setUpMemberVideoRentalTestData(testVideoRentalStore);

        List<MemberVideoRental> testOverdueRentals = testVideoRentalStore.findOverdueRentals();

        assertThat(testOverdueRentals.get(0).getVideo().getVideoDetail().getMovieDirector()).isEqualTo("James Cameron");
    }

    @Test
    void testCompleteMemberVideoRental() {

        VideoRentalStore testVideoRentalStore = new VideoRentalStore();

        setUpMasterTestData(testVideoRentalStore);

        setUpMemberVideoRentalTestData(testVideoRentalStore);

        try {
            testVideoRentalStore.completeMemberVideoRental(testMemberVideoRental);
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("This video is late!");
        }

    }
}