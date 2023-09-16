package com.example.week01_lab_lethanhtung_20008831.services;

import com.example.week01_lab_lethanhtung_20008831.models.GrantAccess;

import java.sql.SQLException;

public interface GrandAccessService {
    void insertGrandAccess(GrantAccess grantAccess) throws SQLException;

}