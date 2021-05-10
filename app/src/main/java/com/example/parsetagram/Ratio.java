package com.example.parsetagram;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import  com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Ratios")
public class Ratio extends ParseObject{
    public static final String KEY_NAME = "name";
    public static final String KEY_RATIO = "ratio";

    public String getName(){
        return getString(KEY_NAME);
    }

    public void setName(String name){
        put(KEY_NAME, name);
    }

    public double getRatio(){
        return getDouble(KEY_RATIO);
    }

    public void setRatio(double ratio){
        put(KEY_RATIO, ratio);
    }



}
