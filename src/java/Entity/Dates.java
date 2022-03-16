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
public class Dates {
    private Date DateTime;

    public Dates() {
    }

    public Dates(Date DateTime) {
        this.DateTime = DateTime;
    }

    public Date getDateTime() {
        return DateTime;
    }

    public void setDateTime(Date DateTime) {
        this.DateTime = DateTime;
    }

    @Override
    public String toString() {
        return "Dates{" + "DateTime=" + DateTime + '}';
    }
    
    
}
