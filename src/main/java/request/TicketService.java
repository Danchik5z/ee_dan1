package request;

import entity.Exhibit;
import entity.Ticket;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketService {
    public static String insert(Ticket ticket) {
        return "Insert into ticket(client_id,hall_id,start_date,price,hour) VALUES(" +
                ticket.getClientID() + "," +
                ticket.getHallID() + "," +
                ticket.getStartDate() + "," +
                ticket.getPrice() + "," +
                ticket.getHour() + ")";
    }

    public static String update(Ticket ticket) {
        return "UPDATE ticket SET client_id = " + ticket.getClientID() +
                ", hall_id = " + ticket.getHallID() +
                ", start_date = " + ticket.getStartDate() +
                ", price = " + ticket.getPrice() +
                ", hour = " + ticket.getHour() +
                " WHERE ticket_id = " + ticket.getID();
    }

    public static String delete(int id) {
        return "DELETE FROM ticket WHERE ticket_id = " + id;
    }

    public static String get(int id) {
        return "select * from ticket where ticket_id = " + id;
    }

    public static String getAll() {
        return "select * from ticket";
    }

    public static String getCLient(Ticket ticket){
        return "select * from client where client_id = "
                +ticket.getClientID()+")";
    }

    public static Ticket parse(ResultSet resultSet) throws SQLException {
        return new Ticket(resultSet.getInt("ticket_id"),
                resultSet.getInt("client_id"),
                resultSet.getInt("hall_id"),
                resultSet.getDate("start_date"),
                resultSet.getInt("price"),
                resultSet.getInt("hour"));
    }
}
