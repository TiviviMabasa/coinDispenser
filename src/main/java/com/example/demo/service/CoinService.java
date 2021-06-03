package com.example.demo.service;

import com.example.demo.exceptions.ItemAndNumbeOfCoinsException;
import com.example.demo.model.CoinBundle;
import com.example.demo.model.entities.Item;

import java.util.List;

public interface CoinService {
    List<Item> fetchAllItems();
    CoinBundle calculateChange(int product, int[] numberOfCoins) throws ItemAndNumbeOfCoinsException;
}
