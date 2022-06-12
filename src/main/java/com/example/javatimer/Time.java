package com.example.javatimer;

import java.util.Timer;
import java.util.TimerTask;

public class Time {
    private String inputTime;
    private int minutes;
    private int seconds;

    public Time() {
        inputTime = "00:00";
        minutes = 0;
        seconds = 0;
    }

    //need method here: break input into minutes and seconds

    public String getInputTime() {
        return inputTime;
        //maybe get int and return as string? might be better for the countdown
        //or: it takes minutes and seconds and converts them from 00-99
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
