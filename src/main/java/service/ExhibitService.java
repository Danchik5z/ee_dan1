package service;

import entity.Exhibit;
import request.ExhibitRequest;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExhibitService {
    private Connection connection;
    private ExhibitRequest exhibitRequest;

    public ExhibitService(Connection connection) {
        this.connection = connection;
        exhibitRequest = new ExhibitRequest();
    }

    public Exhibit get(int id) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(exhibitRequest.get(id));
        resultSet.next();
        return exhibitRequest.parse(resultSet);
    }

    public List<Exhibit> getAll() throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(exhibitRequest.getAll());
        List<Exhibit> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(exhibitRequest.parse(resultSet));
        }
        return list;
    }

    public void insert(Exhibit exhibit) throws SQLException {
        connection.prepareStatement(exhibitRequest.insert(exhibit)).executeUpdate();
    }

    public void delete(int id) throws SQLException {
        connection.prepareStatement(exhibitRequest.delete(id)).executeUpdate();
    }

    public void update(Exhibit exhibit, int id) throws SQLException {
        connection.prepareStatement(exhibitRequest.update(exhibit, id)).executeUpdate();
    }
}
