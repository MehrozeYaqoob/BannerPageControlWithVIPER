package com.example.haidermirza.banner.viper.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.haidermirza.banner.R;
import com.example.haidermirza.banner.adapter.LocalDataAdapter;
import com.example.haidermirza.banner.library.layoutmanager.CenterScrollListener;
import com.example.haidermirza.banner.library.layoutmanager.OverFlyingLayoutManager;
import com.example.haidermirza.banner.viper.contract.OverFlyingContract;
import com.example.haidermirza.banner.viper.presenter.OverFlying_Presenter;


public class OverFlyingActivity extends AppCompatActivity implements OverFlyingContract.OF_View {

     OverFlying_Presenter overFlying_presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_flying);
        RecyclerView recyclerView =  findViewById(R.id.recycler_banner);
        SeekBar seekBar = findViewById(R.id.progress);
        overFlying_presenter=new OverFlying_Presenter();
        overFlying_presenter.attach_view(this);
        overFlying_presenter.on_initial_dataLoad(recyclerView,seekBar,this);
    }

    @Override
    public void show_message(String str) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
}
