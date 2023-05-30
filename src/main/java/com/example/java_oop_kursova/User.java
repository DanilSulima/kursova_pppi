package com.example.java_oop_kursova;

public class User {
    private String first_name;
    private String last_name;
    private String username;
    private String Password;
    private String Gender;

    public User(String first_name, String last_name, String username, String password, String gender) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        Password = password;
        Gender = gender;
    }

    public User() {}

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
