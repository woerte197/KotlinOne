package com.example.usercenter.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class test implements Parcelable {
    private String name;

    protected test(Parcel in) {
        name = in.readString();
    }

    public static final Creator<test> CREATOR = new Creator<test>() {
        @Override
        public test createFromParcel(Parcel in) {
            return new test(in);
        }

        @Override
        public test[] newArray(int size) {
            return new test[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
