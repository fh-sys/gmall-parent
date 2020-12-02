package com.atguigu.gmall.product.service;

import com.atguigu.gmall.bean.product.SkuInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 库存单元表 服务类
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
public interface SkuInfoService extends IService<SkuInfo> {

    /**
     * 保存sku
     * @param skuInfo
     */
    void saveSkuInfo(SkuInfo skuInfo);

    /**
     * 上架sku
     * @param skuId
     */
    void onSale(Long skuId);

    /**
     * 下架sku
     * @param skuId
     */
    void cancelSale(Long skuId);
}
