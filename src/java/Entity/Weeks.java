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
public class Weeks {
    private int id;
    private Date WeekStart;
    private Date WeekEnd;

    public Weeks() {
    }

    public Weeks(Date WeekStart, Date WeekEnd) {
        this.WeekStart = WeekStart;
        this.WeekEnd = WeekEnd;
    }

    public Weeks(int id, Date WeekStart, Date WeekEnd) {
        this.id = id;
        this.WeekStart = WeekStart;
        this.WeekEnd = WeekEnd;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getWeekStart() {
        return WeekStart;
    }

    public void setWeekStart(Date WeekStart) {
        this.WeekStart = WeekStart;
    }

    public Date getWeekEnd() {
        return WeekEnd;
    }

    public void setWeekEnd(Date WeekEnd) {
        this.WeekEnd = WeekEnd;
    }

    @Override
    public String toString() {
        return "Weeks{" + "id=" + id + ", WeekStart=" + WeekStart + ", WeekEnd=" + WeekEnd + '}';
    }

    
    
}
