package com.example.simplerestapis;
//import com.google.gson.annotations.SerializedName;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Categories {
    @SuppressWarnings("unchecked")
    private ArrayList CategoryList;
    //@SerializedName("category")
    private ArrayList mCategory;

    //private String CategoryList;
    public Categories(String category){
        //mCategory = category;
        CategoryList=category;
    }
}