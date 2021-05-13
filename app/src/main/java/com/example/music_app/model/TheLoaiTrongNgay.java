package com.example.music_app.model;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class TheLoaiTrongNgay {

@SerializedName("theloai")
@Expose
private List<Theloai> theloai = null;
@SerializedName("chude")
@Expose
private List<Chude> chude = null;

public List<Theloai> getTheloai() {
return theloai;
}

public void setTheloai(List<Theloai> theloai) {
this.theloai = theloai;
}

public List<Chude> getChude() {
return chude;
}

public void setChude(List<Chude> chude) {
this.chude = chude;
}

}