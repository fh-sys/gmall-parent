package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.bean.product.BaseCategory2;
import com.atguigu.gmall.product.mapper.BaseCategory2Mapper;
import com.atguigu.gmall.product.service.BaseCategory2Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 二级分类表 服务实现类
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
@Service
public class BaseCategory2ServiceImpl extends ServiceImpl<BaseCategory2Mapper, BaseCategory2> implements BaseCategory2Service {

    @Override
    public List<BaseCategory2> getByCategory2ByCategory1Id(Long category1Id) {
        QueryWrapper<BaseCategory2> category2QueryWrapper = new QueryWrapper<>();
        category2QueryWrapper.eq("category1_id",category1Id);
        List<BaseCategory2> baseCategory2List = baseMapper.selectList(category2QueryWrapper);
        return baseCategory2List;

    }
}
