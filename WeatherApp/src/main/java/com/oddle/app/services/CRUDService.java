package com.oddle.app.services;

import java.util.List;

public interface CRUDService<T> {
    List<?> listAll(String city);

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}

