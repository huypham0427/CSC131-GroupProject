package com.example.simplerestapis;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Movies {

    private String title;
    private String year;
    private String ceremony;
    private String category;
    private ArrayList<Award> awards;


    public Movies(String year, String title, String ceremony)
    {
        this.title = title;
        this.year = year;
        this.ceremony = ceremony;
        this.awards = new ArrayList<>();

    }


    public void addAward(Award award){
        awards.add(award);
    }

//    public void getCategory(Award category){
//        awards.add(category);
//    }

    public String getTitle()
    {
        return title;
    }

    public String getYear()
    {
        return year;
    }

    public String getCeremony()
    {
        return ceremony;
    }

    public List<Award> getAwards()
    {
        return awards;
    }

    // Format the output of elements in the apis
    @Override
    public String toString()
    {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", ceremony='" + ceremony + '\'' +
                ", awards=" + awards +
                '}' + "\n";
    }
}
