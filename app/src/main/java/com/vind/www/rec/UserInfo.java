package com.vind.www.rec;

/**
 * Created by VIND on 2016-11-07.
 */

public class UserInfo {
    private String name;
    private String phone;
    private String birth;
    private String major;
    private String stdID;

    public UserInfo() {
        //기본 생성자
    }

    public UserInfo(String name, String phone, String birth, String major, String stdID){
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.major = major;
        this.stdID = stdID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStdID() {
        return stdID;
    }

    public void setStdID(String stdID) {
        this.stdID = stdID;
    }

}
