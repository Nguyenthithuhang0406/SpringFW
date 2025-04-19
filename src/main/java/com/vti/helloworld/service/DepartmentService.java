package com.vti.helloworld.service;

import com.vti.helloworld.entity.Department;
import com.vti.helloworld.modal.DepartmentCreateDto;
import com.vti.helloworld.modal.DepartmentUpdateDto;

import java.util.List;

public interface DepartmentService {
    List<Department> getAll();
    Department create(DepartmentCreateDto department);
    Department update(DepartmentUpdateDto department);
    Department findById(int id);

    void delete(int id);

}
