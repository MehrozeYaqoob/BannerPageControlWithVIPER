package com.example.haidermirza.banner.viper.router

import android.content.Context
import android.content.Intent

import com.example.haidermirza.banner.viper.contract.MainContract
import com.example.haidermirza.banner.viper.view.NormalActivityImp
import com.example.haidermirza.banner.viper.view.OverFlyingActivityImp

class MainRouterImp : MainContract.MainRouter {
    override fun start_normalActivity(context: Context) {
        val intent = Intent(context, NormalActivityImp::class.java)
        context.startActivity(intent)
    }

    override fun start_overFlyingActivity(context: Context) {
        val intent = Intent(context, OverFlyingActivityImp::class.java)
        context.startActivity(intent)
    }
}
