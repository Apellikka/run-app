package com.example.run_app;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity(tableName="run_table")
public class Run {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="date")
    private String mDate;
    @ColumnInfo(name="practice")
    @NonNull
    private String mPractice;

    @ColumnInfo(name="distance")
    @NonNull
    private double mDistance;
    @ColumnInfo(name="duration")
    @NonNull
    private int mDuration;


    public Run(@NonNull String practice, @NonNull double distance, @NonNull int duration) {
        Log.d("Run", "New object " + practice + " " + distance + " " + duration);
        this.mPractice = practice;
        this.mDistance = distance;
        this.mDuration = duration;

        // Get local date and time and format it for use as the primarykey.
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        mDate = now.format(format);
    }

    public String toString() {
        return mPractice + " " + mDistance + " km " + mDuration + " minutes";
    }

    public String getDate() {
        return this.mDate;
    }

    public double getDistance() {
        return this.mDistance;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public String getPractice() {
        return this.mPractice;
    }

    public void setDate(@NonNull String mDate) {
        this.mDate = mDate;
    }

    public void setDistance(double mDistance) {
        this.mDistance = mDistance;
    }

    public void setDuration(int mDuration) {
        this.mDuration = mDuration;
    }

    public void setPractice(@NonNull String mPractice) {
        this.mPractice = mPractice;
    }

}
