package com.zhxfun.controller;

import com.zhxfun.pojo.Item;
import com.zhxfun.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item/")
public class ItemController {

    @Autowired
    private ItemService itemService;

   @RequestMapping("getItemList")
   public List<Item> getItemList() throws InterruptedException {
       Thread.sleep(2000);
       return itemService.getItemList();
    }

}

