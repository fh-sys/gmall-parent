package com.atguigu.gmall.product.service;

import com.atguigu.gmall.bean.product.BaseAttrInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 属性表 服务类
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
public interface BaseAttrInfoService extends IService<BaseAttrInfo> {

    /**
     * 根据一二三级分类id查询平台属性信息
     * @param category1Id
     * @param category2Id
     * @param category3Id
     * @return
     */
    List<BaseAttrInfo> getAttrInfoList(Long category1Id, Long category2Id, Long category3Id);

    /**
     * 保存平台属性和平台属性值
     * @param baseAttrInfo
     */
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);


}
