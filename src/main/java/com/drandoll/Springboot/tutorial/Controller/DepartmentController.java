package com.drandoll.Springboot.tutorial.Controller;

import com.drandoll.Springboot.tutorial.entity.Department;
import com.drandoll.Springboot.tutorial.error.DepartmentNotFoundException;
import com.drandoll.Springboot.tutorial.service.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    private IDepartmentService _departmentService;
    private Logger _logger = LoggerFactory.getLogger(DepartmentController.class);

    public DepartmentController(IDepartmentService departmentService) {
        this._departmentService = departmentService;
    }

    @PostMapping("/departments")
    public Department SaveDepartment(@Valid @RequestBody Department department){
        _logger.info("Inside saveDepartment of DepartmentController");
        return _departmentService.SaveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> FetchDepartmentList(){
        _logger.info("Inside FetchDepartmentList of DepartmentController");
        return _departmentService.FetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public  Department FetchDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {

        return _departmentService.FetchDepartmentById(id);
    }

    @DeleteMapping("/departments/{id}")
    public String DeleteDepartmentById(@PathVariable("id") Long id){
        _departmentService.DeleteDepartmentById(id);
        return "Department deleted Successfully!";
    }

    @PutMapping("/departments/{id}")
    public Department UpdateDepartment(@PathVariable("id") Long id, @RequestBody Department department) throws DepartmentNotFoundException {
        return _departmentService.UpdateDepartment(id, department);
    }

    @GetMapping("/departments/name/{name}")
    public  Department FetchDepartmentByName(@PathVariable("name") String name){
        return _departmentService.FetchDepartmentByName(name);
    }
}