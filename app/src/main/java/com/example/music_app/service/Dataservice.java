package com.example.music_app.service;

import com.example.music_app.model.Album;
import com.example.music_app.model.Baihat;
import com.example.music_app.model.Chude;
import com.example.music_app.model.Playlist;
import com.example.music_app.model.Quangcao;
import com.example.music_app.model.TheLoaiTrongNgay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {
    @GET("songbanner.php")
    //json trả về mảng dữ liệu
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlistofcurrenrday.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();

    @GET("danhsachalbum.php")
    Call<List<Album>> GetAlbum();

    @GET("DanhSachPlayList.php")
    Call<List<Playlist>> getPlaylist();

    @GET("chudevatheloaitrongngay.php")
    Call<TheLoaiTrongNgay> getCategoryMusic();

    @GET("tatcachude.php")
    Call<List<Chude>> getchude();

    @GET("baihatduocthich.php")
    Call<List<Baihat>> getbaihatyeuthich();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> getDanhSachBaiHatTheoQuangCao(@Field("idquangcao") String idquangcao);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> getDanhSachBaiHatTheoPlayList(@Field("idplaylist") String idPlayList);


}
