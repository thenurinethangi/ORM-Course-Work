package com.example.ormcoursework.dao;

import com.example.ormcoursework.entity.Patient;

import java.util.List;

public interface CrudDAO<T> extends SuperDAO{

    String generateNewId();

    boolean delete(T t);

    List<T> getAll();

    boolean add(T t);

    boolean update(T t);

    T search(String id);
}
