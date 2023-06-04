package pbo_kerkel.model;

import java.util.List;

public interface DataDAO<T, E> {
    void doCreate(T t) throws java.sql.SQLException;

    List<T> doRetrieve() throws java.sql.SQLException;

    void doUpdate(T t) throws java.sql.SQLException;

    void doDelete(T t) throws java.sql.SQLException;

    T doGet(E e) throws java.sql.SQLException;
}
