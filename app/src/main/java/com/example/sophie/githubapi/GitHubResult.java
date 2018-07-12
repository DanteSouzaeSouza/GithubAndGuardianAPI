package com.example.sophie.githubapi;


import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class GitHubResult {

    private final static String TAG = "LogTag";

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("description")
    @Expose
    String description;

    @SerializedName("url")
    @Expose
    String url;

    @SerializedName("language")
    @Expose
    String language;

    @SerializedName("html_url")
    @Expose
    String html;

    @SerializedName("forks_count")
    @Expose
    String forks;

    @SerializedName("size")
    @Expose
    String size;

    @SerializedName("created_at")
    @Expose
    String created;

    @SerializedName("updated_at")
    @Expose
    String updated;

    @SerializedName("pushed_at")
    @Expose
    String pushed;

    @SerializedName("private")
    @Expose
    String p;

    @SerializedName("stargazers_count")
    @Expose
    String stars;

    @SerializedName("watchers_count")
    @Expose
    String watchers;

    @SerializedName("open_issues_count")
    @Expose
    String open;

    @SerializedName("homepage")
    @Expose
    String homepage;

    @SerializedName("owner")
    Owner owner;


    public GitHubResult() {

    }

    public GitHubResult(String name, String description, String url, String language, String html, String forks, String size, String created, String updated, String pushed, String p, String stars, String watchers, String open, String homepage) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.language = language;
        this.html = html;
        this.forks = forks;
        this.size = size;
        this.created = created;
        this.updated = updated;
        this.pushed = pushed;
        this.p = p;
        this.stars = stars;
        this.watchers = watchers;
        this.open = open;
        this.homepage = homepage;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getLanguage() {
        return language == null || language.equalsIgnoreCase("null") ? "No Specified Language" : language;
    }

    public String getHtml() {
        return html;
    }

    public String getForks() {
        return forks;
    }

    public String getSize() {
        return size;
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }

    public String getPushed() {
        return pushed;
    }

    public String getP() {
        return p.equalsIgnoreCase("false") ? "No" : "Yes";
    }

    public String getStars() {
        return stars;
    }

    public String getWatchers() {
        return watchers;
    }

    public String getOpen() {
        return open;
    }

    public String getHomepage() {
        return homepage == null || homepage.equalsIgnoreCase("null") ? "Unknown" : homepage;
    }
}

