package com.example.week01_lab_lethanhtung_20008831.services.impl;

import com.example.week01_lab_lethanhtung_20008831.models.Account;
import com.example.week01_lab_lethanhtung_20008831.respositories.AccountRespository;
import com.example.week01_lab_lethanhtung_20008831.services.AccountService;

import java.sql.SQLException;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private final AccountRespository accountRespository;

    public AccountServiceImpl() throws Exception {
        accountRespository = new AccountRespository();
    }
    @Override
    public int login(String username, String password) throws SQLException {
        return accountRespository.login(username, password);
    }

    @Override
    public boolean register(String username, String password, String email, String phone) {
        return false;
    }

    @Override
    public List<Account> getAllAccount() throws SQLException {
        return accountRespository.getALL();
    }

    @Override
    public Account getAccountById(String id) throws SQLException {
        return accountRespository.getOne(id);
    }

    @Override
    public boolean editAccount(Account object) {
        return accountRespository.update(object.getAccountId(), object);
    }

    @Override
    public boolean createAccount(Account account) {
        return accountRespository.insert(account);
    }

    @Override
    public void deleteAccount(String accountId) {
        accountRespository.delete(accountId);
    }


}