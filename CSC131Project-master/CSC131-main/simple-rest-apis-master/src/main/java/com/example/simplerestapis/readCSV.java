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
        String[] arrb = new String[10396];

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

                    s = "[" + category + " " + ceremonyYear + " " + ceremony + " " + filmYear + " " + Name + " " + film + " " + winner + "]";
                    //System.out.println(counter + " " + filmYear);
                    //System.out.println(counter + " " + ceremony);
                    //System.out.println(counter + " " +ceremonyYear);
                    //System.out.println(counter + " "+ category);
                    //System.out.println(counter + " "+ Name);
                    //System.out.println(counter + " " + film);
                    //System.out.println(counter + " " + winner);

                    //System.out.println(counter + ". " + filmYear + ", " + ceremonyYear + ", " + ceremony + ", " + category + ", " + Name + ", " + film + ", " + winner);

                    arrb [counter - 1] = s;
                }
                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Arrays.sort(arrb);
        for( int i = 0; i <= 10396; i++){
            System.out.println(arrb[i].toString());
        }
        //System.out.println(Arrays.toString(arrb));
    }
}



