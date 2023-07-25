package cuit.ljzhang.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cuit.ljzhang.mall.product.entity.CategoryEntity;
import cuit.ljzhang.mall.product.service.BrandService;
import cuit.ljzhang.mall.product.service.CategoryService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cuit.ljzhang.common.utils.PageUtils;
import cuit.ljzhang.common.utils.Query;

import cuit.ljzhang.mall.product.dao.CategoryBrandRelationDao;
import cuit.ljzhang.mall.product.entity.CategoryBrandRelationEntity;
import cuit.ljzhang.mall.product.service.CategoryBrandRelationService;


@Service("categoryBrandRelationService")
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationDao, CategoryBrandRelationEntity> implements CategoryBrandRelationService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;

    @Override
    public Boolean saveDetail(CategoryBrandRelationEntity categoryBrandRelationEntity) {
        String categoryName = categoryService.getById(categoryBrandRelationEntity.getCatelogId()).getName();
        String brandName = brandService.getById(categoryBrandRelationEntity.getBrandId()).getName();
        categoryBrandRelationEntity.setBrandName(brandName);
        categoryBrandRelationEntity.setCatelogName(categoryName);
        return save(categoryBrandRelationEntity);
    }

    @Override
    public Boolean updateCategory(Long catId, String name) {
        CategoryBrandRelationEntity categoryBrandRelationEntity = new CategoryBrandRelationEntity();
        categoryBrandRelationEntity.setCatelogId(catId);
        categoryBrandRelationEntity.setCatelogName(name);
        LambdaUpdateWrapper<CategoryBrandRelationEntity> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(CategoryBrandRelationEntity::getCatelogId, catId);
        return update(categoryBrandRelationEntity, wrapper);
    }

    @Override
    public Boolean updateBrand(Long branId, String brandName) {
        CategoryBrandRelationEntity categoryBrandRelationEntity = new CategoryBrandRelationEntity();
        categoryBrandRelationEntity.setBrandId(branId);
        categoryBrandRelationEntity.setBrandName(brandName);
        LambdaUpdateWrapper<CategoryBrandRelationEntity> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(CategoryBrandRelationEntity::getBrandId, branId);
        return update(categoryBrandRelationEntity, wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryBrandRelationEntity> page = this.page(
                new Query<CategoryBrandRelationEntity>().getPage(params),
                new QueryWrapper<CategoryBrandRelationEntity>()
        );

        return new PageUtils(page);
    }

}