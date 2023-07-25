package cuit.ljzhang.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import cuit.ljzhang.common.valid.AddGroup;
import cuit.ljzhang.common.valid.ListValue;
import cuit.ljzhang.common.valid.UpdateGroup;
import feign.Param;
import lombok.Data;
import org.checkerframework.checker.units.qual.A;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author ljzhang
 * @email 3131939824@qq.com
 * @date 2023-07-18 16:02:43
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@Null(message = "新增不能指定id", groups = {AddGroup.class})
	@NotNull(message = "更新必须指定id", groups = {UpdateGroup.class})
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名不能为空", groups = {AddGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotBlank(groups = {AddGroup.class})
	@URL(message = "必须是合法的url地址", groups = {AddGroup.class, UpdateGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@ListValue(values = {0,1}, groups = {AddGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotBlank(groups = AddGroup.class)
	@Pattern(regexp = "^[a-zA-Z]$",message = "检索首字母必须为一个字母", groups = {AddGroup.class, UpdateGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(groups = AddGroup.class)
	@Min(value = 0, message = "排序数必须大于0", groups = {AddGroup.class, UpdateGroup.class})
	private Integer sort;

}
