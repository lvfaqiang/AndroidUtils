package com.lvfq.androidutil;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * TestItem
 *
 * @author lvfq
 * @date 2017/6/29 上午10:59
 * @mainFunction :
 */

public class TestItem implements Parcelable {


    private int id;
    private String name;

    public TestItem() {
    }

    public TestItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
    }

    protected TestItem(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
    }

    public static final Creator<TestItem> CREATOR = new Creator<TestItem>() {
        @Override
        public TestItem createFromParcel(Parcel source) {
            return new TestItem(source);
        }

        @Override
        public TestItem[] newArray(int size) {
            return new TestItem[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
