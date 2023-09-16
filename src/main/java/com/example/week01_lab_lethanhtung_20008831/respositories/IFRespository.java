package com.example.week01_lab_lethanhtung_20008831.respositories;

import java.sql.SQLException;
import java.util.List;

public interface IFRespository<T> {
    boolean insert(T object) throws SQLException;
    boolean update(String id, T object);
    T getOne(String id);
    List<T> getALL() throws SQLException;
    boolean delete(String id);
}