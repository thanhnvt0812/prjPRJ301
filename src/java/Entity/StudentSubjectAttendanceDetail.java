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
public class StudentSubjectAttendanceDetail {
    private Date dates;
    private int id;
    private String username;
    private String className;
    private int statusAttend;
    private String notes;

    public StudentSubjectAttendanceDetail() {
    }

    public StudentSubjectAttendanceDetail(Date dates, int id, String username, String className, int statusAttend, String notes) {
        this.dates = dates;
        this.id = id;
        this.username = username;
        this.className = className;
        this.statusAttend = statusAttend;
        this.notes = notes;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getStatusAttend() {
        return statusAttend;
    }

    public void setStatusAttend(int statusAttend) {
        this.statusAttend = statusAttend;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "StudentSubjectAttendanceDetail{" + "dates=" + dates + ", id=" + id + ", username=" + username + ", className=" + className + ", statusAttend=" + statusAttend + ", notes=" + notes + '}';
    }
    
}
