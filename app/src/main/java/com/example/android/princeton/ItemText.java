package com.example.android.princeton;

public class ItemText {
    private String mName;
    private String mTown;

    private int mImageResourceId;

    public  ItemText(String name, String town, int imageResourceId) {
        mName = name;
        mTown = town;
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }

    public String getTown() {
        return mTown;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
