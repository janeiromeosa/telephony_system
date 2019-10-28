package com.example.areacodes;

import android.util.Log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NumberParser {
    Map<String, Integer> countryCode;
    Map<String, String> prefix;

    public NumberParser(Map<String, Integer> callingCodes, Map<String, String> prefixes) {

        callingCodes.put("GB", 44);
        callingCodes.put("US",  1);
        callingCodes.put("CN",  86);
        callingCodes.put("NG",  234);
        callingCodes.put("SE",  46);

        prefixes.put("GB", "0");
        prefixes.put("US", "1");
        prefixes.put("CN",  "0");
        prefixes.put("NG",  "0");
        prefixes.put("SE",  "0");
        Log.i("check this", "Youooooo");

        countryCode = callingCodes;
        prefix = prefixes;
    }

    public String parse(String dialledNumber, String userNumber) {
        String internationalFormat = "";

        Set entrySet = countryCode.entrySet();
        Set entrySet2 = prefix.entrySet();
        Iterator it = entrySet.iterator();
        Iterator it2 = entrySet2.iterator();


        //if first character of dailledNumber is contains to +, isDailedNumberIntenational = true;
        if(dialledNumber.startsWith("+")) {
            internationalFormat = dialledNumber;
            Log.i("check this", "If statement");

        }
        else{
            if(dialledNumber.startsWith("0") || dialledNumber.startsWith("1")) {

                while(it.hasNext() && it2.hasNext()){
                    Map.Entry country = (Map.Entry)it.next();
                    Map.Entry preffix = (Map.Entry)it2.next();
//
//                    Log.i("check this", country.getKey().toString());
//                    Log.i("check this", country.getValue().toString());
                    if(userNumber.contains(country.getValue().toString()) && preffix.getKey().toString().equals(country.getKey().toString())){
                        internationalFormat = dialledNumber.replaceFirst(preffix.getValue().toString(), "+" + country.getValue().toString());
                        Log.i("check info", preffix.getValue().toString() );
                        Log.i("check info", preffix.getKey().toString());

                        break;
                    }
                }


                // if prefix key is equal country code key,
                // replace value of prefix to value of calling code

//                internationalFormat = dialledNumber.replaceFirst("0", "+" + "44");
//                Log.i("check this", preffix.getValue().toString() );

            }
        }
        //if first character of dailledNumber is equals to 0, isDailedNumberInternational = false;
        //take off prefix of 0 and replace with + and callingcode
        // return internationalFormat




        //Write a class that, when given a dialled phone number (national or international)
        //and the user’s international phone number, returns the dialled phone number in international format.

        return internationalFormat;

    }
}

