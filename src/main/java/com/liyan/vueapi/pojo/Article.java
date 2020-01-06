package com.liyan.vueapi.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Article {
    private Integer uId;
    private Integer aId;
    private Integer cId;
    private String title;
    private String desc;
    private String content;
    private Integer likes;
    private Integer views;
    private int isTop;
    private Date createTime;
    private Date updateTime;

    private User user=new User();
    private Category category=new Category();


    public Article(Integer uId, Integer cId, String title, String desc, String content, int isTop, Date createTime) {
        this.uId = uId;
        this.cId = cId;
        this.title = title;
        this.desc = desc;
        this.content = content;
        this.isTop = isTop;
        this.createTime = createTime;
    }

    public Article() {
    }

    public int getIsTop() {
        return isTop;
    }



    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
