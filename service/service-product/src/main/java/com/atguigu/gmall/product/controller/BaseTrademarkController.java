package com.atguigu.gmall.product.controller;


import com.atguigu.gmall.bean.product.BaseTrademark;
import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.product.service.BaseTrademarkService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
@RestController
@RequestMapping("/admin/product/baseTrademark")
@CrossOrigin
public class BaseTrademarkController {

    @Autowired
    private BaseTrademarkService baseTrademarkService;

    @GetMapping("/getTrademarkList")
    public Result getTrademarkList(){
        List<BaseTrademark> baseTrademarkList = baseTrademarkService.list(null);
        return Result.ok(baseTrademarkList);
    }
    @ApiOperation("分页查询品牌信息")
    @GetMapping("{pageNo}/{pageSize}")
    public Result getTrademarkByPageNo(@PathVariable("pageNo")Long pageNo,
                                       @PathVariable("pageSize")Long pageSize){
        Page<BaseTrademark> baseTrademarkPage = new Page<>(pageNo,pageSize);
        IPage<BaseTrademark> baseTrademarkList = baseTrademarkService.page(baseTrademarkPage, null);
        return Result.ok(baseTrademarkList);
    }
}

