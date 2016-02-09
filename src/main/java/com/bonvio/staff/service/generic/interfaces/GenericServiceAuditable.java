package com.bonvio.staff.service.generic.interfaces;

import java.io.Serializable;
import java.util.List;

/**
 * Created by igorjan on 01.02.16.
 */
public interface GenericServiceAuditable<T extends Serializable> {
    List<T> getRevisionsById(Integer id);
}
