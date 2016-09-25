/**
 * Project Name : jwaf-jpa-op-sp <br>
 * File Name : Param.java <br>
 * Package Name : com.lee.jwaf.jpa <br>
 * Create Time : 2016-09-23 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.jwaf.jpa;

import static com.lee.jwaf.message.Messages.Msg;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.lee.jwaf.exception.DaoException;
import com.lee.util.StringUtils;

/**
 * ClassName : Param <br>
 * Description : parameter of JPA query <br>
 * Create Time : 2016-09-23 <br>
 * Create by : jimmyblylee@126.com
 */
public class Param implements Serializable {

    private static final long serialVersionUID = -8649926204604667826L;

    private String name;
    private Object value;

    public Param(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Description : convert given params into list of {@link Parameter} <br>
     * Create Time: 2016-09-23 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param objs arrays formated by key, value, key, vlaue, key, value...
     * @return list of {@link Param}
     * @throws DaoException if the params are not dual, and keys are not String
     */
    public static List<Param> toList(Object... objs) throws DaoException {
        if (objs == null || objs.length == 0 || objs.length % 2 == 1) {
            String msgCode = "ERR_JPA_SUPPORT_001/Param.InlegalAruguments";
            String errCode = msgCode.substring(0, msgCode.indexOf("/"));
            throw new DaoException(errCode, Msg.msg("jpa-support", msgCode, null));
        } else {
            List<Param> params = new LinkedList<>();
            for (int i = 0; i < objs.length; i += 2) {
                Object key = objs[i];
                if (!(key instanceof String) && StringUtils.isEmpty(key)) {
                    String msgCode = "ERR_JPA_SUPPORT_001/Param.IllegalParamKeys";
                    String errCode = msgCode.substring(0, msgCode.indexOf("/"));
                    throw new DaoException(errCode, Msg.msg("jpa-support", msgCode, null));
                }
                params.add(new Param((String) key, objs[i + 1]));
            }
            return params;
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }
}
