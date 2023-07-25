package cuit.ljzhang.mall.coupon.dao;

import cuit.ljzhang.mall.coupon.entity.CouponSpuRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券与产品关联
 * 
 * @author ljzhang
 * @email 3131939824@qq.com
 * @date 2023-07-19 09:18:46
 */
@Mapper
public interface CouponSpuRelationDao extends BaseMapper<CouponSpuRelationEntity> {
	
}
