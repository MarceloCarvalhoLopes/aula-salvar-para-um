package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Person;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDto {

    private Long id;
    private String name;

    public DepartmentDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
