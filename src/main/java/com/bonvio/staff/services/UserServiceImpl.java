package com.bonvio.staff.services;

import com.bonvio.staff.dao.UserDAO;
import com.bonvio.staff.models.User;
import com.bonvio.staff.models.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by niko on 03.06.15.
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserDAO userDao;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Transactional
    @Override
    public Integer insertUser(User user) {
        System.out.println("сохранение юзера");
        userDao.insertUser(user);
        return user.getId();
    }

    @Transactional
    @Override
    public Integer deleteUserById(Integer id) {
        userDao.deleteUserById(id);
        return null;
    }

    @Transactional
    @Override
    public Integer updateUser(User user) {
        userDao.updateUser(user);
        return null;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {

        com.bonvio.staff.models.User user = userDao.findByUserName(username);

        System.out.println("user" + user + user.getUserRole().size());


        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }


        List<GrantedAuthority> authorities =
                buildUserAuthority(user.getUserRole());

        return buildUserForAuthentication(user, authorities);

    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(com.bonvio.staff.models.User user,
                                                                                          List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }
}
