package com.example.myframe.welcome.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/4/11.
 */

public class CityList extends DataSupport implements Serializable{

    /**
     * CityName : 安庆公交集团
     * CityCode : 340801
     * IP : 120.209.56.126
     * BS_Port : 4002
     * Socket_Port : 7006
     * Center_X : 117.22
     * Center_Y : 32.71
     */

    private String CityName;
    private String CityCode;
    private String IP;
    private String BS_Port;
    private String Socket_Port;
    private String Center_X;
    private String Center_Y;
    //显示拼音的首字母
    public String letters;

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public String getCityCode() {
        return CityCode;
    }

    public void setCityCode(String CityCode) {
        this.CityCode = CityCode;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getBS_Port() {
        return BS_Port;
    }

    public void setBS_Port(String BS_Port) {
        this.BS_Port = BS_Port;
    }

    public String getSocket_Port() {
        return Socket_Port;
    }

    public void setSocket_Port(String Socket_Port) {
        this.Socket_Port = Socket_Port;
    }

    public String getCenter_X() {
        return Center_X;
    }

    public void setCenter_X(String Center_X) {
        this.Center_X = Center_X;
    }

    public String getCenter_Y() {
        return Center_Y;
    }

    public void setCenter_Y(String Center_Y) {
        this.Center_Y = Center_Y;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }
}
