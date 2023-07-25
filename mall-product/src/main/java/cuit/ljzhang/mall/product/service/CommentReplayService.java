package cuit.ljzhang.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cuit.ljzhang.common.utils.PageUtils;
import cuit.ljzhang.mall.product.entity.CommentReplayEntity;

import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author ljzhang
 * @email 3131939824@qq.com
 * @date 2023-07-18 16:02:42
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

