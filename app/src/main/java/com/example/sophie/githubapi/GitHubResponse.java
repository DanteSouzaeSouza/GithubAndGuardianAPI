package com.example.sophie.githubapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GitHubResponse  {

    @SerializedName("items")
    List<GitHubResult> items;


    public List<GitHubResult> getItems() {
        return items;
    }
}


