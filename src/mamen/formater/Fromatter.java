/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mamen.formater;

/**
 *
 * @author rahma
 */
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Fromatter {

    public final static String DATE_FORMAT = "dd/MM/yyyy";
    public final static String DATE_FORMAT2 = "dd-MM-yyyy";
    public final static String DATE_FORMAT_DB = "yyyy-MM-dd";
    public final static String TIMESTAMP_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public final static String TSID_FORMAT = "yyyyMMddHHmmss";
    public final static String TSID_FORMAT_PINJAMAN = "yyyyMMddHHmmssSSSSSS";

    /**
     * Formated Decimal
     */
    public static String format(double amount, int digit) {
        String format = "###,##0";
        if (digit > 0) {
            format += ".";
            for (int i = 1; i <= digit; i++) {
                format += "0";
            }
        }
        NumberFormat formater = new DecimalFormat(format);
        return formater.format(amount);
    }

    /**
     * Format tanpa koma
     */
    public static String formatWithoutComma(double amount, int digit) {
        String format = "#####";
        if (digit > 0) {
            format += ".";
            for (int i = 1; i <= digit; i++) {
                format += "0";
            }
        }
        NumberFormat formater = new DecimalFormat(format);
        return formater.format(amount);
    }

    public static String format(Date date) {
        return convertDate(date, DATE_FORMAT);
    }

    public static String formatTime(Date date) {
        return convertDate(date, TIMESTAMP_FORMAT);
    }

    public static String formatDb(Date date) {
        return convertDate(date, DATE_FORMAT_DB);
    }

    /**
     */
    public static String convertDate(Date date, String style) {
        SimpleDateFormat sdf = new SimpleDateFormat(style);
        return date == null ? null : sdf.format(date);
    }

    /**
     */
    public static Date convertToDate(String strDate, String style) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(style);
            return sdf.parse(strDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int convertToYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    public static double roundUpDouble(double amount) {
        return (Double) (Math.ceil(amount / 100f) * 100);
    }
   
    public static String formatNumber(double val) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.forLanguageTag("id"));
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);
        return formatter.format(val);
    }

   
}


