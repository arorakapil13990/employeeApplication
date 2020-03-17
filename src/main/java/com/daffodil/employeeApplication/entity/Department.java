package com.daffodil.employeeApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import javax.persistence.*;
import java.util.List;

@Entity
@ApiOperation(value = "department", notes = "Contains information about Department")
public class Department {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "Primary key of Department", name = "id")
    private long id;

    @ApiModelProperty(notes = "Name of Department", name = "id")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    @ApiModelProperty(notes = "List of Employees in a Department", name = "id")
    @JsonIgnore
    private List<Employee> employees;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
