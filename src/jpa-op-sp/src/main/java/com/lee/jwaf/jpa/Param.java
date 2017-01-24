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

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.lee.jwaf.exception.DaoException;
import com.lee.util.StringUtils;

/**
 * ClassName : Param <br>
 * Description : parameter of JPA query <br>
 * Create Time : 2016-09-23 <br>
 * @author jimmyblylee@126.com
 */
@SuppressWarnings("unused")
public final class Param implements Serializable {

    private static final long serialVersionUID = -8649926204604667826L;

    /** The param name. */
    private String name;
    /** The param value. */
    private Object value;

    /**
     * Default constructor.
     * @param name the param name
     * @param value the param value
     */
    public Param(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Description : convert given params into list of {@link Param} <br>
     * Create Time: 2016-09-23 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param objs arrays formated by key, value, key, vlaue, key, value...
     * @return list of {@link Param}
     * @throws DaoException if the params are not dual, and keys are not String
     */
    public static List<Param> toList(Object... objs) throws DaoException {
        if (objs == null || objs.length == 0 || objs.length % 2 == 1) {
            final String msgCode = "ERR_JPA_SUPPORT_001/Param.IllegalArguments";
            final String errCode = msgCode.substring(0, msgCode.indexOf("/"));
            throw new DaoException(errCode, Msg.msg("jpa-support", msgCode, null));
        } else {
            final List<Param> params = new LinkedList<>();
            for (int i = 0; i < objs.length; i += 2) {
                final Object key = objs[i];
                if (!(key instanceof String) || StringUtils.isEmpty(key)) {
                    final String msgCode = "ERR_JPA_SUPPORT_001/Param.IllegalParamKeys";
                    final String errCode = msgCode.substring(0, msgCode.indexOf("/"));
                    throw new DaoException(errCode, Msg.msg("jpa-support", msgCode, null));
                }
                params.add(new Param((String) key, objs[i + 1]));
            }
            return params;
        }
    }

    @SuppressWarnings("WeakerAccess")
    public String getName() {
        return name;
    }

    @SuppressWarnings("WeakerAccess")
    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("WeakerAccess")
    public Object getValue() {
        return value;
    }

    @SuppressWarnings("WeakerAccess")
    public void setValue(Object value) {
        this.value = value;
    }
}
