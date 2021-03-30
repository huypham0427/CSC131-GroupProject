package com.example.simplerestapis.models;

public class StringTest {
    public static void main(String args[])
    {
        String str = "2019,2020,92,SOUND EDITING,Matthew Wood and David Acord,Star Wars: The Rise of Skywalker,False";
        String[] arrOfStr = str.split(",", -1);
        for (String a: arrOfStr) System.out.println(a);
    }
}
