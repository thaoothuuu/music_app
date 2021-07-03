package com.example.music_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_app.activity.DanhsachbaihatActivity;
import com.example.music_app.model.Playlist;
import com.example.music_app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhSachPlaylistAdapter extends RecyclerView.Adapter<DanhSachPlaylistAdapter.ViewHolder>{

    Context context;
    ArrayList<Playlist> PlaylistArrayList = new ArrayList<>();

    public DanhSachPlaylistAdapter(Context context, ArrayList<Playlist> PlaylistArrayList) {
        this.context = context;
        this.PlaylistArrayList = PlaylistArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dong_all_playlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Playlist playlist = PlaylistArrayList.get(position);
        Picasso.with(context).load(playlist.getHinhnen()).into(holder.imgPlaylist);
        holder.txtPlaylist.setText(playlist.getTen());

    }

    @Override
    public int getItemCount() {
        return PlaylistArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPlaylist;
        TextView txtPlaylist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPlaylist = itemView.findViewById(R.id.imageviewdanhsachplaylist);
            txtPlaylist = itemView.findViewById(R.id.textviewdanhsachplaylist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("itemplaylist",PlaylistArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
