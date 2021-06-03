package com.example.demo.model;

public class CoinBundle {
    public int numberOfV1CoinsToBeReturned;
    public int numberOfV2CoinsToBeReturned;
    public int numberOfv3CentsCoinsToBeReturned;
    public int numberOfV4CentsCoinsToBeReturned;

    public CoinBundle(int[] enteredCoins) {
        this.numberOfV1CoinsToBeReturned = enteredCoins[0];
        this.numberOfV2CoinsToBeReturned = enteredCoins[1];
        this.numberOfv3CentsCoinsToBeReturned = enteredCoins[2];
        this.numberOfV4CentsCoinsToBeReturned = enteredCoins[3];

    }

    public int getTotal(){
        int totalAmountToBeReturned = 0;
        totalAmountToBeReturned = totalAmountToBeReturned+this.numberOfV1CoinsToBeReturned* Coin.V1.getValue();
        totalAmountToBeReturned = totalAmountToBeReturned+this.numberOfV2CoinsToBeReturned*Coin.V2.getValue();
        totalAmountToBeReturned = totalAmountToBeReturned+this.numberOfv3CentsCoinsToBeReturned*Coin.V3.getValue();
        totalAmountToBeReturned = totalAmountToBeReturned+this.numberOfV4CentsCoinsToBeReturned*Coin.V4.getValue();

        return totalAmountToBeReturned;
    }
}
