package com.example.haidermirza.banner.viper.contract

import android.content.Context

import com.example.haidermirza.banner.library.BannerLayout

interface MainContract {
    interface MainView {
        fun show_message(str: String)
    }

    interface MainPresenter {
        fun attach_view(view: MainContract.MainView)
        fun on_initial_dataLoad(recyclerBanner: BannerLayout, bannerVertical: BannerLayout, context: Context)
        fun on_banner_clik(path: String)
        fun on_start_normalActivity(context: Context)
        fun on_start_overFlyingActivity(context: Context)
    }

    interface MainInterator {
        fun dataLoad(recyclerBanner: BannerLayout, bannerVertical: BannerLayout, context: Context)
        fun attach_presenter(presenter: MainContract.MainPresenter)
    }

    interface MainRouter {
        fun start_normalActivity(context: Context)
        fun start_overFlyingActivity(context: Context)
    }
}
