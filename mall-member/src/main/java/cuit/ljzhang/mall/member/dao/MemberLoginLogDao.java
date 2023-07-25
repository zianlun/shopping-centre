package cuit.ljzhang.mall.member.dao;

import cuit.ljzhang.mall.member.entity.MemberLoginLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员登录记录
 * 
 * @author ljzhang
 * @email 3131939824@qq.com
 * @date 2023-07-18 20:08:43
 */
@Mapper
public interface MemberLoginLogDao extends BaseMapper<MemberLoginLogEntity> {
	
}
