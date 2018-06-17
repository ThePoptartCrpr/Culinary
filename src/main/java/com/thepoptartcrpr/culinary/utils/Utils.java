package com.thepoptartcrpr.culinary.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.thepoptartcrpr.culinary.Culinary;

public class Utils {
    private static Logger console;

    public static Logger getConsole() {
        if (console == null) console = LogManager.getFormatterLogger(Culinary.MODID);
        return console;
    }

    public static void log(String str) {
        getConsole().info(str);
    }

    public static void log(String... str) {
        getConsole().info(str);
    }

}
