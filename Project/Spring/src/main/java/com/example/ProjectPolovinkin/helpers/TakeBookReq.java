package com.example.ProjectPolovinkin.helpers;

public class TakeBookReq {

    private Integer days;
    private Long userInfo;

    public void setSomeInfo(Long userInfo) {
        this.userInfo = userInfo;
    }



    public Integer getDays() {
        return days;
    }

    public Long getUserInfo() {
        return userInfo;
    }

    @Override
    public String toString() {
        return "TakeBookReq{" +
                " days=" + days +
                ", someInfo=" + userInfo +
                '}';
    }


    public void setDays(Integer days) {
        this.days = days;
    }
}
