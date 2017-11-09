package com.liompei.jandan.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.liompei.jandan.R;
import com.liompei.zxlog.Zx;

/**
 * Created by Liompei
 * time : 2017/11/9 9:13
 * 1137694912@qq.com
 * remark:
 */

public class GlideUtil {

    public static void load(Context context, @Nullable Object url, final ImageView imageView) {
        GlideApp.with(context)
                .load(url)
                .placeholder(R.drawable.icon_default_picture)
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        if (resource instanceof GifDrawable) {
                            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                            imageView.setLayoutParams(new RelativeLayout.LayoutParams(layoutParams.width, 250));
                            imageView.setImageDrawable(resource);
                        } else {
                            BitmapDrawable bitmapDrawable = (BitmapDrawable) resource;
                            Bitmap bitmap = bitmapDrawable.getBitmap();
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            Zx.d(bitmap.getWidth());
                            Zx.d(bitmap.getHeight());

                            float scale = height / width;

                            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                            float nowHeight = layoutParams.width * scale;
                            imageView.setLayoutParams(new RelativeLayout.LayoutParams(layoutParams.width, (int) nowHeight));
                            imageView.setImageBitmap(bitmap);
                        }
                    }
                });
    }
}
