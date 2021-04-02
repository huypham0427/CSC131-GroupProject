package com.example.simplerestapis;
import java.util.*;

import java.io.*;
public class readCSV{
    //year_film,year_ceremony,ceremony,category,name,film,winner

    public static void main(String args[]) {
        String filmYear;
        String ceremonyYear;
        String ceremony;
        String category;
        String Name;
        String film;
        String winner;
        String s;

        int counter = 0;

        ArrayList<String> filmYear2 = new ArrayList<String>();
        ArrayList<String> ceremonyYear2 = new ArrayList<String>();
        ArrayList<String> ceremony2 = new ArrayList<String>();
        ArrayList<String> category2 = new ArrayList<String>();
        ArrayList<String> Name2 = new ArrayList<String>();
        ArrayList<String> film2 = new ArrayList<String>();
        ArrayList<String> winner2 = new ArrayList<String>();


        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:/Users/Pat/gitbase/CSC131-GroupProject/CSC131Project-master/CSC131-main/simple-rest-apis-master/src/KaggleData_the_oscar_award.csv"));
            String line = reader.readLine();

            while (line != null) {

                String[] arrOfStr = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                counter++;

                if (!arrOfStr[5].equals(" "))
                {
                    filmYear = arrOfStr[0];
                    ceremonyYear = arrOfStr[1];
                    ceremony = arrOfStr[2];
                    category = arrOfStr[3];
                    Name = arrOfStr[4];
                    film = arrOfStr[5];
                    winner = arrOfStr[6];

                    //s = category + " " + ceremonyYear + " " + ceremony + " " + filmYear + " " + Name + " " + film + " " + winner  + "\n";
                    //System.out.println(counter + " " + filmYear);
                    //System.out.println(counter + " " + ceremony);
                    //System.out.println(counter + " " +ceremonyYear);
                    //System.out.println(counter + " "+ category);
                    //System.out.println(counter + " "+ Name);
                    //System.out.println(counter + " " + film);
                    //System.out.println(counter + " " + winner);

                    //System.out.println(counter + ". " + filmYear + ", " + ceremonyYear + ", " + ceremony + ", " + category + ", " + Name + ", " + film + ", " + winner);

                    filmYear2.add(filmYear);
                    ceremonyYear2.add(ceremonyYear);
                    ceremony2.add(ceremony);
                    category2.add(category);
                    Name2.add(Name);
                    film2.add(film);
                    winner2.add(winner);


                }

                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(filmYear2);
        Collections.sort(ceremonyYear2);
        Collections.sort(ceremony2);
        Collections.sort(category2);
        Collections.sort(Name2);
        Collections.sort(film2);
        Collections.sort(winner2);

        System.out.println(category2.get(2));
    }
}



