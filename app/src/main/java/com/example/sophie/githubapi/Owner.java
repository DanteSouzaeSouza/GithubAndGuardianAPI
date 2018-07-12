package com.example.sophie.githubapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Owner {

    @SerializedName("avatar_url")
    @Expose
    String avatar;

    @SerializedName("login")
    @Expose
    String ownerName;

    public Owner(){

    }

    public Owner (String avatar, String ownerName){
        this.avatar =  avatar;
        this.ownerName = ownerName;
    }

    public String getAvatar() {
        return avatar;

    }

    public String getOwnerName() {
        return ownerName;
    }
}
