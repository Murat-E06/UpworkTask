package com.merge.pages;

import java.util.ArrayList;

public class BasePage {

    //This ArrayList contains text of Google search results
    //private access modifier used for encapsulation
    private ArrayList<String> googleResult=new ArrayList<>();


    //This ArrayList contains text of Google search results
    //private access modifier used for encapsulation
    private ArrayList<String> bingResult = new ArrayList<>();


    //This method returns ArrayList of Google results
    //public access modifier for getter and setter
    public ArrayList<String> getGoogleResult() {
        return googleResult;
    }

    //This method sets ArrayList of Google results

    public void setGoogleResult(ArrayList<String> googleResult) {
        this.googleResult = googleResult;
    }

    //This method returns ArrayList of Bing results
    //public access modifier for getter and setter
    public ArrayList<String> getBingResult() {
        return bingResult;
    }

    //This method sets ArrayList of Bing results
    public void setBingResult(ArrayList<String> bingResult) {
        this.bingResult = bingResult;
    }
}
