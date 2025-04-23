package com.vti.helloworld.modal;

import com.vti.helloworld.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionCreateDto {
    private Position.PositionName positionName;
}
