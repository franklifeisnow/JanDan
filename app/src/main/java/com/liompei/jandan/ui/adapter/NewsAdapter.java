package com.liompei.jandan.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liompei.jandan.R;

/**
 * Created by Liompei
 * time : 2017/11/8 14:48
 * 1137694912@qq.com
 * remark:
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyHolder>{


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        ImageView iv_img;
        TextView tv_title;
        TextView tv_author;
        TextView tv_time;
        TextView tv_comment;
        public MyHolder(View itemView) {
            super(itemView);
            iv_img=itemView.findViewById(R.id.iv_img);
            tv_title=itemView.findViewById(R.id.tv_title);
            tv_author=itemView.findViewById(R.id.tv_author);
            tv_time=itemView.findViewById(R.id.tv_time);
            tv_comment=itemView.findViewById(R.id.tv_comment);
        }
    }
}
