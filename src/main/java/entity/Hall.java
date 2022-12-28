package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Hall {

    private int hallNumber;

    private LocalDate repair_date;

    private List<Exhibit> exhibits;

    public Hall(int hallNumber, List<Exhibit> exhibits) {
        this.hallNumber = hallNumber;
        this.exhibits = exhibits;
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

    public void setExhibits(List<Exhibit> exhibits) {
        this.exhibits = exhibits;
    }
}
