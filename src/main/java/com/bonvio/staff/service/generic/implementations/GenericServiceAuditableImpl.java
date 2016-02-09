package com.bonvio.staff.service.generic.implementations;

import com.bonvio.staff.dao.generic.interfaces.GenericDAOAuditable;
import com.bonvio.staff.service.generic.interfaces.GenericServiceAuditable;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by igorjan on 01.02.16.
 */
public class GenericServiceAuditableImpl<T extends Serializable> extends GenericServiceImpl<T> implements GenericServiceAuditable<T> {
    @Autowired
    public GenericDAOAuditable<T> tGenericDAOAuditable;

    public List<T> getRevisionsById(Integer id) {
        return tGenericDAOAuditable.getRevisionsById(id);
    }
}
