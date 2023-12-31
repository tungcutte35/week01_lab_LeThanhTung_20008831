package com.example.week01_lab_lethanhtung_20008831.respositories;

import com.example.week01_lab_lethanhtung_20008831.models.Logs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LogRespository implements IFRespository<Logs> {
    private final String TABLE_NAME = "logs";
    private Connection connection;

    public LogRespository() throws Exception {
        connection = DBConnect.getInsance().getConn();
    }
    @Override
    public boolean insert(Logs object) throws SQLException {
        String sql = "INSERT " + TABLE_NAME + "\n" + "VALUES(?,?,?,?)";
        try (PreparedStatement ppsm = connection.prepareStatement(sql)) {
            ppsm.setString(1, object.getAcountId());
            ppsm.setString(2, object.getLogInDate());
            ppsm.setString(3, object.getLogOutDate());
            ppsm.setString(4, object.getNotes());
            int rowsAffected = ppsm.executeUpdate();
            return rowsAffected > 0;
        }
    }

    @Override
    public boolean update(String id, Logs object) {
        return false;
    }

    @Override
    public Logs getOne(String id) {
        return null;
    }

    @Override
    public List<Logs> getALL() throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}