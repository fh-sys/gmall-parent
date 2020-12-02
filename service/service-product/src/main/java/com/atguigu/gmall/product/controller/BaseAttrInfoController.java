package com.atguigu.gmall.product.controller;


import com.atguigu.gmall.bean.product.BaseAttrInfo;
import com.atguigu.gmall.bean.product.BaseAttrValue;
import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import com.atguigu.gmall.product.service.BaseAttrValueService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 属性表 前端控制器
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
@RestController
@RequestMapping("/admin/product")
@CrossOrigin
public class BaseAttrInfoController {

    @Autowired
    private BaseAttrInfoService baseAttrInfoService;
    @Autowired
    private BaseAttrValueService baseAttrValueService;

    @GetMapping("/attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result attrInfoList(@PathVariable("category1Id")Long category1Id,
                               @PathVariable("category2Id")Long category2Id,
                               @PathVariable("category3Id")Long category3Id){

        List<BaseAttrInfo> baseAttrInfoList = baseAttrInfoService.getAttrInfoList(category1Id,category2Id,category3Id);
        return Result.ok(baseAttrInfoList);
    }

    @ApiOperation("添加或修改平台属性信息")
    @PostMapping("saveAttrInfo")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
        //保存平台属性的时候，还要保存平台属性值
        baseAttrInfoService.saveAttrInfo(baseAttrInfo);
        return Result.ok();
    }
    @ApiOperation("根据id查询平台属性信息")
    @GetMapping("getAttrValueList/{attrId}")
    public Result getAttrValueList(@PathVariable("attrId")Long attrId){
        QueryWrapper<BaseAttrValue> baseAttrValueQueryWrapper = new QueryWrapper<>();
        baseAttrValueQueryWrapper.eq("attr_id",attrId);
        List<BaseAttrValue> baseAttrValueList = baseAttrValueService.list(baseAttrValueQueryWrapper);
        return Result.ok(baseAttrValueList);
    }
}

