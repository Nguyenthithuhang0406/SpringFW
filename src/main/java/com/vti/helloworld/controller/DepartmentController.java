package com.vti.helloworld.controller;

import com.vti.helloworld.entity.Department;
import com.vti.helloworld.modal.DepartmentCreateDto;
import com.vti.helloworld.modal.DepartmentUpdateDto;
import com.vti.helloworld.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Dinh nghia la 1 bin
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public List<Department> getAll() {
        return departmentService.getAll();
    }

    @PostMapping("/create")
    public Department create(@RequestBody DepartmentCreateDto department) {
        return departmentService.create(department);
    }

    @PutMapping("/update")
    public Department update(@RequestBody DepartmentUpdateDto dto) {
        return departmentService.update(dto);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable(value = "id") int id) {
        return departmentService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") int id) {
        departmentService.delete(id);
    }
}
