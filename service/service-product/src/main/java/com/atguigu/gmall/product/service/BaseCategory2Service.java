package com.atguigu.gmall.product.service;

import com.atguigu.gmall.bean.product.BaseCategory2;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 二级分类表 服务类
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
public interface BaseCategory2Service extends IService<BaseCategory2> {

    /**
     * 根基一级分类id查询二级分类信息
     * @param category1Id
     * @return
     */
    List<BaseCategory2> getByCategory2ByCategory1Id(Long category1Id);
}
