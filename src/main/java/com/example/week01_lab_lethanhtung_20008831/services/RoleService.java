package com.example.week01_lab_lethanhtung_20008831.services;


import com.example.week01_lab_lethanhtung_20008831.models.Role;

import java.sql.SQLException;
import java.util.List;

public interface RoleService {
    List<Role> getAllRole() throws SQLException;
}