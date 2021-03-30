package com.example.simplerestapis;

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
        int counter = 0;

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "D:/javaWeb/CSC131-GroupProject/CSC131Project-master/CSC131-main/simple-rest-apis-master/src/KaggleData_the_oscar_award.csv"));
            String line = reader.readLine();
          boolean test = line.contains("True");
            while (line != null) {
                String[] arrOfStr = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
//                for (String a: arrOfStr) System.out.println(a);
                counter++;
                for(String a: arrOfStr)


                    filmYear= arrOfStr[0];
                ceremonyYear = arrOfStr[1];
                ceremony = arrOfStr[2];
                category = arrOfStr[3];
                Name = arrOfStr[4];
                film = arrOfStr[5];
                winner=arrOfStr[6];
                //System.out.println(filmYear);
                //System.out.println(ceremony);
                //System.out.println(ceremonyYear);
                //System.out.println(category);
                //System.out.println(Name);
                //System.out.println(film);
                System.out.println(counter + " " + winner);
                //for (String a: arrOfStr) System.out.println(a);

                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

