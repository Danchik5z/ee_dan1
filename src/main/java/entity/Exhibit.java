package entity;

import java.time.LocalDate;
import java.util.List;

public class Exhibit extends MyEntity{

    private final int ID;

    private int hallNumber;

    private String name;

    private int yearOfCreation;

    private String description;

    private String author;

    private List<Exhibition> exhibitionList;

    public Exhibit(int ID, int hallNumber, String name, int yearOfCreation, String description, String author) {
        this.ID = ID;
        this.hallNumber = hallNumber;
        this.name = name;
        this.yearOfCreation = yearOfCreation;
        this.description = description;
        this.author = author;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public List<Exhibition> getExhibitionList() {
        return exhibitionList;
    }

    public void setExhibitionList(List<Exhibition> exhibitionList) {
        this.exhibitionList = exhibitionList;
    }

    @Override
    public String toString() {
        return "Exhibit{" +
                "ID=" + ID +
                ", hallNumber=" + hallNumber +
                ", name='" + name + '\'' +
                ", yearOfCreation=" + yearOfCreation +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
