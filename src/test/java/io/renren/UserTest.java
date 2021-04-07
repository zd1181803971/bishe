package io.renren;

import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Classname UserTest
 * @Description TODO
 * @Date 2021/3/12 15:35
 * @Created by ZhaoDong
 */
@SpringBootTest
public class UserTest {

    @Autowired
    SysUserService sysUserService;

    @Test
    public void test(){
        SysUserEntity entity = sysUserService.getById(1);
        System.out.println(entity);
    }
    @Test
    public void test2(){
        int a,b,c;
        b=10;
        a=b=c=20;
        System.out.println(a);
    }
}
