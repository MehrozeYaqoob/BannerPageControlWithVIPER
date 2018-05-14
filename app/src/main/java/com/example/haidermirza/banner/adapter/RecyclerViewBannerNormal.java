package com.example.haidermirza.banner.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.example.haidermirza.banner.library.RecyclerViewBannerBase;
import com.example.haidermirza.banner.viper.entity.Banner;

import java.util.List;

public class RecyclerViewBannerNormal extends RecyclerViewBannerBase<LinearLayoutManager, NormalRecyclerAdapter> {

    public RecyclerViewBannerNormal(Context context) {
        this(context, null);
    }

    public RecyclerViewBannerNormal(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public RecyclerViewBannerNormal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onBannerScrolled(RecyclerView recyclerView, int dx, int dy) {
        //Solve the problem that the indicator does not update when continuously sliding
        if (bannerSize < 2) return;
        int firstReal = mLayoutManager.findFirstVisibleItemPosition();
        View viewFirst = mLayoutManager.findViewByPosition(firstReal);
        float width = getWidth();
        if (width != 0 && viewFirst != null) {
            float right = viewFirst.getRight();
            float ratio = right / width;
            if (ratio > 0.8) {
                if (currentIndex != firstReal) {
                    currentIndex = firstReal;
                    refreshIndicator();
                }
            } else if (ratio < 0.2) {
                if (currentIndex != firstReal + 1) {
                    currentIndex = firstReal + 1;
                    refreshIndicator();
                }
            }
        }
    }

    @Override
    protected void onBannerScrollStateChanged(RecyclerView recyclerView, int newState) {
        int first = mLayoutManager.findFirstVisibleItemPosition();
        int last = mLayoutManager.findLastVisibleItemPosition();
        if (currentIndex != first && first == last) {
            currentIndex = first;
            refreshIndicator();
        }
    }

    @Override
    protected LinearLayoutManager getLayoutManager(Context context, int orientation) {
        return new LinearLayoutManager(context, orientation, false);
    }

    @Override
    protected NormalRecyclerAdapter getAdapter(Context context, List<Banner> list, OnBannerItemClickListener onBannerItemClickListener) {
        return new NormalRecyclerAdapter(context, list,onBannerItemClickListener);
    }
}