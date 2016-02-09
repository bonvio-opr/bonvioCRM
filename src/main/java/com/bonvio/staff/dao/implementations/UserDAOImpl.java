package com.bonvio.staff.dao.implementations;

import com.bonvio.staff.dao.generic.implementations.GenericDAOImpl;
import com.bonvio.staff.model.User;
import org.springframework.stereotype.Repository;
import com.bonvio.staff.dao.interfaces.UserDAO;

/**
 * Created by igorjan on 09.02.16.
 * Banana
*/

@Repository

public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO {
    public User findByUserName(String username) {
        return entityManager.createQuery("select u from User u where login = :username", User.class).setParameter("username", username).getSingleResult();
    }
}
