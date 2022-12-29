package servlet;

import entity.Client;
import entity.Exhibition;
import entity.MyEntity;
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
public class HallsServlet extends HttpServlet {
    DBService dbService = DBService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            List<MyEntity> list = dbService.getall("exhibition");
            List<Exhibition> exhibitions = new ArrayList<>();
            for(MyEntity entity: list){
                exhibitions.add((Exhibition) entity);
            }
            req.setAttribute("exhibitions", exhibitions);
            req.getRequestDispatcher("/getExhibitions.jsp").forward(req, resp);
        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Client> exhibitions = new ArrayList<>();
            exhibitions.add((Client) dbService.find("exhibition", Integer.parseInt(req.getParameter("find_id"))));
            req.setAttribute("exhibitions", exhibitions);
            req.getRequestDispatcher("/getExhibitions.jsp").forward(req, resp);
        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
