package com.mvpt.dao;

import com.mvpt.model.Login;
import com.mvpt.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User("john", "123456", "John", "john@codegym.vn", 10));
        users.add(new User("bill", "123456", "Bill", "bill@codegym.vn", 15));
        users.add(new User("mike", "123456", "Mike", "mike@codegym.vn", 10));
        users.add(new User("tony", "123456", "Tony", "tony@codegym.vn", 25));
        users.add(new User("tom", "123456", "Tom", "tom@codegym.vn", 32));
    }

    public static User checkLogin(Login login) {
        boolean result = false;
        for (User user : users) {
            if (user.getAccount().equals(login.getAccount())
                    && user.getPassword().equals(login.getPassword())
            ) {
                return user;
            }
        }

        return null;
    }
}
