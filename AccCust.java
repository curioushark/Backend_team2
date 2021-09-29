package com.ghina.Bank_Team2.entity.temp;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class AccCust {

    private String id;

    private int nik;

    private String fullName;

    private String email;

    private String address;

    private int accNumber;

    private int pin;

    private Long balance;

    private String accId;

    private Long amount;

    private String toFrom;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @Temporal(TemporalType.DATE)
    private Date date;

    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNik() {
        return nik;
    }

    public void setNik(int nik) {
        this.nik = nik;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getToFrom() {
        return toFrom;
    }

    public void setToFrom(String toFrom) {
        this.toFrom = toFrom;
    }

}
