package com.banka.practice.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banka.practice.entity.Department; 
  
// Annotation 
@Repository
  
// Interface 
public interface DepartmentRepository 
    extends JpaRepository<Department, Long> { 
        List<Department> findAllByDepartmentNameContaining(String deptName, Sort sort);

}