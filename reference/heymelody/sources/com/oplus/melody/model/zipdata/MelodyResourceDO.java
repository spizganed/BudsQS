package com.oplus.melody.model.zipdata;

import I3.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class MelodyResourceDO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<MelodyResourceDO> CREATOR = new a();
    private String mBackgroundColor;

    @b(alternate = {"nightBackgroundColor"}, value = "backgroundColorNight")
    private String mBackgroundColorNight;
    private String mBottom;
    private int mBottomMargin;
    private int mButton;
    private int mEnterUpAnim;
    private int mFgOffsetMargin;
    private String mForegroundColor;
    private String mForegroundColorNight;
    private String mGradientEndColor;
    private String mGradientEndColorNight;
    private String mGradientStartColor;
    private String mGradientStartColorNight;
    private int mGravity;
    private String mHeight;
    private int mImageOffsetMargin;
    private String mLeft;
    private int mLeftMargin;
    private double mLuminance;
    private String mPath;
    private String mRight;
    private int mRightMargin;
    private String mText;
    private String mTextColor;
    private String mTextColorNight;
    private String mTextSize;
    private String mTop;
    private int mTopMargin;
    private int mType;
    private String mUrl;
    private String mWidth;

    public class a implements Parcelable.Creator<MelodyResourceDO> {
        @Override // android.os.Parcelable.Creator
        public final MelodyResourceDO createFromParcel(Parcel parcel) {
            return new MelodyResourceDO(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final MelodyResourceDO[] newArray(int i10) {
            return new MelodyResourceDO[i10];
        }
    }

    public MelodyResourceDO() {
        this.mLuminance = 1.0d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public String getBackgroundColorNight() {
        return this.mBackgroundColorNight;
    }

    public String getBottom() {
        return this.mBottom;
    }

    public int getBottomMargin() {
        return this.mBottomMargin;
    }

    public int getButton() {
        return this.mButton;
    }

    public int getEnterUpAnim() {
        return this.mEnterUpAnim;
    }

    public int getFgOffsetMargin() {
        return this.mFgOffsetMargin;
    }

    public String getForegroundColor() {
        return this.mForegroundColor;
    }

    public String getForegroundColorNight() {
        return this.mForegroundColorNight;
    }

    public String getGradientEndColor() {
        return this.mGradientEndColor;
    }

    public String getGradientEndColorNight() {
        return this.mGradientEndColorNight;
    }

    public String getGradientStartColor() {
        return this.mGradientStartColor;
    }

    public String getGradientStartColorNight() {
        return this.mGradientStartColorNight;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public String getHeight() {
        return this.mHeight;
    }

    public int getImageOffsetMargin() {
        return this.mImageOffsetMargin;
    }

    public String getLeft() {
        return this.mLeft;
    }

    public int getLeftMargin() {
        return this.mLeftMargin;
    }

    public double getLuminance() {
        return this.mLuminance;
    }

    public String getPath() {
        return this.mPath;
    }

    public String getRight() {
        return this.mRight;
    }

    public int getRightMargin() {
        return this.mRightMargin;
    }

    public String getText() {
        return this.mText;
    }

    public String getTextColor() {
        return this.mTextColor;
    }

    public String getTextColorNight() {
        return this.mTextColorNight;
    }

    public String getTextSize() {
        return this.mTextSize;
    }

    public String getTop() {
        return this.mTop;
    }

    public int getTopMargin() {
        return this.mTopMargin;
    }

    public int getType() {
        return this.mType;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getWidth() {
        return this.mWidth;
    }

    public void setBackgroundColor(String str) {
        this.mBackgroundColor = str;
    }

    public void setBackgroundColorNight(String str) {
        this.mBackgroundColorNight = str;
    }

    public void setBottom(String str) {
        this.mBottom = str;
    }

    public void setBottomMargin(int i10) {
        this.mBottomMargin = i10;
    }

    public void setButton(int i10) {
        this.mButton = i10;
    }

    public void setEnterUpAnim(int i10) {
        this.mEnterUpAnim = i10;
    }

    public void setFgOffsetMargin(int i10) {
        this.mFgOffsetMargin = i10;
    }

    public void setForegroundColor(String str) {
        this.mForegroundColor = str;
    }

    public void setForegroundColorNight(String str) {
        this.mForegroundColorNight = str;
    }

    public void setGradientEndColor(String str) {
        this.mGradientEndColor = str;
    }

    public void setGradientEndColorNight(String str) {
        this.mGradientEndColorNight = str;
    }

    public void setGradientStartColor(String str) {
        this.mGradientStartColor = str;
    }

    public void setGradientStartColorNight(String str) {
        this.mGradientStartColorNight = str;
    }

    public void setGravity(int i10) {
        this.mGravity = i10;
    }

    public void setHeight(String str) {
        this.mHeight = str;
    }

    public void setImageOffsetMargin(int i10) {
        this.mImageOffsetMargin = i10;
    }

    public void setLeft(String str) {
        this.mLeft = str;
    }

    public void setLeftMargin(int i10) {
        this.mLeftMargin = i10;
    }

    public void setLuminance(double d10) {
        this.mLuminance = d10;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public void setRight(String str) {
        this.mRight = str;
    }

    public void setRightMargin(int i10) {
        this.mRightMargin = i10;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setTextColor(String str) {
        this.mTextColor = str;
    }

    public void setTextColorNight(String str) {
        this.mTextColorNight = str;
    }

    public void setTextSize(String str) {
        this.mTextSize = str;
    }

    public void setTop(String str) {
        this.mTop = str;
    }

    public void setTopMargin(int i10) {
        this.mTopMargin = i10;
    }

    public void setType(int i10) {
        this.mType = i10;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public void setWidth(String str) {
        this.mWidth = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mPath);
        parcel.writeString(this.mUrl);
        parcel.writeString(this.mLeft);
        parcel.writeString(this.mTop);
        parcel.writeString(this.mRight);
        parcel.writeString(this.mBottom);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mButton);
        parcel.writeDouble(this.mLuminance);
        parcel.writeString(this.mBackgroundColor);
        parcel.writeString(this.mBackgroundColorNight);
        parcel.writeString(this.mForegroundColor);
        parcel.writeString(this.mForegroundColorNight);
        parcel.writeString(this.mGradientStartColor);
        parcel.writeString(this.mGradientStartColorNight);
        parcel.writeString(this.mGradientEndColor);
        parcel.writeString(this.mGradientEndColorNight);
        parcel.writeString(this.mText);
        parcel.writeString(this.mTextSize);
        parcel.writeString(this.mTextColor);
        parcel.writeString(this.mTextColorNight);
        parcel.writeInt(this.mGravity);
        parcel.writeInt(this.mLeftMargin);
        parcel.writeInt(this.mTopMargin);
        parcel.writeInt(this.mRightMargin);
        parcel.writeInt(this.mBottomMargin);
        parcel.writeInt(this.mFgOffsetMargin);
        parcel.writeInt(this.mImageOffsetMargin);
        parcel.writeInt(this.mEnterUpAnim);
        parcel.writeString(this.mWidth);
        parcel.writeString(this.mHeight);
    }

    public MelodyResourceDO(Parcel parcel) {
        this.mLuminance = 1.0d;
        this.mPath = parcel.readString();
        this.mUrl = parcel.readString();
        this.mLeft = parcel.readString();
        this.mTop = parcel.readString();
        this.mRight = parcel.readString();
        this.mBottom = parcel.readString();
        this.mType = parcel.readInt();
        this.mButton = parcel.readInt();
        this.mLuminance = parcel.readDouble();
        this.mBackgroundColor = parcel.readString();
        this.mBackgroundColorNight = parcel.readString();
        this.mForegroundColor = parcel.readString();
        this.mForegroundColorNight = parcel.readString();
        this.mGradientStartColor = parcel.readString();
        this.mGradientStartColorNight = parcel.readString();
        this.mGradientEndColor = parcel.readString();
        this.mGradientEndColorNight = parcel.readString();
        this.mText = parcel.readString();
        this.mTextSize = parcel.readString();
        this.mTextColor = parcel.readString();
        this.mTextColorNight = parcel.readString();
        this.mGravity = parcel.readInt();
        this.mLeftMargin = parcel.readInt();
        this.mTopMargin = parcel.readInt();
        this.mRightMargin = parcel.readInt();
        this.mBottomMargin = parcel.readInt();
        this.mFgOffsetMargin = parcel.readInt();
        this.mImageOffsetMargin = parcel.readInt();
        this.mEnterUpAnim = parcel.readInt();
        this.mWidth = parcel.readString();
        this.mHeight = parcel.readString();
    }
}
