package com.example.music_app.model;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Playlist {

    @SerializedName("IdPlayList")
    @Expose
    private String idPlayList;
    @SerializedName("Ten")
    @Expose
    private String ten;
    @SerializedName("Hinhnen")
    @Expose
    private String hinhnen;
    @SerializedName("Hinhicon")
    @Expose
    private String hinhicon;

    public String getIdPlayList() {
        return idPlayList;
    }

    public void setIdPlayList(String idPlayList) {
        this.idPlayList = idPlayList;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHinhnen() {
        return hinhnen;
    }

    public void setHinhnen(String hinhnen) {
        this.hinhnen = hinhnen;
    }

    public String getHinhicon() {
        return hinhicon;
    }

    public void setHinhicon(String hinhicon) {
        this.hinhicon = hinhicon;
    }

}
