package com.example.music_app.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.content.SharedPreferences;
import com.example.music_app.R;
import com.example.music_app.activity.Activity_Tatcachude;
import com.example.music_app.activity.LoginActivity;
import com.example.music_app.activity.PreferenceHelper;


public class Fragment_User extends Fragment {

    Button btnLogout;
    View view;
    TextView tvname,tvhobby;
    com.example.music_app.activity.PreferenceHelper preferenceHelper;
    Context context;
    private SharedPreferences app_prefs;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        preferenceHelper = new PreferenceHelper(getContext());
        view = inflater.inflate(R.layout.activity_welcome, container, false);
        tvname = view.findViewById(R.id.tvname);
        tvhobby = view.findViewById(R.id.etusername);
        tvname.setText("Xin chào "+preferenceHelper.getName());
        tvhobby.setText("Need music for "+preferenceHelper.getHobby()+"?");
        btnLogout=  view.findViewById(R.id.btn);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}