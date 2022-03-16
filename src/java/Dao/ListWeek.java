/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Weeks;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 *
 * @author Admin
 */
public class ListWeek {
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    public static List<Weeks> list(String fromD, String toD, String endD) {
        ArrayList<Weeks> dates = new ArrayList<Weeks>();
        try {
            Calendar fromCal = Calendar.getInstance();
            fromCal.setTime(dateFormat.parse(fromD));
            Calendar toCal = Calendar.getInstance();
            toCal.setTime(dateFormat.parse(toD));

            Calendar endCal = Calendar.getInstance();
            endCal.setTime(dateFormat.parse(endD));

            while (!fromCal.after(endCal) && !toCal.after(endCal)) {
                dates.add(new Weeks(fromCal.getTime(), toCal.getTime()));
                fromCal.add(Calendar.DATE, 7);
                toCal.add(Calendar.DATE, 7);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return dates;
    }
}
