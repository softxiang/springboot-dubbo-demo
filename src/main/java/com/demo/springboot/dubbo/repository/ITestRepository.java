package com.demo.springboot.dubbo.repository;

import com.demo.springboot.dubbo.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITestRepository extends JpaRepository<TestEntity,Integer> {
}
