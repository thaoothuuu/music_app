package com.example.music_app.service;

import com.example.music_app.model.Playlist;
import com.example.music_app.model.Quangcao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {
    @GET("songbanner.php")
    //json trả về mảng dữ liệu
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlistofcurrenrday.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();
}
