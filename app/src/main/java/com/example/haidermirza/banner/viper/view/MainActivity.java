package com.example.haidermirza.banner.viper.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.haidermirza.banner.R;
import com.example.haidermirza.banner.library.BannerLayout;
import com.example.haidermirza.banner.viper.contract.MainContract;
import com.example.haidermirza.banner.viper.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    MainPresenter mainPresenter;
    BannerLayout  recyclerBanner;
    BannerLayout bannerVertical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerBanner =  findViewById(R.id.recycler);
        bannerVertical =  findViewById(R.id.recycler_ver);
        mainPresenter=new MainPresenter();

        mainPresenter.attach_view(this);
        mainPresenter.on_initial_dataLoad(recyclerBanner,bannerVertical,this);
    }

    public void jump(View view) {
        mainPresenter.on_start_normalActivity(this);
    }
    public void jumpOverFlying(View view) {
        mainPresenter.on_start_overFlyingActivity(this);
    }

    @Override
    public void show_message(String str) {
        Toast.makeText(MainActivity.this, str , Toast.LENGTH_SHORT).show();
    }
}
