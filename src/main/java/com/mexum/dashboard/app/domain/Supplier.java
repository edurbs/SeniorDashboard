package com.mexum.dashboard.app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Size(max = 50)
    @NotNull
    @Column(name = "ApeFor", nullable = false, length = 50)
    private String tradeName;
}
