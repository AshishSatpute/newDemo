package com.example.andriod.myapplication;


public class User {

    private String id;
    private String name;
    private String email;
    private String gender;
    private Contact contact;
    private String mobile;
    private String home;
    private String office;


    public User(){

    }


    public User(String id, String name, String email, String gender, String mobile, String home, String office) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.home = home;
        this.office = office;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

}
