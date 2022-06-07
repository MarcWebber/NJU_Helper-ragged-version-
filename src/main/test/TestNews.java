import com.el.News.NewsController;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/6/1
 * @ Description:
 * Life is short, I use Java
 */

public class TestNews {
    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            NewsController newsController=new NewsController("softwareengineering");
            System.out.println(i);
//            newsController.showInfo();
        }

    }
}
