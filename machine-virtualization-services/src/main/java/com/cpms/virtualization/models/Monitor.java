package com.cpms.virtualization.models;

/**
 * Created by Rakib on 11/18/2015.
 */
public class Monitor {
    private String timeStamp;
    private String bedTemperature;
    private String nozzleTemperature;
    private String progress;

    public Monitor() {
        this.timeStamp = "0";
        this.bedTemperature = "0";
        this.nozzleTemperature = "0";
        this.progress = "0";
    }

    public Monitor(String timeStamp, String bedTemperature, String nozzleTemperature, String progress) {
        this.timeStamp = timeStamp;
        this.bedTemperature = bedTemperature;
        this.nozzleTemperature = nozzleTemperature;
        this.progress = progress;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getBedTemperature() {
        return bedTemperature;
    }

    public void setBedTemperature(String bedTemperature) {
        this.bedTemperature = bedTemperature;
    }

    public String getNozzleTemperature() {
        return nozzleTemperature;
    }

    public void setNozzleTemperature(String nozzleTemperature) {
        this.nozzleTemperature = nozzleTemperature;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "Monitor [timeStamp=" + timeStamp + ", bedTemperature=" + bedTemperature
                + ", nozzleTemperature=" + nozzleTemperature + ", progress=" + progress + "]";
    }
}
