package org.example;

public class MyException extends Exception{

    public String getDance() {
        return dance;
    }

    public void setDance(String dance) {
        this.dance = dance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String dance;


    private String name;


    public MyException(String message, String dance, String name){
        super(message);

        this.dance = dance;

        this.name = name;
    }



}
