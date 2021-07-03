package com.example.music_app.fragment;

import android.content.Intent;
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
import com.example.music_app.activity.Activity_TatcaPlayList;
import com.example.music_app.activity.Activity_Tatcachude;
import com.example.music_app.adapter.ChuDeAdapter;
import com.example.music_app.model.Chude;
import com.example.music_app.service.APIService;
import com.example.music_app.service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_chude extends Fragment {

    View view;
    ChuDeAdapter chuDeAdapter;
    RecyclerView recyclerViewchude;
    TextView tenChude;
    TextView txtXemThemChude;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chude, container, false);
        recyclerViewchude = view.findViewById(R.id.recyclerviewchude);
        tenChude = view.findViewById(R.id.txtchude);
        txtXemThemChude = view.findViewById(R.id.textviewxemthemchude);
        txtXemThemChude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Activity_Tatcachude.class);
                startActivity(intent);
            }
        });
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Chude>> callback = dataservice.ChudeToday();
        callback.enqueue(new Callback<List<Chude>>() {
            @Override
            public void onResponse(Call<List<Chude>> call, Response<List<Chude>> response) {
                ArrayList<Chude> mangchude = (ArrayList<Chude>) response.body();
                chuDeAdapter = new ChuDeAdapter(getActivity(), mangchude);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewchude.setLayoutManager(linearLayoutManager);
                recyclerViewchude.setAdapter(chuDeAdapter);
            }

            @Override
            public void onFailure(Call<List<Chude>> call, Throwable t) {

            }

        });
    }
}
