package com.demo.springboot.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.demo.springboot.dubbo.entity.TestEntity;
import com.demo.springboot.dubbo.service.IAService;
import com.demo.springboot.dubbo.service.IBService;
import com.demo.springboot.dubbo.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service(interfaceClass=IBService.class,group="test",version="1.0.0")
@Transactional
public class BServiceImpl implements IBService {
    @Autowired
    private ITestService testService;

    @Autowired
    private IAService aService;//相互引用，但实际并未使用
    @Override
    public void test(String string) {
        TestEntity testEntity = new TestEntity();
        testEntity.setTest("B-"+string);
        testEntity = testService.save(testEntity);
        if(!Objects.isNull(testEntity.getId())){
            throw new RuntimeException("BService test...b....");
        }
    }
}
