package com.example.videorentalstore.store.video;

public class Video {

    private VideoDetail videoDetail;
    private boolean available;
    private double rentalPrice;


    public Video(VideoDetail videoDetail, boolean available, double rentalPrice) {
        this.videoDetail = videoDetail;
        this.available = available;
        this.rentalPrice = rentalPrice;

    }


    public VideoDetail getVideoDetail() {
        return videoDetail;
    }

    public void setVideoDetail(VideoDetail videoDetail) {
        this.videoDetail = videoDetail;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

}
