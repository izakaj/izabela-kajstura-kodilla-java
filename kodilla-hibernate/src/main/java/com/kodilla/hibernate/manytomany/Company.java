package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
        name = "Company.retrieveCompaniesWithNamesBeginningWith",
        query = " SELECT * FROM COMPANIES " +
                " WHERE LEFT(COMPANY_NAME,3) = :FIRST ",
        resultClass = Company.class
)
@NamedQuery(
        name = "Company.findCompaniesWithNamesContaining",
        query = " FROM Company WHERE name LIKE :ARG"
)

@Entity
@Table(name = "COMPANIES")
public class Company {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    private int id;

    @NotNull
    @Column(name = "COMPANY_NAME")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company name = " + name;
    }
}
