package com.el.User;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.el.utils.JsonResult;
import com.el.utils.News.DBCPUtil;
import com.el.utils.News.NewsUtil;
import com.el.utils.User.UserDAOUtil;
import com.el.utils.User.UserUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/5/31
 * @ Description:
 * Life is short, I use Java
 */
public class UserController {
    private int id;
    private String name;
    private URL profile;
    private String signature;
    private List<String> departments;
    private JSONObject basicInformation;

    public List<String> getDepartments() {
        return departments;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfile(URL profile) {
        this.profile = profile;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void addDepartments(String dept){
        this.departments.add(dept);
    }

    public void removeDepartments(String dept){
        this.departments.remove(dept);
    }


    // construct a new user
    public UserController(int id) {
        ResultSet resultSet= UserDAOUtil.select(id);
        try {
            /*
             * theResultSet has a life circle until it is parsed!
             * the resources should not be released before this method
             *
             */
            System.out.println("trying to set the basic info of "+id);
            resultSet.next();
            this.id=resultSet.getInt("id");
//            resultSet.next();
            this.name=resultSet.getString("name");
//            resultSet.next();
            this.profile= new URL(resultSet.getString("profile"));
//            resultSet.next();
            this.signature=resultSet.getString("signature");
//            resultSet.next();
            this.departments= Arrays.asList(resultSet.getString("departments").split(","));
            setUserInformationAsJson();
        }catch (SQLException | MalformedURLException e){
            e.printStackTrace();
        } finally {
            try {
                UserUtil.release(resultSet.getStatement().getConnection(), resultSet.getStatement(),resultSet);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
    /*
     * @BUG!!!!
     * A BUG MAY BE PRODUCED HERE
     * IF THE BASIC INFO IS CHANGED
     * BUT THE JSON WON'T CHANGE!
     */
    public List<String> getDepts(){
        return this.departments;
    }

    public JsonResult setUserInformationAsJson(){
            this.basicInformation=new JSONObject();
            this.basicInformation.put("id",this.id);
            this.basicInformation.put("name",this.name);
            this.basicInformation.put("profile",this.profile);
            this.basicInformation.put("signature",this.signature);
            this.basicInformation.put("departments",this.departments);
            System.out.println("trying to set Json for "+id);
        return JsonResult.SetSuccess;
    }

    public JSONObject getUserInformationAsJson(){
        return this.basicInformation;
    }
    //test
}
