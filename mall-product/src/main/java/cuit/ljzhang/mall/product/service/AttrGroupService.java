package cuit.ljzhang.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cuit.ljzhang.common.utils.PageUtils;
import cuit.ljzhang.mall.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author ljzhang
 * @email 3131939824@qq.com
 * @date 2023-07-18 16:02:42
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Long catelogId);

}

