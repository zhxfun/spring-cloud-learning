package com.zhxfun.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhxfun.client.ItemService;
import com.zhxfun.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@RestController
@RequestMapping("/user/")
public class UserController {

    private static final String ITEM_SERVICE_URL = "http://localhost:8080/item/getItemList";
    private static final String ITEM_SERVICE_URL2 = "http://ITEM-SERVICE/item/getItemList";

    @Autowired
    private ItemService itemClient;

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("restTemplate4Ribbon")
    private RestTemplate restTemplate4Ribbon;

    @RequestMapping("getItemList")
    public Object getItemList(){
        ResponseEntity<Result> re = restTemplate.getForEntity(ITEM_SERVICE_URL, Result.class);
        return re.getBody().getData();
    }

    @RequestMapping("getItemList2")
    @HystrixCommand(fallbackMethod = "fallback")
    public Object getItemList2(){
        ResponseEntity<Result> re = restTemplate4Ribbon.getForEntity(ITEM_SERVICE_URL2, Result.class);
        return re.getBody().getData();
    }

    public Object fallback(){
        return Collections.emptyList();
    }


    @RequestMapping("getItemList3")
    public Object getItemList3(){
        return itemClient.getItemList().getData();
    }
}
