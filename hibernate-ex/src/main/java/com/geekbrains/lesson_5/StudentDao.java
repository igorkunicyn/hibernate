package com.geekbrains.lesson_5;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDao extends GenericDaoHibernateImpl<Student, Long> {

    public StudentDao(Class<Student> type) {
        super(type);
    }

    @Override
    public void save(Student o) {
        super.save(o);
    }

    @Override
    public Student read(Long id) {
        return super.read(id);
    }

    @Override
    public void update(Student o) {
        super.update(o);
    }

    @Override
    public void delete(Student o) {
        super.delete(o);
    }

    @Override
    protected SessionFactory getSessionFactory() {
        return new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).
                buildSessionFactory();
    }

}
