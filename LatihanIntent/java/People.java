package com.example.intentprojek;

import android.os.Parcel;
import android.os.Parcelable;

public class People implements Parcelable {
    private String nama;
    private String TTL;
    private String JK;
    private String Agama;
    private String Email;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTTL() {
        return TTL;
    }

    public void setTTL(String TTL) {
        this.TTL = TTL;
    }

    public String getJK() {
        return JK;
    }

    public void setJK(String JK) {
        this.JK = JK;
    }

    public String getAgama() {
        return Agama;
    }

    public void setAgama(String agama) {
        Agama = agama;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.TTL);
        dest.writeString(this.JK);
        dest.writeString(this.Agama);
        dest.writeString(this.Email);
    }

    public People() {
    }

    public People(String data) {
        setNama(data);
        setTTL(data);
        setJK(data);
        setAgama(data);
        setEmail(data);
    }

    protected People(Parcel in) {
        this.nama = in.readString();
        this.TTL = in.readString();
        this.JK = in.readString();
        this.Agama = in.readString();
        this.Email = in.readString();
    }

    public static final Parcelable.Creator<People> CREATOR = new Parcelable.Creator<People>() {
        @Override
        public People createFromParcel(Parcel source) {
            return new People(source);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };
}
