package com.cvent.foodflick.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import java.util.List;

@Embeddable
public class YelpMetaData {
    private String yelp_id;
    private String name;
    private int rating;
    private String address;
    private String url;
    private double latitude;
    private double longitude;
    private String price;
    private String image_url;
    @ElementCollection
    private List<String> categories;
    private int review_count;
    private double distance;
    @ElementCollection
    private List<OpenHours> business_hours;
    private String stars_url;
    @ElementCollection
    private List<String> transactions;

    public YelpMetaData() {
    }

    public String getYelp_id() {
        return yelp_id;
    }

    public void setYelp_id(String yelp_id) {
        this.yelp_id = yelp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public int getReview_count() {
        return review_count;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<OpenHours> getBusiness_hours() {
        return business_hours;
    }

    public void setBusiness_hours(List<OpenHours> business_hours) {
        this.business_hours = business_hours;
    }

    public String getStars_url() {
        return stars_url;
    }

    public void setStars_url(String stars_url) {
        this.stars_url = stars_url;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

}