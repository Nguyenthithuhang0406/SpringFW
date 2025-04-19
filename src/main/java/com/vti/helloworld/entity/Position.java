package com.vti.helloworld.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "position")
@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int positionId;

    @Column(name = "PositionName")
    @Enumerated(EnumType.STRING)
    private PositionName positionName;

    public static enum PositionName {
        DEV, TEST, SCRUM_MASTER, PM
    }
}
