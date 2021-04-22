package com.example.simplerestapis;

//import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class readCSV{


    public static List<Movies> all(){
        String filmYear;
        String ceremonyYear;
        String ceremony;
        String category;
        String Name;
        String film;
        String winner;
        String s;

        int counter = 0;

        ArrayList<Movies> arr = new ArrayList<>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:/Users/Pat/gitbase/CSC131-GroupProject/CSC131Project-master/CSC131-main/simple-rest-apis-master/src/KaggleData_the_oscar_award.csv"));
            String line = reader.readLine();

            while (line != null) {

                String[] arrOfStr = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                counter++;

                if (!arrOfStr[5].equals(""))
                {
                    filmYear = arrOfStr[0];
                    ceremonyYear = arrOfStr[1];
                    ceremony = arrOfStr[2];
                    category = arrOfStr[3];
                    Name = arrOfStr[4];
                    film = arrOfStr[5];
                    winner = arrOfStr[6];

                    Movies object =(new Movies(filmYear, Name, ceremony, film));

                    if (!arr.contains(object)){
                        arr.add(object);
                    }

                    arr.get(arr.indexOf(object)).addAward(new Award(category, Name, Boolean.parseBoolean(winner)));

                }

                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        Collections.sort(filmYear2);
        Collections.sort(ceremonyYear2);
        Collections.sort(ceremony2);
        Collections.sort(category2);
        Collections.sort(Name2);
        Collections.sort(film2);
        Collections.sort(winner2);
        */

//        Collections.sort(arr);
//
//        for(int i = 0; i < arr.size(); i++){
//
//            System.out.print(arr.get(i));
//
//        }
        return arr;
    }

//    public static void main(String[] args) {
//        System.out.print(1);
//
//    }
    public static ArrayList<String> get_Category()
    {
        String category;
        ArrayList<String> arr = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:/Users/Pat/gitbase/CSC131-GroupProject/CSC131Project-master/CSC131-main/simple-rest-apis-master/src/KaggleData_the_oscar_award.csv"));
            String line = reader.readLine();

            while (line != null) {

                String[] arrOfStr = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (!arrOfStr[5].equals(" "))
                {
                    category = arrOfStr[3];
                    arr.add(category);
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(arr);
        return arr;
    }
}



