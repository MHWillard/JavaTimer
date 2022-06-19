package com.example.javatimer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

//put all the controls stuff in here to talk to the UI: MVC model, this Controller talks to the UI (View) and gets Model (data)
public class HelloController {
    private Time time;

    @FXML private TextField timeText;

    @FXML
    protected void onStartButtonClick() {
        System.out.println("button clicked");
        time.countdownTime();
    }

    public void initialize() {

        time = new Time();

        //grab time object values and on change, always push that value to the text field as XX:XX

        timeText.setText(time.getInputTime());

        //when typing: make sure it's only a number, cut off first character of string, add number to end: don't allow more if first character isn't 0
        //delete: remove last character, add 0 at front, keep it to four: deny if string is 00:00

        timeText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //String minText = timeText.getText().substring(0, 2);
                //String secText = timeText.getText().substring(2, 4);
                int toInputTime;

                if (timeText.getText().isBlank()) {
                    toInputTime = 0;
                } else {
                    toInputTime = Integer.parseInt(timeText.getText());
                }

                time.setInputTime(toInputTime);
                timeText.setText(time.convertTime());

                System.out.println(time.convertTime());
                System.out.println(time.convertTime().length());
            }
        });

        //TODO: when text value changes, format() into 0000 format, then return text to display as 00:00
        //TODO: have function always grabbing values on update then pushing up to format

        //TODO: when counting down, adjust timerText so format changes value and displays (but lock editing when active)
    }
}