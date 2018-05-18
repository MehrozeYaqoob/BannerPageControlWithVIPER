package com.example.haidermirza.banner.viper.intrector

import android.content.Context
import com.example.haidermirza.banner.adapter.WebBannerAdapter
import com.example.haidermirza.banner.library.BannerLayout
import com.example.haidermirza.banner.viper.contract.MainContract
import com.example.haidermirza.banner.viper.entity.Banner

class MainIntrectorImp : MainContract.MainInterator {

    private var presenter: MainContract.MainPresenter? = null
    private var list: ArrayList<Banner>? = null

    override fun dataLoad(recyclerBanner: BannerLayout, bannerVertical: BannerLayout, context: Context) {

        setmodel()

        val webBannerAdapter = WebBannerAdapter(context, list)
        webBannerAdapter.setOnBannerItemClickListener { position -> presenter!!.on_banner_clik("Click on the first  $position  item") }

        val webBannerAdapter2 = WebBannerAdapter(context, list)
        webBannerAdapter2.setOnBannerItemClickListener { position -> presenter!!.on_banner_clik("Click on the first  $position  item") }
        recyclerBanner.setAdapter(webBannerAdapter)
        bannerVertical.setAdapter(webBannerAdapter2)
    }

    override fun attach_presenter(presenter: MainContract.MainPresenter) {
        this.presenter = presenter
    }

    private fun setmodel() {
        list = ArrayList()

        list!!.add(Banner("http://img0.imgtn.bdimg.com/it/u=1352823040,1166166164&fm=27&gp=0.jpg"))
        list!!.add(Banner("http://img3.imgtn.bdimg.com/it/u=2293177440,3125900197&fm=27&gp=0.jpg"))
        list!!.add(Banner("http://img3.imgtn.bdimg.com/it/u=3967183915,4078698000&fm=27&gp=0.jpg"))
        list!!.add(Banner("http://img0.imgtn.bdimg.com/it/u=3184221534,2238244948&fm=27&gp=0.jpg"))
        list!!.add(Banner("http://img4.imgtn.bdimg.com/it/u=1794621527,1964098559&fm=27&gp=0.jpg"))
        list!!.add(Banner("http://img4.imgtn.bdimg.com/it/u=1243617734,335916716&fm=27&gp=0.jpg"))
    }
}

