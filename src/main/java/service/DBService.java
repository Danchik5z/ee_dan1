package service;

import connect.Connector;
import entity.*;
import request.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBService {

    private Connection con;
    private static DBService instance;

    public static DBService getInstance(){
        if(instance == null){
            instance = new DBService();
        }
        return instance;
    }

    private DBService(){
        try {
            this.con = Connector.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(String tableName, MyEntity entity) throws SQLException {
        String query = null;
        switch (tableName){
            case "client":
                query = ClientService.insert((Client) entity);
                break;
            case "exhibit":
                query = ExhibitService.insert((Exhibit) entity);
                break;
            case "exhibition":
                query = ExhibitionService.insert((Exhibition) entity);
                break;
            case "hall":
                query = HallService.insert((Hall) entity);
;                break;
            case "ticket":
                query = TicketService.insert((Ticket) entity);
                break;
        }
        PreparedStatement ps = con.prepareStatement(query);
        ps.executeUpdate();
        ps.close();
    }

    public void addExhibitToExhibition(int exhibition_id, int exhibit_id) throws SQLException {
        PreparedStatement ps = con.prepareStatement(ExhibitionService.addExhibitToExhibition(exhibition_id, exhibit_id));
        ps.executeUpdate();
        ps.close();
    }

    public void removeExhibitFromExhibition(int exhibition_id, int exhibit_id) throws SQLException {
        PreparedStatement ps = con.prepareStatement(ExhibitionService.removeExhibitFromExhibition(exhibition_id, exhibit_id));
        ps.executeUpdate();
        ps.close();
    }


    public void addExhibitToHall(int hall_id, int exhibit_id) throws SQLException {
        PreparedStatement ps = con.prepareStatement(HallService.addExhibitToHall(hall_id, exhibit_id));
        ps.executeUpdate();
        ps.close();
    }

    public void removeExhibitFromHall(int hall_id, int exhibit_id) throws SQLException {
        PreparedStatement ps = con.prepareStatement(HallService.removeExhibitFromHall(exhibit_id));
        ps.executeUpdate();
        ps.close();
    }
    public void update(String tableName, MyEntity entity) throws SQLException {
        String query = null;
        switch (tableName){
            case "client":
                query = ClientService.update((Client) entity);
                break;
            case "exhibit":
                query = ExhibitService.update((Exhibit) entity);
                break;
            case "exhibition":
                query = ExhibitionService.update((Exhibition) entity);
                break;
            case "hall":
                query = HallService.update((Hall) entity);
                ;                break;
            case "ticket":
                query = TicketService.update((Ticket) entity);
                break;
        }
        PreparedStatement ps = con.prepareStatement(query);
        ps.executeUpdate();
        ps.close();
    }

    public MyEntity find(String tableName, int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM " + tableName + " WHERE id = " + id + ";");
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            throw new SQLException();
        }

        switch (tableName) {
            case "client":
                Client client = ClientService.parse(rs);
                ps.close();
                return client;

            case "exhibit":
                Exhibit exhibit = ExhibitService.parse(rs);
                exhibit.setExhibitionList(getExhibitionsWithExhibit(exhibit));
                ps.close();
                return exhibit;

            case "exhibition":
                Exhibition exhibition = ExhibitionService.parse(rs);
                exhibition.setExhibitList(getExhibitsForExhibitions(exhibition));
                ps.close();
                return exhibition;

            case "hall":
                Hall hall = HallService.parse(rs);
                hall.setExhibits(getExhibitsForHall(hall));
                ps.close();
                return hall;
            case "ticket":
                Ticket ticket = TicketService.parse(rs);
                ps.close();
                return ticket;
            default:
                return null;
        }
    }

    public List<MyEntity> getall(String tableName) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM " + tableName + ";");
        ResultSet rs = ps.executeQuery();
        List<MyEntity> result = new ArrayList<>();

        switch (tableName) {
            case "client":
                while(rs.next()) {
                    Client client = ClientService.parse(rs);
                    result.add(client);
                }
                break;

            case "exhibit":
                while(rs.next()) {
                    Exhibit exhibit = ExhibitService.parse(rs);
                    exhibit.setExhibitionList(getExhibitionsWithExhibit(exhibit));
                    result.add(exhibit);
                }
                break;

            case "exhibition":
                while(rs.next()) {
                    Exhibition exhibition = ExhibitionService.parse(rs);
                    exhibition.setExhibitList(getExhibitsForExhibitions(exhibition));
                    result.add(exhibition);
                }
                break;

            case "hall":
                while(rs.next()) {
                    Hall hall = HallService.parse(rs);
                    hall.setExhibits(getExhibitsForHall(hall));
                    result.add(hall);
                }
                break;
            case "ticket":
                while(rs.next()) {
                    Ticket ticket = TicketService.parse(rs);
                    result.add(ticket);
                }
                break;
            default:
                return null;
        }
        ps.close();
        return result;
    }

    public List<Exhibit> getExhibitsForExhibitions(Exhibition exhibition) throws SQLException {
        PreparedStatement ps = con.prepareStatement(ExhibitionService.getExhibits(exhibition));
        ResultSet rs = ps.executeQuery();
        List<Exhibit> exhibits = new ArrayList<>();
        while(rs.next()){
            exhibits.add(ExhibitService.parse(rs));
        }
        ps.close();
        return exhibits;
    }

    public List<Exhibition> getExhibitionsWithExhibit(Exhibit exhibit) throws SQLException {
        PreparedStatement ps = con.prepareStatement(ExhibitService.getExhibitions(exhibit));
        ResultSet rs = ps.executeQuery();
        List<Exhibition> exhibits = new ArrayList<>();
        while(rs.next()){
            exhibits.add(ExhibitionService.parse(rs));
        }
        ps.close();
        return exhibits;
    }

    public List<Exhibit> getExhibitsForHall(Hall hall) throws SQLException {
        PreparedStatement ps = con.prepareStatement(HallService.getExhibits(hall));
        ResultSet rs = ps.executeQuery();
        List<Exhibit> exhibits = new ArrayList<>();
        while(rs.next()){
            exhibits.add(ExhibitService.parse(rs));
        }
        ps.close();
        return exhibits;
    }

    public void delete(String tableName, int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM " + tableName + " WHERE id = " + id + ";");
        ps.executeUpdate();
        ps.close();
    }


}
