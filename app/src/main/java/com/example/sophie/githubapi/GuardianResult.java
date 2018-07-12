package com.example.sophie.githubapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class GuardianResult {

        private final static String TAG = "LogTag";

        @SerializedName("results")
        List<Result> results;

        public GuardianResult() {

        }

        public List<Result> getResults(){
            return results;
        }

}
