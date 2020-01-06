package com.liyan.vueapi.pojo;

public class Role {
    private Integer rid;
    private String rolename;

    public Role(Integer rid, String rolename) {
        this.rid = rid;
        this.rolename = rolename;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
