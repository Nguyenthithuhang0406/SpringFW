package com.vti.helloworld.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @Column(name  = "DepartmentName", length = 50, unique = true, nullable = false)
    private String departmentName;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "UpdateDate")
    private Date updateDate;

    @PrePersist
    private void doCreate() {
        this.createDate = new Date();
    }

    @PreUpdate
    private void doUpdate() {
        this.updateDate = new Date();
    }
}
