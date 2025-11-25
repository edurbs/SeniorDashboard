package com.mexum.dashboard.app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "SAPIENS.E095FOR")
public class Supplier {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "CodFor", nullable = false, precision = 9)
    private int id;

}
