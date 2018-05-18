package com.example.haidermirza.banner.viper.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.SeekBar
import android.widget.Toast

import com.example.haidermirza.banner.R
import com.example.haidermirza.banner.viper.contract.OverFlyingContract
import com.example.haidermirza.banner.viper.presenter.OverFlying_PresenterImp


class OverFlyingActivityImp : AppCompatActivity(), OverFlyingContract.OF_View {

    internal lateinit var overFlying_presenterImp: OverFlying_PresenterImp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_over_flying)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_banner)
        val seekBar = findViewById<SeekBar>(R.id.progress)
        overFlying_presenterImp = OverFlying_PresenterImp()
        overFlying_presenterImp.attach_view(this)
        overFlying_presenterImp.on_initial_dataLoad(recyclerView, seekBar, this)
    }

    override fun show_message(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }
}
