package com.example.demo.controller;

import com.example.demo.exceptions.ItemAndNumbeOfCoinsException;
import com.example.demo.model.CoinBundle;
import com.example.demo.model.entities.Item;
import com.example.demo.service.CoinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coinDispenser")
@Slf4j
public class CoinController {

    @Autowired
    private final CoinService coinService;

    @Autowired
    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    //retrieves a list of items on sale
        @RequestMapping(value = "/displayProducts/", method = RequestMethod.GET)
    public List<Item> getItems(){
        List<Item> itemList = coinService.fetchAllItems();
        log.info("Item List [{}]",itemList);
        return itemList;
    }

    //select the type of product and get change
    @RequestMapping(value = "/selectProduct-change/", method = RequestMethod.GET)
    public CoinBundle selectProductsAndGetChange(@RequestParam() int selectedProduct,
                                                 @RequestParam() int[] numberOfCoins){
        CoinBundle numberOfCoinsResponse = null;
        try {
            numberOfCoinsResponse = coinService.calculateChange(selectedProduct,numberOfCoins);
        } catch (ItemAndNumbeOfCoinsException e) {
            e.printStackTrace();
        }
        log.info(" numberOfCoinsResponse [{}]",numberOfCoinsResponse.getTotal());
        return numberOfCoinsResponse;
    }

}
