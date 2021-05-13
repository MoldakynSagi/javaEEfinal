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


public class DeleteElectronicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.valueOf(request.getParameter("id"));

        Connection connection = Db.getConn();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Electronics WHERE id=?");


            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            request.getRequestDispatcher("deleteElectronic.jsp").include(request,response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
