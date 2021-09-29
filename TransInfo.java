package com.ghina.Bank_Team2.entity.temp;

import java.util.Date;

public interface TransInfo {
    Date getTransDate();
    String getType();
    Long getAmount();
    Long getBalance();
    Integer getAccNumber();
    String getFullName();
}
