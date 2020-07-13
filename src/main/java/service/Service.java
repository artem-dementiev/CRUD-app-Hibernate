package service;

import java.util.List;

public interface Service<T> {
    void create(T t);

    T get(long string);

    void update(T t);

    void delete(T t);

    List<T> getAll();

    boolean isExist(String login);
}
