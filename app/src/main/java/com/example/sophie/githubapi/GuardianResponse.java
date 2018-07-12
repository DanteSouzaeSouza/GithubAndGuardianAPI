package com.example.sophie.githubapi;

import com.google.gson.annotations.SerializedName;


public class GuardianResponse {

    @SerializedName("response")
    GuardianResult response;


    public GuardianResult getResponse() {
        return response;
    }
}

