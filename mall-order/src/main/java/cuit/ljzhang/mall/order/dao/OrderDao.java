package cuit.ljzhang.mall.order.dao;

import cuit.ljzhang.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author ljzhang
 * @email 3131939824@qq.com
 * @date 2023-07-18 20:17:50
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
