package cuit.ljzhang.mall.party;

import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
class MallPartyApplicationTests {

    @Resource
    private OSSClient ossClient;

    @Test
    void upload() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("F:\\大型电商--谷粒商城\\1.分布式基础（全栈开发篇）\\资料源码\\docs\\pics\\6a1b2703a9ed8737.jpg");
        ossClient.putObject("mall-ljzhang-zian","test.jpg",fileInputStream);
    }

}
