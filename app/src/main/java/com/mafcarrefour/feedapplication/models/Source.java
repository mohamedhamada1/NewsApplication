package com.mafcarrefour.feedapplication.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Source implements Parcelable {
    private String id, name;


    public Source() {
    }


    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
    }

    protected Source(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
    }

    public static final Creator<Source> CREATOR = new Creator<Source>() {
        @Override
        public Source createFromParcel(Parcel source) {
            return new Source(source);
        }

        @Override
        public Source[] newArray(int size) {
            return new Source[size];
        }
    };
}
