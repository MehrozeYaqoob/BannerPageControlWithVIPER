package com.example.haidermirza.banner.viper.contract;

import android.content.Context;

import com.example.haidermirza.banner.library.BannerLayout;

public interface MainContract {
    interface MainView{
        void show_message(String str);
    }
    interface MainPresenter{
        void attach_view(MainContract.MainView view);
        void on_initial_dataLoad(BannerLayout recyclerBanner, BannerLayout bannerVertical,Context context);
        void on_banner_clik(String path);
        void on_start_normalActivity(Context context);
        void on_start_overFlyingActivity(Context context);
    }
    interface MainInterator{
        void dataLoad(BannerLayout recyclerBanner, BannerLayout bannerVertical,Context context);
        void attach_presenter(MainContract.MainPresenter presenter);
    }
    interface MainRouter{
        void start_normalActivity(Context context);
        void start_overFlyingActivity(Context context);
    }
}
