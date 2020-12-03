package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.bean.product.BaseCategoryView;
import com.atguigu.gmall.product.mapper.BaseCategoryViewMapper;
import com.atguigu.gmall.product.service.BaseCategoryViewService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
@Service
public class BaseCategoryViewServiceImpl extends ServiceImpl<BaseCategoryViewMapper, BaseCategoryView> implements BaseCategoryViewService {


    @Override
    public BaseCategoryView getCategoryViewByCategory3Id(Long category3Id) {
        QueryWrapper<BaseCategoryView> baseCategoryViewQueryWrapper = new QueryWrapper<>();
        baseCategoryViewQueryWrapper.eq("category3_id",category3Id);
        BaseCategoryView baseCategoryView = baseMapper.selectOne(baseCategoryViewQueryWrapper);
        return baseCategoryView;
    }
}
