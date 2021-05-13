package kz.iitu.Sagi.Dao;

import kz.iitu.Sagi.config.Db;

import java.sql.Connection;

public class electronicsDao {

    private static Connection connection;


    {
        connection = Db.getConn();
    }


}
