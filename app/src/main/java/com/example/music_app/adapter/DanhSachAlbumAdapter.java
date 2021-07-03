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

import com.example.music_app.R;
import com.example.music_app.activity.DanhsachbaihatActivity;
import com.example.music_app.model.Album;
import com.example.music_app.model.Playlist;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhSachAlbumAdapter  extends RecyclerView.Adapter<DanhSachAlbumAdapter.ViewHolder> {
    Context context;
    ArrayList<Album> AlbumArrayList = new ArrayList<>();




    public DanhSachAlbumAdapter(Context context, ArrayList<Album> AlbumArrayList) {
        this.context = context;
        this.AlbumArrayList = AlbumArrayList;
    }
    @NonNull
    @Override
    public DanhSachAlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dong_all_album,parent,false);
        return new DanhSachAlbumAdapter.ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull DanhSachAlbumAdapter.ViewHolder holder, int position) {
        Album album = AlbumArrayList.get(position);
        Picasso.with(context).load(album.getHinhAlbum()).into(holder.imgAlbum);
        holder.txtAlbum.setText(album.getTenAlbum());

    }

    @Override
    public int getItemCount() {
        return AlbumArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAlbum;
        TextView txtAlbum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAlbum = itemView.findViewById(R.id.imageviewdanhsachalbum);
            imgAlbum = itemView.findViewById(R.id.textviewdanhsachalbum);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("itemalbum",AlbumArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
