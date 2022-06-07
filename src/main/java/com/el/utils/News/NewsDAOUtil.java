package com.el.utils.News;

import com.el.utils.DAO;
import com.el.utils.SqlResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/6/1
 * @ Description:
 * Life is short, I use Java
 */
public class NewsDAOUtil implements DAO {
    /*
     * A problem may be here
     * the ResultSet could have been released and can't be accessed
     *
     *
     *
     */
    public static ResultSet select(String deptName) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
//        ResultSet resultSet=null;
        String sql="select * from "+deptName+" order by NEWS_DATE desc ";
        try {
            System.err.println("trying to get connection!");
            connection=NewsUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            /*
             * I close the ResultSet personally
             * But the connection won't close I think?
             * Will this lead to bugs?
             */
            return preparedStatement.executeQuery();
//            return resultSet;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {

        }
        return null;
    }

    @Override
    public ResultSet select() {
        return null;
    }

    @Override
    public SqlResult insert() {
        return null;
    }

    @Override
    public <T> SqlResult insert(String key, T value) {
        return null;
    }

    @Override
    public SqlResult update() {
        return null;
    }

    @Override
    public SqlResult delete() {
        return null;
    }
}
