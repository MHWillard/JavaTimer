package com.example.javatimer;

import java.util.Timer;
import java.util.TimerTask;
import java.text.DecimalFormat;

public class Time {
    private String inputTimeString;
    private int inputTime;
    private int minutes;
    private int seconds;

    public Time() {
        inputTimeString = "00:00";
        inputTime = 0;
        minutes = 0;
        seconds = 0;
    }

    //need method here: break input into minutes and seconds

    public String getInputTime() {
        return String.format("%04d",inputTime);
        //maybe get int and return as string? might be better for the countdown
        //or: it takes minutes and seconds and converts them from 00-99
    }

    public void setInputTime(int time) {
        this.inputTime = time;
        //maybe get int and return as string? might be better for the countdown
        //or: it takes minutes and seconds and converts them from 00-99
    }

    public String convertTime() {
        //TODO: when text value changes, format() into 0000 format, then return text to display as 00:00

        //DecimalFormat df = new DecimalFormat("0000");
        //String inputText = df.format(inputTime);
        String inputText = String.format("%04d",inputTime);
        //String s1 = inputText.substring(0, 2);
        //String s2 = inputText.substring(3, 5);

        //String s1 = df.format(minutes);
        //String s2 = df.format(seconds);

        //return df.format(inputTime);
        //return s1 + ":" + s2;
        return inputText;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void countdownTime() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = (minutes * 60) + seconds;
            public void run() {
                System.out.println(i--);
                if (i<0) {
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }

    public void runTimer() {}
}
