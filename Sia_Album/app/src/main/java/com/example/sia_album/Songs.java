package com.example.sia_album;

import android.os.Parcel;
import android.os.Parcelable;

public class Songs implements Parcelable {

    private String songName = " ";
    private int songSource =0;

    protected Songs(Parcel in) {
        songName = in.readString();
        songSource = in.readInt();
    }

    public static final Creator<Songs> CREATOR = new Creator<Songs>() {
        @Override
        public Songs createFromParcel(Parcel in) {
            return new Songs(in);
        }

        @Override
        public Songs[] newArray(int size) {
            return new Songs[size];
        }
    };

    public String getSongName() {
        return songName;
    }

    public int getSongSource() {
        return songSource;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setSongSource(int songSource) {
        this.songSource = songSource;
    }

    public Songs(String songName, int songSource) {
        this.songName = songName;
        this.songSource = songSource;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(songName);
        dest.writeInt(songSource);
    }


}
