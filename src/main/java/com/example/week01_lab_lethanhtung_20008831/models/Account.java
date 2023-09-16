package com.example.week01_lab_lethanhtung_20008831.models;


public class Account {
    private String accountId;
    private String fullName;
    private String password;
    private String email;
    private String phone;
    private STATUS status;

    public Account() {
        this.accountId = "no account";
    }


    public Account(String accountId, String fullName, String password, String email, String phone, STATUS status) {
        this.accountId = accountId;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }


    public String getAccountId() {
        return accountId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getStatus() {
        return status.getValue();
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStatus(int status) {
        this.status = STATUS.values()[status];
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }


}