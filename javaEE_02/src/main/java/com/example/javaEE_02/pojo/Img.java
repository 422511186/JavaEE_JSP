package com.example.javaEE_02.pojo;

public class Img {
    private String img_info;

    public Img() {
    }

    public Img(String img_info) {
        this.img_info = img_info;
    }

    public String getImg_info() {
        return img_info;
    }

    public void setImg_info(String img_info) {
        this.img_info = img_info;
    }

    @Override
    public String toString() {
        return "Img{" +
                "img_info='" + img_info + '\'' +
                '}';
    }
}
