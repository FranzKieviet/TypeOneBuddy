package com.example.parsetagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);


        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("g7zmCOdOaJgvbU5xoMr2g89J8A35HA2QkLRfXFPw")
                .clientKey("gYxKAKusRShl6rthxCbarh8Fpjb60SmSGQKDUKoX")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
