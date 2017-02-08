package com.bjzjnsdemo.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 图片信息
 */
public class ImageItem implements Parcelable {

    public String name;                //图片的名字
    public String thumbnailPath;       //图片的缩略图路径
    public String path;                //图片的路径
    public int res;                    //图片的资源
    public long size;                  //图片的大小
    public int width;                  //图片的宽度
    public int height;                 //图片的高度
    public String mimeType;            //图片的类型
    public long addTime;               //图片的创建时间

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.thumbnailPath);
        dest.writeString(this.path);
        dest.writeInt(this.res);
        dest.writeLong(this.size);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeString(this.mimeType);
        dest.writeLong(this.addTime);
    }

    public ImageItem() {

    }

    protected ImageItem(Parcel in) {
        this.name = in.readString();
        this.thumbnailPath = in.readString();
        this.path = in.readString();
        this.res = in.readInt();
        this.size = in.readLong();
        this.width = in.readInt();
        this.height = in.readInt();
        this.mimeType = in.readString();
        this.addTime = in.readLong();
    }

    public static final Creator<ImageItem> CREATOR = new Creator<ImageItem>() {
        @Override
        public ImageItem createFromParcel(Parcel source) {
            return new ImageItem(source);
        }

        @Override
        public ImageItem[] newArray(int size) {
            return new ImageItem[size];
        }
    };
}
