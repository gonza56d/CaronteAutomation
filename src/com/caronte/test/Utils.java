package com.caronte.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static Date getFecha(String sFecha) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(sFecha);
    }

    public static boolean populated(String string) {
        return string != null && string.length() > 0;
    }

}
