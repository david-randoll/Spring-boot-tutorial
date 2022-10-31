package com.drandoll.Springboot.tutorial.service;

import com.drandoll.Springboot.tutorial.entity.Department;
import com.drandoll.Springboot.tutorial.error.DepartmentNotFoundException;
import com.drandoll.Springboot.tutorial.repository.IDepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentService implements IDepartmentService {

    private IDepartmentRepository _repository;

    public DepartmentService(IDepartmentRepository repository) {
        this._repository = repository;
    }

    @Override
    public Department SaveDepartment(Department department) {
        return _repository.save(department);
    }

    @Override
    public List<Department> FetchDepartmentList() {
        return _repository.findAll();
    }

    @Override
    public Department FetchDepartmentById(Long id) throws DepartmentNotFoundException {
        var departmentOptional = _repository.findById(id);
        if(departmentOptional.isPresent() == false) throw new DepartmentNotFoundException("Department Not Available");

        return departmentOptional.get();
    }

    @Override
    public void DeleteDepartmentById(Long id) {
        _repository.deleteById(id);
    }

    @Override
    public Department UpdateDepartment(Long id, Department department) throws DepartmentNotFoundException {
        var existingDepartment = FetchDepartmentById(id);
        if(Objects.nonNull(department.getDepartmentName()) && "".equalsIgnoreCase(department.getDepartmentName()) == false){
            existingDepartment.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && "".equalsIgnoreCase(department.getDepartmentAddress()) == false){
            existingDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && "".equalsIgnoreCase(department.getDepartmentCode()) == false){
            existingDepartment.setDepartmentCode(department.getDepartmentCode());
        }

        return _repository.save(existingDepartment);
    }

    @Override
    public Department FetchDepartmentByName(String name) {
        return _repository.findByDepartmentNameIgnoreCase(name);
    }
}
