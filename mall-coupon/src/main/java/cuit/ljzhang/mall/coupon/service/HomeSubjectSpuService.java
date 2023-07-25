package cuit.ljzhang.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cuit.ljzhang.common.utils.PageUtils;
import cuit.ljzhang.mall.coupon.entity.HomeSubjectSpuEntity;

import java.util.Map;

/**
 * 专题商品
 *
 * @author ljzhang
 * @email 3131939824@qq.com
 * @date 2023-07-18 19:56:20
 */
public interface HomeSubjectSpuService extends IService<HomeSubjectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

