package request;

import entity.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientService {
    public static String insert(Client client){
        return "Insert into client(full_name,email) VALUES('"+
                client.getFullName() + "','" +
                client.getEmail() +"')";
    }

    public static String update(Client client){
        return "UPDATE client SET full_name = '" + client.getFullName() +
                "' email = '" + client.getEmail() +
                "' WHERE client_id = " + client.getID();
    }

    public static String delete(int id){
        return "DELETE FROM client WHERE client_id = " + id;
    }

    public static String get(int id){
        return "select * from client where client_id = " + id;
    }

    public static String getAll(){
        return "select * from client";
    }

    public static Client parse(ResultSet resultSet) throws SQLException {
        return new Client(resultSet.getInt("client_id"),
                resultSet.getString("full_name"),
                resultSet.getString("email"));
    }

}
