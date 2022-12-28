

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("casmkc");
//        List<Worker> workers = new ArrayList<>();
//        workers.add(new Worker("df","0"));
//        workers.add(new Worker("c","321"));
//        resp.getWriter().write(workers.toString());
//        try {
//            WorkerService workerService = new WorkerService(Connector.getConnection());
//            WorkerRequest workerRequest = new WorkerRequest();
//            ResultSet resultSet = workerService.get();
//            resultSet.next();
//            workerRequest.parse(resultSet);
//
//
//            System.out.println(workerRequest.parse(resultSet));
//
//            resp.getWriter().write(workerRequest.parse(resultSet).toString());
//
//
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

//        First name: <input type = "text" name = "first_name" / ><br / >
//                Last name: <input type = "text" name = "last_name" / ><br / >
//                E - mail: <input type = "email" name = "user_email" / ><br / >
//        <input type = "submit" value = "Submit" / >
//        </form >


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String name = req.getParameter("username");
        String age = req.getParameter("userage");
        String gender = req.getParameter("gender");
        String country = req.getParameter("country");
        String[] courses = req.getParameterValues("courses");

        try {
            writer.println("<p>Name: " + name + "</p>");
            writer.println("<p>Age: " + age + "</p>");
            writer.println("<p>Gender: " + gender + "</p>");
            writer.println("<p>Country: " + country + "</p>");
            writer.println("<h4>Courses</h4>");
            for(String course: courses)
                writer.println("<li>" + course + "</li>");
        } finally {
            writer.close();
        }
    }
}
