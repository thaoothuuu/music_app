package com.example.music_app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.music_app.R;
import com.example.music_app.model.Baihat;
import com.example.music_app.model.Quangcao;
import com.example.music_app.service.APIService;
import com.example.music_app.service.Dataservice;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachbaihatActivity extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewDanhSachBaiHat;
    FloatingActionButton floatingActionButton;
    ImageView imgDanhSachCaKhuc;
    ArrayList<Baihat> mangbaihat;
    //DanhsachbaihatAdapter danhSachBaiHatAdapter;

    Quangcao quangCao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachbaihat);
        DataIntent();
        anhxa();
        init();
        if (quangCao != null && !quangCao.getTenBaiHat().equals("")){
            setValueinview(quangCao.getTenBaiHat(),quangCao.getHinhBaiHat());
            getDataquangcao(quangCao.getIdQuangcao());
        }



    }

    private void getDataquangcao(String idquangcao) {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.getDanhSachBaiHatTheoQuangCao(idquangcao);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat = (ArrayList<Baihat>) response.body();
                Log.d("bbb", mangbaihat.get(0).getTenBaiHat());

            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }

    private void setValueinview(String ten , String hinh) {
        collapsingToolbarLayout.setTitle(ten);
        try {
            URL url = new URL(hinh);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                collapsingToolbarLayout.setBackground(bitmapDrawable);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with(this).load(hinh).into(imgDanhSachCaKhuc);
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);

    }

    private void anhxa() {
        coordinatorLayout = findViewById(R.id.coordinatorlayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar);
        toolbar = findViewById(R.id.toolbardanhsach);
        recyclerViewDanhSachBaiHat = findViewById(R.id.recycleviewdanhsachbaihat);
        floatingActionButton = findViewById(R.id.floatingactionbutton);
        imgDanhSachCaKhuc = findViewById(R.id.imageviewdanhsachcakhuc);
    }


    private void DataIntent() {
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("banner")){
                quangCao = (Quangcao) intent.getSerializableExtra("banner");
                Toast.makeText(this,quangCao.getTenBaiHat(),Toast.LENGTH_SHORT).show();
            }

        }
    }


}