package com.vti.helloworld.service.impl;

import com.vti.helloworld.entity.Department;
import com.vti.helloworld.modal.DepartmentCreateDto;
import com.vti.helloworld.modal.DepartmentUpdateDto;
import com.vti.helloworld.repository.DepartmentRepository;
import com.vti.helloworld.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    final DepartmentRepository departmentRepository ;

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department create(DepartmentCreateDto dto) {
        Department entity = new Department();
        entity.setDepartmentName(dto.getDepartmentName());
        return departmentRepository.save(entity);
    }

    @Override
    public Department update(DepartmentUpdateDto dto) {
        int id = dto.getDepartmentId();
        Department entity = findById(id);
        String newName = dto.getDepartmentName();
        entity.setDepartmentName(newName);
        return departmentRepository.save(entity);
    }

    @Override
    public Department findById(int id) {
        Optional<Department> optional = departmentRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        departmentRepository.deleteById(id);
    }
}
