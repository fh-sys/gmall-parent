package com.atguigu.gmall.product.service;

import com.atguigu.gmall.bean.product.BaseCategory3;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 三级分类表 服务类
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
public interface BaseCategory3Service extends IService<BaseCategory3> {

    /**
     * 根据二级分类id查询三级分类
     * @param category2Id
     * @return
     */
    List<BaseCategory3> getByCategory3ByCategory2Id(Long category2Id);
}
