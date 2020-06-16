package com.annamalai.instagram;

import android.app.Application;

import com.parse.Parse;

public class App extends Application   {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("aLyxmPX5VarJfWe8epl3ogziN8C4raPLjZQryXZs")
                // if defined
                .clientKey("2IKSEdfveYE0oBeziwlovNnvUeKXiLjTti0nolmG")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
