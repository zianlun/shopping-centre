package cuit.ljzhang.mall.product.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import cuit.ljzhang.mall.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cuit.ljzhang.common.utils.PageUtils;
import cuit.ljzhang.common.utils.Query;

import cuit.ljzhang.mall.product.dao.CategoryDao;
import cuit.ljzhang.mall.product.entity.CategoryEntity;
import cuit.ljzhang.mall.product.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        if(StringUtils.isNotBlank(category.getName())){
            categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());
        }
    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> path = new ArrayList<>();
        findDfs(path, catelogId);
        return path.toArray(new Long[path.size()]);
    }

    public void findDfs(List<Long> path, Long catelogId){
        path.add(0, catelogId);
        CategoryEntity categoryEntity = baseMapper.selectById(catelogId);
        if(categoryEntity.getParentCid() != 0){
            findDfs(path, categoryEntity.getParentCid());
        }
    }

    /**
     * 查询处理出树形结构
     * @return
     */
    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> categories = baseMapper.selectList(null);

        List<CategoryEntity> categorTree = categories.stream().filter(
                category -> category.getParentCid() == 0
        ).map(category ->{
            category.setChildren(getChaildren(category.getCatId(), categories));
            return category;
        }).sorted(Comparator.comparingInt(
                category -> (
                        category.getSort() == null ? 0 : category.getSort()
                ))).collect(Collectors.toList());
        return categorTree;
    }

    public List<CategoryEntity> getChaildren(Long root, List<CategoryEntity> categories){
        List<CategoryEntity> chaildren = categories.stream().filter(
                category -> category.getParentCid().equals(root)
        ).map(category ->{
            category.setChildren(getChaildren(category.getCatId(), categories));
            return category;
        }).sorted(Comparator.comparingInt(
                category -> (
                        category.getSort() == null ? 0 : category.getSort()
                ))).collect(Collectors.toList());
        return chaildren;
    }

}