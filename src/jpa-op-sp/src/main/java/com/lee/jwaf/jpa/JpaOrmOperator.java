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

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

/**
 * ClassName : JpaOrmOperator <br>
 * Description : JPA OR-Mapping entities operator <br>
 * Create Time : 2016-09-25 <br>
 * @author jimmyblylee@126.com
 */
@SuppressWarnings("unused")
public interface JpaOrmOperator {

    /**
     * Description : Make an instance managed and persistent. <br>
     * Create Time: 2016-09-25 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param entity entity instance
     * @throws EntityExistsException if the entity already exists. (If the entity already exists, the
     *             <code>EntityExistsException</code> may be thrown when the persist operation is invoked, or the
     *             <code>EntityExistsException</code> or another <code>PersistenceException</code> may be thrown at
     *             flush or commit time.)
     * @throws IllegalArgumentException if the instance is not an entity
     * @throws TransactionRequiredException if invoked on a container-managed entity manager of type
     *             <code>PersistenceContextType.TRANSACTION</code> and there is no transaction
     */
    void persist(Object entity);

    /**
     * Description : Merge the state of the given entity into the current persistence context. <br>
     * Create Time: 2016-09-25 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param <T> target class
     * @param entity entity instance
     * @return the managed instance that the state was merged to
     * @throws IllegalArgumentException if instance is not an entity or is a removed entity
     * @throws TransactionRequiredException if invoked on a container-managed entity manager of type
     *             <code>PersistenceContextType.TRANSACTION</code> and there is no transaction
     */
    <T> T merge(T entity);

    /**
     * Description : Remove the entity instance. <br>
     * Create Time: 2016-09-25 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param entity entity instance
     * @throws IllegalArgumentException if the instance is not an entity or is a detached entity
     * @throws TransactionRequiredException if invoked on a container-managed entity manager of type
     *             <code>PersistenceContextType.TRANSACTION</code> and there is no transaction
     */
    void remove(Object entity);

    /**
     * Description : Find by primary key. Search for an entity of the specified class and primary key. If the entity
     * instance is contained in the persistence context, it is returned from there. <br>
     * Create Time: 2016-09-25 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param <T> target class
     * @param entityClass entity class
     * @param primaryKey primary key
     * @return the found entity instance or null if the entity does not exist
     * @throws IllegalArgumentException if the entityClass or the primaryKey is null
     */
    <T> T find(Class<T> entityClass, Object primaryKey);

    /**
     * Description : Check if the instance is a managed entity instance belonging to the current persistence context.
     * <br>
     * Create Time: 2016-09-25 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param entity entity instance
     * @return boolean indicating if entity is in persistence context
     * @throws IllegalArgumentException if not an entity
     */
    boolean contains(Object entity);

    /**
     * Description : Remove the given entity from the persistence context, causing a managed entity to become detached.
     * Unflushed changes made to the entity if any (including removal of the entity), will not be synchronized to the
     * database. Entities which previously referenced the detached entity will continue to reference it. <br>
     * Create Time: 2016-09-25 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param entity entity instance
     * @throws IllegalArgumentException if the instance is not an entity
     * @since Java Persistence 2.0
     */
    void detach(Object entity);

    /**
     * Description : Synchronize the persistence context to the underlying database. <br>
     * Create Time: 2016-09-25 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @throws TransactionRequiredException if there is no transaction
     * @throws PersistenceException if the flush fails
     */
    void flush();

    /**
     * Description : Clear the persistence context, causing all managed entities to become detached. Changes made to
     * entities that have not been flushed to the database will not be persisted. <br>
     * Create Time: 2016-09-25 <br>
     * Create by : jimmyblylee@126.com <br>
     */
    void clear();
}
