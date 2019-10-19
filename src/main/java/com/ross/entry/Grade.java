package com.ross.entry;

public class Grade {
    private Integer grId;

    private String grName;

    public Integer getGrId() {
        return grId;
    }

    public void setGrId(Integer grId) {
        this.grId = grId;
    }

    public String getGrName() {
        return grName;
    }

    public void setGrName(String grName) {
        this.grName = grName == null ? null : grName.trim();
    }

    public Grade() {
    }

    public Grade(Integer grId, String grName) {
        this.grId = grId;
        this.grName = grName;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grId=" + grId +
                ", grName='" + grName + '\'' +
                '}';
    }
}