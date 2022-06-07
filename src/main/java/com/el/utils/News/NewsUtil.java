package com.el.utils.News;

import com.el.utils.DAO;
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
 * @ Date: 2022/6/1
 * @ Description:
 * Life is short, I use Java
 */
public class NewsUtil {
    private static DataSource dataSource;
    //create dataSource
    static {
        try {
            InputStream in = UserUtil.class.getClassLoader().getResourceAsStream("dbcpconfig_news_table.properties");
            Properties properties = new Properties();
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
        return DBCPUtil.getConnection(dataSource);
    }
    public static void release(Connection conn, Statement st, ResultSet rs){
        DBCPUtil.release(conn,st,rs);
    }
}
