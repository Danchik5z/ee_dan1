package service;



import entity.Client;
import request.ClientRequest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private Connection connection;
    private ClientRequest clientRequest;

    public ClientService(Connection connection) {
        this.connection = connection;
        clientRequest = new ClientRequest();
    }

    public Client get(int id) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(clientRequest.get(id));
        resultSet.next();
        return clientRequest.parse(resultSet);
    }

    public List<Client> getAll() throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(clientRequest.getAll());
        List<Client> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(clientRequest.parse(resultSet));
        }
        return list;
    }

    public void insert(Client client) throws SQLException {
        connection.prepareStatement(clientRequest.insert(client)).executeUpdate();
    }

    public void delete(int id) throws SQLException {
        connection.prepareStatement(clientRequest.delete(id)).executeUpdate();
    }

    public void update(Client client, int id) throws SQLException {
        connection.prepareStatement(clientRequest.update(client, id)).executeUpdate();
    }
}
