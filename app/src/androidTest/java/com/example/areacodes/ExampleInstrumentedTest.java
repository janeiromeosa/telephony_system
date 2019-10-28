package com.example.areacodes;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    String userNumber = "+447780859556"; //always international
    String dailledNumber = "07480359538"; //either national or international

    //Mapping variables created
    Map<String, Integer> countryCodes = new HashMap<>();
    Map<String, String> prefixes = new HashMap<>();
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        NumberParser parser = new NumberParser(countryCodes, prefixes);

        //returning dailledNumber in international format
        parser.parse(dailledNumber, userNumber);

        assertEquals("com.example.areacodes", appContext.getPackageName());
        assertEquals("+442079460056", parser.parse("02079460056", "+441614960148"));
        assertEquals("+442079460056", parser.parse("+442079460056", "+441614960148"));
        assertEquals("+442079460056", parser.parse("02079460056", "+441614960148"));
    }
}
