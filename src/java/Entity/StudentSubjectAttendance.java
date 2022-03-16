/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class StudentSubjectAttendance {
    private String subjectCode;
    private String subjectName;
    private String className;
    private Date dates;

    public StudentSubjectAttendance() {
    }

    public StudentSubjectAttendance(String subjectCode, String subjectName, String className, Date dates) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.className = className;
        this.dates = dates;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    @Override
    public String toString() {
        return "StudentSubjectAttendance{" + "subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", className=" + className + ", dates=" + dates + '}';
    }
    
}
