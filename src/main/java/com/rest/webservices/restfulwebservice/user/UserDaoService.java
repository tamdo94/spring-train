package com.rest.webservices.restfulwebservice.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }

        users.add(user);
        return user;
    }

    public User findOne(int id) {
        return users.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
    }

    public User deleteById(int id) {
        User user = users.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
        users.removeIf(v -> v.getId() == id);

        return user;
    }

}
