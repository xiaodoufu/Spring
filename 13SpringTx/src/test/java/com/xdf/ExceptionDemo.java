package com.xdf;

import com.xdf.proxyfactory.BuyStockService;
import com.xdf.proxyfactory.impl.BuyStockException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;

public class ExceptionDemo {

    /**
     在service层增加了运行时异常  但是没有使用事务
     问题：
     01.用户的钱减少了
     02.出现异常
     03.股票数量还没有增加


     配置完事务之后 再次运行
     getBean 获取的是事务工厂

     */
    @Test
    public  void testBuyAddRuntimeException() throws ArithmeticException {
        ApplicationContext context=new ClassPathXmlApplicationContext("proxyFactory.xml");
       BuyStockService service= (BuyStockService) context.getBean("proxyFactoryBean");
        service.buyStock("张三",100,1);

    }
}
