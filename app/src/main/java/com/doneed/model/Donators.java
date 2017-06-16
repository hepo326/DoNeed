package com.doneed.model;

import android.os.Parcel;
import android.os.Parcelable;


public class Donators implements Parcelable  {

    private String id;
    private String name;
    private String profilePicture;
    private String phone;
    private String address;
    private String details;
    private String cateogry;
    private String amount;



    public Donators(String id, String name, String profilePicture,
                    String phone, String address, String details, String cateogry, String amount) {
        this.id = id;
        this.name = name;
        this.profilePicture = profilePicture;
        this.phone = phone;
        this.address = address;
        this.details = details;
        this.cateogry = cateogry;
        this.amount = amount;



    }

    private Donators(Parcel in) {
        id=in.readString();
        name=in.readString();
        profilePicture=in.readString();
        phone=in.readString();
        address=in.readString();
        details=in.readString();
        cateogry=in.readString();
        amount=in.readString();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }
    public String getProfilePicture() {
        return profilePicture;
    }

    public String getphone() {
        return phone;
    }

    public String getaddress() {
        return address;
    }

    public String getdetails() {
        return details;
    }

    public String getcateogry() {
        return cateogry;
    }
    public String getamount() {
        return amount;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(id);
        out.writeString(name);
        out.writeString(profilePicture);
        out.writeString(phone);
        out.writeString(address);
        out.writeString(details);
        out.writeString(cateogry);
        out.writeString(amount);

    }

    public static final Creator<Donators> CREATOR = new Creator<Donators>() {
        public Donators createFromParcel(Parcel in) {
            return new Donators(in);
        }

        public Donators[] newArray(int size) {
            return new Donators[size];
        }
    };
}
