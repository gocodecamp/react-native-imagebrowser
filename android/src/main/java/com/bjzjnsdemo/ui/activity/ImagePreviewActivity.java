package com.bjzjnsdemo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bjzjnsdemo.R;
import com.bjzjnsdemo.models.ImageItem;
import com.bjzjnsdemo.tools.IntentKey;
import com.bjzjnsdemo.ui.adapter.ImagePageAdapter;
import com.bjzjnsdemo.ui.view.ViewPagerFixed;

import java.util.ArrayList;


/**
 * ======================== 图片加载的使用说明 ========================
 * <p>
 * 类型	                    Scheme	                 示例
 * 远程图片                	http://,https://        HttpURLConnection
 * 本地文件	                file://	                FileInputStream
 * asset目录下的资源	        asset://            	AssetManager
 * res目录下的资源	        res://	                Resources.openRawResource
 * <p>
 * imageItem.path = "http://img0.pconline.com.cn/pconline/1505/14/6457042_4_thumb.jpg";  //网络图片的全路径
 * imageItem.path = "file://" + PathUtils.getRealFilePath(this, originalUri);  //添加图片在SD卡的绝对路径
 * imageItem.path = "asset:///"+"ic_launcher.png";                      //添加图片在 asset目录下的路径名称
 * imageItem.path = "res:///" + R.drawable.ic_launcher;               //  "res://包名(实际可以是任何字符串甚至留空)/" + R.drawable.ic_launcher
 */

/**
 * 图片浏览界面
 */
public class ImagePreviewActivity extends AppCompatActivity {

    private ViewPagerFixed mViewPagerFixed;
    private ArrayList<ImageItem> mImageItems;   //需要展示的图片的集合
    private int mCurrentPosition = 0;           //跳转进图片预览界面时的序号，第几个图片

    public static final int CHOOSE_PICTURE = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_preview);

        mImageItems = getIntent().getParcelableArrayListExtra(IntentKey.EXTRA_IMAGE_ITEMS);   //获取图片集合
        mCurrentPosition = getIntent().getIntExtra(IntentKey.EXTRA_SELECTED_IMAGE_POSITION, 0);         //默认的图片显示位置
        mViewPagerFixed = (ViewPagerFixed) findViewById(R.id.viewpager);


        for (int i = 0; i < mImageItems.size(); i++) {
            Log.d("Count", "path = " + mImageItems.get(i).path);
        }

        if (mImageItems == null || mImageItems.size() == 0) {
            ImageItem imageItem = new ImageItem();
            imageItem.path = "http://img0.pconline.com.cn/pconline/1505/14/6457042_4_thumb.jpg";  //网络图片的全路径
            mImageItems = new ArrayList<>();
            mImageItems.add(imageItem);
            mImageItems.add(imageItem);
            mImageItems.add(imageItem);
            mImageItems.add(imageItem);
            mImageItems.add(imageItem);
        }
        ImagePageAdapter adapter = new ImagePageAdapter(this, mImageItems);
        mViewPagerFixed.setAdapter(adapter);
        mViewPagerFixed.setCurrentItem(mCurrentPosition, false);


//        //  //调用相册
//        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        intent.setType("image/*");
//        startActivityForResult(intent, CHOOSE_PICTURE);

    }

//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        if (resultCode != Activity.RESULT_OK) return;
//        switch (requestCode) {
//            case CHOOSE_PICTURE:
//                Uri originalUri = data.getData();        //获得图片的uri
//                if (originalUri == null) {
//                    return;
//                }
//
//                if (mImageItems == null || mImageItems.size() == 0) {
//                    ImageItem imageItem = new ImageItem();
////
////                    类型	                Scheme	                 示例
////                    远程图片            	http://,https://        HttpURLConnection
////                    本地文件	            file://	                FileInputStream
////                    asset目录下的资源	    asset://            	AssetManager
////                    res目录下的资源	        res://	                Resources.openRawResource
////
////                    imageItem.path = "http://img0.pconline.com.cn/pconline/1505/14/6457042_4_thumb.jpg";  //网络图片的全路径
////                    imageItem.path = "file://" + PathUtils.getRealFilePath(this, originalUri);  //添加图片在SD卡的绝对路径
////                    imageItem.path = "asset:///"+"ic_launcher.png";                  //添加图片在 asset目录下的路径名称
////                    imageItem.path = "res:///" + R.drawable.ic_launcher;            //  "res://包名(实际可以是任何字符串甚至留空)/" + R.drawable.ic_launcher
//
//                    mImageItems = new ArrayList<>();
//                    mImageItems.add(imageItem);
//                    mImageItems.add(imageItem);
//                    mImageItems.add(imageItem);
//                    mImageItems.add(imageItem);
//                    mImageItems.add(imageItem);
//                }
//                ImagePageAdapter adapter = new ImagePageAdapter(this, mImageItems);
//                mViewPagerFixed.setAdapter(adapter);
//                mViewPagerFixed.setCurrentItem(mCurrentPosition, false);
//        }
//    }
}
