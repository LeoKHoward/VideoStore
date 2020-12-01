package com.example.videorentalstore.store.video;

public class VideoDetail {

    private final String movieTitle;
    private final String movieDirector;
    private final int movieReleaseYear;
    private final String movieLanguage;
    private final String movieGenre;
    private final int movieRunTime;
    public final int ageCertificate;


    public VideoDetail(String movieTitle, String movieDirector, int movieReleaseYear, String movieLanguage,
                       String movieGenre, int movieRunTime, int ageCertificate) {

        this.movieTitle = movieTitle;
        this.movieDirector = movieDirector;
        this.movieReleaseYear = movieReleaseYear;
        this.movieLanguage = movieLanguage;
        this.movieGenre = movieGenre;
        this.movieRunTime = movieRunTime;
        this.ageCertificate = ageCertificate;

    }


    public String getMovieTitle() {
        return movieTitle;
    }


    public String getMovieDirector() {
        return movieDirector;
    }


    public int getMovieReleaseYear() {
        return movieReleaseYear;
    }


    public String getMovieLanguage() {
        return movieLanguage;
    }


    public String getMovieGenre() {
        return movieGenre;
    }


    public int getMovieRunTime() {
        return movieRunTime;
    }


    public int getAgeCertificate() {
        return ageCertificate;
    }


}
