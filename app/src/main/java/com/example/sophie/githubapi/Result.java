package com.example.sophie.githubapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Result {

    @SerializedName("webTitle")
    @Expose
    String title;

    @SerializedName("sectionName")
    @Expose
    String section;

    @SerializedName("webPublicationDate")
    @Expose
    String publication;

    @SerializedName("webUrl")
    @Expose
    String web;

    @SerializedName("type")
    @Expose
    String type;

    @SerializedName("pillarName")
    @Expose
    String pillarName;



    public Result(){

    }

    public Result(String title, String section, String publication, String web, String type, String pillarName){
        this.title = title;
        this.section = section;
        this.publication = publication;
        this.web = web;
        this.type = type;
        this.pillarName = pillarName;
    }

    public String getTitle(){
        return title;
    }

    public String getSection(){
        return section;
    }

    public String getPublication(){
        return publication;
    }

    public String getWeb(){
        return web;
    }

    public String getType(){
        return type;
    }

    public String getPillarName() {
        return pillarName;
    }
}
