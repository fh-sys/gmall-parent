package com.atguigu.gmall.product.controller;


import com.atguigu.gmall.bean.product.SpuInfo;
import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.product.service.SpuInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
@RestController
@RequestMapping("/admin/product")
@CrossOrigin
public class SpuInfoController {
    @Autowired
    private SpuInfoService spuInfoService;

    @GetMapping("{pageNo}/{pageSize}")
    public Result getSpuByPage(@PathVariable("pageNo")Long pageNo,
                               @PathVariable("pageSize")Long pageSize,
                               Long category3Id){
        Page<SpuInfo> spuInfoPage = new Page<>(pageNo,pageSize);
        QueryWrapper<SpuInfo> spuInfoQueryWrapper = new QueryWrapper<>();
        spuInfoQueryWrapper.eq("category3_id",category3Id);
        IPage<SpuInfo> page = spuInfoService.page(spuInfoPage, spuInfoQueryWrapper);
        return Result.ok(page);
    }

    @PostMapping("saveSpuInfo")
    public Result saveSpuInfo(@RequestBody SpuInfo spuInfo){
        spuInfoService.saveSpuInfo(spuInfo);
        return Result.ok();
    }
}

