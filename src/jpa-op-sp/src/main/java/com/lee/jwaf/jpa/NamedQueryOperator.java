/**
 * Project Name : jwaf-jpa-op-sp <br>
 * File Name : NamedQueryOperator.java <br>
 * Package Name : com.lee.jwaf.jpa <br>
 * Create Time : 2016-09-25 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.jwaf.jpa;

import java.util.List;

import javax.persistence.LockTimeoutException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.persistence.PessimisticLockException;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TransactionRequiredException;

/**
 * ClassName : NamedQueryOperator <br>
 * Description : Named query operator <br>
 * Create Time : 2016-09-25 <br>
 * Create by : jimmyblylee@126.com
 */
public interface NamedQueryOperator {

    /**
     * Description : query list by given named query <br>
     * Create Time: 2016-09-25 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param <T> target class
     * @param queryName the query name
     * @param params the ordered parameter, these parameters will be put into the query one by one in number order.
     * @return a list of the results
     *
     * @throws ClassCastException if the result is not the given type
     * @throws IllegalStateException if called for a Java Persistence query language UPDATE or DELETE statement
     * @throws QueryTimeoutException if the query execution exceeds the query timeout value set and only the statement
     *             is rolled back
     * @throws TransactionRequiredException if a lock mode has been set and there is no transaction
     * @throws PessimisticLockException if pessimistic locking fails and the transaction is rolled back
     * @throws LockTimeoutException if pessimistic locking fails and only the statement is rolled back
     * @throws PersistenceException if the query execution exceeds the query timeout value set and the transaction is
     *             rolled back
     */
    public <T> List<T> queryByNamedQuery(String queryName, Object... params);

    /**
     * Description : query list by given named query <br>
     * Create Time: 2016-09-25 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param <T> target Class
     * @param queryName name of namedQuery
     * @param params {@link Param} list, and this will be set as the parameters into the query
     * @return a list of the results
     *
     * @throws ClassCastException if the result is not the given type
     * @throws IllegalStateException if called for a Java Persistence query language UPDATE or DELETE statement
     * @throws QueryTimeoutException if the query execution exceeds the query timeout value set and only the statement
     *             is rolled back
     * @throws TransactionRequiredException if a lock mode has been set and there is no transaction
     * @throws PessimisticLockException if pessimistic locking fails and the transaction is rolled back
     * @throws LockTimeoutException if pessimistic locking fails and only the statement is rolled back
     * @throws PersistenceException if the query execution exceeds the query timeout value set and the transaction is
     *             rolled back
     */
    public <T> List<T> queryByNamedQuery(String queryName, List<Param> params);

    /**
     * Description : query list with given named query by page <br>
     * Create Time: 2016-09-25 <br>
     * Create by : jimmyblylee@126.com <br>
     * 
     * @param <T> target class
     * @param queryName name of namedQuery
     * @param start page start
     * @param limit if limit &lt; 0 then will set it with {@link Integer#MAX_VALUE}
     * @param params the ordered parameter, these parameters will be put into the query one by one in number order.
     * @return a list of the results
     *
     * @throws ClassCastException if the result is not the given type
     * @throws IllegalArgumentException start &lt; 0
     * @throws IllegalStateException if called for a Java Persistence query language UPDATE or DELETE statement
     * @throws QueryTimeoutException if the query execution exceeds the query timeout value set and only the statement
     *             is rolled back
     * @throws TransactionRequiredException if a lock mode has been set and there is no transaction
     * @throws PessimisticLockException if pessimistic locking fails and the transaction is rolled back
     * @throws LockTimeoutException if pessimistic locking fails and only the statement is rolled back
     * @throws PersistenceException if the query execution exceeds the query timeout value set and the transaction is
     *             rolled back
     */
    public <T> List<T> queryByNamedQuery(String queryName, Integer start, Integer limit, Object... params);

    /**
     * Description : query list with given named query by page <br>
     * Create Time: 2016-09-25 <br>
     * Create by : jimmyblylee@126.com <br>
     * 
     * @param <T> target class
     * @param queryName query name
     * @param start paging start
     * @param limit if limit &lt; 0 then will set it with {@link Integer#MAX_VALUE}
     * @param params {@link Param} list, and this will be set as the parameters into the query
     * @return a list of the results
     *
     * @throws ClassCastException if the result is not the given type
     * @throws IllegalArgumentException start &lt; 0
     * @throws IllegalStateException if called for a Java Persistence query language UPDATE or DELETE statement
     * @throws QueryTimeoutException if the query execution exceeds the query timeout value set and only the statement
     *             is rolled back
     * @throws TransactionRequiredException if a lock mode has been set and there is no transaction
     * @throws PessimisticLockException if pessimistic locking fails and the transaction is rolled back
     * @throws LockTimeoutException if pessimistic locking fails and only the statement is rolled back
     * @throws PersistenceException if the query execution exceeds the query timeout value set and the transaction is
     *             rolled back
     */
    public <T> List<T> queryByNamedQuery(String queryName, Integer start, Integer limit, List<Param> params);

    /**
     * Description : get count by a counting sql defined by named query <br>
     * Create Time: 2016-09-25 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param queryName name of namedQuery
     * @param params the ordered parameter, these parameters will be put into the query one by one in number order.
     * @return the result
     *
     * @throws NoResultException if there is no result
     * @throws NonUniqueResultException if more than one result
     * @throws IllegalStateException if called for a Java Persistence query language UPDATE or DELETE statement
     * @throws QueryTimeoutException if the query execution exceeds the query timeout value set and only the statement
     *             is rolled back
     * @throws TransactionRequiredException if a lock mode has been set and there is no transaction
     * @throws PessimisticLockException if pessimistic locking fails and the transaction is rolled back
     * @throws LockTimeoutException if pessimistic locking fails and only the statement is rolled back
     * @throws PersistenceException if the query execution exceeds the query timeout value set and the transaction is
     *             rolled back
     */
    public Integer getCountByNamedQuery(String queryName, Object... params);

    /**
     * Description : get count by a counting sql defined by named query <br>
     * Create Time: 2016-09-25 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param queryName name of namedQuery
     * @param params {@link Param} list, and this will be set as the parameters into the query
     * @return the result
     *
     * @throws NoResultException if there is no result
     * @throws NonUniqueResultException if more than one result
     * @throws IllegalStateException if called for a Java Persistence query language UPDATE or DELETE statement
     * @throws QueryTimeoutException if the query execution exceeds the query timeout value set and only the statement
     *             is rolled back
     * @throws TransactionRequiredException if a lock mode has been set and there is no transaction
     * @throws PessimisticLockException if pessimistic locking fails and the transaction is rolled back
     * @throws LockTimeoutException if pessimistic locking fails and only the statement is rolled back
     * @throws PersistenceException if the query execution exceeds the query timeout value set and the transaction is
     *             rolled back
     */
    public Integer getCountByNamedQuery(String queryName, List<Param> params);

    /**
     * Description : get sigle result by given named sql <br>
     * Create Time: 2016-09-25 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param <T> the target type you want
     * @param queryName name of namedQuery
     * @param params the ordered parameter, these parameters will be put into the query one by one in number order.
     * @return the result
     *
     * @throws ClassCastException if the result is not the given type
     * @throws NoResultException if there is no result
     * @throws NonUniqueResultException if more than one result
     * @throws IllegalStateException if called for a Java Persistence query language UPDATE or DELETE statement
     * @throws QueryTimeoutException if the query execution exceeds the query timeout value set and only the statement
     *             is rolled back
     * @throws TransactionRequiredException if a lock mode has been set and there is no transaction
     * @throws PessimisticLockException if pessimistic locking fails and the transaction is rolled back
     * @throws LockTimeoutException if pessimistic locking fails and only the statement is rolled back
     * @throws PersistenceException if the query execution exceeds the query timeout value set and the transaction is
     *             rolled back
     */
    public <T> T getSingleResultByNamedQuery(String queryName, Object... params);

    /**
     * Description : get sigle result by given named sql <br>
     * Create Time: 2016-09-25 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param <T> the target type you want
     * @param queryName name of namedQuery
     * @param params {@link Param} list, and this will be set as the parameters into the query
     * @return the result
     *
     * @throws ClassCastException if the result is not the given type
     * @throws NoResultException if there is no result
     * @throws NonUniqueResultException if more than one result
     * @throws IllegalStateException if called for a Java Persistence query language UPDATE or DELETE statement
     * @throws QueryTimeoutException if the query execution exceeds the query timeout value set and only the statement
     *             is rolled back
     * @throws TransactionRequiredException if a lock mode has been set and there is no transaction
     * @throws PessimisticLockException if pessimistic locking fails and the transaction is rolled back
     * @throws LockTimeoutException if pessimistic locking fails and only the statement is rolled back
     * @throws PersistenceException if the query execution exceeds the query timeout value set and the transaction is
     *             rolled back
     */
    public <T> T getSingleResultByNamedQuery(String queryName, List<Param> params);

    /**
     * Description : Execute an update or delete statement. by named query <br>
     * Create Time: 2016-09-25 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param queryName name of namedQuery
     * @param params the ordered parameter, these parameters will be put into the query one by one in number order.
     * @return the number of entities updated or deleted
     *
     * @throws IllegalStateException if called for a Java Persistence query language SELECT statement or for a criteria
     *             query
     * @throws TransactionRequiredException if there is no transaction
     * @throws QueryTimeoutException if the statement execution exceeds the query timeout value set and only the
     *             statement is rolled back
     * @throws PersistenceException if the query execution exceeds the query timeout value set and the transaction is
     *             rolled back
     */
    public Integer executeByNamedQuery(String queryName, Object... params);

    /**
     * Description : Execute an update or delete statement. by named query <br>
     * Create Time: 2016-09-25 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param queryName name of namedQuery
     * @param params {@link Param} list, and this will be set as the parameters into the query
     * @return the number of entities updated or deleted
     *
     * @throws IllegalStateException if called for a Java Persistence query language SELECT statement or for a criteria
     *             query
     * @throws TransactionRequiredException if there is no transaction
     * @throws QueryTimeoutException if the statement execution exceeds the query timeout value set and only the
     *             statement is rolled back
     * @throws PersistenceException if the query execution exceeds the query timeout value set and the transaction is
     *             rolled back
     */
    public Integer executeByNamedQuery(String queryName, List<Param> params);
}
