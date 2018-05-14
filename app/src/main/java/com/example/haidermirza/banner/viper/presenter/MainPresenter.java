package com.example.haidermirza.banner.viper.presenter;

import android.content.Context;

import com.example.haidermirza.banner.library.BannerLayout;
import com.example.haidermirza.banner.viper.contract.MainContract;
import com.example.haidermirza.banner.viper.intrector.MainIntrector;
import com.example.haidermirza.banner.viper.router.MainRouter;

public class MainPresenter implements MainContract.MainPresenter {
    private MainContract.MainView view;
    private MainContract.MainInterator interactor;
    private MainContract.MainRouter mainRouter;

    @Override
    public void attach_view(MainContract.MainView view) {
        this.view = view;
    }

    public MainPresenter() {
        this.interactor = new MainIntrector();
        interactor.attach_presenter(this);
        this.mainRouter = new MainRouter();
    }

    @Override
    public void on_initial_dataLoad(BannerLayout recyclerBanner, BannerLayout bannerVertical, Context context) {
        interactor.dataLoad(recyclerBanner, bannerVertical, context);
    }

    @Override
    public void on_banner_clik(String path) {
        view.show_message(path);
    }

    @Override
    public void on_start_normalActivity(Context context) {
        mainRouter.start_normalActivity(context);
    }

    @Override
    public void on_start_overFlyingActivity(Context context) {
        mainRouter.start_overFlyingActivity(context);
    }
}
