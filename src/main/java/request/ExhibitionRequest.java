package request;


import entity.Exhibition;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExhibitionRequest {
    public  String insert(Exhibition exhibition) {
        return "Insert into wishes(start_date,end_date,name,country,city,venue) VALUES(" +
                exhibition.getStartDate() + "," +
                exhibition.getEndDate() + "," +
                exhibition.getName() + "," +
                exhibition.getCountry() + "," +
                exhibition.getCity() + "," +
                exhibition.getVenue() + ")";
    }

    public  String update(Exhibition exhibition, int id) {
        return "UPDATE wishes SET start_date = " + exhibition.getStartDate() +
                " end_date = " + exhibition.getEndDate() +
                " name = " + exhibition.getName() +
                " country = " + exhibition.getCountry() +
                " city = " + exhibition.getCity() +
                " venue = " + exhibition.getVenue() +
                " WHERE exhibition_id = " + id;
    }

    public  String delete(int id) {
        return "DELETE FROM exhibition WHERE exhibition_id = " + id;
    }

    public  String get(int id) {
        return "select * from exhibition where exhibition_id = " + id;
    }

    public  String getAll() {
        return "select * from exhibition";
    }

    public  Exhibition parse(ResultSet resultSet) throws SQLException {
        return new Exhibition(resultSet.getInt("exhibition_id"),
                resultSet.getDate("start_date"),
                resultSet.getDate("end_date"),
                resultSet.getString("name"),
                resultSet.getString("country"),
                resultSet.getString("city"),
                resultSet.getString("venue")) {
        };
    }
}
