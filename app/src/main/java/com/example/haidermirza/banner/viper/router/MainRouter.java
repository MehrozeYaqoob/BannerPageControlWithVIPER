package com.example.haidermirza.banner.viper.router;

import android.content.Context;
import android.content.Intent;

import com.example.haidermirza.banner.viper.contract.MainContract;
import com.example.haidermirza.banner.viper.view.NormalActivity;
import com.example.haidermirza.banner.viper.view.OverFlyingActivity;

public class MainRouter implements MainContract.MainRouter {
    @Override
    public void start_normalActivity(Context context) {
        Intent intent = new Intent(context, NormalActivity.class);
        context. startActivity(intent);
    }

    @Override
    public void start_overFlyingActivity(Context context) {
        Intent intent =new Intent(context, OverFlyingActivity.class);
        context.startActivity(intent);
    }
}
