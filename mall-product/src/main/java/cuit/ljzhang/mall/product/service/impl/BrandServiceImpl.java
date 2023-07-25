package cuit.ljzhang.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cuit.ljzhang.mall.product.entity.AttrGroupEntity;
import cuit.ljzhang.mall.product.service.CategoryBrandRelationService;
import cuit.ljzhang.mall.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cuit.ljzhang.common.utils.PageUtils;
import cuit.ljzhang.common.utils.Query;

import cuit.ljzhang.mall.product.dao.BrandDao;
import cuit.ljzhang.mall.product.entity.BrandEntity;
import cuit.ljzhang.mall.product.service.BrandService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        LambdaQueryWrapper<BrandEntity> wrapper = Wrappers.lambdaQuery();
        String keyField = (String) params.get("key");
        log.info("keyField : {}", keyField);
        if(StringUtils.isNotBlank(keyField))
        wrapper.like(BrandEntity::getName, keyField);
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                wrapper
        );
        return new PageUtils(page);
    }

    /*
    * 同步更细冗余数据
    * */
    @Override
    @Transactional
    public void updateDetail(BrandEntity brand) {
        this.updateById(brand);
        if(StringUtils.isNotBlank(brand.getName())){
            categoryBrandRelationService.updateBrand(brand.getBrandId(), brand.getName());
        }
    }

}