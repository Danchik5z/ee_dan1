package servlet;

import entity.Client;
import service.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet
public class ClientCUD extends HttpServlet {
    DBService dbService = DBService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            dbService.delete("client", Integer.parseInt(req.getParameter("delete_id")));
            req.getRequestDispatcher("/clientclient").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("action").equals("create")){
            Client client = new Client(0, req.getParameter("name"), req.getParameter("email"));
            try {
                dbService.insert("client", client);
                req.getRequestDispatcher("/clientclient").forward(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if(req.getParameter("action").equals("update")){

            Client client = new Client(Integer.parseInt(req.getParameter("update_id")), req.getParameter("u_name"), req.getParameter("u_email"));
            try {
                dbService.update("client",client);
                req.getRequestDispatcher("/clientclient").forward(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
