package com.example.haidermirza.banner.viper.presenter

import android.content.Context

import com.example.haidermirza.banner.library.BannerLayout
import com.example.haidermirza.banner.viper.contract.MainContract
import com.example.haidermirza.banner.viper.intrector.MainIntrectorImp
import com.example.haidermirza.banner.viper.router.MainRouterImp

class MainPresenterImp : MainContract.MainPresenter {
    private var view: MainContract.MainView? = null
    private val interactor: MainContract.MainInterator
    private val mainRouter: MainContract.MainRouter

    override fun attach_view(view: MainContract.MainView) {
        this.view = view
    }

    init {
        this.interactor = MainIntrectorImp()
        interactor.attach_presenter(this)
        this.mainRouter = MainRouterImp()
    }

    override fun on_initial_dataLoad(recyclerBanner: BannerLayout, bannerVertical: BannerLayout, context: Context) {
        interactor.dataLoad(recyclerBanner, bannerVertical, context)
    }

    override fun on_banner_clik(path: String) {
        view!!.show_message(path)
    }

    override fun on_start_normalActivity(context: Context) {
        mainRouter.start_normalActivity(context)
    }

    override fun on_start_overFlyingActivity(context: Context) {
        mainRouter.start_overFlyingActivity(context)
    }
}
