package org.spring.interfaces;

import java.util.List;

public interface Crud<E, ID> {
    void save(E e);

    List<E> findAll();

    E findById(ID id);


    void remove(ID id);

    void update(E e);
}
