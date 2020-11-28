package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.bean.product.BaseCategory1;
import com.atguigu.gmall.bean.product.BaseCategory2;
import com.atguigu.gmall.bean.product.BaseCategory3;
import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.product.service.BaseCategory1Service;
import com.atguigu.gmall.product.service.BaseCategory2Service;
import com.atguigu.gmall.product.service.BaseCategory3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CategoryApiController
 * @Description: 分类控制器
 * @Author Hao
 * @Date 2020/11/27 19:23
 * @Version V1.0
 **/
@RestController
@RequestMapping("/admin/product")
@CrossOrigin
public class CategoryApiController {

    @Autowired
    private BaseCategory1Service category1Service;
    @Autowired
    private BaseCategory2Service category2Service;
    @Autowired
    private BaseCategory3Service category3Service;


    @GetMapping("/getCategory1")
    public Result getCategory1(){
        List<BaseCategory1> category1List = category1Service.list(null);
        return Result.ok(category1List);
    }
    @GetMapping("/getCategory2/{category1Id}")
    public Result getCategory1(@PathVariable("category1Id")Long category1Id){
        List<BaseCategory2> list = category2Service.getByCategory2ByCategory1Id(category1Id);
        return Result.ok(list);
    }
    @GetMapping("/getCategory3/{category2Id}")
    public Result getCategory3(@PathVariable("category2Id")Long category2Id){
        List<BaseCategory3> list = category3Service.getByCategory3ByCategory2Id(category2Id);
        return Result.ok(list);
    }

}
