package com.example.matterport;

public class Fish {
    private String name;
    private String info;
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Fish(String catfish, int source, String s) {
        this.name = catfish;
        this.image = source;
        this.info = s;
    }

    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
