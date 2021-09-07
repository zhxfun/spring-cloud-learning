package com.zhxfun.client;

import com.zhxfun.pojo.Result;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceFallback implements ItemService{
    @Override
    public Result getItemList() {
        return Result.failed("服务降级");
    }
}
