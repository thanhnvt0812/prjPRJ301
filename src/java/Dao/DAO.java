/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Account;
import Entity.AttendanceInformation;
import Entity.Dates;
import Entity.ScheduleDetail;
import Entity.Slot;
import Entity.StudentSubjectAttendance;
import Entity.StudentSubjectAttendanceDetail;
import Entity.SubjectAttendance;
import Entity.TeacherScheduleDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class DAO {

    Connection conn = null;// connect with sql sever
    PreparedStatement ps = null;//throw command from netbean to sql sever
    ResultSet rs = null;// get returned results

    public Account getAccount(String username, String password, int role) {
        String querry = "select * from Account where Username = ? and Password = ? and Role = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, role);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getInt(3));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Dates> Paging(int index) {
        String querry = "select Dates from Dates order by dateID OFFSET ? rows fetch next 7 rows only";
        List<Dates> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setInt(1, (index - 1) * 7);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Dates(rs.getDate(1)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Slot> getSlot() {
        String querry = "select * from Slot";
        List<Slot> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Slot(rs.getInt(1), rs.getString(2), rs.getTime(3), rs.getTime(4)));
            }
        } catch (Exception e) {
            System.out.println("sadasdasd");
        }
        return list;
    }

    public List<ScheduleDetail> getStudentScheduleDetail(String username, Date dates) {
        String querry = "select b.SubjectCode, f.ClassName, a.StartedAttend, c.Dates, g.SlotName from Attendance a \n"
                + "	inner join Schedule b on a.Id = b.Id \n"
                + "	inner join Dates c on c.DateId = b.DateId\n"
                + "	inner join ClassMember d on d.RollNumber = a.RollNumber\n"
                + "	inner join Student e on e.Rollnumber = d.RollNumber\n"
                + "	inner join Class f on f.Id = d.ClassId\n"
                + "	inner join Slot g on g.SlotId = b.SlotId\n"
                + "	where e.Username = ? and c.Dates=?";
        List<ScheduleDetail> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, username);
            ps.setDate(2, (java.sql.Date) dates);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ScheduleDetail(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println("sadasdasd");
        }
        return list;
    }

    public List<StudentSubjectAttendance> getStdSubject(String username) {
        String querry = "select distinct top 3 a.subjectCode,d.subjectName,b.className,e.Dates from Schedule a \n"
                + "                inner join Class  b on b.Id =  a.ClassId\n"
                + "                inner join ClassMember c on c.classID = b.Id\n"
                + "                inner join [Subject] d on d.subjectCode = a.subjectCode\n"
                + "                inner join Dates e on e.dateID =  a.dateID\n"
                + "                inner join Student g on g.rollNumber = c.rollNumber\n"
                + "                where g.username = ? order by e.Dates";
        List<StudentSubjectAttendance> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new StudentSubjectAttendance(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4)));
            }
        } catch (Exception e) {
            System.out.println("sadasdasd");
        }
        return list;
    }

    public List<StudentSubjectAttendanceDetail> getStdAttendanceDetail(String username, String subjectCode, String className) {
        String querry = "select c.Dates,b.slotID,e.username,d.className,a.StartedAttend,a.Notes  from Attendance a \n"
                + "inner join Schedule b on a.id = b.Id\n"
                + "inner join Dates c on c.dateID= b.dateID\n"
                + "inner join Class d on d.Id = b.classID\n"
                + "inner join Teacher e on e.Id = b.teacherID\n"
                + "inner join ClassMember g on g.rollNumber = a.rollNumber\n"
                + "inner join Student f on f.rollNumber = g.rollNumber\n"
                + "where f.username = ? and b.subjectCode = ? and d.className= ? \n"
                + "order by c.Dates ASC";
        List<StudentSubjectAttendanceDetail> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, username);
            ps.setString(2, subjectCode);
            ps.setString(3, className);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new StudentSubjectAttendanceDetail(rs.getDate(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
        } catch (Exception e) {
            System.out.println("sadasdasd");
        }
        return list;
    }

    public List<TeacherScheduleDetail> getTeacherScheduleDetail(String username, Date dates) {
        String querry = "select a.SubjectCode, e.ClassName, g.SlotName, d.Dates from Schedule a \n"
                + "inner join Teacher b on a.TeacherId = b.Id\n"
                + "inner join Subject c on a.SubjectCode = c.SubjectCode\n"
                + "inner join Dates d on a.DateId = d.DateId\n"
                + "inner join Class e on a.ClassId = e.Id\n"
                + "inner join Slot g on a.SlotId = g.SlotId\n"
                + "where b.Username =? and d.Dates =?";
        List<TeacherScheduleDetail> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, username);
            ps.setDate(2, (java.sql.Date) dates);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TeacherScheduleDetail(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4)));
            }
        } catch (Exception e) {
            System.out.println("sadasdasd");
        }
        return list;
    }

    public List<SubjectAttendance> getSubjectAttendanceDetail(String username) {
        String querry = "select  f.subjectCode,f.subjectName,b.className,d.startTime,d.endTime,e.Dates  from Schedule a \n"
                + "inner join Class b on a.classID = b.Id\n"
                + "inner join Teacher c on a.teacherID =c.Id \n"
                + "inner join Slot d on a.slotID = d.slotID\n"
                + "inner join Dates e on a.dateID =e.dateID\n"
                + "inner join [Subject] f on a.subjectCode =f.subjectCode\n"
                + "where c.username=? and e.Dates = DATEADD(DAY, DATEDIFF(DAY, 0, GETDATE()), 0)";
        List<SubjectAttendance> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SubjectAttendance(rs.getString(1), rs.getString(2), rs.getString(3), rs.getTime(4), rs.getTime(5), rs.getDate(6)));
            }
        } catch (Exception e) {
            System.out.println("sadasdasd");
        }
        return list;
    }

    public List<AttendanceInformation> getAttendanceInformation(String subjectCode, String className, String startTime, String endTime, String username) {
        String querry = "select b.rollNumber,c.Name,b.StartedAttend,b.Notes from Schedule a\n"
                + "                inner join Attendance b on b.id = a.Id\n"
                + "                inner join Student c on c.rollNumber =b.rollNumber\n"
                + "                inner join Dates d on d.dateID = a.dateID\n"
                + "                inner join Class e on e.ID = a.classID\n"
                + "                inner join Slot f on f.slotID = a.slotID\n"
                + "                inner join Teacher g on g.ID =a.teacherID\n"
                + "                where d.Dates =DATEADD(DAY, DATEDIFF(DAY, 0, GETDATE()), 0) and a.subjectCode = ? \n"
                + "                and e.className = ? \n"
                + "                and f.startTime = ? and f.endTime = ? \n"
                + "                and g.username = ?  \n"
                + "                ORDER BY c.Rollnumber ASC";
        List<AttendanceInformation> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, subjectCode);
            ps.setString(2, className);
            ps.setString(3, startTime);
            ps.setString(4, endTime);
            ps.setString(5, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new AttendanceInformation(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
        } catch (Exception e) {
            System.out.println("sadasdasd");
        }
        return list;
    }

    public void takeAttendance(int status, String notes, String subjectCode, String rollNumber, String userName, String startTime, String endTime) {
        String query = "UPDATE Attendance SET  StartedAttend = ?, Notes = ? from Schedule a \n"
                + "inner join Attendance b on b.id =  a.Id \n"
                + "inner join Dates c on c.dateID = a.dateID \n"
                + "inner join Teacher d on d.ID = a.teacherID \n"
                + "inner join Slot f on f.slotID = a.slotID \n"
                + "where c.Dates = DATEADD(DAY, DATEDIFF(DAY, 0, GETDATE()), 0) and a.subjectCode = ? \n"
                + "and b.rollNumber = ? \n"
                + "and d.username= ? and \n"
                + "f.startTime= ? and f.endTime = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, status);
            ps.setString(2, notes);
            ps.setString(3, subjectCode);
            ps.setString(4, rollNumber);
            ps.setString(5, userName);
            ps.setString(6, startTime);
            ps.setString(7, endTime);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("sadasdasd");
        }
    }

    public static void main(String[] args) {
        DAO acc = new DAO();
        List<SubjectAttendance> list = acc.getSubjectAttendanceDetail("Teacher1");
        for (SubjectAttendance o : list) {
            System.out.println(o);
        }

    }
}
