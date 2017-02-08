package com.bjzjnsdemo.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.bjzjnsdemo.models.ImageItem;
import com.bjzjnsdemo.ui.activity.ImagePreviewActivity;
import com.bjzjnsdemo.ui.activity.RichEditorActivity;

import java.util.ArrayList;

/**
 * Created by blade on 19/01/2017.
 */

public class Navigator {

    public static void startImageViewActivity(Context context, ArrayList<ImageItem> itemList,int currentIndex) {
        Intent intent = new Intent(context,ImagePreviewActivity.class);
        intent.putParcelableArrayListExtra(IntentKey.EXTRA_IMAGE_ITEMS,itemList);
	intent.putExtra(IntentKey.EXTRA_SELECTED_IMAGE_POSITION,currentIndex);
        context.startActivity(intent);
    }

    public static void startRichEditorActivityForResult(Activity activity, int requestcode) {
        Intent intent = new Intent(activity,RichEditorActivity.class);
        activity.startActivityForResult(intent,requestcode);
    }

}
