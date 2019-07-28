package com.hfad.samplecollegeproject3.Data;

import com.firebase.ui.auth.data.model.User;

public class UserData {

    private String username;
    private String poemlines;
    private int poemlength;
    private String poemtitle;                                   //    private long latitude; private long longitude;
    private String Time;

    public UserData(String poemtitle,String poemlines,int poemlength,String username,String Time){
         this.poemlength=poemlength;
         this.poemtitle=poemtitle;                      // what to do for latitude and longitude -?
         this.poemlines=poemlines;
         this.username=username;
         this.Time=Time;
    }

    public UserData()
    {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPoemlength() {
        return poemlength;
    }

    public void setPoemlength(int poemlength) {
        this.poemlength = poemlength;
    }

    public String getPoemlines() {
        return poemlines;
    }

    public void setPoemlines(String poemlines) {
        this.poemlines = poemlines;
    }


    public String getPoemtitle() {
        return poemtitle;
    }

    public void setPoemtitle(String poemtitle) {
        this.poemtitle = poemtitle;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
