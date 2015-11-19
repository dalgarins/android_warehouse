package com.maxwell.warehouse.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Maxwell on 04/11/2015.
 */
public class Utils {

    public static ArrayList<String> readURLs(String url) {
        ArrayList<String> allURls = new ArrayList<String>();
        try {
            URL urls = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(urls
                    .openStream()));
            String str;
            while ((str = in.readLine()) != null) {
                allURls.add(str);
            }
            in.close();
            return allURls ;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
