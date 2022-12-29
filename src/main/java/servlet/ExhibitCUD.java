package servlet;

import entity.Client;
import entity.Exhibit;
import service.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet
public class ExhibitCUD extends HttpServlet {
    DBService dbService = DBService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            dbService.delete("exhibit", Integer.parseInt(req.getParameter("delete_id")));
            req.getRequestDispatcher("/exhibit").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("action").equals("create")){
            Exhibit exhibit = new Exhibit(0,
                    Integer.parseInt(req.getParameter("hallnumber")),
                    req.getParameter("name"),
                    Integer.parseInt(req.getParameter("year")),
                    req.getParameter("description"),
                    req.getParameter("author"));
            try {
                dbService.insert("exhibit", exhibit);
                req.getRequestDispatcher("/exhibit").forward(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if(req.getParameter("action").equals("update")){

            Exhibit exhibit = new Exhibit(Integer.parseInt(req.getParameter("update_id")),
                    Integer.parseInt(req.getParameter("u_hallnumber")),
                    req.getParameter("u_name"),
                    Integer.parseInt(req.getParameter("u_year")),
                    req.getParameter("u_description"),
                    req.getParameter("u_author"));
            try {
                dbService.update("exhibit",exhibit);
                req.getRequestDispatcher("/exhibit").forward(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
