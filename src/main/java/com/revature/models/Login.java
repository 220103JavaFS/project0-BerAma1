package com.revature.models;

import java.util.Objects;

public class Login {
    public String username;
    public String password;
    public String user_Role;
    public int user_Id;

    public Login() {
    }

    public Login(String username, String password, String user_Role, int user_Id) {
        this.username = username;
        this.password = password;
        this.user_Role = user_Role;
        this.user_Id = user_Id;
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

    public String getUser_Role() {
        return user_Role;
    }

    public void setUser_Role(String user_Role) {
        this.user_Role = user_Role;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return user_Id == login.user_Id && Objects.equals(username, login.username) && Objects.equals(password, login.password) && Objects.equals(user_Role, login.user_Role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, user_Role, user_Id);
    }

    @Override
    public String toString() {
        return "Login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user_Role='" + user_Role + '\'' +
                ", user_Id=" + user_Id +
                '}';
    }
}
