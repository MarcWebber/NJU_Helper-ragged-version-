package com.el.utils.Login;

import com.el.utils.User.UserUtil;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/6/3
 * @ Description:
 * Life is short, I use Java
 */
public class LoginUtil {
    private static Properties properties;
    private static DataSource dataSource;

    //create dataSource
    static {
        try {
            InputStream in = UserUtil.class.getClassLoader().getResourceAsStream("dbcpconfig_login_table.properties");
            properties = new Properties();
            properties.load(in);
            try {
                dataSource = BasicDataSourceFactory.createDataSource(properties);
            } catch (Exception e) {
                System.err.println("DataSource creation failure");
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.err.println("load property failure");
            e.printStackTrace();
        }
    }

    //get a connection from the dataSource
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            try {
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // to start a transmission
        System.err.println("getConncetion!");
        return connection;
    }

    public static void release(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("released!");
    }
}


