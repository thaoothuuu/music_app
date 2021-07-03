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
import com.example.music_app.model.Chude;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChuDeAdapter extends RecyclerView.Adapter<ChuDeAdapter.ViewHolder> {

    Context context;
    ArrayList<Chude> mangchude;
    View view;

    public ChuDeAdapter(Context context, ArrayList<Chude> mangchude) {
        this.context = context;
        this.mangchude = mangchude;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.dong_playlist,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Chude chude = mangchude.get(position);
        holder.txttenchude.setText(chude.getTenChuDe());
        Picasso.with(context).load(chude.getHinhChuDe()).into(holder.imgchude);

    }

    @Override
    public int getItemCount() {
        return mangchude.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgchude;
        TextView txttenchude;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgchude = itemView.findViewById(R.id.imageviewchude);
            txttenchude = itemView.findViewById(R.id.textviewchude);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
//                    intent.putExtra("itemchude",mangchude.get(getPosition()));
//                    context.startActivity(intent);
//
//                }
//            });
        }
    }
}
