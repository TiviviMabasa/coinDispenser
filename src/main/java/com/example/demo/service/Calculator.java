package com.example.demo.service;

import com.example.demo.model.CoinBundle;

public interface Calculator {
    int calculateTotal(CoinBundle enteredCoins);
    CoinBundle calculateChange(Integer amountMoneyToReturn);
}
