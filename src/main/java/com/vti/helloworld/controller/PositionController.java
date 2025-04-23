package com.vti.helloworld.controller;

import com.vti.helloworld.entity.Position;
import com.vti.helloworld.modal.PositionCreateDto;
import com.vti.helloworld.modal.PositionSearchDto;
import com.vti.helloworld.modal.PositionUpdateDto;
import com.vti.helloworld.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/position")
public class PositionController {
    @Autowired
    PositionService positionService;

    @GetMapping
    public List<Position> getAll() {
        return positionService.getAll();
    }

    @GetMapping("/search")
    public Page<Position> search(PositionSearchDto request) {
        return positionService.search(request);
    }

    @PostMapping("/create")
    public Position create(@RequestBody PositionCreateDto dto){
        return positionService.create(dto);
    }

    @PutMapping("/update")
    public Position update(@RequestBody PositionUpdateDto dto){
        return positionService.update(dto);
    }

    @GetMapping("/{id}")
    public Position findById(@PathVariable(value = "id") int id){
        return positionService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") int id){
        positionService.delete(id);
    }
}
