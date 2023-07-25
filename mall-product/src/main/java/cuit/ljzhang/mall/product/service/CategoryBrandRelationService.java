package cuit.ljzhang.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import cuit.ljzhang.common.utils.PageUtils;
import cuit.ljzhang.mall.product.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author ljzhang
 * @email 3131939824@qq.com
 * @date 2023-07-18 16:02:42
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Boolean saveDetail(CategoryBrandRelationEntity categoryBrandRelationEntity);

    Boolean updateBrand(Long branId, String brandName);

    Boolean updateCategory(Long catId, String name);

}

