/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Account;
import Entity.AttendanceInformation;
import Entity.Dates;
import Entity.Class;
import Entity.ClassMember;
import Entity.ScheduleDetail;
import Entity.Slot;
import Entity.Student;
import Entity.StudentList;
import Entity.StudentSubjectAttendance;
import Entity.StudentSubjectAttendanceDetail;
import Entity.SubjectAttendance;
import Entity.TeacherInfor;
import Entity.TeacherScheduleDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

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

    public List<StudentList> getAllStudent() {
        String querry = "select Name, Rollnumber from Student";
        List<StudentList> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new StudentList(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("sadasdasd");
        }
        return list;
    }

    public List<TeacherInfor> getTeacher() {
        String querry = "select Id, Fullname from Teacher";
        List<TeacherInfor> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TeacherInfor(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("sadasdasd");
        }
        return list;
    }

    public List< Class> getClassName() {
        String querry = "select * from Class";
        List<Class> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Class(rs.getInt(1), rs.getString(2)));
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

    public List<StudentList> getClassMember(String className) {
        String querry = "select a.Name, a.Rollnumber from Student a\n"
                + "inner join ClassMember b on a.Rollnumber = b.RollNumber\n"
                + "inner join Class c on b.ClassId = c.Id \n"
                + "where c.ClassName = ? ";
        List<StudentList> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, className);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new StudentList(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("sadasdasd");
        }
        return list;
    }

    public Student getStudentInfor(String rollnumber) {
        String sql = "select s.Rollnumber, s.Name, s.Username, s.EmailAddress, s.Gender, s.DOB from Student s where s.Rollnumber = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, rollnumber);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public TeacherInfor getTeacherInfor(int id) {
        String sql = "select s.Id, s.Username, s.Fullname, s.EmailAddress, s.Gender, s.DOB from Teacher s where s.ID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new TeacherInfor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateStudent(Student s) {

        String sql = "UPDATE Student SET Name = ?, Username = ?,EmailAddress = ?, Gender =?, DOB = ? WHERE Rollnumber = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getUsername());
            ps.setString(3, s.getEmail());
            ps.setBoolean(4, s.isGender());
            ps.setString(5, s.getDob());
            ps.setString(6, s.getRollnumber());
            rs = ps.executeQuery();

        } catch (Exception ex) {

            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateTeacher(TeacherInfor s) {

        String sql = "UPDATE Teacher SET Username = ?, Fullname = ?,EmailAddress = ?, Gender =?, DOB = ? WHERE Id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, s.getUsername());
            ps.setString(2, s.getName());
            ps.setString(3, s.getEmail());
            ps.setBoolean(4, s.isGender());
            ps.setString(5, s.getDob());
            ps.setInt(6, s.getId());
            rs = ps.executeQuery();

        } catch (Exception ex) {

            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertStudent(Student s) {

        String sql = "INSERT INTO Student(RollNumber, Name, Username, EmailAddress, Gender, DOB)\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, s.getRollnumber());
            ps.setString(2, s.getName());
            ps.setString(3, s.getUsername());
            ps.setString(4, s.getEmail());
            ps.setBoolean(5, s.isGender());
            ps.setString(6, s.getDob());
            rs = ps.executeQuery();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertTeacher(TeacherInfor s) {

        String sql = "INSERT INTO Teacher(Id,  Username, Fullname, EmailAddress, Gender, DOB)\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getUsername());
            ps.setString(4, s.getEmail());
            ps.setBoolean(5, s.isGender());
            ps.setString(6, s.getDob());
            rs = ps.executeQuery();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertAccount(Account a) {

        String sql = "INSERT INTO [Account]\n"
                + "           ([Username]\n"
                + "           ,[Password]\n"
                + "           ,[Role])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, a.getUsername());
            ps.setString(2, a.getPassword());
            ps.setInt(3, a.getRole());
            rs = ps.executeQuery();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertStudentIntoCalss(ClassMember c) {

        String sql = "INSERT INTO [ClassMember]\n"
                + "           (RollNumber, ClassID)\n"
                + "     VALUES (?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, c.getRollnumber());
            ps.setInt(2, c.getClassID());
            ps.executeQuery();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteStudent(String id) {
        String sql = "DELETE Student WHERE RollNumber=?";
        try {

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteTeacher(int id) {
        String sql = "DELETE Teacher WHERE Id=?";
        try {

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteStudentFromClass(String rollnumber) {
        String sql = "delete from ClassMember where RollNumber=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, rollnumber);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                + "where c.username=? and e.Dates = '2022-07-12'";
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
                + "                where d.Dates ='2022-07-12' and a.subjectCode = ? \n"
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
        DAO dao = new DAO();
//        Account acc = new Account("A3", "333", 2);
//        dao.insertAccount(acc);
//        Student stu = new Student("HE3", "Mr.3", "A3", "3@gmail.com", true, "01/01/2001");
//        dao.insertStudent(stu);
        ClassMember clm = new ClassMember("HE3", 2);
        dao.insertStudentIntoCalss(clm);

    }
}
