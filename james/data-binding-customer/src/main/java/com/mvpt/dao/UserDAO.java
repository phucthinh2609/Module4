package com.mvpt.dao;

import com.mvpt.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User("john", "123456","John", "john@codegym.vn", 10));
        users.add(new User("bill", "123456","Bill", "bill@codegym.vn", 15));
        users.add(new User("mike", "123456","Mike", "mike@codegym.vn", 10));
        users.add(new User("john", "123456","John", "john@codegym.vn", 10));
        users.add(new User("john", "123456","John", "john@codegym.vn", 10));

        User u3 = new User();
        u3.setAge(16);
        u3.setName("");
        u3.setAccount("");
        u2.setEmail("");
        u3.setPassword("123456");
        users.add(u3);

    }
}
