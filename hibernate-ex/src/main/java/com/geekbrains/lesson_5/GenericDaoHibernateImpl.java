package com.geekbrains.lesson_5;

import java.io.Serializable;

public class GenericDaoHibernateImpl <T, PK extends Serializable>
    implements GenericDao<T, PK extends Serializable>{

    private Class<T> type;

    public GenericDaoHibernateImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public PK create(T o) {
        return (PK) getSession.save(o);
    }

    @Override
    public T read(PK id) {
        return (T)  getSession.getType(type, id);
    }

    @Override
    public void update(T o) {
        getSession.update(o);
    }

    @Override
    public void delete(T o) {
        getSession.delete(o);
    }
}
