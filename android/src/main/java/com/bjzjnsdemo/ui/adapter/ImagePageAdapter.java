package com.bjzjnsdemo.ui.adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.bjzjnsdemo.models.ImageItem;
import com.bjzjnsdemo.tools.TelephonyUtils;
import com.bjzjnsdemo.ui.view.SimplePhotoView;
import com.facebook.imagepipeline.common.ResizeOptions;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * 图片浏览适配器
 */

public class ImagePageAdapter extends PagerAdapter {

    private int screenWidth;
    private int screenHeight;
    private ArrayList<ImageItem> images = new ArrayList<>();
    private Activity mActivity;
    public PhotoViewClickListener listener;

    public ImagePageAdapter(Activity activity, ArrayList<ImageItem> images) {
        this.mActivity = activity;
        this.images = images;

        screenWidth = TelephonyUtils.getScreenWidth(mActivity);
        screenHeight = TelephonyUtils.getScreenHeight(mActivity);
    }

    public void setPhotoViewClickListener(PhotoViewClickListener listener) {
        this.listener = listener;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        SimplePhotoView photoView = new SimplePhotoView(mActivity);
        ImageItem imageItem = images.get(position);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(screenWidth, screenHeight);
        photoView.setLayoutParams(layoutParams);
        ResizeOptions resizeOptions = new ResizeOptions(screenWidth, screenHeight);
        //绝对路径的图片显示
        photoView.setImageUri(imageItem.path, resizeOptions);
//        photoView.setImageUri(imageItem.uri, resizeOptions);
        //本地图片的显示方式
        //photoView.setImageUri("file://" + imageItem.path, resizeOptions);
        //应用内部图片的显示方式
        //photoView.setImageResource(imageItem.res);
        photoView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float x, float y) {
                if (listener != null) listener.OnPhotoTapListener(view, x, y);
            }
        });
        container.addView(photoView);
        return photoView;
    }

    @Override
    public int getCount() {
        return images == null ? 0 : images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public interface PhotoViewClickListener {
        void OnPhotoTapListener(View view, float v, float v1);
    }
}
