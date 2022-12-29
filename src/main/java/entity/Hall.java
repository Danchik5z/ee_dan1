package entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Hall extends MyEntity{

    private int hallNumber;

    private Date repair_date;

    private List<Exhibit> exhibits;

    public Hall(int hallNumber, Date repair_date) {
        this.hallNumber = hallNumber;
        this.repair_date = repair_date;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public List<Exhibit> getExhibits() {
        return exhibits;
    }

    public Date getRepair_date() {
        return repair_date;
    }

    public void setExhibits(List<Exhibit> exhibits) {
        this.exhibits = exhibits;
    }
}
