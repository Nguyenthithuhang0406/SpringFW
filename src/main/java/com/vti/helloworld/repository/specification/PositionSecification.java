package com.vti.helloworld.repository.specification;

import com.vti.helloworld.entity.Position;
import com.vti.helloworld.modal.PositionSearchDto;
import org.springframework.data.jpa.domain.Specification;

public class PositionSecification {
    public static Specification<Position> buildCondition(PositionSearchDto request) {
        return Specification.where(buildName(request));
    }

    private static Specification<Position> buildName(PositionSearchDto request){
        if(request.getPositionName() == null || request.getPositionName().equals("")){
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("positionName"), "%" + request.getPositionName() + "%");
        });
    }
}
