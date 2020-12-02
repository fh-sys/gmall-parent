package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.bean.product.SkuAttrValue;
import com.atguigu.gmall.bean.product.SkuImage;
import com.atguigu.gmall.bean.product.SkuInfo;
import com.atguigu.gmall.bean.product.SkuSaleAttrValue;
import com.atguigu.gmall.product.mapper.SkuInfoMapper;
import com.atguigu.gmall.product.service.SkuAttrValueService;
import com.atguigu.gmall.product.service.SkuImageService;
import com.atguigu.gmall.product.service.SkuInfoService;
import com.atguigu.gmall.product.service.SkuSaleAttrValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 库存单元表 服务实现类
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo> implements SkuInfoService {

    @Autowired
    private SkuImageService skuImageService;
    @Autowired
    private SkuAttrValueService skuAttrValueService;
    @Autowired
    private SkuSaleAttrValueService skuSaleAttrValueService;

    @Override
    public void saveSkuInfo(SkuInfo skuInfo) {
        //添加sku信息
        baseMapper.insert(skuInfo);
        //sku图片信息
        List<SkuImage> skuImageList = skuInfo.getSkuImageList();
        if (!skuImageList.isEmpty()){
            for (SkuImage skuImage : skuImageList) {
                //在sku图片中设置skuid
                skuImage.setSkuId(skuInfo.getId());
                skuImageService.save(skuImage);
            }
        }
        //添加sku平台属性关联表信息
        List<SkuAttrValue> skuAttrValueList = skuInfo.getSkuAttrValueList();
        if (!skuAttrValueList.isEmpty()){
            for (SkuAttrValue skuAttrValue : skuAttrValueList) {
                skuAttrValue.setSkuId(skuInfo.getId());
                skuAttrValueService.save(skuAttrValue);
            }
        }
        //添加sku销售属关联表信息
        List<SkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
        if (!skuSaleAttrValueList.isEmpty()){
            for (SkuSaleAttrValue skuSaleAttrValue : skuSaleAttrValueList) {
                //在sku销售属性值关联表中设置sku的id
                skuSaleAttrValue.setSkuId(skuInfo.getId());
                //在sku销售属性值关联表中设置spu的id
                skuSaleAttrValue.setSpuId(skuInfo.getSpuId());
                skuSaleAttrValueService.save(skuSaleAttrValue);
            }
        }
    }

    @Override
    public void onSale(Long skuId) {
        SkuInfo skuInfo = new SkuInfo();
        skuInfo.setId(skuId);
        skuInfo.setIsSale(0);
        baseMapper.updateById(skuInfo);
    }

    @Override
    public void cancelSale(Long skuId) {
        //创建skuInfo对象
        SkuInfo skuInfo = new SkuInfo();
        skuInfo.setId(skuId);
        skuInfo.setIsSale(1);
        baseMapper.updateById(skuInfo);

    }
}
