package com.vti.helloworld.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentCreateDto {
    @NotBlank(message = "Tên phòng ban không được để trống!")
    @Length(max = 50, message = "Tên phòng ban không được quá 50 ký tự!")
    private String departmentName;
}
