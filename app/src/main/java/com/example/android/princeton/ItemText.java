package com.example.android.princeton;

public class ItemText {
    private String mName;
    private String mTown;
    private String mWebAddress;

    private int mImageResourceId;

    public  ItemText(String name, String town, int imageResourceId) {
        mName = name;
        mTown = town;
        mImageResourceId = imageResourceId;
    }

    public  ItemText(String name, String town,  String webAddress, int imageResourceId) {
        mName = name;
        mTown = town;
        mWebAddress = webAddress;
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }

    public String getTown() {
        return mTown;
    }

    public String getWebAddress() {
        return mWebAddress;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
