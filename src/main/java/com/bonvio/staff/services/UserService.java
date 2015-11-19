package com.bonvio.staff.services;

import com.bonvio.staff.models.User;

import java.util.List;

/**
 * Created by niko on 03.06.15.
 */
public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(Integer id);
    public Integer insertUser(User user);
    public Integer deleteUserById(Integer id);
    public Integer updateUser(User user);
}
