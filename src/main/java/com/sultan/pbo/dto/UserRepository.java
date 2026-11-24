package com.sultan.pbo.dto;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.common.hash.Hashing;
import com.sultan.pbo.model.User;

public class UserRepository {
    private static final HashMap<String, User> users = new HashMap<>();

    public static String hashPassword(String password) {
        return Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
    }

    public void create(String email, String password) throws Exception {
        if (users.containsKey(email)) {
            throw new Exception("email already exist.");
        }

        User user = new User(email, hashPassword(password));
        users.put(email, user);
    }

    public User find(String email, String password) {
        User user = users.get(email);
        if (user == null)
            return null;

        if (!user.getPasswordHash().equals(hashPassword(password)))
            return null;
        return user;
    }

    public ArrayList<User> findAll() {
        return new ArrayList<User>(users.values());
    }

    public void update(String email, String password) throws Exception {
        if (!users.containsKey(email) && !users.get(email).getPasswordHash().equals(hashPassword(password))) {
            throw new Exception("email does not exist.");
        }

        users.get(email).setPasswordHash(hashPassword(password));
    }

    public void delete(String email, String password) throws Exception {
        if (!users.containsKey(email) && !users.get(email).getPasswordHash().equals(hashPassword(password))) {
            throw new Exception("email does not exist.");
        }

        users.remove(email);
    }
}
