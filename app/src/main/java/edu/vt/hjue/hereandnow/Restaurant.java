package edu.vt.hjue.hereandnow;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jhou on 12/3/16.
 */
public class Restaurant implements Parcelable {

    private String name;
    private String type;
    private float rate;
    private float time;
    private int profile_pic_id;
    private int points;

    public Restaurant(String name, float time, int point, int profile, float rate, String type) {
        this.name = name;
        this.time = time;
        this.type = type;
        this.points = point;
        this.profile_pic_id = profile;
        this.rate = rate;
    }

    protected Restaurant(Parcel in) {
        name = in.readString();
        time = in.readFloat();
        type = in.readString();
        rate = in.readFloat();
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

    public float getTime() {
        return time;
    }


    public int getPoints() { return points;}

    public int getProfile_pic_id() {
        return profile_pic_id;
    }

    public float getRate() { return rate;}

    public String getType() { return type;}

    public void setProfile_pic_id(int id) {
        this.profile_pic_id = id;
    }

    public void setTime(float number) {
        this.time = number;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeFloat(time);
        dest.writeString(type);
        dest.writeFloat(rate);
        dest.writeInt(profile_pic_id);
        dest.writeInt(points);
    }
}
