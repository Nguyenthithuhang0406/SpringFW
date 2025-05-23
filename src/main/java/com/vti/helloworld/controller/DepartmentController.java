package com.vti.helloworld.controller;

import com.vti.helloworld.entity.Department;
import com.vti.helloworld.modal.DepartmentCreateDto;
import com.vti.helloworld.modal.DepartmentSearchDto;
import com.vti.helloworld.modal.DepartmentUpdateDto;
import com.vti.helloworld.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//Dinh nghia la 1 bin
@RestController
@RequestMapping("/api/v1/department")
@Validated
@CrossOrigin("http://localhost:5173")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Department> getAll() {
        return departmentService.getAll();
    }

    @GetMapping("/search")
    public Page<Department> search(DepartmentSearchDto request) {
        return departmentService.search(request);
    }

    @PostMapping("/create")
    public Department create(@RequestBody @Valid DepartmentCreateDto department) {
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

    @GetMapping("/searchNoPage")
    public List<Department> findAllByDepartmentNameContains(@RequestParam(value = "name") String departmentName) {
        return departmentService.findAllByDepartmentNameContains(departmentName);
    }
}
