package com.atguigu.gmall.product.service;

import com.atguigu.gmall.bean.product.SpuInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
public interface SpuInfoService extends IService<SpuInfo> {

    /**
     * 保存spu信息
     * @param spuInfo
     */
    void saveSpuInfo(SpuInfo spuInfo);
}
