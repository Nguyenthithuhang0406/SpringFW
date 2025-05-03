package com.vti.helloworld.utils;

import org.springframework.data.jpa.domain.Specification;

public class SpecificationCustom<E> {
    public Specification<?> like(String key, String value){
        if(value == null || value.equals("") ){
            return null;
        }
        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get(key), "%" + value + "%");
        });

    }
}
