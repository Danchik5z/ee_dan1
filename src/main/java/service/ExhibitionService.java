package service;

import entity.Exhibition;
import request.ExhibitionRequest;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExhibitionService {
    private Connection connection;
    private ExhibitionRequest exhibitionRequest;

    public ExhibitionService(Connection connection) {
        this.connection = connection;
        exhibitionRequest = new ExhibitionRequest();
    }

    public Exhibition get(int id) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(exhibitionRequest.get(id));
        resultSet.next();
        return exhibitionRequest.parse(resultSet);
    }

    public List<Exhibition> getAll() throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(exhibitionRequest.getAll());
        List<Exhibition> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(exhibitionRequest.parse(resultSet));
        }
        return list;
    }

    public void insert(Exhibition exhibition) throws SQLException {
        connection.prepareStatement(exhibitionRequest.insert(exhibition)).executeUpdate();
    }

    public void delete(int id) throws SQLException {
        connection.prepareStatement(exhibitionRequest.delete(id)).executeUpdate();
    }

    public void update(Exhibition exhibition, int id) throws SQLException {
        connection.prepareStatement(exhibitionRequest.update(exhibition, id)).executeUpdate();
    }
}
