package com.demo.springboot.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.demo.springboot.dubbo.entity.TestEntity;
import com.demo.springboot.dubbo.service.IAService;
import com.demo.springboot.dubbo.service.IBService;
import com.demo.springboot.dubbo.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service(interfaceClass=IAService.class,group="test",version="1.0.0")
@Transactional
public class AServiceImpl implements IAService {
    @Autowired
    private ITestService testService;

    //@Reference(group = "test", version = "1.0.0",check = false)
    @Autowired
    private IBService bService;
    @Override
    public void test(String string) {
        TestEntity testEntity = new TestEntity();
        testEntity.setTest("A-"+string);
        testEntity = testService.save(testEntity);
        if(!Objects.isNull(testEntity.getId())){
            throw new RuntimeException("AService test....a...");
        }
    }
}
