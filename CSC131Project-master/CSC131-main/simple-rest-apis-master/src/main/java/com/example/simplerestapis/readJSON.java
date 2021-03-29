package com.example.simplerestapis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 

public class readJSON {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ParseException
    {
        //JSON parser object to parse read filei
        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader("datahubio_oscar_data_json.json");

        Object obj = jsonParser.parse(reader);

        JSONObject Movie = (JSONObject)obj;

        JSONArray array = (JSONArray)Movie.get("category");
         
    //     try (FileReader reader = new FileReader("datahubio_oscar_data_json.json"))
    //     {
    //         //Read JSON file
    //         Object obj = jsonParser.parse(reader);
 
    //         JSONArray MovieList = (JSONArray) obj;
    //         //System.out.println(MovieList);
             
    //         //Iterate over employee array
    //         MovieList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
 
    //     } catch (FileNotFoundException e) {
    //         e.printStackTrace();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     } catch (ParseException e) {
    //         e.printStackTrace();
    //     }
    // }

    // private static void parseEmployeeObject(JSONObject employee) 
    // {
    //     //Get employee object within list
    //     JSONObject Movie = (JSONObject) employee.get("category");
         
    //     //Get employee first name
    //     String category = (String) Movie.get("category");    
    //     System.out.println(category);
         
    //     // //Get employee last name
    //     // String lastName = (String) Movie.get("lastName");  
    //     // System.out.println(lastName);
         
    //     // //Get employee website name
    //     // String website = (String) employeeObject.get("website");    
    //     // System.out.println(website);
    }
}
