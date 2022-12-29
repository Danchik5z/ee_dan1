package servlet;

import entity.Client;
import entity.Exhibit;
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
public class ExhibitServlet extends HttpServlet {
    DBService dbService = DBService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            List<MyEntity> list = dbService.getall("exhibit");
            List<Exhibit> exhibits = new ArrayList<>();
            for(MyEntity entity: list){
                exhibits.add((Exhibit) entity);
            }
            req.setAttribute("exhibits", exhibits);
            req.getRequestDispatcher("/getExhibits.jsp").forward(req, resp);
        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Exhibit> exhibits = new ArrayList<>();
            exhibits.add((Exhibit) dbService.find("exhibit", Integer.parseInt(req.getParameter("find_id"))));
            req.setAttribute("exhibits", exhibits);
            req.getRequestDispatcher("/getExhibits.jsp").forward(req, resp);
        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
