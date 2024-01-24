package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.PersonDepartmentDto;
import com.devsuperior.aula.dto.PersonDto;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public PersonDepartmentDto insert(PersonDepartmentDto dto){

        Person entity =  new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        //        Department department = new Department();
        //        department.setId(dto.getDepartment().getId());


        Department department = departmentRepository.getReferenceById(dto.getDepartment().getId());

        entity.setDepartment(department);
        entity = personRepository.save(entity);

        return new PersonDepartmentDto(entity);


    }

    public PersonDto insert(PersonDto dto){

        Person entity =  new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        //        Department department = departmentRepository.getReferenceById(dto.getDepartmentId());
        Department department = new Department();
        department.setId(dto.getDepartmentId());

        entity.setDepartment(department);
        entity = personRepository.save(entity);

        return new PersonDto(entity);

    }


}
