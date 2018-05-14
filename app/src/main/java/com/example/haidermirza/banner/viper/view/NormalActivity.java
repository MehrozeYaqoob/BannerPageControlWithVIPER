package com.example.haidermirza.banner.viper.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.haidermirza.banner.R;
import com.example.haidermirza.banner.adapter.RecyclerViewBannerNormal;
import com.example.haidermirza.banner.library.RecyclerViewBannerBase;
import com.example.haidermirza.banner.viper.contract.NormalBannerContract;
import com.example.haidermirza.banner.viper.presenter.NormalBanner_Presenter;

import java.util.ArrayList;
import java.util.List;

public class NormalActivity extends AppCompatActivity implements NormalBannerContract.NB_View {
    RecyclerViewBannerNormal banner, banner2;
    NormalBanner_Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        banner = findViewById(R.id.banner);
        banner2 = findViewById(R.id.banner2);
        presenter=new NormalBanner_Presenter();
        presenter.attach_view(this);

        presenter.on_initial_dataLoad(banner,banner2,this);
    }

    @Override
    public void show_message(String str) {
        Toast.makeText(NormalActivity.this, str, Toast.LENGTH_SHORT).show();
    }
}
