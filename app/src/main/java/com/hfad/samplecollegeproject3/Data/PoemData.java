package com.hfad.samplecollegeproject3.Data;

import java.util.List;

public class PoemData {

    private List<String> Users;      // time stamp of the poem -?
    private String poemLines;
    private int poemLength;
    private String poemTitle;
    private String Time;
    private String Key;

    public PoemData()
    {

    }

    public PoemData( List<String> Users,String poemLines, int poemLength, String poemTitle,String Time,String Key)
    {
        this.Users=Users;
        this.poemLines=poemLines;
        this.poemLength=poemLength;
        this.poemTitle=poemTitle;
        this.Time=Time;
        this.Key=Key;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public List<String> getUsers() {
        return Users;
    }

    public void setUsers(List<String> users) {
        Users = users;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getPoemLines() {
        return poemLines;
    }

    public void setPoemLines(String poemLines) {
        this.poemLines = poemLines;
    }

    public int getPoemLength() {
        return poemLength;
    }

    public void setPoemLength(int poemLength) {
        this.poemLength = poemLength;
    }

    public String getPoemTitle() {
        return poemTitle;
    }

    public void setPoemTitle(String poemTitle) {
        this.poemTitle = poemTitle;
    }
}
