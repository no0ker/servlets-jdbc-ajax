package finder.servlet;

import finder.db.DbHelper;
import finder.db.SqlHelper;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class InitPostServlet extends HttpServlet {

    private SqlHelper sqlHelper = new SqlHelper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        try {
            DbHelper.executeUpdate(sqlHelper.getQuery("create_cities"));
            out.println("ok");
        } catch (NamingException e) {
            e.printStackTrace();
            out.println(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            out.println(e.getMessage());
        }



    }
}
