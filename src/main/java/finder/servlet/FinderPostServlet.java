package finder.servlet;

import finder.ajax_entities.ResultTable;
import finder.ajax_entities.Row;
import finder.db.DbHelper;
import finder.db.SqlHelper;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FinderPostServlet extends HttpServlet {

    private final static Logger LOG = Logger.getLogger(FinderPostServlet.class);
    private SqlHelper sqlHelper = new SqlHelper();
    private String queryName = "find_user";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");


        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String postData = stringBuilder.toString();

        HashMap<String, String> requestData = new HashMap<String, String>();
        String[] keyvalues = postData.split("&");
        for (String i : keyvalues) {
            String[] parsed = i.split("=");
            if (parsed.length > 1) {
                requestData.put(parsed[0], parsed[1]);
            }
        }

        PrintWriter out = response.getWriter();
        try {
            ResultTable resultTable = getResultTable(requestData);
            out.println(resultTable.toString());
            LOG.debug(resultTable.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private ResultTable getResultTable(HashMap<String, String> requestData) throws IOException, SQLException, NamingException {
        String query = sqlHelper.getQuery(queryName);
        DataSource dataSource = DbHelper.getDataSource();
        Connection connection = dataSource.getConnection();
        List<String> arguments = new ArrayList<String>();

        if (requestData.containsKey("firstName")) {
            query += " and u.firstname = ?";
            arguments.add(requestData.get("firstName"));
        }
        if (requestData.containsKey("middleName")) {
            query += " and u.middlename = ?";
            arguments.add(requestData.get("middleName"));
        }
        if (requestData.containsKey("secondName")) {
            query += " and u.secondname = ?";
            arguments.add(requestData.get("secondName"));
        }
        if (requestData.containsKey("city")) {
            query += " and ci.name = ?";
            arguments.add(requestData.get("city"));
        }
        if (requestData.containsKey("color")) {
            query += " and c.color = ?";
            arguments.add(requestData.get("color"));
        }
        if (requestData.containsKey("model")) {
            query += " and c.model = ?";
            arguments.add(requestData.get("model"));
        }

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        for (int i = 0; i < arguments.size(); ++i) {
            preparedStatement.setString(i + 1, arguments.get(i));
        }

        ResultSet resultSet = preparedStatement.executeQuery();

        ResultTable resultTable = new ResultTable();

        while (resultSet.next()) {
            resultTable.addRow(new Row(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            ));
        }

        return resultTable;
    }
}
