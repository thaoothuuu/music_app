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

    @GET("Albumforday.php")
    Call<List<Album>> GetAlbumDay();


    @GET("chudeforday.php")
    Call<List<Chude>> ChudeToday();

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

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> getDanhSachBaiHatTheoAlbum(@Field("idalbum") String idAlbum);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> getDanhSachBaiHatTheoChude(@Field("idchude") String idChuDe);

    @FormUrlEncoded
    @POST("searchbaihat.php")
    Call<List<Baihat>> getSearchBaiHat(@Field("tukhoa") String tuKhoa);

//    @FormUrlEncoded
//    @POST("updateluotthich.php")
//    Call<String> updateLuotThich(@Field("luotthich") String luotthich, @Field("idbaihat") String idbaihat);


}
