// function CreateSQL(){
//     let db
//     db = openDatabase("MySql", "1.0", "我的数据库描述", 1024 * 1024 * 1024);
//     var result = db ? "数据库创建成功" : "数据库创建失败";
//     console.log(result);
//     return db
// }

var db
if (db == null){
    db = openDatabase("MySql", "1.0", "我的数据库描述", 1024 * 1024 * 1024);
}
var result = db ? "数据库创建成功" : "数据库创建失败";
console.log(result);


function CreateTableFromInputStream(s, sql_name){
    let tx
    db.transaction(function (tx) {
        tx.executeSql('DROP TABLE IF EXISTS ' + sql_name);
        tx.executeSql('CREATE TABLE IF NOT EXISTS '+ sql_name + ' (id, title, href , date)');
        //tx.executeSql('INSERT INTO LOGS VALUES (1,\'title1\',\'href1\',\'time\')');
    });

    let num = 0;
    while (s.length > 0) {
        if (s.indexOf(";") == -1) {
            break;
        }
        num++;
        let quote1 = s.indexOf(",");
        let s1 = s.substring(0, quote1);
        s = s.substring(quote1 + 1);
        let quote2 = s.indexOf(",");
        let s2 = s.substring(0, quote2);
        s = s.substring(quote2 + 1);
        let quote3 = s.indexOf(";");
        let s3 = s.substring(0, quote3);
        s = s.substring(quote3 + 1);
        //alert([num, s1, s2, s3, 0]);
        db.transaction(function (tx) {

            tx.executeSql('INSERT INTO ' + sql_name + ' VALUES (?, ?, ?, ?)', [num, s1, s2, s3]);
        });

    }

    return tx

}

function GetInfoListFromThisJson(index, json){
    var this_obj = JSON.parse(json)
    var ret_map = new Array()
    ret_map['title'] = this_obj.index.title
    ret_map['text'] = this_obj.index.summary
    ret_map['date'] = this_obj.index.daytime
    ret_map['href'] = this_obj.index.url

    return ret_map
    
}