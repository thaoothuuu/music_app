package com.example.music_app.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.music_app.R;
import com.example.music_app.adapter.BannerAdapter;
import com.example.music_app.model.Quangcao;
import com.example.music_app.service.APIService;
import com.example.music_app.service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_banner extends Fragment {
    View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    BannerAdapter bannerAdapter;
    Runnable runnable;
    Handler handler;
    int currentItem;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner,container,false);
        GetData();
        anhxa();
        return view;
    }

    private void anhxa() {
        viewPager = view.findViewById(R.id.viewpager);
        circleIndicator = view.findViewById(R.id.indicatordefault);
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Quangcao>> callback = dataservice.GetDataBanner();

        //lắng nghe dữ liệu trả về
        callback.enqueue(new Callback<List<Quangcao>>() {
            @Override
            public void onResponse(Call<List<Quangcao>> call, Response<List<Quangcao>> response) {
                //kết quả trả về
                //lấy dữ liệu trong response
                ArrayList<Quangcao> Banners = (ArrayList<Quangcao>) response.body();

                bannerAdapter = new BannerAdapter(getActivity(),Banners);
                viewPager.setAdapter(bannerAdapter);
                circleIndicator.setViewPager(viewPager);

                handler = new Handler();
                runnable = () -> {
                    currentItem = viewPager.getCurrentItem();
                    currentItem++;
                   if(currentItem>=viewPager.getAdapter().getCount()){
                        currentItem=0;
                    }


                    viewPager.setCurrentItem(currentItem,true);
                    handler.postDelayed(runnable,4500);
                };
                handler.postDelayed(runnable,4500);

            }

            @Override
            public void onFailure(Call<List<Quangcao>> call, Throwable t) {
                //không trả được dữ liệu

            }
        });
    }
}
