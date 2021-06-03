package com.example.demo.model.repo;

import com.example.demo.model.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    //find Item by Id
    Item findItemById(int id);
}


