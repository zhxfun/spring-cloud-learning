package com.zhxfun.service.impl;

import com.zhxfun.mapper.ItemMapper;
import com.zhxfun.pojo.Item;
import com.zhxfun.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;

    @Autowired
    public ItemServiceImpl(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public List<Item> getItemList() {
        return itemMapper.selectByExampleWithBLOBs(null);
    }
}
