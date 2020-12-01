package com.example.videorentalstore.store;


import com.example.videorentalstore.store.members.Member;
import com.example.videorentalstore.store.video.Video;
import com.example.videorentalstore.store.video.VideoDetail;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class VideoRentalStore {

    List<Video> videos = new LinkedList<>();
    List<Member> members = new LinkedList<>();
    List<MemberVideoRental> memberVideoRentals = new LinkedList<>();

    public List<Video> findAllAvailableVideos() {
        List<Video> availableVideos = new LinkedList<>();
        for (Video video : videos) {
            if (video.getAvailable()) {
                availableVideos.add(video);
            }
        }
        return availableVideos;
    }

    public List<Member> findAllMembers() {
        List<Member> allMembers = new LinkedList<>();

        for (Member member : members) {
            if (member.getForename() != null) {
                allMembers.add(member);
            }
        }
        return allMembers;
    }

    public List<Video> findVideosWithCertainWordInMovieTitle(String searchWord) {
        List<Video> searchResults = new LinkedList<>();
        Set<VideoDetail> alreadyFoundVideoDetails = new HashSet<>();

        for (Video video : videos) {
            if (!alreadyFoundVideoDetails.contains(video.getVideoDetail())) {
                if (video.getVideoDetail().getMovieTitle().toUpperCase().contains(searchWord.toUpperCase())) {
                    searchResults.add(video);
                    alreadyFoundVideoDetails.add(video.getVideoDetail());
                }
            }
        }
        return searchResults;
    }

    public List<Video> findVideosByGenre(String genreSearchWord) {
        List<Video> genreSearchResults = new LinkedList<>();
        Set<VideoDetail> alreadyFoundVideoDetails = new HashSet<>();

        for (Video video : videos) {
            if (!alreadyFoundVideoDetails.contains(video.getVideoDetail())) {
                if (video.getVideoDetail().getMovieGenre().toUpperCase().contains(genreSearchWord.toUpperCase())) {
                    genreSearchResults.add(video);
                    alreadyFoundVideoDetails.add(video.getVideoDetail());
                }
            }
        }
        return genreSearchResults;
    }

    public List<MemberVideoRental> findOverdueRentals() {
        List<MemberVideoRental> overdueRentals = new LinkedList<>();

        for (MemberVideoRental memberVideoRental : memberVideoRentals) {
            if (memberVideoRental.getDateOfReturn().isBefore(LocalDate.now())) {
                overdueRentals.add(memberVideoRental);
            }
        }
        return overdueRentals;
    }



    public void addMember(Member member) {
        members.add(member);
    }

    public void addVideo(Video video) {
        videos.add(video);
    }

    public void addMemberVideoRental(MemberVideoRental memberVideoRental) {
        memberVideoRentals.add(memberVideoRental);
    }


}
