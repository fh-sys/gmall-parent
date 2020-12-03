package com.atguigu.gmall.item;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ItemController
 * @Description:
 * @Author Hao
 * @Date 2020/12/2 11:34
 * @Version V1.0
 **/
@Controller
public class ItemController {
    //跳转页面不用restcontroller
    @Autowired
    private ItemFeignClient itemFeignClient;

    @ApiOperation("跳转到首页")
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @ApiOperation("跳转到详情页")
    @RequestMapping("/{skuId}.html")
    public String getItemInfo(@PathVariable("skuId")Long skuId, Model model){

        //返回数据给页面
        Map<String, Object> map = itemFeignClient.getItemInfo(skuId);

        model.addAllAttributes(map);
        return "item/index1";
    }
}
