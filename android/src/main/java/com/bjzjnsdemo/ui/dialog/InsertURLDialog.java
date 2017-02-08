package com.bjzjnsdemo.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.bjzjnsdemo.R;
import com.bjzjnsdemo.event.InsertEvent;

import org.greenrobot.eventbus.EventBus;


/**
 * 插入链接对话框
 */
public class InsertURLDialog {

    public static final int STYLE_INSERT_IAMGE = 1001;
    public static final int STYLE_INSERT_LINK = 1002;

    private final Dialog mDialog;
    private Context mContext;
    private EditText mLinkURL;       //链接地址
    private EditText mLinkText;      //链接文字
    private TextView mOKText;        //确认按钮
    private TextView mCancelText;    //取消按钮
    private int mStyle;   //对话框样式标记


    public InsertURLDialog(Context context, int style) {
        mContext = context;
        mDialog = new Dialog(mContext, R.style.InsertURL_Dialog);
        View dialog = View.inflate(mContext, R.layout.dialog_insert_url, null);
        WindowManager.LayoutParams localLayoutParams = mDialog.getWindow().getAttributes();

        mDialog.onWindowAttributesChanged(localLayoutParams);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.setCancelable(true);
        dialog.setMinimumWidth(10000);

        mLinkURL = (EditText) dialog.findViewById(R.id.linkURL);
        mLinkText = (EditText) dialog.findViewById(R.id.linkText);
        mOKText = (TextView) dialog.findViewById(R.id.okText);
        mCancelText = (TextView) dialog.findViewById(R.id.cancelText);
        mStyle = style;

        mOKText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertEvent insertEvent = new InsertEvent();
                insertEvent.dialog = mDialog;
                insertEvent.url = mLinkURL.getText().toString().trim();
                insertEvent.text = mLinkText.getText().toString().trim();
                insertEvent.style = mStyle;
                EventBus.getDefault().post(insertEvent);
            }
        });

        mCancelText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        if (style == STYLE_INSERT_IAMGE) {
            mLinkText.setVisibility(View.GONE);
        }

        mDialog.setContentView(dialog);
        localLayoutParams.gravity = Gravity.FILL_HORIZONTAL;
    }

    public void dismiss() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    public void show() {
        if (mDialog != null) {
            mDialog.show();
        }
    }
}
