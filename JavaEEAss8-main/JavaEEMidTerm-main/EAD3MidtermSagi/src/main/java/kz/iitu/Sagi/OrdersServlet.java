package kz.iitu.Sagi;

import kz.iitu.Sagi.config.Db;
import kz.iitu.Sagi.model.Purchase;

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


public class OrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = Db.getConn();
        List<Purchase> purchases = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Orders ORDER BY id asc");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){


                Purchase purchase = new Purchase();

                purchase.setElectronic_id(resultSet.getLong("electronic_id"));
                purchase.setId(resultSet.getLong("id"));
                purchase.setUser_id(resultSet.getLong("user_id"));

                purchases.add(purchase);

            }

            request.setAttribute("Orders", purchases);
            request.getRequestDispatcher("viewOrders.jsp").include(request,response);



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
