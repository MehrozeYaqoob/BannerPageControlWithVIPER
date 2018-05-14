package com.example.haidermirza.banner.viper.contract;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.SeekBar;

import com.example.haidermirza.banner.library.BannerLayout;

public interface OverFlyingContract {
    interface OF_View{
        void show_message(String str);
    }
    interface OF_Intrector{
        void attach_presenter(OverFlyingContract.OF_Presenter presenter);
        void initial_dataLoad(RecyclerView recyclerView, SeekBar seekBar, Context context);
    }
    interface OF_Presenter{
        void attach_view(OverFlyingContract.OF_View view);
        void on_banner_clik(String path);
        void on_initial_dataLoad(RecyclerView recyclerView, SeekBar seekBar, Context context);
    }
}
