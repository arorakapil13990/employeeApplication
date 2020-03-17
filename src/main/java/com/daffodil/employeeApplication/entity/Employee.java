package com.daffodil.employeeApplication.entity;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import javax.persistence.*;

@Entity
@ApiOperation(value = "employee", notes = "Contains information about Employee")
public class Employee {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "Primary key of Employee", name = "id")
    private long id;

    @ApiModelProperty(notes = "Name of an Employee", name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ApiModelProperty(notes = "Department of an Employee", name = "department")
    private Department department;

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
