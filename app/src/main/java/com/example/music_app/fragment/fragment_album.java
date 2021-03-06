package com.example.music_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_app.R;
import com.example.music_app.adapter.AlbumAdapter;
import com.example.music_app.adapter.PlayListAdapter;
import com.example.music_app.model.Album;
import com.example.music_app.model.Playlist;
import com.example.music_app.service.APIService;
import com.example.music_app.service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_album extends Fragment {

    View view;
    AlbumAdapter albumAdapter;
    RecyclerView recyclerViewalbum;
    TextView tenAlbum;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_album, container, false);
        recyclerViewalbum = view.findViewById(R.id.recyclerviewalbum);
        tenAlbum = view.findViewById(R.id.txtalbum);
        GetData();
        return view;
    }


}
