package com.example.android.quakereport;

/**
 * Created by msi on 2/23/2017.
 */

public class EarthQuake {

    public double mMagnitude;
    public String mLocation;
    public String mdate;
    public long mTimeInMilliseconds;
    public String uri;

    public EarthQuake(double mMagnitude,String location,long millisec) {
        this.mMagnitude = mMagnitude;
        this.mLocation = location;
        this.mTimeInMilliseconds = millisec;
    }
    public EarthQuake(double mMagnitude,String location,long millisec,String url) {
        this.mMagnitude = mMagnitude;
        this.mLocation = location;
        this.mTimeInMilliseconds = millisec;
        this.uri = url;
    }

    public double getmMagnitude(){
        return mMagnitude;
    }

    public String getlocation(){
        return mLocation;
    }

    public String getMdate(){
        return mdate;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;

    }

    public String getUrl(){
        return uri;
    }
}
