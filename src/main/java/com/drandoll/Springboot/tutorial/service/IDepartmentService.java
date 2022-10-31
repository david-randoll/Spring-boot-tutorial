package com.drandoll.Springboot.tutorial.service;

import com.drandoll.Springboot.tutorial.entity.Department;
import com.drandoll.Springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface IDepartmentService {
    Department SaveDepartment(Department department);

    List<Department> FetchDepartmentList();

    Department FetchDepartmentById(Long id) throws DepartmentNotFoundException;

    void DeleteDepartmentById(Long id);

    Department UpdateDepartment(Long id, Department department) throws DepartmentNotFoundException;

    Department FetchDepartmentByName(String name);
}
