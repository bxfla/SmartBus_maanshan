package com.example.myframe.bus.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/4/15.
 */

public class StationListBean extends DataSupport implements Serializable {

    /**
     * beginStation :
     * beginTime :
     * busCode :
     * endStation :
     * endTime :
     * lat : 31.692788333333333
     * lineCode : 1
     * lineName : 1璺�
     * lon : 118.535065
     * maxOrder : 0
     * minOrder : 0
     * pos : 0
     * staDis : 292.27
     * stationCode :
     * stationName : 椹瀺灞变笢绔�
     * stationOrder : 1
     * sxx : 0
     * upDown :
     * upDownName :
     */

    private String beginStation;
    private String beginTime;
    private String busCode;
    private String endStation;
    private String endTime;
    private String lat;
    private String lineCode;
    private String lineName;
    private String lon;
    private int maxOrder;
    private int minOrder;
    private int pos;
    private String staDis;
    private String stationCode;
    private String stationName;
    private int stationOrder;
    private String sxx;
    private String upDown;
    private String upDownName;
    private String cityCode;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getBeginStation() {
        return beginStation;
    }

    public void setBeginStation(String beginStation) {
        this.beginStation = beginStation;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getBusCode() {
        return busCode;
    }

    public void setBusCode(String busCode) {
        this.busCode = busCode;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public int getMaxOrder() {
        return maxOrder;
    }

    public void setMaxOrder(int maxOrder) {
        this.maxOrder = maxOrder;
    }

    public int getMinOrder() {
        return minOrder;
    }

    public void setMinOrder(int minOrder) {
        this.minOrder = minOrder;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getStaDis() {
        return staDis;
    }

    public void setStaDis(String staDis) {
        this.staDis = staDis;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getStationOrder() {
        return stationOrder;
    }

    public void setStationOrder(int stationOrder) {
        this.stationOrder = stationOrder;
    }

    public String getSxx() {
        return sxx;
    }

    public void setSxx(String sxx) {
        this.sxx = sxx;
    }

    public String getUpDown() {
        return upDown;
    }

    public void setUpDown(String upDown) {
        this.upDown = upDown;
    }

    public String getUpDownName() {
        return upDownName;
    }

    public void setUpDownName(String upDownName) {
        this.upDownName = upDownName;
    }
}
