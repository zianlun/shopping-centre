package cuit.ljzhang.mall.product.dao;

import cuit.ljzhang.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author ljzhang
 * @email 3131939824@qq.com
 * @date 2023-07-18 16:02:43
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
