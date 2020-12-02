package com.example.videorentalstore;

import com.example.videorentalstore.store.MemberVideoRental;
import com.example.videorentalstore.store.VideoRentalStore;
import com.example.videorentalstore.store.members.Member;
import com.example.videorentalstore.store.video.Video;
import com.example.videorentalstore.store.video.VideoDetail;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VideoRentalStoreApplication {

    public static void main(String[] args) {

        VideoRentalStore videoRentalStore = new VideoRentalStore();


        // Hardcode member details
        Member newMember = memberDetails();

        // Hardcode video details
        Video newVideo = videoDetails();


        // Add details of member from above to list of Members
        videoRentalStore.addMember(newMember);

        // Add details of video from above to list of Videos
        videoRentalStore.addVideo(newVideo);



        /* Create new object of Video and search for a specific word within the movie title available in list of Videos
        Also, if there are multiple videos of the same movie, this picks just the first one
        rather than returning them all
         */
//        Video rentFirstVideoInStore =
//                videoRentalStore.findVideosWithCertainWordInMovieTitle("Terminator").get(0);

        /*
        Uses hardcoded member and video details from above and sets them along with a rental date and days rented for
        Uncomment line below to test list of videos containing search word
         */
//        MemberVideoRental memberVideoRental = memberVideoRentalDetails(newMember, rentFirstVideoInStore);




        /* Create new object of Video and search for a specific genre available in list of Videos
        Also, if there are multiple videos of the same movie, this picks just the first one
        rather than returning them all
         */
        Video findFirstActionMovieInStore = videoRentalStore.findVideosByGenre("action").get(0);

        /*
        Uses hardcoded member and video details from above and sets them along with a rental date and days rented for
         */
        MemberVideoRental memberVideoRental = memberVideoRentalDetails(newMember, findFirstActionMovieInStore);


//        List<Video> availableVideos = videoRentalStore.findAllAvailableVideos();
//        MemberVideoRental memberVideoRental = memberVideoRentalDetails(newMember, (Video) availableVideos);

        // Adds hardcoded rental details from above to MemberVideoRental list
        videoRentalStore.addMemberVideoRental(memberVideoRental);


        // Finds out if video is meant to be returned by today's date and if so adds it to list of overdueRentals
        List<MemberVideoRental> overdueRentals = videoRentalStore.findOverdueRentals();

        // Prints out list of overdueRentals
        System.out.println("OVERDUE: " + overdueRentals);


        System.out.println("\n-----MEMBER DETAILS----" +
                "\nMEMBER ID: " + newMember.getMemberId() +
                "\nNAME: " + newMember.getTitle() + " " + newMember.getForename() + " " + newMember.getSurname() +
                "\nADDRESS: " + newMember.getAddressLine1() + ", " + newMember.getAddressLine2() + ", "
                + newMember.getTown() + ", " + newMember.getPostcode() +
                "\nPHONE NUMBER: " + newMember.getPhoneNumber() +
                "\nDOB: " + newMember.getDateOfBirth() +
                "\nMEMBERSHIP START: " + newMember.getMembershipStartDate() +
                "\nMEMBERSHIP END: " + newMember.getMembershipEndDate());

        System.out.println("\n\n-----VIDEO DETAILS----" +
                "\nMOVIE TITLE: " + newVideo.getVideoDetail().getMovieTitle() +
                "\nMOVIE DIRECTOR: " + newVideo.getVideoDetail().getMovieDirector() +
                "\nMOVIE RELEASE YEAR: " + newVideo.getVideoDetail().getMovieReleaseYear() +
                "\nMOVIE LANGUAGE: " + newVideo.getVideoDetail().getMovieLanguage() +
                "\nMOVIE GENRE: " + newVideo.getVideoDetail().getMovieGenre() +
                "\nMOVIE RUN TIME: " + newVideo.getVideoDetail().getMovieRunTime() + " minutes" +
                "\nMOVIE AGE CERTIFICATE: " + newVideo.getVideoDetail().getAgeCertificate() +
                "\nAVAILABLE TO RENT: " + newVideo.getAvailable() +
                "\nRENTAL COST: £" + newVideo.getRentalPrice());
//        Rental price is always set for 10 days? Maybe price per day instead?

        System.out.println("\n\n-----RENTAL DETAILS----" +
                "\nDATE OF RENTAL: " + memberVideoRental.getDateOfRental() +
                "\nDAYS RENTED FOR: " + memberVideoRental.getDaysRentedFor() +
                "\nDATE OF RETURN: " + memberVideoRental.getDateOfReturn());

    }


    private static MemberVideoRental memberVideoRentalDetails(Member newMember, Video newVideo) {

        return new MemberVideoRental(newMember, newVideo, LocalDate.now().minusDays(12),
                10);
    }

    private static Video videoDetails() {
        VideoDetail newVideoDetail = new VideoDetail("Terminator", "James Cameron",
                1984, "English", "Action", 108, 18);


        return new Video(newVideoDetail, false, 5.99);
    }

    private static Member memberDetails() {

        LocalDate memberDateOfBirth = LocalDate.of(1990, 4, 23);

        LocalDate membershipStartDate = LocalDate.of(2011, 12, 25);

        LocalDate membershipEndDate = LocalDate.of(2021, 12, 25);


        return new Member(1001, "Mr", "Testy", "Test",
                "2 Test House", "Test Street", "Test Town", "XX10 XXX",
                "07123456789", memberDateOfBirth, membershipStartDate, membershipEndDate);


    }


}
