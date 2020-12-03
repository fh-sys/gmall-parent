package com.atguigu.gmall.product.client;

import com.atguigu.gmall.bean.product.BaseCategoryView;
import com.atguigu.gmall.bean.product.SkuInfo;
import com.atguigu.gmall.bean.product.SpuSaleAttr;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ProductFeignClient
 * @Description: 商品服务远程调用接口
 * @Author Hao
 * @Date 2020/12/3 9:57
 * @Version V1.0
 **/
@FeignClient(name = "service-product")
public interface ProductFeignClient {


    @RequestMapping("api/product/getPrice/{skuId}")
    BigDecimal getPrice(@PathVariable("skuId") Long skuId);

    @RequestMapping("api/product/getSkuInfoById/{skuId}")
    SkuInfo getSkuInfoById(@PathVariable("skuId")Long skuId);

    @RequestMapping("api/product/getSpuSaleAttrListBySpuId/{spuId}")
    List<SpuSaleAttr> getSpuSaleAttrListBySpuId(@PathVariable("spuId")Long spuId);

    @RequestMapping("api/product/getCategoryViewByCategory3Id/{category3Id}")
    BaseCategoryView getCategoryViewByCategory3Id(@PathVariable("category3Id")Long category3Id);
}
