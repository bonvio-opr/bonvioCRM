//package com.bonvio.staff.dao.generic.implementations;
//
//import net.bonvio.dao.generic.interfaces.GenericDAOAuditable;
//import org.hibernate.envers.AuditReader;
//import org.hibernate.envers.AuditReaderFactory;
//import org.hibernate.envers.query.AuditEntity;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.Serializable;
//import java.lang.reflect.ParameterizedType;
//import java.util.List;
//
///**
// * Created by igorjan on 11.12.15.
// * banana
// */
//
//public abstract class GenericDAOAuditableImpl<T extends Serializable> extends GenericDAOImpl<T> implements GenericDAOAuditable<T> {
//
//    private Class<T> tClass;
//
//    @SuppressWarnings("unchecked")
//    public GenericDAOAuditableImpl() {
//        tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//    }
//
//    @Transactional
//    public List<T> getRevisionsById(Integer id) {
//        AuditReader reader = AuditReaderFactory.get(entityManager);
//        List<T> requireList = reader.createQuery().forRevisionsOfEntity(tClass, true, true).add(AuditEntity.id().eq(id))
//                .addOrder(AuditEntity.revisionNumber().asc()).getResultList();
//        return requireList;
//    }
//}
