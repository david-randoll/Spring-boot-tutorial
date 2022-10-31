package com.drandoll.Springboot.tutorial.service;

import com.drandoll.Springboot.tutorial.entity.Department;
import com.drandoll.Springboot.tutorial.repository.IDepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private IDepartmentService _departmentService;

    @MockBean
    private IDepartmentRepository _departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                                .departmentName("IT")
                                .departmentAddress("Ahmedabad")
                                .departmentCode("IT-06")
                                .departmentId(1L)
                                .build();
        Mockito.when(_departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on Valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        var departmentName = "IT";
        var found = _departmentService.FetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}