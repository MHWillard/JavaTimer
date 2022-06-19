package com.example.javatimer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

//put all the controls stuff in here to talk to the UI: MVC model, this Controller talks to the UI (View) and gets Model (data)
public class HelloController {
    private Time time;

    @FXML public TextField timeText;

    @FXML
    protected void onStartButtonClick() {
        System.out.println("button clicked");
        time.countdownTime();
        //maybe: store textField in model, push it here on initialize, have it updated in model then pushed to here
    }

    @FXML
    protected void onClearButtonClick() {
        System.out.println("stop button clicked");
        //stop countdown timer
        //reset seconds to 0
        time.setSeconds(0);
        time.stopTimer();
        timeText.setText(time.getSecondsText());
    }

    public void initialize() {

        time = new Time();

        //grab time object values and on change, always push that value to the text field as XX:XX

        timeText.setText(time.getSecondsText());

        //when typing: make sure it's only a number, cut off first character of string, add number to end: don't allow more if first character isn't 0
        //delete: remove last character, add 0 at front, keep it to four: deny if string is 00:00

        timeText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //String minText = timeText.getText().substring(0, 2);
                //String secText = timeText.getText().substring(2, 4);
                int toSeconds;

                if (timeText.getText().isBlank()) {
                    toSeconds = 0;
                } else {
                    toSeconds = Integer.parseInt(timeText.getText());
                }

                time.setSeconds(toSeconds);
                timeText.setText(time.convertTime());

                System.out.println(time.convertTime());
                System.out.println(time.convertTime().length());
            }
        });

        /*
        When button is clicked:
            hide Start button
            show Pause button
            update value of inputTime
            convert inputTime to minutes and seconds
            convert minutes + seconds = totalSeconds
            create countdownTimer
            run countdownTimer
            for each countdown second: decrease inputTimer value by one
        */

        //TODO: when text value changes, format() into 0000 format, then return text to display as 00:00
        //TODO: have function always grabbing values on update then pushing up to format

        //TODO: when counting down, adjust timerText so format changes value and displays (but lock editing when active)
    }
}