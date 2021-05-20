package com.example.music_app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.music_app.adapter.DanhSachPlaylistAdapter;
import com.example.music_app.model.Playlist;
import com.example.music_app.R;
import com.example.music_app.service.APIService;
import com.example.music_app.service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_TatcaPlayList extends AppCompatActivity {
    RecyclerView recyclerViewPlaylist;
    Toolbar toolbarPlaylist;
    DanhSachPlaylistAdapter danhSachPlaylistAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__tatca_play_list);

        init();
        GetData();
    }

    private void GetData() {
        Dataservice dataService = APIService.getService();
        Call<List<Playlist>> callBack = dataService.getPlaylist();
        callBack.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                ArrayList<Playlist> mangPlaylist = (ArrayList<Playlist>) response.body();
                danhSachPlaylistAdapter = new DanhSachPlaylistAdapter(Activity_TatcaPlayList.this,mangPlaylist);
                recyclerViewPlaylist.setLayoutManager(new GridLayoutManager(Activity_TatcaPlayList.this,2));
                recyclerViewPlaylist.setAdapter(danhSachPlaylistAdapter);
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        });

    }

    private void init() {
        recyclerViewPlaylist = findViewById(R.id.recycleviewplaylist);
        toolbarPlaylist = findViewById(R.id.toolbarplaylist);
        setSupportActionBar(toolbarPlaylist);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ALL PLAYLIST");
        toolbarPlaylist.setTitleTextColor(getResources().getColor(R.color.black));
        toolbarPlaylist.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}