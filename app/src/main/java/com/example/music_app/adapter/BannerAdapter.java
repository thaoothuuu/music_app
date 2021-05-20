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
import androidx.viewpager.widget.PagerAdapter;

import com.example.music_app.R;
import com.example.music_app.activity.DanhsachbaihatActivity;
import com.example.music_app.model.Quangcao;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<Quangcao> arrayListBanner;

    public BannerAdapter(Context context, ArrayList<Quangcao> arrayListBanner) {
        this.context = context;
        this.arrayListBanner = arrayListBanner;
    }

    @Override
    public int getCount() {
        //bao nhieu page trong viewpager

        return arrayListBanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        //trả về view tùy theo object đc định hình

        return view == object;
    }


    //định hình và gán dữ liệu cho mỗi object tượng trưng cho mỗi page
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view= inflater.inflate(R.layout.dong_banner,null);

        ImageView imgBackgroundBanner = view.findViewById(R.id.imagebackgroundbanner);
        ImageView imgSongBanner = view.findViewById(R.id.imageviewbanner);
        TextView txtTitleSongBanner = view.findViewById(R.id.textviewtitlebannerbaihat);
        TextView txtNoiDung = view.findViewById(R.id.textviewnoidung);

        Picasso.with(context).load(arrayListBanner.get(position).getHinhanh()).into(imgBackgroundBanner);
        Picasso.with(context).load(arrayListBanner.get(position).getHinhBaiHat()).into(imgSongBanner);
        txtTitleSongBanner.setText(arrayListBanner.get(position).getTenBaiHat());
        txtNoiDung.setText(arrayListBanner.get(position).getNoidung());


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                intent.putExtra("banner",arrayListBanner.get(position));
                context.startActivity(intent);

            }
        });

        container.addView(view);
        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
