package com.nyist.entity;

/**
 * Created by kingcos on 06/02/2017.
 */
public class MediaFile {

    private String mediaFilename;

    public MediaFile() {
    }

    public MediaFile(String mediaFilename) {
        this.mediaFilename = mediaFilename;
    }

    public String getMediaFilename() {
        return mediaFilename;
    }

    public void setMediaFilename(String mediaFilename) {
        this.mediaFilename = mediaFilename;
    }
}
