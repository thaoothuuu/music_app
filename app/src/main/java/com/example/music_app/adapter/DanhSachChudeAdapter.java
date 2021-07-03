package com.example.music_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_app.R;
import com.example.music_app.activity.Activity_TatcaPlayList;
import com.example.music_app.activity.DanhsachbaihatActivity;
import com.example.music_app.model.Chude;
import com.example.music_app.model.Playlist;
import com.example.music_app.service.APIService;
import com.example.music_app.service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachChudeAdapter extends RecyclerView.Adapter<DanhSachChudeAdapter.ViewHolder> {
    Context context;
    ArrayList<Chude> ChudeArrayList = new ArrayList<>();

    public DanhSachChudeAdapter(Context context, ArrayList<Chude> ChudeArrayList) {
        this.context = context;
        this.ChudeArrayList = ChudeArrayList;
    }
    @NonNull
    @Override
    public DanhSachChudeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dong_allchude,parent,false);
        return new DanhSachChudeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhSachChudeAdapter.ViewHolder holder, int position) {
        Chude chude = ChudeArrayList.get(position);
        Picasso.with(context).load(chude.getHinhChuDe()).into(holder.imgChude);
        holder.txtChude.setText(chude.getTenChuDe());

    }

    @Override
    public int getItemCount() {
        return ChudeArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgChude;
        TextView txtChude;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgChude = itemView.findViewById(R.id.imageviewdanhsachchude);
            txtChude = itemView.findViewById(R.id.textviewdanhsacchude);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("itemchude",ChudeArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
