package kz.iitu.Sagi;

import kz.iitu.Sagi.config.Db;
import kz.iitu.Sagi.model.Electronic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Update")
public class UpdateFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));

        Connection connection = Db.getConn();
        Electronic electronic = null;


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Electronics Where id=?");

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            electronic = new Electronic();

            electronic.setId(resultSet.getLong("id"));
            electronic.setName(resultSet.getString("name"));
            electronic.setDescription(resultSet.getString("description"));
            electronic.setPrice(resultSet.getDouble("price"));

            request.setAttribute("electronic", electronic);
            request.getRequestDispatcher("updateElectronic.jsp").include(request,response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
