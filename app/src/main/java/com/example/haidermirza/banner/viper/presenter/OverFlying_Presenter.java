package com.example.haidermirza.banner.viper.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.SeekBar;

import com.example.haidermirza.banner.viper.contract.OverFlyingContract;
import com.example.haidermirza.banner.viper.intrector.OverFlying_Intrector;

public class OverFlying_Presenter implements OverFlyingContract.OF_Presenter {
    private OverFlyingContract.OF_Intrector of_intrector;
    private OverFlyingContract.OF_View of_view;

    @Override
    public void attach_view(OverFlyingContract.OF_View view) {
        this.of_view = view;
        of_intrector = new OverFlying_Intrector();
        of_intrector.attach_presenter(this);
    }

    @Override
    public void on_banner_clik(String path) {
        of_view.show_message(path);
    }

    @Override
    public void on_initial_dataLoad(RecyclerView recyclerView, SeekBar seekBar, Context context) {
        of_intrector.initial_dataLoad(recyclerView, seekBar, context);
    }
}
