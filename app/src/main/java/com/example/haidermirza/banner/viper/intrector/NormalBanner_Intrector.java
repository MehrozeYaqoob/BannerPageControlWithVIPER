package com.example.haidermirza.banner.viper.intrector;

import android.content.Context;
import android.widget.Toast;

import com.example.haidermirza.banner.adapter.RecyclerViewBannerNormal;
import com.example.haidermirza.banner.library.RecyclerViewBannerBase;
import com.example.haidermirza.banner.viper.contract.NormalBannerContract;
import com.example.haidermirza.banner.viper.entity.Banner;
import com.example.haidermirza.banner.viper.view.NormalActivity;

import java.util.ArrayList;
import java.util.List;

public class NormalBanner_Intrector implements NormalBannerContract.NB_Intrector {
    private NormalBannerContract.NB_Presenter nb_presenter;
    private List<Banner> list;
    @Override
    public void attach_presenter(NormalBannerContract.NB_Presenter presenter) {
        nb_presenter=presenter;
    }

    @Override
    public void initial_dataLoad(RecyclerViewBannerNormal banner, RecyclerViewBannerNormal banner2, Context context) {

        setModel();
        banner.initBannerImageView(list, new RecyclerViewBannerBase.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                nb_presenter.on_banner_clik("clicked:" + position);
            }
        });
        banner2.initBannerImageView(list, new RecyclerViewBannerBase.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                nb_presenter.on_banner_clik("clicked:" + position);
            }
        });
    }
    private void setModel(){
       list = new ArrayList<>();
        list.add(new Banner("http://img0.imgtn.bdimg.com/it/u=1352823040,1166166164&fm=27&gp=0.jpg"));
    }
}
