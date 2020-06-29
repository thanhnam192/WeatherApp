package com.weather.app.services;

import java.util.List;

public interface CRUDService<T> {
    List<T> listAll(String city);

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}

