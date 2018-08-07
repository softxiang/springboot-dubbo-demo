package com.demo.springboot.dubbo.service.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.springboot.dubbo.entity.TestEntity;
import com.demo.springboot.dubbo.service.IAService;
import com.demo.springboot.dubbo.service.IBService;
import com.demo.springboot.dubbo.service.ICService;
import com.demo.springboot.dubbo.service.ITestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDubboDemoApplicationTests {

    @Autowired
    private ITestService testService;
    @Autowired
    private ICService icService;

    @Reference(group = "test", version = "1.0.0")
    private IAService iaService;
    @Reference(group = "test", version = "1.0.0")
    private IBService ibService;

    @Test
    public void testSave() {
        TestEntity test = new TestEntity();
        test.setTest("aaaaaaaaaaa");
        test  = testService.save(test);
        System.out.println(test.getId());
    }

    @Test
    public void  testDubbo(){
        System.out.println("start......");
        try {
            iaService.test("aaaa");
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            ibService.test("bbbbb");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void  testC(){
        try {
            icService.test("ccc");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
