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
public class AttendanceInformation {
    private String rollNumber;
    private String name;
    private int status;
    private String notes;

    public AttendanceInformation() {
    }

    public AttendanceInformation(String rollNumber, String name, int status, String notes) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.status = status;
        this.notes = notes;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "AttendanceInformation{" + "rollNumber=" + rollNumber + ", name=" + name + ", status=" + status + ", notes=" + notes + '}';
    }
    
}
