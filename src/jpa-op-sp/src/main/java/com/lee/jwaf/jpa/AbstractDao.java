/* ***************************************************************************
 * EZ.JWAF/EZ.JCWAP: Easy series Production.
 * Including JWAF(Java-based Web Application Framework)
 * and JCWAP(Java-based Customized Web Application Platform).
 * Copyright (C) 2016-2017 the original author or authors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of MIT License as published by
 * the Free Software Foundation;
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the MIT License for more details.
 *
 * You should have received a copy of the MIT License along
 * with this library; if not, write to the Free Software Foundation.
 * ***************************************************************************/

package com.lee.jwaf.jpa;

import static com.lee.jwaf.message.Messages.Msg;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lee.util.Assert;

/**
 * ClassName : AbstractDao <br>
 * Description : AbstractDao provides ormapping operation support <br>
 * Create Time : 2016-09-25 <br>
 * @author jimmyblylee@126.com
 */
@SuppressWarnings({"unused", "checkstyle:multiplestringliterals"})
public abstract class AbstractDao implements JpaOrmOperator, NamedQueryOperator {

    /**
     * @return the EntityManager.
     */
    abstract EntityManager em();

    /**
     * Create a named query.
     * @param queryName the name of the namedQuery
     * @param params params
     * @return the JPA Query
     */
    private Query createNamedQuery(String queryName, Object... params) {
        final Query query = em().createNamedQuery(queryName);
        if (params != null && params.length > 0) {
            int pos = 0;
            for (Object param : params) {
                query.setParameter(pos++, param);
            }
        }
        return query;
    }

    /**
     * Create a named query.
     * @param queryName the name of the named query
     * @param params params by list of type {@link Param}
     * @return the JPA Query
     */
    private Query createNamedQuery(String queryName, List<Param> params) {
        final Query query = em().createNamedQuery(queryName);
        if (params != null && params.size() > 0) {
            for (Param param : params) {
                query.setParameter(param.getName(), param.getValue());
            }
        }
        return query;
    }

    /*
     * (non-Javadoc)
     * @see com.lee.jwaf.jpa.NamedQueryOperator#queryByNamedQuery(java.lang.String, java.lang.Object[])
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> queryByNamedQuery(String queryName, Object... params) {
        Assert.hasText(queryName, Msg.msg("jpa-support", "ERR_JPA_SUPPORT_002/AbstractDao.queryNameEmpty", null));
        return createNamedQuery(queryName, params).getResultList();
    }

    /*
     * (non-Javadoc)
     * @see com.lee.jwaf.jpa.NamedQueryOperator#queryByNamedQuery(java.lang.String, java.util.List)
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> queryByNamedQuery(String queryName, List<Param> params) {
        Assert.hasText(queryName, Msg.msg("jpa-support", "ERR_JPA_SUPPORT_002/AbstractDao.queryNameEmpty", null));
        return createNamedQuery(queryName, params).getResultList();
    }

    /*
     * (non-Javadoc)
     * @see com.lee.jwaf.jpa.NamedQueryOperator#queryByNamedQuery(java.lang.String, java.lang.Integer,
     * java.lang.Integer, java.lang.Object[])
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> queryByNamedQuery(String queryName, Integer start, Integer limit, Object... params) {
        Assert.hasText(queryName, Msg.msg("jpa-support", "ERR_JPA_SUPPORT_002/AbstractDao.queryNameEmpty", null));
        Assert.isTrue(start > -1, Msg.msg("ERR_JPA_SUPPORT_002/AbstractDao.startShouldGreaterThanZero"));
        return createNamedQuery(queryName, params).setFirstResult(start)
                .setMaxResults(limit > 0 ? limit : Integer.MAX_VALUE).getResultList();
    }

    /*
     * (non-Javadoc)
     * @see com.lee.jwaf.jpa.NamedQueryOperator#queryByNamedQuery(java.lang.String, java.lang.Integer,
     * java.lang.Integer, java.util.List)
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> queryByNamedQuery(String queryName, Integer start, Integer limit, List<Param> params) {
        Assert.hasText(queryName, Msg.msg("jpa-support", "ERR_JPA_SUPPORT_002/AbstractDao.queryNameEmpty", null));
        Assert.isTrue(start > -1, Msg.msg("jpa-support",
            "ERR_JPA_SUPPORT_002/AbstractDao.startShouldGreaterThanZero", null));
        return createNamedQuery(queryName, params).setFirstResult(start)
                .setMaxResults(limit > 0 ? limit : Integer.MAX_VALUE).getResultList();
    }

    /*
     * (non-Javadoc)
     * @see com.lee.jwaf.jpa.NamedQueryOperator#getCountByNamedQuery(java.lang.String, java.lang.Object[])
     */
    @Override
    public Integer getCountByNamedQuery(String queryName, Object... params) {
        Assert.hasText(queryName, Msg.msg("jpa-support", "ERR_JPA_SUPPORT_002/AbstractDao.queryNameEmpty", null));
        return ((Number) getSingleResultByNamedQuery(queryName, params)).intValue();
    }

    /*
     * (non-Javadoc)
     * @see com.lee.jwaf.jpa.NamedQueryOperator#getCountByNamedQuery(java.lang.String, java.util.List)
     */
    @Override
    public Integer getCountByNamedQuery(String queryName, List<Param> params) {
        Assert.hasText(queryName, Msg.msg("jpa-support", "ERR_JPA_SUPPORT_002/AbstractDao.queryNameEmpty", null));
        return ((Number) getSingleResultByNamedQuery(queryName, params)).intValue();
    }

    /*
     * (non-Javadoc)
     * @see com.lee.jwaf.jpa.NamedQueryOperator#getSingleResultByNamedQuery(java.lang.String, java.lang.Object[])
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T getSingleResultByNamedQuery(String queryName, Object... params) {
        Assert.hasText(queryName, Msg.msg("jpa-support", "ERR_JPA_SUPPORT_002/AbstractDao.queryNameEmpty", null));
        return (T) createNamedQuery(queryName, params).getSingleResult();
    }

    /*
     * (non-Javadoc)
     * @see com.lee.jwaf.jpa.NamedQueryOperator#getSingleResultByNamedQuery(java.lang.String, java.util.List)
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T getSingleResultByNamedQuery(String queryName, List<Param> params) {
        Assert.hasText(queryName, Msg.msg("jpa-support", "ERR_JPA_SUPPORT_002/AbstractDao.queryNameEmpty", null));
        return (T) createNamedQuery(queryName, params).getSingleResult();
    }

    /*
     * (non-Javadoc)
     * @see com.lee.jwaf.jpa.NamedQueryOperator#executeByNamedQuery(java.lang.String, java.lang.Object[])
     */
    @Override
    public Integer executeByNamedQuery(String queryName, Object... params) {
        Assert.hasText(queryName, Msg.msg("jpa-support", "ERR_JPA_SUPPORT_002/AbstractDao.queryNameEmpty", null));
        return createNamedQuery(queryName, params).executeUpdate();
    }

    /*
     * (non-Javadoc)
     * @see com.lee.jwaf.jpa.NamedQueryOperator#executeByNamedQuery(java.lang.String, java.util.List)
     */
    @Override
    public Integer executeByNamedQuery(String queryName, List<Param> params) {
        Assert.hasText(queryName, Msg.msg("jpa-support", "ERR_JPA_SUPPORT_002/AbstractDao.queryNameEmpty", null));
        return createNamedQuery(queryName, params).executeUpdate();
    }

    /*
     * (non-Javadoc)
     * @see com.lee.jwaf.jpa.JpaOrmOperator#persist(java.lang.Object)
     */
    @Override
    public void persist(Object entity) {
        em().persist(entity);
    }

    /*
     * (non-Javadoc)
     * @see com.lee.jwaf.jpa.JpaOrmOperator#merge(java.lang.Object)
     */
    @Override
    public <T> T merge(T entity) {
        return em().merge(entity);
    }

    /*
     * (non-Javadoc)
     * @see com.lee.jwaf.jpa.JpaOrmOperator#remove(java.lang.Object)
     */
    @Override
    public void remove(Object entity) {
        em().remove(entity);
    }

    /*
     * (non-Javadoc)
     * @see com.lee.jwaf.jpa.JpaOrmOperator#find(java.lang.Class, java.lang.Object)
     */
    @Override
    public <T> T find(Class<T> entityClass, Object primaryKey) {
        Assert.notNull(entityClass, Msg.msg("jpa-support", "ERR_JPA_SUPPORT_002/AbstractDao.findClassEmpty", null));
        Assert.notNull(entityClass,
                Msg.msg("jpa-support", "ERR_JPA_SUPPORT_002/AbstractDao.findPrimaryKeyEmpty", null));
        return em().find(entityClass, primaryKey);
    }

    /*
     * (non-Javadoc)
     * @see com.lee.jwaf.jpa.JpaOrmOperator#contains(java.lang.Object)
     */
    @Override
    public boolean contains(Object entity) {
        return em().contains(entity);
    }

    /*
     * (non-Javadoc)
     * @see com.lee.jwaf.jpa.JpaOrmOperator#detach(java.lang.Object)
     */
    @Override
    public void detach(Object entity) {
        em().detach(entity);
    }

    /*
     * (non-Javadoc)
     * @see com.lee.jwaf.jpa.JpaOrmOperator#flush()
     */
    @Override
    public void flush() {
        em().flush();
    }

    /*
     * (non-Javadoc)
     * @see com.lee.jwaf.jpa.JpaOrmOperator#clear()
     */
    @Override
    public void clear() {
        em().clear();
    }

}
