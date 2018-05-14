package com.example.haidermirza.banner.viper.intrector;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.SeekBar;

import com.example.haidermirza.banner.R;
import com.example.haidermirza.banner.adapter.LocalDataAdapter;
import com.example.haidermirza.banner.library.layoutmanager.CenterScrollListener;
import com.example.haidermirza.banner.library.layoutmanager.OverFlyingLayoutManager;
import com.example.haidermirza.banner.viper.contract.OverFlyingContract;

public class OverFlying_Intrector implements OverFlyingContract.OF_Intrector {
    private OverFlyingContract.OF_Presenter of_presenter;

    private RecyclerView recyclerView;
    private OverFlyingLayoutManager mOverFlyingLayoutManager;
    private Handler mHandler;
    private Runnable mRunnable;
    private int currentPosition = 0;
    private SeekBar seekBar;
    private Context context;

    @Override
    public void attach_presenter(OverFlyingContract.OF_Presenter presenter) {
        of_presenter = presenter;
    }

    @Override
    public void initial_dataLoad(RecyclerView recyclerView, SeekBar seekBar, Context context) {
        this.recyclerView = recyclerView;
        this.seekBar = seekBar;
        this.context = context;
        set_layoutManager();
        recyclerView.setAdapter(new LocalDataAdapter());
        recyclerView.setLayoutManager(mOverFlyingLayoutManager);
        recyclerView.addOnScrollListener(new CenterScrollListener());
        set_handler();
        set_seekBar();
    }

    private  void set_layoutManager() {
        mOverFlyingLayoutManager = new OverFlyingLayoutManager(0.75f, 385, OverFlyingLayoutManager.HORIZONTAL);
        mOverFlyingLayoutManager.setOnPageChangeListener(new OverFlyingLayoutManager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                currentPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private  void set_handler() {
        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                currentPosition++;
                Log.d("recyclerBanner", currentPosition + " ");
                mOverFlyingLayoutManager.scrollToPosition(currentPosition);
                //  recyclerView.smoothScrollToPosition(currentPosition);
                mHandler.postDelayed(this, 3000);
            }
        };
        mHandler.postDelayed(mRunnable, 3000);
    }

    private void set_seekBar() {

        seekBar.setProgress(385);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mOverFlyingLayoutManager.setItemSpace(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                of_presenter.on_banner_clik("seekBar progress set to "+seekBar.getProgress());
            }
        });
    }
}
