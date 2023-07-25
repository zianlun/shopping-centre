package cuit.ljzhang.mall.member.dao;

import cuit.ljzhang.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author ljzhang
 * @email 3131939824@qq.com
 * @date 2023-07-18 20:08:44
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
