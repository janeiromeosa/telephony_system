package com.example.areacodes;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;


//Assumptions - Both individuals live in the same country

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String userNumber = "+447780859556"; //always international
        String dailledNumber = "07480359538"; //either national or international

        //Mapping variables created
        Map<String, Integer> countryCodes = new HashMap<>();
        Map<String, String> prefixes = new HashMap<>();

        //mapping variables set
        NumberParser parser = new NumberParser(countryCodes, prefixes);

        //returning dailledNumber in international format
        Log.i("check this",parser.parse(dailledNumber, userNumber));

        //Write a class that, when given a dialled phone number (national or international)
        //and the user’s international phone number, returns the dialled phone number in international format.

       /*

        assertEquals("+442079460056", parser.parse("02079460056", "+441614960148"));
        assertEquals("+442079460056", parser.parse("+442079460056", "+441614960148"));
        assertEquals("+442079460056", parser.parse("02079460056", "+441614960148"));

        */

    }


}

