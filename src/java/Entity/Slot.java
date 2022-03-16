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
public class Slot {
    private int slotID;
    private String slotName;
    private Date slotStart;
    private Date slotEnd;

    public Slot() {
    }

    public Slot(int slotID, String slotName, Date slotStart, Date slotEnd) {
        this.slotID = slotID;
        this.slotName = slotName;
        this.slotStart = slotStart;
        this.slotEnd = slotEnd;
    }

    public int getSlotID() {
        return slotID;
    }

    public void setSlotID(int slotID) {
        this.slotID = slotID;
    }

    public String getSlotName() {
        return slotName;
    }

    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }

    public Date getSlotStart() {
        return slotStart;
    }

    public void setSlotStart(Date slotStart) {
        this.slotStart = slotStart;
    }

    public Date getSlotEnd() {
        return slotEnd;
    }

    public void setSlotEnd(Date slotEnd) {
        this.slotEnd = slotEnd;
    }

    @Override
    public String toString() {
        return "Slot{" + "slotID=" + slotID + ", slotName=" + slotName + ", slotStart=" + slotStart + ", slotEnd=" + slotEnd + '}';
    }
    
}
