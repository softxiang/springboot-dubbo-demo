package com.demo.springboot.dubbo.service;

import com.demo.springboot.dubbo.entity.TestEntity;

public interface ITestService {
    TestEntity save(TestEntity testEntity);
}
