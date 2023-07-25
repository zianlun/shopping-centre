package cuit.ljzhang.mall.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName AttrRespDto
 * @Description
 * @Author ljzhang
 * @Date 2023/7/22 18:04
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttrRespDto extends AttrDto{

    private String catelogName;

    private String groupName;

    private Long[] path;
}
