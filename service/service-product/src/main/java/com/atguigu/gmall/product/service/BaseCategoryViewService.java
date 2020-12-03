package com.atguigu.gmall.product.service;

import com.atguigu.gmall.bean.product.BaseCategoryView;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
public interface BaseCategoryViewService extends IService<BaseCategoryView> {

    /**
     * 根据三级分类查询一二三级分类信息
     * @param category3Id
     * @return
     */
    BaseCategoryView getCategoryViewByCategory3Id(Long category3Id);
}
