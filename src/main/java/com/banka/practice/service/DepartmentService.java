package com.banka.practice.service;

// Importing required classes 
import java.util.List;

import com.banka.practice.entity.Department; 
  
// Interface 
public interface DepartmentService { 
  
    // Save operation 
    Department saveDepartment(Department department); 
  
    // Read operation 
    List<Department> fetchDepartmentList(); 
  
    // Update operation 
    Department updateDepartment(Department department, Long departmentId); 
  
    // Delete operation 
    void deleteDepartmentById(Long departmentId);

    Department getDepartmentById(Long departmentId); 

    List<Department> findDepartmentByDepartmentName(String deptName, String sortField);

    
}