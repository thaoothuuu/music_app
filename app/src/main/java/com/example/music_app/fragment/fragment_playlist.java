package com.example.music_app.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_app.R;
import com.example.music_app.activity.Activity_TatcaPlayList;
import com.example.music_app.activity.DanhsachbaihatActivity;
import com.example.music_app.adapter.PlayListAdapter;
import com.example.music_app.model.Playlist;
import com.example.music_app.service.APIService;
import com.example.music_app.service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_playlist extends Fragment {

    View view;
    PlayListAdapter playListAdapter;
    RecyclerView recyclerViewplaylist;
    TextView tenPlaylist;
    TextView txtXemThemPlaylist;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist, container, false);
        recyclerViewplaylist = view.findViewById(R.id.recyclerviewplaylist);
        tenPlaylist = view.findViewById(R.id.txtplaylist);

        txtXemThemPlaylist = view.findViewById(R.id.textviewxemthemplaylist);
        txtXemThemPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Activity_TatcaPlayList.class);
                startActivity(intent);
            }
        });


        GetData();
        return view;
    }

    private void GetData() {

        Dataservice dataservice = APIService.getService();
        Call<List<Playlist>> callback = dataservice.GetPlaylistCurrentDay();
        callback.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                ArrayList<Playlist> mangplaylist = (ArrayList<Playlist>) response.body();
                playListAdapter = new PlayListAdapter(getActivity(), mangplaylist);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewplaylist.setLayoutManager(linearLayoutManager);
                recyclerViewplaylist.setAdapter(playListAdapter);




            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }

        });
    }
}
