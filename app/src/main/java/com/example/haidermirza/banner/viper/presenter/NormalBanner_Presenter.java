package com.example.haidermirza.banner.viper.presenter;

import android.content.Context;

import com.example.haidermirza.banner.adapter.RecyclerViewBannerNormal;
import com.example.haidermirza.banner.viper.contract.MainContract;
import com.example.haidermirza.banner.viper.contract.NormalBannerContract;
import com.example.haidermirza.banner.viper.intrector.NormalBanner_Intrector;

public class NormalBanner_Presenter implements NormalBannerContract.NB_Presenter {
    private NormalBannerContract.NB_View nb_view;
    private NormalBannerContract.NB_Intrector nb_intrector;

    @Override
    public void attach_view(NormalBannerContract.NB_View view) {
        this.nb_view = view;
        nb_intrector = new NormalBanner_Intrector();
        nb_intrector.attach_presenter(this);
    }

    @Override
    public void on_banner_clik(String path) {
        nb_view.show_message(path);
    }

    @Override
    public void on_initial_dataLoad(RecyclerViewBannerNormal banner, RecyclerViewBannerNormal banner2, Context context) {
        nb_intrector.initial_dataLoad(banner, banner2, context);
    }
}
