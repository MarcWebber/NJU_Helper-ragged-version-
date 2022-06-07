package com.el.Login;

import com.el.utils.Login.LoginDAOUtil;
import com.el.utils.Login.LoginUtil;

/**
 * Created with Intellij IDEA
 *
 * @ Author: MarcWebber
 * @ Date: 2022/6/2
 * @ Description:
 * Life is short, I use Java
 */
public class LoginController {
    private final int Id;
    private final String password;

    public int getId() {
        return Id;
    }

    public String getPassword() {
        return password;
    }

    public LoginController(int Id, String password) {
        this.Id = Id;
        this.password = password;
    }

    public boolean check() {
        return LoginDAOUtil.checkUser(Id, password) == 1;
    }
}
