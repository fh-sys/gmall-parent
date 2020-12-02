package com.atguigu.gmall.product.service;

import com.atguigu.gmall.bean.product.SpuSaleAttr;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * spu销售属性 服务类
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
public interface SpuSaleAttrService extends IService<SpuSaleAttr> {

    /**
     * 查询spu的销售属性信息，包括销售属性值
     * @param spuId
     * @return
     */
    List<SpuSaleAttr> spuSaleAttrList(Long spuId);
}
