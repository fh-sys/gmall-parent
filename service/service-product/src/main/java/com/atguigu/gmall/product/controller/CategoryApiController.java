package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getCategory1")
    public Result getCategory1(){
        return Result.ok();
    }

}
