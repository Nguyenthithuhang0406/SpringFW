package com.vti.helloworld.service.impl;

import com.vti.helloworld.entity.Department;
import com.vti.helloworld.modal.DepartmentCreateDto;
import com.vti.helloworld.modal.DepartmentSearchDto;
import com.vti.helloworld.modal.DepartmentUpdateDto;
import com.vti.helloworld.repository.DepartmentRepository;
import com.vti.helloworld.repository.specification.DepartmentSepcification;
import com.vti.helloworld.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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
    public Page<Department> search(DepartmentSearchDto request) {
        Specification<Department> condition = DepartmentSepcification.buildCondition(request);
// Tạo phân trang, sắp xếp
        Sort sort = null;
        if ("ASC".equalsIgnoreCase(request.getSortType())){
            sort = Sort.by(request.getSortBy()).ascending();
        } else {
            sort = Sort.by(request.getSortBy()).descending();
        }
// Tạo ra đối tượng Pageable có sắp xếp
        Pageable pageable = PageRequest.of(request.getPage()-1, request.getSize(), sort);

        Page<Department> page = departmentRepository.findAll(condition, pageable);

        return page;
    }

    @Override
    public Department create(DepartmentCreateDto dto) {
        Department checker = departmentRepository.findByDepartmentName(dto.getDepartmentName());
        if (checker != null) {
            System.err.println("Department đã tồn tại!");
            return null;
        }
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

    @Override
    public List<Department> findAllByDepartmentNameContains(String departmentName) {
        return departmentRepository.findAllByDepartmentNameContains(departmentName);
    }
}
