package dao;

import java.util.List;

public interface EntityDao<T> {
    void add(T t);

    void update(T t);

    T find(long string);

    List<T> findAll();

    void delete(T t);

    boolean isExist(String login);
}
