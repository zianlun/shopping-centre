package cuit.ljzhang.mall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import cuit.ljzhang.mall.product.dto.AttrDto;
import cuit.ljzhang.mall.product.dto.AttrRespDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cuit.ljzhang.mall.product.entity.AttrEntity;
import cuit.ljzhang.mall.product.service.AttrService;
import cuit.ljzhang.common.utils.PageUtils;
import cuit.ljzhang.common.utils.R;



/**
 * 商品属性
 *
 * @author ljzhang
 * @email 3131939824@qq.com
 * @date 2023-07-18 16:48:12
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attr:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{attrId}")
    //@RequiresPermissions("product:attr:info")
    public R info(@PathVariable("attrId") Long attrId){
//		AttrEntity attr = attrService.getById(attrId);
        AttrRespDto attrRespDto = attrService.getAttrInfo(attrId);
        return R.ok().put("attr", attrRespDto);
    }

    //  /product/attr/base/list/{catelogId}
    @GetMapping("/base/list/{catelogId}")
    public R attrBase(@RequestParam Map<String, Object> params, @PathVariable Long catelogId){
        PageUtils page = attrService.queryByCatelogId(params, catelogId);
        return R.ok().put("page", page);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attr:save")
    public R save(@RequestBody AttrDto attr){
		attrService.saveAttr(attr);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attr:update")
    public R update(@RequestBody AttrEntity attr){
		attrService.updateById(attr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attr:delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }


}
