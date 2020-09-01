package com.example.myapplication8.JavaBean;

import cn.bmob.v3.BmobObject;

public class Person extends BmobObject {
    private int id;
    private String name;
    private String company;
    private String department;
    private String position;
    private String phonenumber;
    private String mail;
    private String fax;
    private String website;
    private String address;
    public void setId(int id){this.id=id;}

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getName() {
        return name;
    }


    public String getCompany() {
        return company;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMail() {
        return mail;
    }

    public String getFax() {
        return fax;
    }

    public String getWebsite() {
        return website;
    }


    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPosition(String position) { return position; }

    public int getId(){return id;}
}
