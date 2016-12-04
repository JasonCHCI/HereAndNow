package edu.vt.hjue.hereandnow;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jhou on 12/3/16.
 */
public class Restaurant implements Parcelable {

    private String name;
    private String time;
    private String type;
    private float rate;
    private int guestNum;
    private int profile_pic_id;
    private int points;

    public Restaurant(String name, String time, int number, int point, int profile, float rate, String type) {
        this.name = name;
        this.time = time;
        this.type = type;
        this.guestNum = number;
        this.points = point;
        this.profile_pic_id = profile;
        this.rate = rate;
    }

    protected Restaurant(Parcel in) {
        name = in.readString();
        time = in.readString();
        type = in.readString();
        rate = in.readInt();
        guestNum = in.readInt();
        profile_pic_id = in.readInt();
        points = in.readInt();
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public int getNumber() { return guestNum;}

    public int getPoints() { return points;}

    public int getProfile_pic_id() {
        return profile_pic_id;
    }

    public float getRate() { return rate;}

    public String getType() { return type;}

    public void setProfile_pic_id(int id) {
        this.profile_pic_id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(time);
        dest.writeString(type);
        dest.writeFloat(rate);
        dest.writeInt(guestNum);
        dest.writeInt(profile_pic_id);
        dest.writeInt(points);
    }
}
