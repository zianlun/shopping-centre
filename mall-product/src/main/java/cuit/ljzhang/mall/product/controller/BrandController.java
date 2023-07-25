package cuit.ljzhang.mall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import cuit.ljzhang.common.valid.AddGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import cuit.ljzhang.mall.product.entity.BrandEntity;
import cuit.ljzhang.mall.product.service.BrandService;
import cuit.ljzhang.common.utils.PageUtils;
import cuit.ljzhang.common.utils.R;

import javax.validation.Valid;


/**
 * 品牌
 *
 * @author ljzhang
 * @email 3131939824@qq.com
 * @date 2023-07-18 16:53:23
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:brand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("product:brand:info")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    @PostMapping("/update/status")
    public R updateStatus(@RequestBody BrandEntity brand){
        brandService.updateById(brand);
        return R.ok();
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    //@RequiresPermissions("product:brand:save")
    public R save(@Validated({AddGroup.class}) @RequestBody BrandEntity brand){
		brandService.save(brand);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:brand:update")
    public R update(@RequestBody BrandEntity brand){
		//同步更新其他地方的数据
		brandService.updateDetail(brand);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:brand:delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));
        return R.ok();
    }

}
