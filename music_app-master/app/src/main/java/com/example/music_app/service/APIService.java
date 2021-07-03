package com.example.music_app.service;

public class APIService {
    private static String base_url = "https://appmusicnt118.000webhostapp.com/server/";

    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
