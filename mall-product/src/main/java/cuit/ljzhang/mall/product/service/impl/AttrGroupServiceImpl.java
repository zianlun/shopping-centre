package cuit.ljzhang.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cuit.ljzhang.common.utils.PageUtils;
import cuit.ljzhang.common.utils.Query;

import cuit.ljzhang.mall.product.dao.AttrGroupDao;
import cuit.ljzhang.mall.product.entity.AttrGroupEntity;
import cuit.ljzhang.mall.product.service.AttrGroupService;

@Slf4j
@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        if(catelogId == 0){
            LambdaQueryWrapper<AttrGroupEntity> wrapper = Wrappers.lambdaQuery();
            String keyField = (String) params.get("key");
            log.info("keyField : {}", keyField);
            if(StringUtils.isNotBlank(keyField)){
                wrapper.eq(AttrGroupEntity::getAttrGroupId, keyField)
                        .or()
                        .like(AttrGroupEntity::getAttrGroupName, keyField);
            }
            IPage<AttrGroupEntity> page = this.page(
                    new Query<AttrGroupEntity>().getPage(params),
                    wrapper
            );
            return new PageUtils(page);
        }
        LambdaQueryWrapper<AttrGroupEntity> wrapper = Wrappers.lambdaQuery();
        String keyField = (String) params.get("key");
        log.info("keyField : {}", keyField);
        wrapper.eq(AttrGroupEntity::getCatelogId, catelogId);
        if(StringUtils.isNotBlank(keyField)){
            wrapper.eq(AttrGroupEntity::getAttrGroupId, keyField)
                    .or()
                    .like(AttrGroupEntity::getAttrGroupName, keyField);
        }
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                wrapper
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }



}