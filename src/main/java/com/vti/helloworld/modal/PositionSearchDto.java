package com.vti.helloworld.modal;

import com.vti.helloworld.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionSearchDto {
    private Position.PositionName positionName;
    private int page;
    private int size;
    private String sortBy = "positionId";
    private String sortType = "ASC";
}
