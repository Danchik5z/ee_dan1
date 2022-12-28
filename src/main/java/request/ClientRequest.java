package request;

import entity.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRequest {
    public  String insert(Client client){
        return "Insert into client(full_name,email) VALUES('"+
                client.getFullName() + "','" +
                client.getEmail() +"')";
    }

    public  String update(Client client, int id){
        return "UPDATE clients SET full_name = '" + client.getFullName() +
                "' email = '" + client.getEmail() +
                "' WHERE client_id = " + id;
    }

    public  String delete(int id){
        return "DELETE FROM client WHERE client_id = " + id;
    }

    public  String get(int id){
        return "select * from client where client_id = " + id;
    }

    public String getAll(){
        return "select * from client";
    }

    public Client parse(ResultSet resultSet) throws SQLException {
        return new Client(resultSet.getInt("client_id"),
                resultSet.getString("full_name"),
                resultSet.getString("email"));
    }

}
