package cuit.ljzhang.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cuit.ljzhang.common.utils.PageUtils;
import cuit.ljzhang.mall.ware.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author ljzhang
 * @email 3131939824@qq.com
 * @date 2023-07-18 20:28:14
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

