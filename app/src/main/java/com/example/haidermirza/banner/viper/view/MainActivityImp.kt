package com.example.haidermirza.banner.viper.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

import com.example.haidermirza.banner.R
import com.example.haidermirza.banner.library.BannerLayout
import com.example.haidermirza.banner.viper.contract.MainContract
import com.example.haidermirza.banner.viper.presenter.MainPresenterImp

class MainActivityImp : AppCompatActivity(), MainContract.MainView {

    internal lateinit var mainPresenterImp: MainPresenterImp
    internal lateinit var recyclerBanner: BannerLayout
    internal lateinit var bannerVertical: BannerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerBanner = findViewById(R.id.recycler)
        bannerVertical = findViewById(R.id.recycler_ver)
        mainPresenterImp = MainPresenterImp()

        mainPresenterImp.attach_view(this)
        mainPresenterImp.on_initial_dataLoad(recyclerBanner, bannerVertical, this)
    }

    fun jump(view: View) {
        mainPresenterImp.on_start_normalActivity(this)
    }

    fun jumpOverFlying(view: View) {
        mainPresenterImp.on_start_overFlyingActivity(this)
    }

    override fun show_message(str: String) {
        Toast.makeText(this@MainActivityImp, str, Toast.LENGTH_SHORT).show()
    }
}
