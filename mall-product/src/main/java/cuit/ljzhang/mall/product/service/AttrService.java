package cuit.ljzhang.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cuit.ljzhang.common.utils.PageUtils;
import cuit.ljzhang.mall.product.dto.AttrDto;
import cuit.ljzhang.mall.product.dto.AttrRespDto;
import cuit.ljzhang.mall.product.entity.AttrEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author ljzhang
 * @email 3131939824@qq.com
 * @date 2023-07-18 16:02:42
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrDto attr);

    PageUtils queryByCatelogId(@RequestParam Map<String, Object> params, @PathVariable Long catelogId);

    AttrRespDto getAttrInfo(Long attrId);
}

