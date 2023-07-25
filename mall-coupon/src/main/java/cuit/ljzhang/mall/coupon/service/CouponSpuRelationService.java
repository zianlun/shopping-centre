package cuit.ljzhang.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cuit.ljzhang.common.utils.PageUtils;
import cuit.ljzhang.mall.coupon.entity.CouponSpuRelationEntity;

import java.util.Map;

/**
 * 优惠券与产品关联
 *
 * @author ljzhang
 * @email 3131939824@qq.com
 * @date 2023-07-19 09:18:46
 */
public interface CouponSpuRelationService extends IService<CouponSpuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

