package com.demo.springboot.dubbo.service.impl;

import com.demo.springboot.dubbo.entity.TestEntity;
import com.demo.springboot.dubbo.repository.ITestRepository;
import com.demo.springboot.dubbo.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl implements ITestService {
    @Autowired
    private ITestRepository testRepository;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public TestEntity save(TestEntity testEntity) {
        return testRepository.save(testEntity);
    }
}
