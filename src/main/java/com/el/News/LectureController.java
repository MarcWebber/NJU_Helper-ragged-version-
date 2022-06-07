package com.el.News;

import com.alibaba.fastjson.JSONObject;
import com.el.utils.JsonResult;
import com.el.utils.News.LectureDAOUtil;
import com.el.utils.News.LectureUtil;


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
public class LectureController {
    private final String deptName;
    private final List<List<String>> lectureLists ;
    private List<JSONObject> lectureJSON;
    public LectureController(String deptName){
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
        ResultSet resultSet= LectureDAOUtil.select(deptName);
        lectureLists=new ArrayList<>();
        try {
            while (true){
//                assert resultSet != null;
                if (resultSet.isLast()){
                    break;
                }
                resultSet.next();
                List<String> stringList=new ArrayList<>();
                stringList.add(resultSet.getString("LEC_TITLE"));
                stringList.add(resultSet.getString("LEC_ABSTRACT"));
                stringList.add(dateToString(resultSet.getDate("LEC_DATE")));
                stringList.add(resultSet.getString("LEC_URL"));
                lectureLists.add(stringList);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            setInformationAsJson();
            try {
                LectureUtil.release(resultSet.getStatement().getConnection(), resultSet.getStatement(),resultSet);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    // don't call this method
    // or there will be bugs in transforming the date

    // it shouldn't be set again and again
    private JsonResult setInformationAsJson(){
        if (this.lectureJSON ==null){
            this.lectureJSON =new ArrayList<>();
        }
        for (List<String> listList:lectureLists){
            JSONObject jo=new JSONObject();
            jo.put("LEC_TITLE",listList.get(0));
            jo.put("LEC_ABSTRACT",listList.get(1));
            jo.put("LEC_DATE",listList.get(2));
            jo.put("LEC_URL",listList.get(3));
            lectureJSON.add(jo);
        }
        return JsonResult.SetSuccess;
    }

    private String dateToString(Date date){
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public List<JSONObject> getLectureJSON(){
        return this.lectureJSON;
    }

    // test!!!
    public String toString(){
        System.out.println("deptName"+deptName);
        lectureLists.forEach(s->{
            s.forEach(System.out::println);
        });
        return null;
    }
}