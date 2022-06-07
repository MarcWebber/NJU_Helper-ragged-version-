// 先引入SQLGetAndSert.js
document.write("<script src='./resources/scripts/SQLGetAndSert.js'></script>")


var str_lectures = "我院召开2021届本科毕业生座谈会,https://sfs.nju.edu.cn/10760/12/00/c10760a528896/page.htm,2021-06-10;外院召开2021届研究生毕业生座谈会,https://sfs.nju.edu.cn/10760/0f/1c/c10760a528156/page.htm,2021-06-03;外院召开2021届研究生毕业生座谈会,https://sfs.nju.edu.cn/10760/0f/1c/c10760a528156/page.htm,2021-06-03;外院党委举办《档案里的党员精神》党史学习教育专题讲座,https://sfs.nju.edu.cn/10760/0d/a9/c10760a527785/page.htm,2021-06-01;外院党委举办《档案里的党员精神》党史学习教育专题讲座,https://sfs.nju.edu.cn/10760/0d/a9/c10760a527785/page.htm,2021-06-01;外国语学院党委与江苏省委党史工办机关党委举行结对共建活动,https://sfs.nju.edu.cn/10760/f3/e0/c10760a521184/page.htm,2021-05-24;外国语学院党委与江苏省委党史工办机关党委举行结对共建活动,https://sfs.nju.edu.cn/10760/f3/e0/c10760a521184/page.htm,2021-05-24;党史学习教育专题讲座：档案里的党员精神,https://sfs.nju.edu.cn/10760/f0/47/c10760a520263/page.htm,2021-05-20;党史学习教育专题讲座：档案里的党员精神,https://sfs.nju.edu.cn/10760/f0/47/c10760a520263/page.htm,2021-05-20;俄语系举办读书交流会暨“悦读俄罗斯”读书征文比赛,https://sfs.nju.edu.cn/10760/dd/85/c10760a515461/page.htm,2021-04-14;俄语系举办读书交流会暨“悦读俄罗斯”读书征文比赛,https://sfs.nju.edu.cn/10760/dd/85/c10760a515461/page.htm,2021-04-14;回眸百年党史 祭奠铮铮铁骨  ——记外国语学院党委清明祭扫雨花台活动,https://sfs.nju.edu.cn/10760/dd/71/c10760a515441/page.htm,2021-04-14;回眸百年党史 祭奠铮铮铁骨  ——记外国语学院党委清明祭扫雨花台活动,https://sfs.nju.edu.cn/10760/dd/71/c10760a515441/page.htm,2021-04-14;学史明理，学史增信——外国语学院党委举办党史学习教育专题讲座,https://sfs.nju.edu.cn/10760/db/fd/c10760a515069/page.htm,2021-04-12;学史明理，学史增信——外国语学院党委举办党史学习教育专题讲座,https://sfs.nju.edu.cn/10760/db/fd/c10760a515069/page.htm,2021-04-12;孙本文社会学论坛（第267期）,https://sociology.nju.edu.cn/17645/ab/4d/c17645a568141/page.htm,2022-05-05;孙本文社会学论坛第(266)期,https://sociology.nju.edu.cn/17645/a2/b2/c17645a565938/page.htm,2022-04-13;孙本文社会学论坛第（265）期,https://sociology.nju.edu.cn/17645/9c/20/c17645a564256/page.htm,2022-03-21;孙本文社会学论坛（第264期）,https://sociology.nju.edu.cn/17645/9a/34/c17645a563764/page.htm,2022-03-15;孙本文社会学论坛（第263期）,https://sociology.nju.edu.cn/17645/74/e8/c17645a554216/page.htm,2021-12-06;孙本文社会学论坛（第262期）,https://sociology.nju.edu.cn/17645/6f/63/c17645a552803/page.htm,2021-12-02;孙本文社会学论坛（第261期）,https://sociology.nju.edu.cn/17645/58/b4/c17645a546996/page.htm,2021-11-17;合美博士餐叙第五十六期,https://sociology.nju.edu.cn/17645/54/df/c17645a546015/page.htm,2021-11-11;郑钢社会学人讲座第十五期,https://sociology.nju.edu.cn/17645/53/29/c17645a545577/page.htm,2021-11-09;合美博士餐叙第五十五期,https://sociology.nju.edu.cn/17645/1e/63/c17645a532067/page.htm,2021-06-22;郑钢社会学人讲座第十四期,https://sociology.nju.edu.cn/17645/10/0f/c17645a528399/page.htm,2021-06-07;孙本文社会学论坛（第259期）,https://sociology.nju.edu.cn/17645/f5/68/c17645a521576/page.htm,2021-05-26;孙本文社会学论坛（第258期）,https://sociology.nju.edu.cn/17645/ee/ef/c17645a519919/page.htm,2021-05-18;孙本文社会学论坛（第257期）,https://sociology.nju.edu.cn/17645/ee/ee/c17645a519918/page.htm,2021-05-18;"

var lecture_table
window.onload = function(){
    lecture_table = CreateTableFromInputStream(str_lectures, "LECTURES")
    
}

function SetTitleFromLecturesSQL(id_list_name, index){
    db.transaction(function (lecture_table) {
        lecture_table.executeSql('select * from LECTURES', [], function (lecture_table, results) {
            document.querySelector("#"+ id_list_name).innerHTML = results.rows.item(index).title;
        })
    })
}

function SetHrefFromLecturesSQL(id_list_name, index){
    db.transaction(function (lecture_table) {
        lecture_table.executeSql('select * from LECTURES', [], function (lecture_table, results) {
            document.querySelector("#" + id_list_name).setAttribute("href",
             results.rows.item(index).href)
        })
    })
}

function SetDateFromLecturesSQL(id_list_name, index){
    db.transaction(function (lecture_table) {
        lecture_table.executeSql('select * from LECTURES', [], function (lecture_table, results) {
            document.querySelector("#" + id_list_name).innerHTML = results.rows.item(index).date;
        })
    })
}

function RecreateLecturesTable(){
    delete(lecture_table)
    lecture_table = CreateTableFromInputStream(str_lectures, "LECTURES")
}