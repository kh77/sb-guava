package com.sm.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableList;
import com.sm.dto.User;
import com.sm.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class UserService {

    private final Cache<Long, User> userCache;

    public UserService() {
        userCache = CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(10, TimeUnit.MINUTES).build();
    }

    public User create(User user) {
        Long id = UserRepo.incrementId();
        UserRepo.save(id, user);
        log.info("save in repo");
        userCache.put(id, user);
        log.info("save in cache");
        user.setId(id);
        return user;
    }

    public User getUserById(Long id) {
        User user = userCache.getIfPresent(id);
        if (user == null) {
            log.info("retrieve from database");
            user = UserRepo.getById(id);
        } else {
            log.info("retrieve from cache");
        }
        return user;
    }

    public List<User> getAllUsers() {
        return ImmutableList.copyOf(userCache.asMap().values());
    }

    public void updateUser(User user) {
        if (getUserById(user.getId()) != null) {
            userCache.put(user.getId(), user);
            UserRepo.save(user.getId(), user);
        }
    }

    public void deleteUser(Long id) {
        if (UserRepo.getById(id) != null) {
            log.info("remove from database & cache");
            UserRepo.remove(id);
            userCache.invalidate(id);
        }
    }
}
