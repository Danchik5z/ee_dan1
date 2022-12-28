package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Ticket;
import request.TicketRequest;


public class TicketService {
    private Connection connection;
    private TicketRequest ticketRequest;

    public TicketService(Connection connection) {
        this.connection = connection;
        ticketRequest = new TicketRequest();
    }

    public List<Ticket> getAll() throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(ticketRequest.getAll());
        List<Ticket> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(ticketRequest.parse(resultSet));
        }
        return list;
    }

    public Ticket get(int id) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(ticketRequest.get(id));
        resultSet.next();
        return ticketRequest.parse(resultSet);
    }

    public void insert(Ticket ticket) throws SQLException {
        connection.prepareStatement(ticketRequest.insert(ticket)).executeUpdate();
    }

    public void delete(int id) throws SQLException {
        connection.prepareStatement(ticketRequest.delete(id)).executeUpdate();
    }

    public void update(Ticket ticket, int id) throws SQLException {
        connection.prepareStatement(ticketRequest.update(ticket, id)).executeUpdate();
    }
}
