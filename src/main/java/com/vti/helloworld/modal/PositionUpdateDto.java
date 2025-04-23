package com.vti.helloworld.modal;

import com.vti.helloworld.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionUpdateDto {
    private Integer positionId;
    private Position.PositionName positionName;
}
