package com.example.haidermirza.banner.viper.presenter

import android.content.Context

import com.example.haidermirza.banner.adapter.RecyclerViewBannerNormal
import com.example.haidermirza.banner.viper.contract.NormalBannerContract
import com.example.haidermirza.banner.viper.intrector.NormalBanner_IntrectorImp

class NormalBanner_PresenterImp : NormalBannerContract.NB_Presenter {
    private var nb_view: NormalBannerContract.NB_View? = null
    private var nb_intrector: NormalBannerContract.NB_Intrector? = null

    override fun attach_view(view: NormalBannerContract.NB_View) {
        this.nb_view = view
        nb_intrector = NormalBanner_IntrectorImp()
        nb_intrector!!.attach_presenter(this)
    }

    override fun on_banner_clik(path: String) {
        nb_view!!.show_message(path)
    }

    override fun on_initial_dataLoad(banner: RecyclerViewBannerNormal, banner2: RecyclerViewBannerNormal, context: Context) {
        nb_intrector!!.initial_dataLoad(banner, banner2, context)
    }
}
