package com.example.simplerestapis;
//import com.google.gson.annotations.SerializedName;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Categories {

    private String category;
    private String name;
    private boolean winner;

    public Categories(String category, String name, boolean winner)
    {
        this.category = category;
        this.name = name;
        this.winner = winner;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getName()
    {
        return name;
    }

    public boolean isWinner()
    {
        return winner;
    }

//    @SuppressWarnings("unchecked")
//    private ArrayList CategoryList;
//    //@SerializedName("category")
//    private ArrayList mCategory;
//
//    //private String CategoryList;
//    public Categories(String category){
//        //mCategory = category;
//        CategoryList=category;
    }
//}