package com.liompei.jandan.ui.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liompei.jandan.R;
import com.liompei.jandan.bean.OtherBean;
import com.liompei.jandan.util.GlideUtil;
import com.liompei.jandan.util.TimeUtil;
import com.liompei.jandan.view.MyGridView;
import com.liompei.jandan.view.MyMaxImageView;
import com.liompei.zxlog.Zx;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liompei
 * time : 2017/11/9 11:21
 * 1137694912@qq.com
 * remark:
 */

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.BaseHolder> {

    private List<OtherBean.CommentsBean> mCommentsBeanList;

    public PictureAdapter() {
        mCommentsBeanList = new ArrayList<>();
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            return new MyOnlyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_picture_only_list, parent, false));
        } else {
            return new BaseHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_picture_gv_list, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        OtherBean.CommentsBean commentsBean = mCommentsBeanList.get(position);
        List<String> pics = commentsBean.getPics();
        holder.tv_author.setText(commentsBean.getComment_author());
        holder.tv_content.setText(commentsBean.getText_content());
        holder.tv_like.setText(commentsBean.getVote_positive());
        holder.tv_un_like.setText(commentsBean.getVote_negative());
        holder.tv_comment.setText("吐槽 " + commentsBean.getSub_comment_count());
        try {
            holder.tv_time.setText(TimeUtil.getTimeFormatText(TimeUtil.stringToDate(commentsBean.getComment_date(), "yyyy-MM-dd HH:mm:ss")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (holder instanceof MyOnlyHolder) {
            MyOnlyHolder myOnlyHolder = (MyOnlyHolder) holder;
            String picUrl = pics.get(0);
            if (picUrl.endsWith(".gif")) {
                myOnlyHolder.iv_type_gif.setVisibility(View.VISIBLE);
            } else {
                myOnlyHolder.iv_type_gif.setVisibility(View.GONE);
            }
            GlideUtil.load(myOnlyHolder.mMyMaxImageView.getContext(), picUrl, myOnlyHolder.mMyMaxImageView);
        } else if (holder instanceof MyGvHolder) {
            MyGvHolder myGvHolder = (MyGvHolder) holder;
            Zx.d("多个图片集合");
        }
    }

    @Override
    public int getItemCount() {
        return mCommentsBeanList.size();
    }

    public void newData(List<OtherBean.CommentsBean> commentsBeanList) {
        mCommentsBeanList.clear();
        mCommentsBeanList.addAll(commentsBeanList);
        notifyDataSetChanged();
    }

    class BaseHolder extends RecyclerView.ViewHolder {
        CardView cv_content;
        TextView tv_author;  //作者
        TextView tv_time;  //时间
        TextView tv_content;  //文字
        LinearLayout ll_support;  //OO
        TextView tv_like_des;
        TextView tv_like;  //OO数量
        LinearLayout ll_un_support;  //XX
        TextView tv_un_like;  //XX数量
        TextView tv_comment;  //吐槽
        ImageView iv_more;  //更多

        public BaseHolder(View itemView) {
            super(itemView);
            cv_content = itemView.findViewById(R.id.cv_content);
            tv_author = itemView.findViewById(R.id.tv_author);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_content = itemView.findViewById(R.id.tv_content);
            ll_support = itemView.findViewById(R.id.ll_support);
            tv_like_des = itemView.findViewById(R.id.tv_like_des);
            tv_like = itemView.findViewById(R.id.tv_like);
            ll_un_support = itemView.findViewById(R.id.ll_un_support);
            tv_un_like = itemView.findViewById(R.id.tv_un_like);
            tv_comment = itemView.findViewById(R.id.tv_comment);
            iv_more = itemView.findViewById(R.id.iv_more);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mCommentsBeanList.get(position).getPics().size();
    }

    class MyOnlyHolder extends BaseHolder {
        MyMaxImageView mMyMaxImageView;
        ImageView iv_type_gif;

        public MyOnlyHolder(View itemView) {
            super(itemView);
            mMyMaxImageView = itemView.findViewById(R.id.m_max_view);
            iv_type_gif = itemView.findViewById(R.id.iv_type_gif);
        }
    }

    class MyGvHolder extends BaseHolder {
        MyGridView mMyGridView;  //图片

        public MyGvHolder(View itemView) {
            super(itemView);
            mMyGridView = itemView.findViewById(R.id.m_grid_view);
        }
    }

}
