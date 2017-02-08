package com.bjzjnsdemo.event;

import android.app.Dialog;

/**
 * 富文本编辑器插入数据的Event
 */

public class InsertEvent {

    public Dialog dialog; //对话框
    public String url;  //插入的链接
    public String text; //插入链接对应的文字
    public int style; //插入对话框的样式

}
