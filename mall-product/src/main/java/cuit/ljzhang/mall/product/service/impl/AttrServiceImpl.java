package cuit.ljzhang.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cuit.ljzhang.mall.product.dto.AttrDto;
import cuit.ljzhang.mall.product.dto.AttrRespDto;
import cuit.ljzhang.mall.product.entity.AttrAttrgroupRelationEntity;
import cuit.ljzhang.mall.product.entity.AttrGroupEntity;
import cuit.ljzhang.mall.product.entity.CategoryEntity;
import cuit.ljzhang.mall.product.service.AttrAttrgroupRelationService;
import cuit.ljzhang.mall.product.service.AttrGroupService;
import cuit.ljzhang.mall.product.service.CategoryService;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.jcajce.provider.symmetric.AES;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cuit.ljzhang.common.utils.PageUtils;
import cuit.ljzhang.common.utils.Query;

import cuit.ljzhang.mall.product.dao.AttrDao;
import cuit.ljzhang.mall.product.entity.AttrEntity;
import cuit.ljzhang.mall.product.service.AttrService;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;


    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttrGroupService attrGroupService;

    @Override
    public AttrRespDto getAttrInfo(Long attrId) {
        AttrEntity attrEntity = getById(attrId);
        AttrRespDto attrRespDto = new AttrRespDto();
        BeanUtils.copyProperties(attrEntity, attrRespDto);
        LambdaQueryWrapper<AttrAttrgroupRelationEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(AttrAttrgroupRelationEntity::getAttrId, attrId);
        AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = attrAttrgroupRelationService.getOne(wrapper);
        if(attrAttrgroupRelationEntity != null){
            attrRespDto.setAttrGroupId(attrAttrgroupRelationEntity.getAttrGroupId());
            AttrGroupEntity attrGroupEntity = attrGroupService.getById(attrAttrgroupRelationEntity.getAttrGroupId());
            if(attrGroupEntity != null){
                attrRespDto.setGroupName(attrGroupEntity.getAttrGroupName());
            }
        }
        Long[] path = categoryService.findCatelogPath(attrRespDto.getCatelogId());
        CategoryEntity categoryEntity = categoryService.getById(attrRespDto.getCatelogId());
        attrRespDto.setPath(path);
        if(categoryEntity != null)
            attrRespDto.setCatelogName(categoryEntity.getName());
        return attrRespDto;
    }

    @Override
    public PageUtils queryByCatelogId(Map<String, Object> params, Long catelogId) {
        LambdaQueryWrapper<AttrEntity> wrapper = Wrappers.lambdaQuery();
        if(catelogId != 0)
            wrapper.eq(AttrEntity::getCatelogId, catelogId);
        String keyField = (String)params.get("key");
        if(StringUtils.isNotBlank(keyField)){
            wrapper.eq(AttrEntity::getAttrId, keyField)
                    .or()
                    .like(AttrEntity::getAttrName, keyField);
        }
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                wrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        pageUtils.setList(pageUtils.getList().stream().map(
                (item) -> {
                    AttrRespDto attrRespDto = new AttrRespDto();
                    BeanUtils.copyProperties(item, attrRespDto);
                    AttrAttrgroupRelationEntity attrAttrgroupRelationEntity =
                            attrAttrgroupRelationService.getOne(
                                    new LambdaQueryWrapper<AttrAttrgroupRelationEntity>()
                                    .eq(AttrAttrgroupRelationEntity::getAttrId, attrRespDto.getAttrId())
                            );
                    AttrGroupEntity attrGroupEntity = attrGroupService.getById(attrAttrgroupRelationEntity.getAttrId());
                    if(attrGroupEntity != null)
                    attrRespDto.setGroupName(attrGroupEntity.getAttrGroupName());
                    CategoryEntity categoryEntity = categoryService.getById(attrRespDto.getCatelogId());
                    if(categoryEntity != null)
                    attrRespDto.setCatelogName(categoryEntity.getName());
                    return attrRespDto;
                }
        ).collect(Collectors.toList()));
        return pageUtils;
    }

    @Override
    public void saveAttr(AttrDto attrDto) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attrDto, attrEntity);
        save(attrEntity);
        AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = new AttrAttrgroupRelationEntity();
        attrAttrgroupRelationEntity.setAttrId(attrEntity.getAttrId());
        attrAttrgroupRelationEntity.setAttrGroupId(attrDto.getAttrGroupId());
        attrAttrgroupRelationService.save(attrAttrgroupRelationEntity);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

}