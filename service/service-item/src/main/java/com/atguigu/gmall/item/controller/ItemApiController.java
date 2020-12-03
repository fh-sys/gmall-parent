package com.atguigu.gmall.item.controller;

import com.atguigu.gmall.item.service.ItemService;
import com.atguigu.gmall.product.client.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName ItemApiController
 * @Description: 商品详情服务控制器
 * @Author Hao
 * @Date 2020/12/3 9:51
 * @Version V1.0
 **/
@RestController
public class ItemApiController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("api/item/{skuId}.html")
    Map<String, Object> getItemInfo(@PathVariable("skuId") Long skuId){
        Map<String, Object> map = itemService.getItemInfo(skuId);
        return map;
    }
}
