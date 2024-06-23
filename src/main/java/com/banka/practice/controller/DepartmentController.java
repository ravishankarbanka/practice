package com.banka.practice.controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.banka.practice.entity.Department;
import com.banka.practice.service.DepartmentService;

  
// Annotation 
@RestController()
@RequestMapping("dept")
 
// Class 
public class DepartmentController { 
  
    @Autowired private DepartmentService departmentService; 
  

    @GetMapping
    public String getMethodName() {
        return "Reachable";
    }
    

    // Save operation 
    @PostMapping("departments") 
    public Department saveDepartment( 
        @RequestBody Department department) 
    { 
        return departmentService.saveDepartment(department); 
    } 
  
    // Read operation 
    @GetMapping("departments") 
    public List<Department> fetchDepartmentList() 
    { 
        return departmentService.fetchDepartmentList(); 
    } 
  

  // Read operation 
  @GetMapping("departments/search/{dept}") 
  public List<Department> searcDepartments(@PathVariable("dept") String deptName, @RequestParam Map<String, String> queryParam) 
  { 
    System.out.println("---------------------------Dept " + deptName);
    String sortField = ""; 
    if(!queryParam.isEmpty())
        if(queryParam.containsKey("OrderBy"))
        sortField = queryParam.get("OrderBy");

      return departmentService.findDepartmentByDepartmentName( deptName, sortField);
  } 


    // Update operation 
    @GetMapping("departments/{id}") 
    public Department 
    getDepartmentById(@PathVariable("id") Long departmentId) 
    { 
        try {
        return departmentService.getDepartmentById(departmentId); 
        } catch(NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Department with id " + departmentId + "  not found");
        }

    } 

    // Update operation 
    @PutMapping("departments/{id}") 
    public Department 
    updateDepartment(@RequestBody Department department, 
                     @PathVariable("id") Long departmentId) 
    { 
        return departmentService.updateDepartment( 
            department, departmentId); 
    } 
  
    // Delete operation 
    @DeleteMapping("departments/{id}") 
    public String deleteDepartmentById(@PathVariable("id") 
                                       Long departmentId) 
    { 
        departmentService.deleteDepartmentById(departmentId); 
  
        return "Deleted Successfully"; 
    } 
}