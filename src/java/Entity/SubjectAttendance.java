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
public class SubjectAttendance {
    private String subjectCode;
    private String subjectName;
    private String className;
    private Date startTime;
    private Date endTime;
    private Date dates;

    public SubjectAttendance() {
    }

    public SubjectAttendance(String subjectCode, String subjectName, String className, Date startTime, Date endTime, Date dates) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.className = className;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    @Override
    public String toString() {
        return "SubjectAttendance{" + "subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", className=" + className + ", startTime=" + startTime + ", endTime=" + endTime + ", dates=" + dates + '}';
    }
    
}
