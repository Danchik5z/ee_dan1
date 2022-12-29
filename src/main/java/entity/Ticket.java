package entity;

import java.time.LocalDate;
import java.util.Date;

public class Ticket extends MyEntity{

    private int ID;

    private int clientID;

    private int hallID;


    private Date startDate;

    private int price;

    private int hour;

    public Ticket(int ID, int clientID, int hallID, Date startDate, int price, int hour) {
        this.ID = ID;
        this.clientID = clientID;
        this.hallID = hallID;
        this.startDate = startDate;
        this.price = price;
        this.hour = hour;
    }

    public int getID() {
        return ID;
    }

    public int getClientID() {
        return clientID;
    }

    public int getHallID() {
        return hallID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getPrice() {
        return price;
    }

    public int getHour() {
        return hour;
    }
}
