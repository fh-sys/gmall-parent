package com.atguigu.gmall.product.controller;


import com.atguigu.gmall.bean.product.SpuSaleAttr;
import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.product.service.SpuSaleAttrService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * spu销售属性 前端控制器
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
@RestController
@RequestMapping("/admin/product")
@CrossOrigin
public class SpuSaleAttrController {
    @Autowired
    private SpuSaleAttrService spuSaleAttrService;

    @ApiOperation("根据id获取spu销售属性,包括销售属性值")
    @GetMapping("spuSaleAttrList/{spuId}")
    public Result spuSaleAttrList(@PathVariable("spuId")Long spuId){
        List<SpuSaleAttr> spuSaleAttrList = spuSaleAttrService.spuSaleAttrList(spuId);
        return Result.ok(spuSaleAttrList);
    }
}

