package cuit.ljzhang.mall.product;


import com.aliyun.oss.OSSClient;
import cuit.ljzhang.mall.product.entity.BrandEntity;
import cuit.ljzhang.mall.product.service.BrandService;
import cuit.ljzhang.mall.product.service.CategoryService;
import cuit.ljzhang.mall.product.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


@SpringBootTest
class MallProductApplicationTests {

    @Autowired
    private BrandService brandService;

    @Autowired
    private OSSClient ossClient;

    @Autowired
    private CategoryService categoryService;


    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        brandService.save(brandEntity);
    }

    @Test
    void update(){
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandId(1L);
        brandEntity.setName("华为");
        brandEntity.setDescript("测试品牌");
        brandEntity.setShowStatus(1);
        brandEntity.setSort(0);
        brandService.updateById(brandEntity);
    }

    @Test
    void upload() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("F:\\大型电商--谷粒商城\\1.分布式基础（全栈开发篇）\\资料源码\\docs\\pics\\6a1b2703a9ed8737.jpg");
        ossClient.putObject("mall-ljzhang-zian","test",fileInputStream);
    }

    @Test
    void dfs(){
        Long[] path = categoryService.findCatelogPath(255L);
        for(int i = 0; i < path.length; i++){
            System.out.println(path[i]);
        }
    }
}
