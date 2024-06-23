package com.banka.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.banka.practice.entity.Department;
import com.banka.practice.repository.DepartmentRepository;

@DataJpaTest
public class RepositoryTests {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void insertTest(){
        Department department = new Department(1L, "Test Insert", "Department Address", "C1");
        Department savedDepartment = departmentRepository.save(department);
        Department query = testEntityManager.find(Department.class, savedDepartment.getDepartmentId());
        assertEquals(savedDepartment.getDepartmentName(), query.getDepartmentName());
    }

    @Test
    void updateDepartmentTest(){
        Department department = new Department(null, "Test Insert", "Department Address", "C1");
        departmentRepository.save(department);
        //testEntityManager.persist(department);
        String newName = "Changed name";
        
        department.setDepartmentName(newName);
        Department qDepartment = departmentRepository.save(department);
        assertEquals(qDepartment.getDepartmentName(),newName);
    }

}
