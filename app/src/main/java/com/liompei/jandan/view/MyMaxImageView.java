package com.liompei.jandan.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by Liompei
 * time : 2017/11/9 15:58
 * 1137694912@qq.com
 * remark:宽度最大，高度自适应的imageView
 * 若高度超过屏幕，将被压缩为屏幕的1/3
 */

public class MyMaxImageView extends AppCompatImageView {

    private float mHeight = 0;

    public MyMaxImageView(Context context) {
        super(context);
    }

    public MyMaxImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyMaxImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        Zx.d("onMeasure");
//        if (mHeight != 0) {
//            int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
//            int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);   //当前高
//            int resultHeight = (int) Math.max(mHeight, sizeHeight);  //当前的高度和缩放的高度哪个大取哪个值
//
//            if (resultHeight >= ScreenSizeUtil.getScreenHeight((Activity) getContext())) {
//                resultHeight = ScreenSizeUtil.getScreenHeight((Activity) getContext()) / 3;
//            }
//            setMeasuredDimension(sizeWidth, resultHeight);
//        } else {
//            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        }
//    }
//
//    //设置一个位图作为这个ImageView的内容
//    @Override
//    public void setImageBitmap(Bitmap bm) {
//        Zx.d("setImageBitmap");
//        if (bm != null) {
//            getBitmapHeight(bm);
//        }
//        super.setImageBitmap(bm);
//        requestLayout();  //重新测量
//    }
//
//    @Override
//    public void setImageDrawable(@Nullable Drawable drawable) {
//        Zx.d("setImageDrawable");
//        if (drawable != null) {
//            getBitmapHeight(getBitmapForDrawable(drawable));
//        }
//        super.setImageDrawable(drawable);
//        requestLayout();  //重新测量
//    }
//
//    //拿到图片缩放后的高度
//    private void getBitmapHeight(Bitmap bitmap) {
//        float bitmapWidth = bitmap.getWidth();
//        float bitmapHeight = bitmap.getHeight();
//
//        if (bitmapWidth > 0 && bitmapHeight > 0) {
//            //拿到宽度的缩放值
//            float scaleWidth = getWidth() / bitmapWidth;
//            //拿到高度根据宽度缩放后的高度
//            mHeight = bitmapHeight * scaleWidth;
//        }
//    }
//
//    private Bitmap getBitmapForDrawable(Drawable drawable) {
//        if (drawable != null) {
//            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
//            return bitmapDrawable.getBitmap();
//        } else {
//            return null;
//        }
//    }

}
