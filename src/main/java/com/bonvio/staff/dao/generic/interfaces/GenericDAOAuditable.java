package com.bonvio.staff.dao.generic.interfaces;

import java.util.List;

/**
 * Created by igorjan on 11.12.15.
 */
public interface GenericDAOAuditable<T> extends GenericDAO<T> {
    List<T> getRevisionsById(Integer id);
}
