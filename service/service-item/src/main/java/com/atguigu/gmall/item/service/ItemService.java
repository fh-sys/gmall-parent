package com.atguigu.gmall.item.service;

import java.util.Map;

/**
 * @ClassName ItemService
 * @Description: 商品详情接口
 * @Author Hao
 * @Date 2020/12/2 14:08
 * @Version V1.0
 **/
public interface ItemService {

    /**
     * 根据skuid查询商品详细信息，包括价格，分类，图片
     * @param skuId
     * @return
     */
    Map<String, Object> getItemInfo(Long skuId);
}
