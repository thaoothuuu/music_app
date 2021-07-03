package com.example.music_app.activity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.music_app.R;

public class WelcomeActivity extends AppCompatActivity {

    private TextView tvname,tvhobby;
    private Button btnlogout;
   private com.example.music_app.activity.PreferenceHelper preferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        preferenceHelper = new com.example.music_app.activity.PreferenceHelper(this);

        tvhobby = (TextView) findViewById(R.id.etusername);
        tvname = (TextView) findViewById(R.id.tvname);
        btnlogout = (Button) findViewById(R.id.btn);
        tvname.setText("Xin chào "+preferenceHelper.getName());
        tvhobby.setText("Need music for "+preferenceHelper.getHobby()+"?");

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.music_app.activity.WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                com.example.music_app.activity.WelcomeActivity.this.finish();


            Intent intent1 = new Intent(WelcomeActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            preferenceHelper.putIsLogin(false);

            WelcomeActivity.this.finish();


        };
    });
}}

