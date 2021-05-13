package kz.iitu.Sagi;

import kz.iitu.Sagi.config.Db;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = null;
        String userPassword = null;
        Long userId = null;

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        Connection connection = Db.getConn();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Users WHERE name=? and password=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                userId = resultSet.getLong("id");
                userName = resultSet.getString("name");
                userPassword = resultSet.getString("password");


            }

            if (name.equals(userName) && password.equals(userPassword)) {
                Cookie ck = new Cookie("userId", String.valueOf(userId));
                ck.setMaxAge(60 * 20);
                response.addCookie(ck);

                request.getRequestDispatcher("userDashboard.jsp").include(request, response);

                HttpSession session = request.getSession();
                session.setAttribute("name", name);

            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.jsp");
                requestDispatcher.include(request, response);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("userLogin.jsp");
    }
}
