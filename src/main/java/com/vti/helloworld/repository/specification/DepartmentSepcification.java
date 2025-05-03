package com.vti.helloworld.repository.specification;

import com.vti.helloworld.entity.Department;
import com.vti.helloworld.modal.DepartmentSearchDto;
import org.springframework.data.jpa.domain.Specification;

public class DepartmentSepcification {

    public static Specification<Department> buildCondition(DepartmentSearchDto request) {
        return Specification.where(buildName(request))
                .and(fromDate(request))
                .and(toDate(request));
    }

    private  static Specification<Department> buildName(DepartmentSearchDto request){
        if(request.getName() == null || request.getName().equals("") ){
            return null;
        }
        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("departmentName"), "%" + request.getName() + "%");
        });

    }

    private static Specification<Department> fromDate(DepartmentSearchDto request){
        if(request.getFromDate() == null){
            return null;
        }
        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.greaterThanOrEqualTo(root.get("createDate"), request.getFromDate());
        });
    }

    private static Specification<Department> toDate(DepartmentSearchDto request){
        if(request.getFromDate() == null){
            return null;
        }
        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.lessThanOrEqualTo(root.get("createDate"), request.getToDate());
        });
    }


}
