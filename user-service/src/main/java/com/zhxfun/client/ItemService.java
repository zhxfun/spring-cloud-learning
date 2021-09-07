package com.zhxfun.client;

import com.zhxfun.pojo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "ITEM-SERVICE",fallback = ItemServiceFallback.class)
public interface ItemService {

    @RequestMapping(value = "/item/getItemList")
     Result getItemList();
}
