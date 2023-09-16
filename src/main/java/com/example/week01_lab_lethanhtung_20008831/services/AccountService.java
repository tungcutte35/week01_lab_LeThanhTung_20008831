package com.example.week01_lab_lethanhtung_20008831.services;

import com.example.week01_lab_lethanhtung_20008831.models.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountService {
    int login(String username, String password) throws SQLException;
    boolean register(String username, String password, String email, String phone);

    List<Account> getAllAccount() throws SQLException;

    Account getAccountById(String id) throws SQLException;

    boolean editAccount(Account object);


    boolean createAccount(Account account);

    void deleteAccount(String accountId);
}