package com.example.parsetagram;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import  com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("BloodSugar")
public class BG extends ParseObject{
    public static final String KEY_VALUE = "value";
    public static final String KEY_USER = "user";
    public static final String KEY_MEAL= "meal";
    public static final String KEY_CREATED_KEY = "createdAt";

    public String getValue(){
        return (KEY_VALUE);
    }

    public void setValue(int bg){
        put(KEY_VALUE, bg);
    }

    public String getMeal(){
        return getString(KEY_MEAL);
    }

    public void setMeal(int meal){
        put(KEY_MEAL, meal);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user){
        put(KEY_USER, user);
    }

}
