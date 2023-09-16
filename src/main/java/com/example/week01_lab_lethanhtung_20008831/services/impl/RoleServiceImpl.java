package com.example.week01_lab_lethanhtung_20008831.services.impl;

import com.example.week01_lab_lethanhtung_20008831.models.Role;
import com.example.week01_lab_lethanhtung_20008831.respositories.RoleRepository;
import com.example.week01_lab_lethanhtung_20008831.services.RoleService;

import java.sql.SQLException;
import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRespository;

    public RoleServiceImpl() throws Exception {
        roleRespository = new RoleRepository();
    }



    @Override
    public List<Role> getAllRole() throws SQLException {
        return roleRespository.getALL();
    }
}