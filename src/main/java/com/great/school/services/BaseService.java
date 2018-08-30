package com.great.school.services;

import java.util.List;

/**
 * Created by Kibet on 25-Nov-17.
 */
public interface BaseService<T> {

    public T add(T t);

    public void delete(long id);

    public T update(T t);

    public T getById(long id);

    public List<T> all();
}