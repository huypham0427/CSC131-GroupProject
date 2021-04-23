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
    private String film;
    private String Name;


    public Movies(String year, String Name, String ceremony, String film)
    {
        //this.title = title;
        this.year = year;
        this.ceremony = ceremony;
        this.awards = new ArrayList<>();
        this.Name = Name;
        this.film = film;

    }


    public void addAward(Award award){
        awards.add(award);
    }

    public String getFilm(){
        return film;
    }

//    public String getTitle()
//    {
//        return title;
//    }

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
//    @Override
//    public String toString()
//    {
//        return "Movie{ " +
//                "year='" + year + '\'' +
//                ", ceremony='" + ceremony + '\'' +
//                ", awards=" + awards +
//                '}' + "\n";
//    }
}
