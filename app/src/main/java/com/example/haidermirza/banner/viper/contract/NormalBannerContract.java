package com.example.haidermirza.banner.viper.contract;

import android.content.Context;

import com.example.haidermirza.banner.adapter.RecyclerViewBannerNormal;
import com.example.haidermirza.banner.library.BannerLayout;

public interface NormalBannerContract {
    interface NB_View{
        void show_message(String str);
    }
    interface NB_Intrector{
        void attach_presenter(NormalBannerContract.NB_Presenter presenter);
        void initial_dataLoad(RecyclerViewBannerNormal banner,RecyclerViewBannerNormal banner2,Context context);
    }
    interface NB_Presenter{
        void attach_view(NormalBannerContract.NB_View view);
        void on_banner_clik(String path);
        void on_initial_dataLoad(RecyclerViewBannerNormal banner,RecyclerViewBannerNormal banner2,Context context);
    }
}
