package com.el.News;

import com.alibaba.fastjson.JSONObject;
import com.el.utils.JsonResult;
import com.el.utils.News.ActivityDAOUtil;
import com.el.utils.News.ActivityUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/6/6
 * @ Description:
 * Life is short, I use Java
 */
public class ActivityController {
    private final String deptName;
    private final List<List<String>> activityLists ;
    private List<JSONObject> activityJSON;
    public ActivityController(String deptName){
        /*
         * @BUG!!!!
         * May produce a bug here
         * if the method is recalled again and again, it will collapse
         * many many bugs!!!!!!
         * Maybe Solved!
         */
        this.deptName=deptName;
        /*
         * @BUG!!!!
         * the resource maybe auto closed!
         * Solved!!!
         */
        ResultSet resultSet= ActivityDAOUtil.select(deptName);
        activityLists=new ArrayList<>();
        try {
            while (true){
//                assert resultSet != null;
                if (resultSet.isLast()){
                    break;
                }
                resultSet.next();
                List<String> stringList=new ArrayList<>();
                stringList.add(resultSet.getString("Activity_TITLE"));
                stringList.add(resultSet.getString("Activity_ABSTRACT"));
                stringList.add(dateToString(resultSet.getDate("Activity_DATE")));
                stringList.add(resultSet.getString("Activity_URL"));
                activityLists.add(stringList);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            setInformationAsJson();
            try {
                ActivityUtil.release(resultSet.getStatement().getConnection(), resultSet.getStatement(),resultSet);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    // don't call this method
    // or there will be bugs in transforming the date

    // it shouldn't be set again and again
    private JsonResult setInformationAsJson(){
        if (this.activityJSON ==null){
            this.activityJSON =new ArrayList<>();
        }
        for (List<String> listList:activityLists){
            JSONObject jo=new JSONObject();
            jo.put("Activity_TITLE",listList.get(0));
            jo.put("Activity_ABSTRACT",listList.get(1));
            jo.put("Activity_DATE",listList.get(2));
            jo.put("Activity_URL",listList.get(3));
            activityJSON.add(jo);
        }
        return JsonResult.SetSuccess;
    }

    private String dateToString(Date date){
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public List<JSONObject> getActivityJSON(){
        return this.activityJSON;
    }

    // test!!!
    public String toString(){
        System.out.println("deptName"+deptName);
        activityLists.forEach(s->{
            s.forEach(System.out::println);
        });
        return null;
    }
}
