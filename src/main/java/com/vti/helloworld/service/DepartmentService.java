package com.vti.helloworld.service;

import com.vti.helloworld.entity.Department;
import com.vti.helloworld.modal.DepartmentCreateDto;
import com.vti.helloworld.modal.DepartmentSearchDto;
import com.vti.helloworld.modal.DepartmentUpdateDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DepartmentService {
    List<Department> getAll();

    Page<Department> search(DepartmentSearchDto request);
    Department create(DepartmentCreateDto department);
    Department update(DepartmentUpdateDto department);
    Department findById(int id);

    List<Department> findAllByDepartmentNameContains(String departmentName);


    void delete(int id);

}
