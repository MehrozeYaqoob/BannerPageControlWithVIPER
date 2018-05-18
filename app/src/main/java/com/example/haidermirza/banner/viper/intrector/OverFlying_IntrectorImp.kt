package com.example.haidermirza.banner.viper.intrector

import android.content.Context
import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.SeekBar
import com.example.haidermirza.banner.adapter.LocalDataAdapter
import com.example.haidermirza.banner.library.layoutmanager.CenterScrollListener
import com.example.haidermirza.banner.library.layoutmanager.OverFlyingLayoutManager
import com.example.haidermirza.banner.viper.contract.OverFlyingContract

class OverFlying_IntrectorImp : OverFlyingContract.OF_Intrector {
    private var of_presenter: OverFlyingContract.OF_Presenter? = null

    private var recyclerView: RecyclerView? = null
    private var mOverFlyingLayoutManager: OverFlyingLayoutManager? = null
    private var mHandler: Handler? = null
    private var mRunnable: Runnable? = null
    private var currentPosition = 0
    private var seekBar: SeekBar? = null
    private var context: Context? = null

    override fun attach_presenter(presenter: OverFlyingContract.OF_Presenter) {
        of_presenter = presenter
    }

    override fun initial_dataLoad(recyclerView: RecyclerView, seekBar: SeekBar, context: Context) {
        this.recyclerView = recyclerView
        this.seekBar = seekBar
        this.context = context
        set_layoutManager()
        recyclerView.adapter = LocalDataAdapter()
        recyclerView.layoutManager = mOverFlyingLayoutManager
        recyclerView.addOnScrollListener(CenterScrollListener())
        set_handler()
        set_seekBar()
    }

    private fun set_layoutManager() {
        mOverFlyingLayoutManager = OverFlyingLayoutManager(0.75f, 385, OverFlyingLayoutManager.HORIZONTAL)
        mOverFlyingLayoutManager!!.setOnPageChangeListener(object : OverFlyingLayoutManager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                currentPosition = position
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    private fun set_handler() {
        mHandler = Handler()
        mRunnable = object : Runnable {
            override fun run() {
                currentPosition++
                Log.d("recyclerBanner", currentPosition.toString() + " ")
                mOverFlyingLayoutManager!!.scrollToPosition(currentPosition)
                //  recyclerView.smoothScrollToPosition(currentPosition);
                mHandler!!.postDelayed(this, 3000)
            }
        }
        mHandler!!.postDelayed(mRunnable, 3000)
    }

    private fun set_seekBar() {

        seekBar!!.progress = 385
        seekBar!!.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                mOverFlyingLayoutManager!!.itemSpace = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                of_presenter!!.on_banner_clik("seekBar progress set to " + seekBar.progress)
            }
        })
    }
}
