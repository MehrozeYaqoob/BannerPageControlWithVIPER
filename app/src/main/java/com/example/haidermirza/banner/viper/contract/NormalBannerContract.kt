package com.example.haidermirza.banner.viper.contract

import android.content.Context
import com.example.haidermirza.banner.adapter.RecyclerViewBannerNormal

interface NormalBannerContract {
    interface NB_View {
        fun show_message(str: String)
    }

    interface NB_Intrector {
        fun attach_presenter(presenter: NormalBannerContract.NB_Presenter)
        fun initial_dataLoad(banner: RecyclerViewBannerNormal, banner2: RecyclerViewBannerNormal, context: Context)
    }

    interface NB_Presenter {
        fun attach_view(view: NormalBannerContract.NB_View)
        fun on_banner_clik(path: String)
        fun on_initial_dataLoad(banner: RecyclerViewBannerNormal, banner2: RecyclerViewBannerNormal, context: Context)
    }
}
