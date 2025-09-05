package com.kruma.core.util;

/**
 * Created by Enrique on 17/06/2016.
 */
public class StringUtils {

    public static String firstCapitalize(String txt)
    {
        if(txt.isEmpty())return "";
        int length= txt.length();
        String first =txt.substring(0,1);
        first= first.toUpperCase();
        String capitalize= first+txt.substring(1,length);
        return capitalize;
    }
}
