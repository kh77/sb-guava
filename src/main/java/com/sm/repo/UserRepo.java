package com.sm.repo;

import com.sm.dto.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepo {

    public static Map<Long, User> map = new HashMap<>();
    public static Long number = 0L;

    public static User getById(Long id) {

        return map.get(id);
    }

    public static User save(Long id, User user) {
        return map.put(id, user);
    }

    public static void remove(Long id) {
        map.remove(id);
    }

    public static Long incrementId() {
        return ++number;
    }
}
