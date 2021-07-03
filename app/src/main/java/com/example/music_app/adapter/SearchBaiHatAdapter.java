package com.example.music_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_app.activity.PlayNhacActivity;
import com.example.music_app.model.Baihat;
import com.example.music_app.R;
import com.example.music_app.service.APIService;
import com.example.music_app.service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchBaiHatAdapter extends RecyclerView.Adapter<SearchBaiHatAdapter.ViewHolder>  {
    Context context;
    ArrayList<Baihat> mangBaiHat;

    public SearchBaiHatAdapter(Context context, ArrayList<Baihat> mangBaiHat) {
        this.context = context;
        this.mangBaiHat = mangBaiHat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_timkiem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Baihat baiHat = mangBaiHat.get(position);
        holder.txtTenBaiHat.setText(baiHat.getTenBaiHat());
        holder.txtCaSi.setText(baiHat.getCaSi());
        Picasso.with(context).load(baiHat.getHinhBaiHat()).into(holder.imageViewBaiHat);
    }

    @Override
    public int getItemCount() {
        return mangBaiHat.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtTenBaiHat, txtCaSi;
        ImageView imageViewBaiHat, imageViewLuotThich;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenBaiHat = itemView.findViewById(R.id.textviewsearchtenbaihat);
            txtCaSi = itemView.findViewById(R.id.textviewsearchtencasi);
            imageViewBaiHat = itemView.findViewById(R.id.imageviewsearchbaihat);
            //imageViewLuotThich = itemView.findViewById(R.id.imageviewsearchluotthich);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhuc",mangBaiHat.get(getPosition()));
                    context.startActivity(intent);
                }
            });
//            imageViewLuotThich.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    imageViewLuotThich.setImageResource(R.drawable.iconloved);
//                    Dataservice dataService = APIService.getService();
//                    Call<String> callBack = dataService.updateLuotThich("1",mangBaiHat.get(getPosition()).getIdBaiHat());
//                    callBack.enqueue(new Callback<String>() {
//                        @Override
//                        public void onResponse(Call<String> call, Response<String> response) {
//                            String ketQua = response.body();
//                            if(ketQua.equals("Success")){
//                                Toast.makeText(context,"Đã thích",Toast.LENGTH_SHORT).show();
//                            }else{
//                                Toast.makeText(context,"Lỗi",Toast.LENGTH_SHORT).show();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<String> call, Throwable t) {
//
//                        }
//                    });
//                    imageViewLuotThich.setEnabled(false);
//                }
//            });
        }
    }
}
