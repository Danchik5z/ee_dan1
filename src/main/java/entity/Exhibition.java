package entity;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

public class Exhibition extends MyEntity{

    private int id;
    private Date startDate;

    private Date endDate;

    private String name;

    private String country;

    private String city;

    private String venue;

    private List<Exhibit> exhibitList;

    public List<Exhibit> getExhibitList() {
        return exhibitList;
    }

    public void setExhibitList(List<Exhibit> exhibitList) {
        this.exhibitList = exhibitList;
    }

    public Exhibition(int id, Date startDate, Date endDate,
                      String name, String country, String city, String venue) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.country = country;
        this.city = city;
        this.venue = venue;
    }

    public int getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getVenue() {
        return venue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
