package com.example.hoduchieu.sqlite_demo;

/**
 * Created by hoduchieu on 11/25/16.
 */

public class SinhVien {

    int ID;
    String Ten;
    String Email;

    public SinhVien (int ID,String Ten,String Email){
        this.ID = ID;
        this.Ten = Ten;
        this.Email = Email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
