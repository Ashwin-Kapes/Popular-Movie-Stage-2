package com.android.popmovies.application;


import android.app.Application;

import com.android.popmovies.retrofit.MovieAPI;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application {
    private static com.android.popmovies.retrofit.MovieAPI.MovieClient movieClient;

    public static MovieAPI.MovieClient getMovieClient() {
        return movieClient;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(getApplicationContext()).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);
        movieClient = new MovieAPI.MovieClient();
    }
}
