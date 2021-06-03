package com.example.demo.service.impl;

import com.example.demo.exceptions.ItemNotFoundException;
import com.example.demo.model.CoinBundle;
import com.example.demo.model.entities.Item;
import com.example.demo.model.repo.ItemRepository;
import com.example.demo.service.Calculator;
import com.example.demo.service.CoinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CoinServiceImpl implements CoinService {

    @Autowired
    ItemRepository itemRepository;

    private Calculator calculator = new CalculatorImpl();
    

    @Override
    public List<Item> fetchAllItems() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public CoinBundle calculateChange(int product, int[] numberOfCoins) {
        //get the item price from the database
        Item item = itemRepository.findItemById(product);
        log.info("Our Item from the database [{}] ", item);
        if (item == null){
            throw new ItemNotFoundException("Item selected is not found");
        }
        double amount = item.getPrice();

        //calculate the number of coins needed to be returned
       CoinBundle coinBundle = enterCoins(numberOfCoins,amount);

         return coinBundle;
    }

    private CoinBundle enterCoins(int[] coins,double amount) {

        log.info("Trying to invoke the calculator service");
        //get the total amount
        CoinBundle enteredCoins = new CoinBundle(coins);
        enteredCoins.getTotal();

        Integer total = calculator.calculateTotal(enteredCoins);
        double totalChange = total - amount;

        Integer intValue = (int) totalChange;
        CoinBundle coinBundle = calculator.calculateChange(intValue);

        log.info("Our calculated coin bundle is [{}] ", coinBundle.getTotal());
        return coinBundle;


    }
}
