package com.bonvio.staff.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Created by mil on 07.07.15.
 */
public class HibernateAwareObjectMapper extends ObjectMapper{

    public HibernateAwareObjectMapper() {
        registerModule(new Hibernate4Module());
    }

}
