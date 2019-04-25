package com.example.myframe.http.bean;

/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class Login {

    /**
     * id : 18
     * name : allen123
     * type : 0
     * createTime : 2018-06-27 10:18:47
     * phoneNumber : 17052732808
     * headPath : http://image.tv188.com/images/member/head_image.jpg
     * tokenId : 4761182680843567127
     */

    private int id;
    private String name;
    private int type;
    private String createTime;
    private long phoneNumber;
    private String headPath;
    private long tokenId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
    }

    public long getTokenId() {
        return tokenId;
    }

    public void setTokenId(long tokenId) {
        this.tokenId = tokenId;
    }
}
