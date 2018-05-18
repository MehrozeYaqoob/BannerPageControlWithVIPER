package com.example.haidermirza.banner.viper.intrector

import android.content.Context
import com.example.haidermirza.banner.adapter.RecyclerViewBannerNormal
import com.example.haidermirza.banner.viper.contract.NormalBannerContract
import com.example.haidermirza.banner.viper.entity.Banner
import java.util.*
import kotlin.collections.ArrayList

class NormalBanner_IntrectorImp : NormalBannerContract.NB_Intrector {
    private var nb_presenter: NormalBannerContract.NB_Presenter? = null
    private var list: MutableList<Banner>? = null
    override fun attach_presenter(presenter: NormalBannerContract.NB_Presenter) {
        nb_presenter = presenter
    }

    override fun initial_dataLoad(banner: RecyclerViewBannerNormal, banner2: RecyclerViewBannerNormal, context: Context) {

        setModel()
        banner.initBannerImageView(list!!) { position -> nb_presenter!!.on_banner_clik("clicked:$position") }
        banner2.initBannerImageView(list!!) { position -> nb_presenter!!.on_banner_clik("clicked:$position") }
    }

    private fun setModel() {
        list = ArrayList()
        list!!.add(Banner("http://img0.imgtn.bdimg.com/it/u=1352823040,1166166164&fm=27&gp=0.jpg"))
    }
}
