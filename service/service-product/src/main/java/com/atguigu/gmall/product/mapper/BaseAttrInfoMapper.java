package com.atguigu.gmall.product.mapper;

import com.atguigu.gmall.bean.product.BaseAttrInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 属性表 Mapper 接口
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
public interface BaseAttrInfoMapper extends BaseMapper<BaseAttrInfo> {

    /**
     * 根基一二三级分类信息，查询平台属性的信息，包括平台属性值
     * @param categoryMap
     * @return
     */
    List<BaseAttrInfo> selectAttrInfoList(Map<String, Long> categoryMap);


}
