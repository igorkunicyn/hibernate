package com.geekbrains.lesson_5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDaoHibernateImpl<T, PK extends Serializable>
        implements GenericDao<T, PK> {


    private final Class<T> type;
    private final SessionFactory sessionFactory;
    private Session session;

    public GenericDaoHibernateImpl(Class<T> type) {
        this.type = type;
        sessionFactory = getSessionFactory();
        session = null;
    }
    @Override
    public void save(T object) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public T read(PK id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        T object = session.get(type, id);
        session.getTransaction().commit();
        return object;
    }

    @Override
    public void update(T o) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
    }

    @Override
    public void delete(T o) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
    }

    @Override
    public List<T> findAll() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<T> list = new ArrayList<>(session.createQuery("from " + type.getSimpleName()).getResultList());
        session.getTransaction().commit();
        return list;
    }

    protected abstract SessionFactory getSessionFactory();

}
