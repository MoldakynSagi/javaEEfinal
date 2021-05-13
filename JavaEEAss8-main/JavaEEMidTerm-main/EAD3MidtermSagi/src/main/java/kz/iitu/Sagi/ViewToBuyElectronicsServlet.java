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
import java.util.ArrayList;
import java.util.List;


public class ViewToBuyElectronicsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = Db.getConn();

        List<Electronic> electronics = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Electronics ORDER  BY id asc ");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                Electronic electronic = new Electronic();

                electronic.setId(resultSet.getLong("id"));
                electronic.setName(resultSet.getString("name"));
                electronic.setDescription(resultSet.getString("description"));
                electronic.setPrice(resultSet.getDouble("price"));

                electronics.add(electronic);
            }

            request.setAttribute("Electronics", electronics); //
            request.getRequestDispatcher("buyElectronics.jsp").include(request,response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
