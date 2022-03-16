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
public class ScheduleDetail {
    private String subjectCode;
    private String className;
    private int status;
    private Date dates;
    private String slotName;

    public ScheduleDetail() {
    }

    public ScheduleDetail(String subjectCode, String className, int status, Date dates, String slotName) {
        this.subjectCode = subjectCode;
        this.className = className;
        this.status = status;
        this.dates = dates;
        this.slotName = slotName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getSlotName() {
        return slotName;
    }

    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }

    @Override
    public String toString() {
        return "ScheduleDetail{" + "subjectCode=" + subjectCode + ", className=" + className + ", status=" + status + ", dates=" + dates + ", slotName=" + slotName + '}';
    }
    
}
