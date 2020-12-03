package com.atguigu.gmall.item.service.impl;

import com.atguigu.gmall.bean.product.BaseCategoryView;
import com.atguigu.gmall.bean.product.SkuInfo;
import com.atguigu.gmall.bean.product.SpuSaleAttr;
import com.atguigu.gmall.item.service.ItemService;
import com.atguigu.gmall.product.client.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ItemServiceImpl
 * @Description:
 * @Author Hao
 * @Date 2020/12/2 14:14
 * @Version V1.0
 **/
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ProductFeignClient productFeignClient;

    @Override
    public Map<String, Object> getItemInfo(Long skuId) {
        Map<String, Object> map = new HashMap<>();
        //调用商品服务获取商品信息
        SkuInfo skuInfo =productFeignClient.getSkuInfoById(skuId);
        //调用商品服务获取价格
        BigDecimal bigDecimal =  productFeignClient.getPrice(skuId);
        //调用商品服务获取分类信息
        BaseCategoryView baseCategoryView = productFeignClient.getCategoryViewByCategory3Id(skuInfo.getCategory3Id());
        //调用商品服务获取商品销售属性信息，销售属性列表在spu中
        List<SpuSaleAttr> spuSaleAttrList =productFeignClient.getSpuSaleAttrListBySpuId(skuInfo.getSpuId());
        map.put("skuInfo",skuInfo);
        map.put("price",bigDecimal);
        map.put("categoryView",baseCategoryView);
        map.put("spuSaleAttrList",spuSaleAttrList);

        return map;
    }
}
