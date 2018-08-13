package com.demo.springboot.dubbo.service.impl;

import com.demo.springboot.dubbo.entity.TestEntity;
import com.demo.springboot.dubbo.service.ICService;
import com.demo.springboot.dubbo.service.IDService;
import com.demo.springboot.dubbo.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class CServiceImpl implements ICService {
    @Autowired
    private ITestService testService;

    @Autowired
    private IDService idService;
    @Override
    public void test(String string) {
        TestEntity testEntity = new TestEntity();
        testEntity.setTest("C-"+string);
        testEntity = testService.save(testEntity);
        if(!Objects.isNull(testEntity.getId())){
            throw new RuntimeException("CService test....a...");
        }
    }

    @Override
    public void test1(String string) {
        TestEntity testEntity = new TestEntity();
        testEntity.setTest("C1-"+string);
        testEntity = testService.save(testEntity);
        idService.test("C1-"+string);
    }
}
