package request;

import entity.Ticket;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketRequest {
    public  String insert(Ticket ticket) {
        return "Insert into flats(client_id,hall_id,start_date,price,hour) VALUES('" +
                ticket.getClientID() + "'," +
                ticket.getHallID() + "'," +
                ticket.getStartDate() + "," +
                ticket.getPrice() + "," +
                ticket.getHour() + ")";
    }

    public String update(Ticket ticket, int id) {
        return "UPDATE flats SET client_id = " + ticket.getClientID() +
                ", hall_id = " + ticket.getHallID() +
                ", start_date = " + ticket.getStartDate() +
                ", price = " + ticket.getPrice() +
                ", hour = " + ticket.getHour() +
                " WHERE ticket_id = " + id;
    }

    public  String delete(int id) {
        return "DELETE FROM ticket WHERE ticket_id = " + id;
    }

    public  String get(int id) {
        return "select * from ticket where ticket_id = " + id;
    }

    public  String getAll() {
        return "select * from ticket";
    }

    public  Ticket parse(ResultSet resultSet) throws SQLException {
        return new Ticket(resultSet.getInt("ticket_id"),
                resultSet.getInt("client_id"),
                resultSet.getInt("hall_id"),
                resultSet.getDate("start_date"),
                resultSet.getInt("price"),
                resultSet.getInt("hour"));
    }
}
