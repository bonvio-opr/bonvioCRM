package com.bonvio.staff.dao.interfaces;

import com.bonvio.staff.dao.generic.interfaces.GenericDAO;
import com.bonvio.staff.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by igorjan on 09.02.16.
 * Banana
*/

public interface UserDAO extends GenericDAO<User> {
    User findByUserName(String username);
}
