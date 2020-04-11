package com.example.tour;


class TourItem {

    private String title;
    private String eventDesc;
    private String location;
    private int image;

    TourItem(String title, String eventDesc, String location, int image) {
        this.title = title;
        this.eventDesc = eventDesc;
        this.location = location;
        this.image = image;
    }

    TourItem(String title, String location, int image) {
        this.title = title;
        this.location = location;
        this.image = image;
    }


    String getTitle() {
        return title;
    }

    String getEventDesc() {
        return eventDesc;
    }

    int getImage() {
        return image;
    }

    String getLocation() {
        return location;
    }
}
