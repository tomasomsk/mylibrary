package my.library.dao;

import org.hibernate.Session;

import java.util.List;

public interface GenericDAO<T> {

    List<T> findAll();

    T findById(Long id);

    void create(T entity);

    T update(T entity);

    void delete(T entity);

    Session getCurrentSession();

    T findByName(String name);

}