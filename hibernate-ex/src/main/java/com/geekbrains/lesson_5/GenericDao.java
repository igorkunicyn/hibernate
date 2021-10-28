package com.geekbrains.lesson_5;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <T, PK extends Serializable> {

    void save(T newInstance);

    T read(PK id);

    void update(T transientObject);

    void delete(T persistenceObject);

    List<T> findAll();
}
