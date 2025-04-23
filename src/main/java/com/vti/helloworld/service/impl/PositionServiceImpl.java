package com.vti.helloworld.service.impl;

import com.vti.helloworld.entity.Position;
import com.vti.helloworld.modal.PositionCreateDto;
import com.vti.helloworld.modal.PositionSearchDto;
import com.vti.helloworld.modal.PositionUpdateDto;
import com.vti.helloworld.repository.PositionRepository;
import com.vti.helloworld.repository.specification.PositionSecification;
import com.vti.helloworld.service.PositionService;
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
public class PositionServiceImpl implements PositionService {
    final PositionRepository positionRepository;


    @Override
    public List<Position> getAll() {
        return positionRepository.findAll();
    }

    @Override
    public Page<Position> search(PositionSearchDto request) {
        Specification<Position> condition = PositionSecification.buildCondition(request);

        // Tạo phân trang, sắp xếp
        Sort sort = null;
        if ("ASC".equalsIgnoreCase(request.getSortType())) {
            sort = Sort.by(request.getSortBy()).ascending();
        } else {
            sort = Sort.by(request.getSortBy()).descending();
        }

        // Tạo ra đối tượng Pageable có sắp xếp
        Pageable pageable = PageRequest.of(request.getPage()-1, request.getSize(), sort);
        Page<Position> page = positionRepository.findAll(condition, pageable);
        return page;
    }

    @Override
    public Position create(PositionCreateDto position) {
        Position checker = positionRepository.findByPositionName(position.getPositionName());
        if (checker != null) {
            System.err.println("Position đã tồn tại!");
            return null;
        }
        Position entity = new Position();
        entity.setPositionName(position.getPositionName());
        return positionRepository.save(entity);
    }

    @Override
    public Position update(PositionUpdateDto position) {
        int id = position.getPositionId();
        Position entity = positionRepository.findById(id).orElse(null);
        if (entity == null) {
            System.err.println("Position không tồn tại!");
            return null;
        }
        Position.PositionName positionName = position.getPositionName();
        entity.setPositionName(positionName);
        return positionRepository.save(entity);
    }

    @Override
    public Position findById(int id) {
        Optional<Position> optinal= positionRepository.findById(id);
        if (optinal.isPresent()) {
            return optinal.get();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        Position entity = findById(id);
        if (entity == null) {
            System.err.println("Position không tồn tại!");
            return;
        }
        positionRepository.deleteById(id);
    }
}
