package com.atguigu.gmall.product.controller;


import com.atguigu.gmall.bean.product.SpuImage;
import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.product.service.SkuImageService;
import com.atguigu.gmall.product.service.SpuImageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品图片表 前端控制器
 * </p>
 *
 * @author fh
 * @since 2020-11-28
 */
@RestController
@RequestMapping("/admin/product")
@CrossOrigin
public class SpuImageController {
    @Autowired
    private SpuImageService spuImageService;

    @GetMapping("spuImageList/{spuId}")
    public Result spuImageList(@PathVariable("spuId")Long spuId){
        QueryWrapper<SpuImage> spuImageQueryWrapper = new QueryWrapper<>();
        spuImageQueryWrapper.eq("spu_id",spuId);
        List<SpuImage> spuImageList = spuImageService.list(spuImageQueryWrapper);
        return Result.ok(spuImageList);
    }
}

