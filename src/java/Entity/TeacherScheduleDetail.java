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
public class TeacherScheduleDetail {
    private String subjectCode;
    private String className;
    private String slotName;
    private Date dates;

    public TeacherScheduleDetail() {
    }

    public TeacherScheduleDetail(String subjectCode, String className, String slotName, Date dates) {
        this.subjectCode = subjectCode;
        this.className = className;
        this.slotName = slotName;
        this.dates = dates;
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

    public String getSlotName() {
        return slotName;
    }

    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    @Override
    public String toString() {
        return "TeacherScheduleDetail{" + "subjectCode=" + subjectCode + ", className=" + className + ", slotName=" + slotName + ", dates=" + dates + '}';
    }
    
}
