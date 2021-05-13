package com.example.music_app.service;

import com.example.music_app.model.Album;
import com.example.music_app.model.Baihat;
import com.example.music_app.model.Chude;
import com.example.music_app.model.Playlist;
import com.example.music_app.model.Quangcao;
import com.example.music_app.model.TheLoaiTrongNgay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {
    @GET("songbanner.php")
    //json trả về mảng dữ liệu
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlistofcurrenrday.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();

    @GET("danhsachalbum.php")
    Call<List<Album>> GetAlbum();

    @GET("chudevatheloaitrongngay.php")
    Call<TheLoaiTrongNgay> getCategoryMusic();

    @GET("tatcachude.php")
    Call<List<Chude>> getchude();

    @GET("baihatduocthich.php")
    Call<List<Baihat>> getbaihatyeuthich();
}
