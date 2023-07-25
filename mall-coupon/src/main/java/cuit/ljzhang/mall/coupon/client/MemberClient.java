package cuit.ljzhang.mall.coupon.client;

import cuit.ljzhang.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName MemberClient
 * @Description
 * @Author ljzhang
 * @Date 2023/7/19 9:32
 * @Version 1.0
 */
@FeignClient("memberservice")
public interface MemberClient  {
    @GetMapping("member/member/info/{id}")
    public R getMember(@PathVariable("id") Long id);
}
