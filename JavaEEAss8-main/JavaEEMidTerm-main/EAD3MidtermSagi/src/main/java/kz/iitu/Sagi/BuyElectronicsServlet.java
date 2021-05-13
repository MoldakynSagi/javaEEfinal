package kz.iitu.Sagi;

import kz.iitu.Sagi.config.Db;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/Buy")
public class BuyElectronicsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.valueOf(request.getParameter("id"));
        String userId = null;

        Cookie ck[] = request.getCookies();

        if (ck != null) {
            int i = 0;
            while (!ck[i].getName().equals("userId")) {
                i++;
            }

            userId = ck[i].getValue();
        }


        Connection connection = Db.getConn();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Orders(user_id, electronic_id) VALUES (?, ?)");
            preparedStatement.setLong(1, Long.parseLong(userId));
            preparedStatement.setLong(2,id);

            preparedStatement.executeUpdate();

            request.getRequestDispatcher("userDashboard.jsp").include(request,response);



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
