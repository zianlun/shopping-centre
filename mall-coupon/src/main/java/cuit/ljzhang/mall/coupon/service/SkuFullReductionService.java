package cuit.ljzhang.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cuit.ljzhang.common.utils.PageUtils;
import cuit.ljzhang.mall.coupon.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author ljzhang
 * @email 3131939824@qq.com
 * @date 2023-07-18 19:56:19
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

