package com.atguigu.gmall.item;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @ClassName ItemFeignClient
 * @Description: itemfeign远程调用
 * @Author Hao
 * @Date 2020/12/2 20:21
 * @Version V1.0
 **/
@FeignClient(name = "service-item")
public interface ItemFeignClient {

    /**
     * 获取详情页面信息
     * @param skuId
     * @return
     */
    @RequestMapping("api/item/{skuId}.html")
    Map<String, Object> getItemInfo(@PathVariable("skuId") Long skuId);
}
