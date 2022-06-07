package com.el.News;

import com.alibaba.fastjson.JSONObject;
import com.el.utils.JsonResult;
import com.el.utils.News.NewsDAOUtil;
import com.el.utils.News.NewsUtil;


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
 * @ Date: 2022/6/1
 * @ Description:
 * Life is short, I use Java
 */
public class NewsController {
    private final String deptName;
    private final List<List<String>> newsLists ;
    private List<JSONObject> newsJSON;
    public NewsController(String deptName){
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
        ResultSet resultSet= NewsDAOUtil.select(deptName);
        newsLists=new ArrayList<>();
        try {
            while (true){
//                assert resultSet != null;
                if (resultSet.isLast()){
                    break;
                }
                resultSet.next();
                List<String> stringList=new ArrayList<>();
                stringList.add(resultSet.getString("NEWS_TITLE"));
                stringList.add(resultSet.getString("NEWS_ABSTRACT"));
                stringList.add(dateToString(resultSet.getDate("NEWS_DATE")));
                stringList.add(resultSet.getString("NEWS_URL"));
                newsLists.add(stringList);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            setInformationAsJson();
            try {
                NewsUtil.release(resultSet.getStatement().getConnection(), resultSet.getStatement(),resultSet);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    // don't call this method
    // or there will be bugs in transforming the date

    // it shouldn't be set again and again
    private JsonResult setInformationAsJson(){
        if (this.newsJSON==null){
            this.newsJSON=new ArrayList<>();
        }
        for (List<String> listList:newsLists){
            JSONObject jo=new JSONObject();
//            System.out.println("123345667");
            jo.put("NEWS_TITLE",listList.get(0));
            jo.put("NEWS_ABSTRACT",listList.get(1));
            jo.put("NEWS_DATE",listList.get(2));
            jo.put("NEWS_URL",listList.get(3));
            newsJSON.add(jo);
        }
        return JsonResult.SetSuccess;
    }

    private String dateToString(Date date){
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public List<JSONObject> getNewsJSON(){
        return this.newsJSON;
    }

    // test!!!
    public String toString(){
        System.out.println("deptName"+deptName);
        newsLists.forEach(s->{
        s.forEach(System.out::println);
        });
        return null;
    }
}
