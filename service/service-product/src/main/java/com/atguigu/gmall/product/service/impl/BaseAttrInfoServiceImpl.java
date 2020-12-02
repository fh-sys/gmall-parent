package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.bean.product.BaseAttrInfo;
import com.atguigu.gmall.bean.product.BaseAttrValue;
import com.atguigu.gmall.product.mapper.BaseAttrInfoMapper;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import com.atguigu.gmall.product.service.BaseAttrValueService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 属性表 服务实现类
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
@Service
public class BaseAttrInfoServiceImpl extends ServiceImpl<BaseAttrInfoMapper, BaseAttrInfo> implements BaseAttrInfoService {

    @Autowired
    private BaseAttrValueService baseAttrValueService;

    @Override
    public List<BaseAttrInfo> getAttrInfoList(Long category1Id, Long category2Id, Long category3Id) {
//        //根据id等级一级id编号查询平台属性的信息
        //如果需要将查询出来的结果遍历再查询的话可以直接封装SQL直接查询一次
        Map<String, Long> categoryMap = new HashMap<>();
        categoryMap.put("category1Id",category1Id);
        categoryMap.put("category2Id",category2Id);
        categoryMap.put("category3Id",category3Id);
        List<BaseAttrInfo> baseAttrInfoList = baseMapper.selectAttrInfoList(categoryMap);
        return  baseAttrInfoList;
//        QueryWrapper<BaseAttrInfo> baseAttrInfoQueryWrapper = new QueryWrapper<>();
//        if (category1Id>0&&category2Id<=0&&category3Id<=0){
//            baseAttrInfoQueryWrapper.eq("category_level",1);
//            baseAttrInfoQueryWrapper.eq("category_id",category1Id);
//        }
//        if (category1Id>0&&category2Id>0&&category3Id<=0){
//            baseAttrInfoQueryWrapper.eq("category_level",2);
//            baseAttrInfoQueryWrapper.eq("category_id",category2Id);
//        }
//        if (category1Id>0&&category2Id>0&&category3Id>0) {
//            baseAttrInfoQueryWrapper.eq("category_level", 3);
//            baseAttrInfoQueryWrapper.eq("category_id", category3Id);
//        }
//        List<BaseAttrInfo> baseAttrInfoList = baseMapper.selectList(baseAttrInfoQueryWrapper);
//        //根据平台属性的信息，查询平台属性值信息
//        baseAttrInfoList.forEach(baseAttrInfo -> {
//            Long attrInfoId = baseAttrInfo.getId();
//            QueryWrapper<BaseAttrValue> baseAttrValueQueryWrapper = new QueryWrapper<>();
//            baseAttrValueQueryWrapper.eq("attr_id",attrInfoId);
//            List<BaseAttrValue> baseAttrValueList = baseAttrValueService.list(baseAttrValueQueryWrapper);
//            baseAttrInfo.setAttrValueList(baseAttrValueList);
//        });
    }

    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        //获取baseAttrInfo的id，根据是否为空判断更新还是添加
        Long arrtId = baseAttrInfo.getId();
        if (null != arrtId){
            //有值更新,先删除，再插入
            baseAttrInfo.getAttrValueList().forEach(baseAttrValue -> {
                baseAttrValueService.removeById(baseAttrValue.getId());
                baseAttrValueService.save(baseAttrValue);
            });

        }else {
            //id没值添加
            baseMapper.insert(baseAttrInfo);
            //保存平台属性值
            List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
            attrValueList.forEach(baseAttrValue -> {
                //设置平台属性id
                baseAttrValue.setAttrId(baseAttrInfo.getId());
                baseAttrValueService.save(baseAttrValue);
            });
        }

    }


}
