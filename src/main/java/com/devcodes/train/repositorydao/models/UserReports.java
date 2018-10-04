package com.devcodes.train.repositorydao.models;

public class UserReports {

    private Integer id;
    private String username;
    private String fullname;
    private String roles;

    public UserReports(Integer id, String username, String fullname, String roles) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.roles = roles;
    }

    public UserReports() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserReports{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
