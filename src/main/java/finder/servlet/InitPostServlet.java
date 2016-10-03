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
import java.util.ArrayList;
import java.util.List;

public class InitPostServlet extends HttpServlet {

    private SqlHelper sqlHelper = new SqlHelper();
    private List<String> queries = new ArrayList<String>(){{
        add("1-create_cities");
        add("2-create_cars");
        add("3-create_users");
        add("4-create_inter_table");
    }};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        for(int i = 0; i < queries.size(); ++i){
            try {
                DbHelper.executeUpdate(sqlHelper.getQuery(queries.get(i)));
                out.println("<br> ok");
            } catch (NamingException e) {
                e.printStackTrace();
                out.println("<br>" + e.getMessage());
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("<br>" + e.getMessage());
            }
        }
    }
}
