package cuit.ljzhang.mall.order.dao;

import cuit.ljzhang.mall.order.entity.RefundInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 退款信息
 * 
 * @author ljzhang
 * @email 3131939824@qq.com
 * @date 2023-07-18 20:17:49
 */
@Mapper
public interface RefundInfoDao extends BaseMapper<RefundInfoEntity> {
	
}
