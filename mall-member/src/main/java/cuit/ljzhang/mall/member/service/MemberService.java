package cuit.ljzhang.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cuit.ljzhang.common.utils.PageUtils;
import cuit.ljzhang.mall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author ljzhang
 * @email 3131939824@qq.com
 * @date 2023-07-18 20:08:44
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

