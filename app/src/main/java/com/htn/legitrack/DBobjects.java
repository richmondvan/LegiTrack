package com.htn.legitrack;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class DBobjects {
    public String id; // Open states id, never display!
    public String comments; //comments from user
    public int score; //score 1-5

    public DBobjects() {
        comments = "";
        id = "";
        score = 99;
    }

    public DBobjects(DBobjects myObj) {
        id = myObj.id;
        comments = myObj.comments;
        score = myObj.score;
    }

    public DBobjects(String ID, String COMMENTS, int SCORE) {
        id = ID;
        comments = COMMENTS;
        score = SCORE;
    }

    public DBobjects(Bill myBill) {
        id = myBill.id;
    }

    public void setComments(String COMMENTS) {
        this.comments = COMMENTS;
    }

    public String getComments() {
        return this.comments;
    }

    public void setScore(int SCORE) {
        this.score = SCORE;
    }

    public int getScore() {
        return this.score;
    }

    public void setId(String ID) {
        this.id = ID;
    }

    public String getId() {
        return this.id;
    }
}
