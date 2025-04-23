package com.vti.helloworld.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentSearchDto {
    private String name;
    private Date fromDate;
    private Date toDate;

    // cac doi tuong de phan trang
    private int page;
    private int size;
    private String sortBy = "departmentId";
    private String sortType = "DESC";
}
