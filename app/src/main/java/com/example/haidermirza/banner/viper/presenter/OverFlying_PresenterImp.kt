package com.example.haidermirza.banner.viper.presenter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.widget.SeekBar

import com.example.haidermirza.banner.viper.contract.OverFlyingContract
import com.example.haidermirza.banner.viper.intrector.OverFlying_IntrectorImp

class OverFlying_PresenterImp : OverFlyingContract.OF_Presenter {
    private var of_intrector: OverFlyingContract.OF_Intrector? = null
    private var of_view: OverFlyingContract.OF_View? = null

    override fun attach_view(view: OverFlyingContract.OF_View) {
        this.of_view = view
        of_intrector = OverFlying_IntrectorImp()
        of_intrector!!.attach_presenter(this)
    }

    override fun on_banner_clik(path: String) {
        of_view!!.show_message(path)
    }

    override fun on_initial_dataLoad(recyclerView: RecyclerView, seekBar: SeekBar, context: Context) {
        of_intrector!!.initial_dataLoad(recyclerView, seekBar, context)
    }
}
