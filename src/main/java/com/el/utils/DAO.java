package com.el.utils;

import java.sql.ResultSet;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/5/31
 * @ Description:
 * Life is short, I use Java
 */
public interface DAO {
    ResultSet select();
    SqlResult insert();
    <T> SqlResult insert(String key,T value);
    SqlResult update();
    SqlResult delete();
}
