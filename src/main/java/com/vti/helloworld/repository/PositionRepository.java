package com.vti.helloworld.repository;

import com.vti.helloworld.entity.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
    Position findByPositionName(Position.PositionName positionName);

    Page<Position> findAll(Specification<Position> condition, Pageable pageable);
}
