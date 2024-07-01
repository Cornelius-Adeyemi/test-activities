package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {


    public static void main(String ...args){

        String path = "/Users/adebisiadeyemi/IdeaProjects/testing/src/main/resources/myFile";


        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print each line to the console
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle potential IOException
        }



    }
}
