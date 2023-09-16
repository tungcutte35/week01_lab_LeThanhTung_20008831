package com.example.week01_lab_lethanhtung_20008831.services.impl;

import com.example.week01_lab_lethanhtung_20008831.models.GrantAccess;
import com.example.week01_lab_lethanhtung_20008831.respositories.GrantAccessRespository;
import com.example.week01_lab_lethanhtung_20008831.services.GrandAccessService;

import java.sql.SQLException;

public class GrandAccessServiceImpl implements GrandAccessService {
    private final GrantAccessRespository grantAccessRespository;

    public GrandAccessServiceImpl() throws Exception {
        grantAccessRespository = new GrantAccessRespository();
    }

    @Override
    public void insertGrandAccess(GrantAccess grantAccess) throws SQLException {
        grantAccessRespository.insert(grantAccess);
    }
}