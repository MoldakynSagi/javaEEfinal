package kz.iitu.Sagi;

import kz.iitu.Sagi.config.Db;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        Connection connection = Db.getConn();

        String dbName = null;
        String dbPassword = null;
        Long dbId = null;



        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Admin WHERE name=? and password=?");

            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){
                dbName = resultSet.getString("name");
                dbPassword = resultSet.getString("password");
            }

            if(name.equals(dbName) && password.equals(dbPassword)){

                request.getRequestDispatcher("adminDashboard.jsp").include(request, response);
            }else{
//                response.sendRedirect("login.jsp");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminLogin.jsp");
                requestDispatcher.include(request, response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
