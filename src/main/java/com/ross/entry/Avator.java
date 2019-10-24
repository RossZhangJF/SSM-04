package com.ross.entry;

import java.io.Serializable;

public class Avator implements Serializable {
    private Integer imgId;
    private String imgUrl;
    private Integer stuId;

    public Avator(Integer imgId, String imgUrl, Integer stuId) {
        this.imgId = imgId;
        this.imgUrl = imgUrl;
        this.stuId = stuId;
    }

    public Avator() {
    }

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    @Override
    public String toString() {
        return "Avator{" +
                "imgId=" + imgId +
                ", imgUrl='" + imgUrl + '\'' +
                ", stuId=" + stuId +
                '}';
    }
}
