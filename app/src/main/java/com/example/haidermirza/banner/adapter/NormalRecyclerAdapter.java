package com.example.haidermirza.banner.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.haidermirza.banner.library.RecyclerViewBannerBase;
import com.example.haidermirza.banner.viper.entity.Banner;

import java.util.List;

/**
 * RecyclerView Adapter
 */
public class NormalRecyclerAdapter extends RecyclerView.Adapter<NormalRecyclerAdapter.NormalHolder> {

    private RecyclerViewBannerBase.OnBannerItemClickListener onBannerItemClickListener;
    private Context context;
    private List<Banner> urlList;

    public NormalRecyclerAdapter(Context context, List<Banner> urlList, RecyclerViewBannerBase.OnBannerItemClickListener onBannerItemClickListener) {
        this.context = context;
        this.urlList = urlList;
        this.onBannerItemClickListener = onBannerItemClickListener;
    }

    @Override
    public NormalRecyclerAdapter.NormalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalHolder(new ImageView(context));
    }

    @Override
    public void onBindViewHolder(NormalHolder holder, final int position) {
        if (urlList == null || urlList.isEmpty())
            return;
        String url = urlList.get(position % urlList.size()).getUrl();
        ImageView img = (ImageView) holder.itemView;
        Glide.with(context).load(url).into(img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onBannerItemClickListener != null) {
                    onBannerItemClickListener.onItemClick(position % urlList.size());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    class NormalHolder extends RecyclerView.ViewHolder {
        ImageView bannerItem;

        NormalHolder(View itemView) {
            super(itemView);
            bannerItem = (ImageView) itemView;
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            bannerItem.setLayoutParams(params);
            bannerItem.setScaleType(ImageView.ScaleType.FIT_XY);

        }
    }

}
