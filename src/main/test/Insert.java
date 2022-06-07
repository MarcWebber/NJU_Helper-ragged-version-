import com.el.utils.User.UserUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/6/4
 * @ Description:
 * Life is short, I use Java
 */
public class Insert {
        public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql="insert into user_passwd (Uuid,Pwd) VALUES (?,?)";
        try {
            connection= UserUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            for(int i=211250003;i<211250246;i++){
                preparedStatement.setInt(1,i);
                preparedStatement.setString(2,""+i);
                preparedStatement.executeUpdate();
            }
            connection.commit();

            //test
//            return preparedStatement.executeQuery();
//            return statement.executeQuery(sql);
        }catch (SQLException e){
            e.printStackTrace();
            //            return null;
        } finally {
            UserUtil.release(connection,preparedStatement,null);
        }
    }
}
