package servlet;

import entity.Client;
import entity.Exhibition;
import service.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet
public class ExhibitionCUD extends HttpServlet {

    DBService dbService = DBService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            dbService.delete("exhibition", Integer.parseInt(req.getParameter("delete_id")));
            req.getRequestDispatcher("/exhibition").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("action").equals("create")){
            Exhibition exhibition = new Exhibition(0, Date.valueOf(req.getParameter("start")), Date.valueOf(req.getParameter("end")),
                    req.getParameter("name"),
                    req.getParameter("country"),
                    req.getParameter("city"),
                    req.getParameter("venue"));
            try {
                dbService.insert("exhibitions", exhibition);
                req.getRequestDispatcher("/exhibition").forward(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if(req.getParameter("action").equals("update")){

            Exhibition exhibition = new Exhibition(Integer.parseInt(req.getParameter("update_id")),
                    Date.valueOf(req.getParameter("start")),
                    Date.valueOf(req.getParameter("end")),
                    req.getParameter("name"),
                    req.getParameter("country"),
                    req.getParameter("city"),
                    req.getParameter("venue"));
            try {
                dbService.update("client",exhibition);
                req.getRequestDispatcher("/exhibition").forward(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if(req.getParameter("action").equals("add")){
            try {
                dbService.addExhibitToExhibition(Integer.parseInt(req.getParameter("exh_id")), Integer.parseInt(req.getParameter("add_id")));
                req.getRequestDispatcher("/exhibition").forward(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (req.getParameter("action").equals("remove")){
            try {
                dbService.removeExhibitFromExhibition(Integer.parseInt(req.getParameter("exh_id")), Integer.parseInt(req.getParameter("add_id")));
                req.getRequestDispatcher("/exhibition").forward(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
