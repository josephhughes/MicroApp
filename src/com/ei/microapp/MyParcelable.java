package com.ei.microapp;

import android.os.Parcel;
import android.os.Parcelable;

public class MyParcelable implements Parcelable{

    public String[][] strings;

    public String[][] getStrings() {
        return strings;
    }

    public void setStrings(String[][] strings) {
        this.strings = strings;
    }

    public MyParcelable() {
        strings = new String[1][1];
    }

    public MyParcelable(Parcel in) {
        strings = (String[][]) in.readSerializable();
    }

//    @Override
    public int describeContents() {
        return 0;
    }

//    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(strings);

    }
    public static final Parcelable.Creator<MyParcelable> CREATOR = new Parcelable.Creator<MyParcelable>() {

//        @Override
        public MyParcelable createFromParcel(Parcel in) {
            return new MyParcelable(in);
        }

//        @Override
        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };
}