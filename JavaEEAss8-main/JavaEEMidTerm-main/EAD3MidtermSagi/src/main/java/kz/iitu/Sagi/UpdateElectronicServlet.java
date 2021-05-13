package kz.iitu.Sagi;

import kz.iitu.Sagi.config.Db;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpdateElectronicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long elId = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String desc = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        Connection connection = Db.getConn();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Electronics SET name=?, description=?, price=? WHERE id=?");

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, desc);
            preparedStatement.setDouble(3, price);
            preparedStatement.setLong(4, elId);

            preparedStatement.executeUpdate();


            request.getRequestDispatcher("updateElectronic.jsp").include(request,response);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
