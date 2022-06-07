package com.el.Servlet;

import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.xml.ws.WebFault;
import java.io.File;
import java.util.Date;
import java.util.Random;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/6/5
 * @ Description:
 * Life is short, I use Java
 */
@Deprecated
public class UploadImgServlet {
    /**
     * 图片上传到服务器文件夹中
     *
     * @param
     * @return imgurl图片路径，success接口状态
     */
//    @RequestMapping("/uploadimage")
//    @ResponseBody
    public String uploadPicture() {
        return null;
////            @RequestParam(value = "file", required = false) MultipartFile file,
//                                HttpServletRequest request, HttpServletResponse response) {
//        JSONObject obj = new JSONObject();
//        File targetFile = null;
//        String url = "";// 返回存储路径
//        String fileName = file.getOriginalFilename();// 获取文件名加后缀
//        if (fileName != null && fileName != "") {
//            //文件存储位置
//            ServletContext scontext = request.getSession().getServletContext();
//            // 获取绝对路径
//            String path = scontext.getRealPath("/") + "UpLoadFile/imageFile";
//            String lastname = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
//            fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + lastname;//当前时间+随机数=新的文件名
//            // 如果文件夹不存在则创建
//            File pathfile = new File(path);
//            if (!pathfile.exists()) {
//                pathfile.mkdirs();
//            }
//            // 将图片存入文件夹
//            targetFile = new File(path, fileName);
//            try {
//                // 将上传的文件写到服务器上指定的文件。
//                file.transferTo(targetFile);
//                obj.put("success", true);
//                url = fileName;//保存路径，便于后续存入数据库
//            } catch (Exception e) {
//                e.printStackTrace();
//                obj.put("success", false);
//                obj.put("errorMsg", e.getMessage());
//            }
//        }
//        obj.put("imgurl", url);
//        return obj.toString();
//    }
    }
}
