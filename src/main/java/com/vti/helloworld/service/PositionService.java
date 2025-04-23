package com.vti.helloworld.service;

import com.vti.helloworld.entity.Department;
import com.vti.helloworld.entity.Position;
import com.vti.helloworld.modal.*;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PositionService {
    List<Position> getAll();
    Page<Position> search(PositionSearchDto request);
    Position create(PositionCreateDto position);
    Position update(PositionUpdateDto position);
    Position findById(int id);
    void delete(int id);
}
