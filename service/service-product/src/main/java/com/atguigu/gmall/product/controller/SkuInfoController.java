package com.atguigu.gmall.product.controller;


import com.atguigu.gmall.bean.product.SkuInfo;
import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.product.service.SkuInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 库存单元表 前端控制器
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
@RestController
@RequestMapping("/admin/product")
@CrossOrigin
public class SkuInfoController {

    @Autowired
    private SkuInfoService skuInfoService;

    @ApiOperation("保存sku信息，包括sku相关的信息")
    @PostMapping("saveSkuInfo")
    public Result saveSkuInfo(@RequestBody SkuInfo skuInfo){
        skuInfoService.saveSkuInfo(skuInfo);
        return Result.ok();
    }

    @ApiOperation("分页查询sku信息")
    @GetMapping("list/{pageNo}/{pageSize}")
    public Result getSkuInfoByPage(@PathVariable("pageNo")Long pageNo,
                                   @PathVariable("pageSize")Long pageSize){
        Page<SkuInfo> skuInfoPage = new Page<>(pageNo, pageSize);
        IPage<SkuInfo> page = skuInfoService.page(skuInfoPage, null);
        return Result.ok(page);
    }
    @ApiOperation("上架")
    @PostMapping("onSale")
    public Result onSale(Long skuId){
        skuInfoService.onSale(skuId);
        return Result.ok();
    }
    @ApiOperation("下架")
    @PostMapping("cancelSale")
    public Result cancelSale(Long skuId){
        skuInfoService.cancelSale(skuId);
        return Result.ok();
    }

}

