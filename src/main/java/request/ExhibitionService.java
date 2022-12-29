package request;


import entity.Exhibit;
import entity.Exhibition;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExhibitionService {
    public static String insert(Exhibition exhibition) {
        return "Insert into exhibition(start_date,end_date,name,country,city,venue) VALUES(" +
                exhibition.getStartDate() + "," +
                exhibition.getEndDate() + ",'" +
                exhibition.getName() + "','" +
                exhibition.getCountry() + "','" +
                exhibition.getCity() + "','" +
                exhibition.getVenue() + "')";
    }

    public static String update(Exhibition exhibition) {
        return "UPDATE exhibition SET start_date = " + exhibition.getStartDate() +
                "' end_date = '" + exhibition.getEndDate() +
                "', name = '" + exhibition.getName() +
                "', country = '" + exhibition.getCountry() +
                "', city = '" + exhibition.getCity() +
                "', venue = '" + exhibition.getVenue() +
                " WHERE exhibition_id = " + exhibition.getId();
    }

    public static String delete(int id) {
        return "DELETE FROM exhibition WHERE exhibition_id = " + id;
    }

    public static String get(int id) {
        return "select * from exhibition where exhibition_id = " + id;
    }

    public static String getAll() {
        return "select * from exhibition";
    }

    public static String getExhibits(Exhibition exhibition){
        return "select * from exhibit where exhibit_id in (select exhibit_id from exhibition-exhibit where exhibition_id = "
                +exhibition.getId()+")";
    }

    public static String addExhibitToExhibition(int exhibition_id, int exhibit_id){
        return "insert into exhibition-exhibit(exhibition_id, exhibit_id) VALUES(" + exhibition_id + "," + exhibition_id + ");";
    }

    public static String removeExhibitFromExhibition(int exhibition_id, int exhibit_id){
        return "delete * from exhibition-exhibit(exhibition_id, exhibit_id) Where exhibition_id = " + exhibition_id + " AND exhibit_id = " + exhibition_id + ");";
    }

    public static Exhibition parse(ResultSet resultSet) throws SQLException {
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
