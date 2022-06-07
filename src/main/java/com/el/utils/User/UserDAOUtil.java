package com.el.utils.User;

import com.el.utils.DAO;
import com.el.utils.SqlResult;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/5/31
 * @ Description:
 * Life is short, I use Java
 */
public class UserDAOUtil implements DAO {
    /*
     * @BUG!!!!
     * 资源浪费，内存泄漏
     */

    public static ResultSet select(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql="select * from user_basic_info where id="+id;
        try {
            connection= UserUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            //test
            return preparedStatement.executeQuery();
//            return statement.executeQuery(sql);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }finally {

        }
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
