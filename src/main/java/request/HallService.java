package request;

import entity.Hall;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HallService {
    public static String insert(Hall hall) {
        return "insert into hall(repair_date) VALUES(" + hall.getRepair_date() + ")";
    }

    public static String update(Hall hall) {
        return "UPDATE hall SET hall_id = " + hall.getHallNumber() +
                ", repair_date = " + hall.getRepair_date();
    }

    public static String delete(int id) {
        return "DELETE FROM exhibit WHERE hall_id = " + id;
    }

    public static String get(int id) {
        return "select * from hall where hall_id = " + id;
    }

    public static String getAll() {
        return "select * from hall";
    }

    public static String getExhibits(Hall hall){
        return "select * from exhibit where hall_id = " + hall.getHallNumber();
    }

    public static String addExhibitToHall(int hall_id, int exhibit_id){
        return "UPDATE exhibit SET hall_id"+ hall_id+" WHERE exhibit_id = " + exhibit_id;
    }

    public static String removeExhibitFromHall(int exhibit_id){
        return "UPDATE exhibit SET hall_id = -1 WHERE exhibit_id = " + exhibit_id;
    }

    public static Hall parse(ResultSet resultSet) throws SQLException {
        return new Hall(resultSet.getInt("hall_id"),
                resultSet.getDate("repair_date"));
    }
}
