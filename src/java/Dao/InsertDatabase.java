/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Admin
 */
public class InsertDatabase {

    Connection conn = null;// connect with sql sever
    PreparedStatement ps = null;//throw command from netbean to sql sever
    ResultSet rs = null;// get returned results

    public void insert(String date) {

        String querry = "insert into Dates([Dates]) values (?)";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, date);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("sdfsdfsd");
        }
    }

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
//
//    public static void main(String[] args) throws java.lang.Exception {
//        InsertDatabase Insertdate = new InsertDatabase();
//        Date dt = new Date();
//        List<Date> dates = printDates("20220510", "20220725");
//        Date startDate;
//        for (Date date : dates) {
//            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
//            Insertdate.insert(format1.format(date));
//        }
//    }
//
//    public static List<Date> printDates(String fromDate, String toDate) {
//        ArrayList<Date> dates = new ArrayList<Date>();
//
//        try {
//
//            Calendar fromCal = Calendar.getInstance();
//            fromCal.setTime(dateFormat.parse(fromDate));
//
//            Calendar toCal = Calendar.getInstance();
//            toCal.setTime(dateFormat.parse(toDate));
//
//            while (!fromCal.after(toCal)) {
//                dates.add(fromCal.getTime());
//                fromCal.add(Calendar.DATE, 1);
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return dates;
//    }

    public void insert1(int id, int status) {
        String querry = "insert into Attendance values (?,?,'HE789012',NULL)";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setInt(1, id);
            ps.setInt(2, status);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insert2(int id) {
        String querry = "insert into Attendance values (?,2,'HE789012',NULL)";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        InsertDatabase isDtb = new InsertDatabase();
        for (int i = 1; i <= 19; i++) {
            if (i < 7) {
                isDtb.insert1(i, 1);
            }
            if (i >= 7) {
                isDtb.insert2(i);
            }

        }
    }
}
