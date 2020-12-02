package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.bean.product.SpuImage;
import com.atguigu.gmall.bean.product.SpuInfo;
import com.atguigu.gmall.bean.product.SpuSaleAttr;
import com.atguigu.gmall.bean.product.SpuSaleAttrValue;
import com.atguigu.gmall.product.mapper.SpuInfoMapper;
import com.atguigu.gmall.product.service.SpuImageService;
import com.atguigu.gmall.product.service.SpuInfoService;
import com.atguigu.gmall.product.service.SpuSaleAttrService;
import com.atguigu.gmall.product.service.SpuSaleAttrValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
@Service
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoMapper, SpuInfo> implements SpuInfoService {

    @Autowired
    private SpuImageService spuImageService;
    @Autowired
    private SpuSaleAttrService spuSaleAttrService;
    @Autowired
    private SpuSaleAttrValueService spuSaleAttrValueService;

    @Override
    public void saveSpuInfo(SpuInfo spuInfo) {

        //添加spu
        baseMapper.insert(spuInfo);
        //添加spu图片
        List<SpuImage> spuImageList = spuInfo.getSpuImageList();
        if (!spuImageList.isEmpty()){
            for (SpuImage spuImage : spuImageList) {
                spuImage.setSpuId(spuInfo.getId());
                spuImageService.save(spuImage);
            }
        }
        //添加spu销售属性信息
        List<SpuSaleAttr> spuSaleAttrList = spuInfo.getSpuSaleAttrList();
        if (!spuSaleAttrList.isEmpty()){
            for (SpuSaleAttr spuSaleAttr : spuSaleAttrList) {
                spuSaleAttr.setSpuId(spuInfo.getId());
                spuSaleAttrService.save(spuSaleAttr);
                //添加商品销售属性值
                List<SpuSaleAttrValue> spuSaleAttrValueList = spuSaleAttr.getSpuSaleAttrValueList();
                if (!spuSaleAttrValueList.isEmpty()){
                    for (SpuSaleAttrValue spuSaleAttrValue : spuSaleAttrValueList) {
                        //设置spuid
                        spuSaleAttrValue.setSpuId(spuInfo.getId());
                        //设置平台销售属性id
                        spuSaleAttrValue.setBaseSaleAttrId(spuSaleAttr.getBaseSaleAttrId());
                        //设置销售属性名称
                        spuSaleAttrValue.setSaleAttrName(spuSaleAttr.getSaleAttrName());
                        spuSaleAttrValueService.save(spuSaleAttrValue);
                    }
                }
            }
        }
    }
}
