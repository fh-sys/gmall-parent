package com.atguigu.gmall.product.controller;


import com.atguigu.gmall.bean.product.BaseSaleAttr;
import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.product.service.BaseSaleAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 基本销售属性表 前端控制器
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
@RestController
@RequestMapping("/admin/product")
@CrossOrigin
public class BaseSaleAttrController {
    @Autowired
    private BaseSaleAttrService baseSaleAttrService;

    @GetMapping("baseSaleAttrList")
    public Result baseSaleAttrList(){
        List<BaseSaleAttr> baseSaleAttrList = baseSaleAttrService.list(null);
        return Result.ok(baseSaleAttrList);
    }
}

