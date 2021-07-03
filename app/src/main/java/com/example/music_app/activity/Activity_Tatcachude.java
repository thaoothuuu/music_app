package com.example.music_app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.music_app.R;
import com.example.music_app.adapter.DanhSachAlbumAdapter;
import com.example.music_app.adapter.DanhSachChudeAdapter;
import com.example.music_app.model.Album;
import com.example.music_app.model.Chude;
import com.example.music_app.service.APIService;
import com.example.music_app.service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Tatcachude extends AppCompatActivity {

    RecyclerView recyclerViewChude;
    Toolbar toolbarChude;
    DanhSachChudeAdapter danhSachChudeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__tatcachude);

        init();
        GetData();
    }

    private void GetData() {
        Dataservice dataService = APIService.getService();
        Call<List<Chude>> callBack = dataService.getchude();

        callBack.enqueue(new Callback<List<Chude>>() {
            @Override
            public void onResponse(Call<List<Chude>> call, Response<List<Chude>> response) {
                ArrayList<Chude> mangChude = (ArrayList<Chude>) response.body();
                danhSachChudeAdapter = new DanhSachChudeAdapter(Activity_Tatcachude.this,mangChude);
                recyclerViewChude.setLayoutManager(new GridLayoutManager(Activity_Tatcachude.this,2));
                recyclerViewChude.setAdapter(danhSachChudeAdapter);
            }

            @Override
            public void onFailure(Call<List<Chude>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerViewChude = findViewById(R.id.recyclerviewchude);
        toolbarChude = findViewById(R.id.toolbarchude);
        setSupportActionBar(toolbarChude);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ALL CHỦ DỀ");
        toolbarChude.setTitleTextColor(getResources().getColor(R.color.black));
        toolbarChude.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}