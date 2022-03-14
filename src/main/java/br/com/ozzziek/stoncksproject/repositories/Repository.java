package br.com.ozzziek.stoncksproject.repositories;

import java.util.List;

public interface Repository<T> {
    Long insert(T obj);
    T findById(Long id);
    List<T> list(String parameters);
    void update(Long id, T obj);
    void remove(Long id);
}
