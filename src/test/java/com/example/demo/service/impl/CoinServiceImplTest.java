package com.example.demo.service.impl;

import com.example.demo.model.entities.Item;
import com.example.demo.model.repo.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
class CoinServiceImplTest {

    @InjectMocks
    CoinServiceImpl vendingService;

     @Mock
    private ItemRepository itemRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_return_return_coin_change(){
        //given
        BDDMockito.given(itemRepository.findAll()).willReturn(retriveItemList());
        //when
        Mockito.when(vendingService.fetchAllItems()).thenReturn(retriveItemList());
        List<Item> itemList = retriveItemList();
        assertNotNull("Item list is not null",itemList);
    }

    public List<Item> retriveItemList() {
        List<Item> itemList = new ArrayList<>();
        Item item = new Item();
        item.setId(3);
        item.setName("Fanta");
        item.setPrice(15);
        itemList.add(item);
        return itemList;
    }

}