package com.mock.ecommerce.repo;

import java.util.List;

public interface DAO<T>{
    List<T> findALl();
    T findById(Long id);
    void save(T vo);
    void delete(Long id);
}
