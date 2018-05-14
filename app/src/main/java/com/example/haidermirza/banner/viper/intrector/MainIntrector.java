package com.example.haidermirza.banner.viper.intrector;

import android.content.Context;

import com.example.haidermirza.banner.adapter.WebBannerAdapter;
import com.example.haidermirza.banner.library.BannerLayout;
import com.example.haidermirza.banner.viper.contract.MainContract;
import com.example.haidermirza.banner.viper.entity.Banner;

import java.util.ArrayList;
import java.util.List;

public class MainIntrector implements MainContract.MainInterator {

    private MainContract.MainPresenter presenter;
    private List<Banner> list;

    @Override
    public void dataLoad(BannerLayout recyclerBanner, BannerLayout bannerVertical, Context context) {

        setmodel();

        WebBannerAdapter webBannerAdapter=new WebBannerAdapter(context,list);
        webBannerAdapter.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                presenter.on_banner_clik("Click on the first  " + position+"  item");
            }
        });

        WebBannerAdapter WebBannerAdapter2 =new WebBannerAdapter(context,list);
        WebBannerAdapter2.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                presenter.on_banner_clik("Click on the first  " + position+"  item");
            }
        });
        recyclerBanner.setAdapter(webBannerAdapter);
        bannerVertical.setAdapter(WebBannerAdapter2);
    }

    @Override
    public void attach_presenter(MainContract.MainPresenter presenter) {
        this.presenter=presenter;
    }

    private void setmodel(){
        list = new ArrayList<>();
        list.add(new Banner("http://img0.imgtn.bdimg.com/it/u=1352823040,1166166164&fm=27&gp=0.jpg"));
        list.add(new Banner("http://img3.imgtn.bdimg.com/it/u=2293177440,3125900197&fm=27&gp=0.jpg"));
        list.add(new Banner("http://img3.imgtn.bdimg.com/it/u=3967183915,4078698000&fm=27&gp=0.jpg"));
        list.add(new Banner("http://img0.imgtn.bdimg.com/it/u=3184221534,2238244948&fm=27&gp=0.jpg"));
        list.add(new Banner("http://img4.imgtn.bdimg.com/it/u=1794621527,1964098559&fm=27&gp=0.jpg"));
        list.add(new Banner("http://img4.imgtn.bdimg.com/it/u=1243617734,335916716&fm=27&gp=0.jpg"));
    }
}

