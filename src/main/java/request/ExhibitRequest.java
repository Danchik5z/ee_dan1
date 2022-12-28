package request;

import entity.Exhibit;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExhibitRequest {
    public  String insert(Exhibit exhibit) {
        return "Insert into flats(hall_id,name,year_of_creation,description,author) VALUES('" +
                exhibit.getHallNumber() + "'," +
                exhibit.getName() + "," +
                exhibit.getYearOfCreation() + "," +
                exhibit.getDescription() + "," +
                exhibit.getAuthor() + ")";
    }

    public String update(Exhibit exhibit, int id) {
        return "UPDATE exhibit SET hall_id = " + exhibit.getHallNumber() +
                ", name = " + exhibit.getName() +
                ", year_of_creation = " + exhibit.getYearOfCreation() +
                ", description = " + exhibit.getDescription() +
                ", author = " + exhibit.getAuthor() +
                " WHERE exhibit_id = " + id;
    }

    public  String delete(int id) {
        return "DELETE FROM exhibit WHERE exhibit_id = " + id;
    }

    public  String get(int id) {
        return "select * from exhibit where exhibit_id = " + id;
    }

    public  String getAll() {
        return "select * from exhibit";
    }

    public  Exhibit parse(ResultSet resultSet) throws SQLException {
        return new Exhibit(resultSet.getInt("exhibit_id"),
                resultSet.getInt("hall_id"),
                resultSet.getString("name"),
                resultSet.getInt("year_of_creation"),
                resultSet.getString("description"),
                resultSet.getString("author"));
    }
}
