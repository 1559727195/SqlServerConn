package com.massky.connsqlserver;

import java.io.Serializable;

public class user extends BaseDao<user> implements Serializable {
    private  int id = -1;
    public String username;
    public String password;
    public int usertype = -1;
    public String name;

    public String getResetpwd() {
        return resetpwd;
    }

    public void setResetpwd(String resetpwd) {
        this.resetpwd = resetpwd;
    }

    public String resetpwd;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getUsertype() {
        return usertype;
    }

    public String getName() {
        return name;
    }

}
