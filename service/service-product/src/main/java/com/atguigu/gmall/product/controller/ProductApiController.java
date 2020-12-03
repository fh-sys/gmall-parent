package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.bean.product.*;
import com.atguigu.gmall.product.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName ProductApiController
 * @Description: 商品服务对内提供服务接口
 * @Author Hao
 * @Date 2020/12/3 10:32
 * @Version V1.0
 **/
@RestController
@RequestMapping("/api/product/")
public class ProductApiController {
    @Autowired
    private SkuInfoService skuInfoService;
    @Autowired
    private SkuImageService skuImageService;
    @Autowired
    private SpuSaleAttrService spuSaleAttrService;
    @Autowired
    private BaseCategoryViewService baseCategoryViewService;


    @RequestMapping("getSkuInfoById/{skuId}")
    public SkuInfo getSkuInfoById(@PathVariable("skuId")Long skuId){
        SkuInfo skuinfo = skuInfoService.getById(skuId);
        QueryWrapper<SkuImage> skuImageQueryWrapper = new QueryWrapper<>();
        skuImageQueryWrapper.eq("sku_id",skuId);
        List<SkuImage> skuImageList = skuImageService.list(skuImageQueryWrapper);
        skuinfo.setSkuImageList(skuImageList);
        return skuinfo;
    }
    @RequestMapping("getPrice/{skuId}")
    public BigDecimal getPrice(@PathVariable("skuId") Long skuId){
        SkuInfo skuInfo = skuInfoService.getById(skuId);
        return skuInfo.getPrice();
    }

    @RequestMapping("getSpuSaleAttrListBySpuId/{spuId}")
    public List<SpuSaleAttr> getSpuSaleAttrListBySpuId(@PathVariable("spuId")Long spuId){
        List<SpuSaleAttr> spuSaleAttrList = spuSaleAttrService.spuSaleAttrList(spuId);
        return spuSaleAttrList;
    }

    @RequestMapping("getCategoryViewByCategory3Id/{category3Id}")
    public BaseCategoryView getCategoryViewByCategory3Id(@PathVariable("category3Id")Long category3Id){
        BaseCategoryView baseCategoryView = baseCategoryViewService.getCategoryViewByCategory3Id(category3Id);
        return baseCategoryView;
    }
}
