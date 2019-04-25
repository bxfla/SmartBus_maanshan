package com.example.myframe.http.bean;

/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description: 资讯 - 最新  实体
 */

public class ZiXunAll {


    /**
     * categoryName : 篮球资讯
     * createTime : 2018-05-27 11:30:08
     * id : 82831
     * imageUrl : http://image.tv188.com/article/newsfiles/file/basketball/NBA/cavaliers/2018-05-27/cc31788d800bf9b154b1eec46d17fef5.jpg
     * publicDay : 2018-05-26 00:00:00
     * publicTime : 2018-05-26 11:58:00
     * sourceUrl : http://www.ss28.com/basketball/NBA/cavaliers/2018-05-27/48735.html
     * title : 场均.分之人生抬詹姆斯一手!抢七他得先发?
     */

    private String categoryName;
    private String createTime;
    private int id;
    private String imageUrl;
    private String publicDay;
    private String publicTime;
    private String sourceUrl;
    private String title;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPublicDay() {
        return publicDay;
    }

    public void setPublicDay(String publicDay) {
        this.publicDay = publicDay;
    }

    public String getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(String publicTime) {
        this.publicTime = publicTime;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
