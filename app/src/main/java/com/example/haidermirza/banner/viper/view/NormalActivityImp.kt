package com.example.haidermirza.banner.viper.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

import com.example.haidermirza.banner.R
import com.example.haidermirza.banner.adapter.RecyclerViewBannerNormal
import com.example.haidermirza.banner.viper.contract.NormalBannerContract
import com.example.haidermirza.banner.viper.presenter.NormalBanner_PresenterImp

class NormalActivityImp : AppCompatActivity(), NormalBannerContract.NB_View {
    internal lateinit var banner: RecyclerViewBannerNormal
    internal lateinit var banner2: RecyclerViewBannerNormal
    internal lateinit var presenterImp: NormalBanner_PresenterImp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)
        banner = findViewById(R.id.banner)
        banner2 = findViewById(R.id.banner2)
        presenterImp = NormalBanner_PresenterImp()
        presenterImp.attach_view(this)

        presenterImp.on_initial_dataLoad(banner, banner2, this)
    }

    override fun show_message(str: String) {
        Toast.makeText(this@NormalActivityImp, str, Toast.LENGTH_SHORT).show()
    }
}
