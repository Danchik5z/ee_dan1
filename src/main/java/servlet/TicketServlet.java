package servlet;

import entity.Client;
import entity.MyEntity;
import entity.Ticket;
import service.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet
public class TicketServlet extends HttpServlet {
    DBService dbService = DBService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            List<MyEntity> list = dbService.getall("ticket");
            List<Ticket> clients = new ArrayList<>();
            for(MyEntity entity: list){
                clients.add((Ticket) entity);
            }
            req.setAttribute("tickets", clients);
            req.getRequestDispatcher("/getTickets.jsp").forward(req, resp);
        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Ticket> clients = new ArrayList<>();
            clients.add((Ticket) dbService.find("ticket", Integer.parseInt(req.getParameter("find_id"))));
            req.setAttribute("tickets", clients);
            req.getRequestDispatcher("/getTickets.jsp").forward(req, resp);
        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
