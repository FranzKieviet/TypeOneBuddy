package com.example.parsetagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);
        ParseObject.registerSubclass(BG.class);
        ParseObject.registerSubclass(Ratio.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("nctLs0Aam0GG9IS6ZrWiraAd1J32sMdus5AMfTTa")
                .clientKey("DeHKNIYEp1BfZvkGES3Gr8Pn4xMhVFn6mskgG1nd")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
