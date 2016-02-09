package com.bonvio.staff.service.implementations;

import com.bonvio.staff.dao.interfaces.UserDAO;
import com.bonvio.staff.model.UserRole;
import com.bonvio.staff.service.generic.implementations.GenericServiceImpl;
import com.bonvio.staff.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.bonvio.staff.service.interfaces.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by igorjan on 09.02.16.
 * Banana
*/

@Service("userDetailsService")
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService, UserDetailsService {
    @Autowired
    UserDAO userDAO;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {
        com.bonvio.staff.model.User user = userDAO.findByUserName(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
        return buildUserForAuthentication(user, authorities);

    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(com.bonvio.staff.model.User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
        Set<GrantedAuthority> setAuths = new HashSet<>();
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        return new ArrayList<>(setAuths);
    }
}
