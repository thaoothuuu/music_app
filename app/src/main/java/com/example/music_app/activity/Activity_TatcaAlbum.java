package com.example.music_app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.music_app.R;
import com.example.music_app.adapter.DanhSachAlbumAdapter;
import com.example.music_app.adapter.DanhSachPlaylistAdapter;
import com.example.music_app.model.Album;
import com.example.music_app.model.Playlist;
import com.example.music_app.service.APIService;
import com.example.music_app.service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_TatcaAlbum extends AppCompatActivity {
    RecyclerView recyclerViewAlbum;
    Toolbar toolbarAlbum;
    DanhSachAlbumAdapter danhSachAlbumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__tatca_album);

        init();
        GetData();
    }

    private void GetData() {
        Dataservice dataService = APIService.getService();
        Call<List<Album>> callBack = dataService.GetAlbum();

        callBack.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> mangAlbum = (ArrayList<Album>) response.body();
                danhSachAlbumAdapter = new DanhSachAlbumAdapter(Activity_TatcaAlbum.this,mangAlbum);
                recyclerViewAlbum.setLayoutManager(new GridLayoutManager(Activity_TatcaAlbum.this,2));
                recyclerViewAlbum.setAdapter(danhSachAlbumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerViewAlbum = findViewById(R.id.recyclerviewalbum);
        toolbarAlbum = findViewById(R.id.toolbaralbum);
        setSupportActionBar(toolbarAlbum);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ALL ALBUM");
        toolbarAlbum.setTitleTextColor(getResources().getColor(R.color.black));
        toolbarAlbum.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}