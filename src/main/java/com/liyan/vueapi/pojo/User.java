package com.liyan.vueapi.pojo;

public class User {
    private Integer id;

    private Integer rid;

    private String username;

    private String password;

    private String phone;

    private String email;

    private Role role;


    public User(String username, String password, String phone, String email) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public User(Integer rid, String username, String password, String phone, String email) {
        this.rid = rid;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public User(Integer id, Integer rid, String username, String phone, String email, Role role) {
        this.id = id;
        this.rid = rid;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
