package com.el.utils.Login;

import com.el.utils.News.NewsUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/6/4
 * @ Description:
 * Life is short, I use Java
 */
public class LoginDAOUtil {
    public static int checkUser(int Id,String password){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select count(*) from user_passwd where Uuid=(?) and Pwd=(?)";
        try {
            connection=LoginUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,Id);
            preparedStatement.setString(2,password);
//            System.out.println(Id);
//            System.out.println(password);
            /*
             * @BUG!!!!
             *
             */
//            System.out.println(sql);
            resultSet=preparedStatement.executeQuery();
            resultSet.next();
//            System.out.println(preparedStatement.executeQuery().getObject(0));
            return resultSet.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                LoginUtil.release(resultSet.getStatement().getConnection(), resultSet.getStatement(),resultSet);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return 0;
    }
}
