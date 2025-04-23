package com.vti.helloworld.repository;

import com.vti.helloworld.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {
    Department findByDepartmentName(String departmentName);

    List<Department> findAllByDepartmentNameContains(String departmentName);
}
