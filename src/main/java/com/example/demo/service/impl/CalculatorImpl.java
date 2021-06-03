package com.example.demo.service.impl;

import com.example.demo.exceptions.InsufficientAmountToPurchaseItemException;
import com.example.demo.model.Coin;
import com.example.demo.model.CoinBundle;
import com.example.demo.service.Calculator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculatorImpl implements Calculator {

    @Override
    public int calculateTotal(CoinBundle enteredCoins) {
        //get total amount of coin bundle
        return enteredCoins.getTotal();
    }

    @Override
    public CoinBundle calculateChange(Integer amountMoneyToReturn) {

        //calculate change of coins
        CoinBundle change = new CoinBundle(new int[4]);
        int remainingAmount = amountMoneyToReturn;

        change.numberOfV4CentsCoinsToBeReturned = remainingAmount / Coin.V4.getValue();
        remainingAmount = remainingAmount % Coin.V4.getValue();

        change.numberOfv3CentsCoinsToBeReturned = remainingAmount / Coin.V3.getValue();
        remainingAmount = remainingAmount % Coin.V3.getValue();

        change.numberOfV2CoinsToBeReturned = remainingAmount / Coin.V2.getValue();
        remainingAmount = remainingAmount % Coin.V2.getValue();

        change.numberOfV1CoinsToBeReturned = remainingAmount / Coin.V1.getValue();
        remainingAmount = remainingAmount % Coin.V1.getValue();
        if (change.getTotal() < 0 ){
           throw new InsufficientAmountToPurchaseItemException("Insufficient amount to purchase the Item");
        }

        log.info("Calculated change [{}] ", change.getTotal());
        return change;
    }
}
