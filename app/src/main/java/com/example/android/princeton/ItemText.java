package com.example.android.princeton;

public class ItemText {
    private String mName;
    private String mTown;

//    /** image resource is not provided **/
//    private static final int NO_IMAGE_PROVIDED = -1;
//    /** image resource id **/
//    private int mImageResourceId = NO_IMAGE_PROVIDED;

//    public  ItemText(String name, String town, int imageResourceId) {
//        mName = name;
//        mTown = town;
//        mImageResourceId = imageResourceId;
//    }

    public ItemText(String name, String town) {
        mName = name;
        mTown = town;
    }

    public String getName() {
        return mName;
    }

    public String getTown() {
        return mTown;
    }

//    public int getImageResourceId() {
//        return mImageResourceId;
//    }

//    public boolean hasValidImage() {
//        return mImageResourceId != NO_IMAGE_PROVIDED;
//    }
}
