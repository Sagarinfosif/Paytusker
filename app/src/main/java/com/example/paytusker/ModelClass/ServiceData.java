package com.example.paytusker.ModelClass;

public class ServiceData {

    String title;
    int image;

    public ServiceData(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public ServiceData() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

