package com.example.parsetagram;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import  com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.Date;

@ParseClassName("Post")
public class Post extends ParseObject{
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_USER = "user";
    public static final String KEY_CREATED = "objectId";
    public static final String KEY_DATE = "date";
    public static final String KEY_TITLE = "title";

    public String getDescription(){
        return getString(KEY_DESCRIPTION);
    }

    public void setDescription(String description){
        put(KEY_DESCRIPTION, description);
    }

    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile parseFile){
        put(KEY_IMAGE, parseFile);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user){
        put(KEY_USER, user);
    }

    public String getDate(){
        return getString(KEY_DATE);
    }

    public void setDate(String date){
        put(KEY_DATE, date);}

    public String getTitle(){
        return getString(KEY_TITLE);
    }

    public void setTitle(String title){
        put(KEY_TITLE, title);}

}
