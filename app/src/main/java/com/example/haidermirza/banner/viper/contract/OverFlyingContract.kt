package com.example.haidermirza.banner.viper.contract

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.widget.SeekBar

interface OverFlyingContract {
    interface OF_View {
        fun show_message(str: String)
    }

    interface OF_Intrector {
        fun attach_presenter(presenter: OverFlyingContract.OF_Presenter)
        fun initial_dataLoad(recyclerView: RecyclerView, seekBar: SeekBar, context: Context)
    }

    interface OF_Presenter {
        fun attach_view(view: OverFlyingContract.OF_View)
        fun on_banner_clik(path: String)
        fun on_initial_dataLoad(recyclerView: RecyclerView, seekBar: SeekBar, context: Context)
    }
}
