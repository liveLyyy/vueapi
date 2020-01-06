package com.liyan.vueapi.pojo;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String id;
    private String parentId;
    private String text;
    private String url;
    private String level;
    private List<Menu> children;


    public Menu(String id, String parentId, String text, String url, String level) {
        this.id = id;
        this.parentId = parentId;
        this.text = text;
        this.url = url;
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
