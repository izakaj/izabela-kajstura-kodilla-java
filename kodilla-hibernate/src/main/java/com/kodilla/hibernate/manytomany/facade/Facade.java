package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;

@Service
public final class Facade {

    private static final Logger LOGGER = LoggerFactory.getLogger(Facade.class);
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    public void processSearch(final String partOfCompanyName,
                              final String partOfEmployeeName) {
            LOGGER.info("Start companies search");
            List<Company> foundCompanies =
                    companyDao.findCompaniesWithNamesContaining(partOfCompanyName);
            System.out.println(foundCompanies);
            LOGGER.info("Companies search done");

            LOGGER.info("Start employees search");
            List<Employee> foundEmployees =
                    employeeDao.findEmployeeWithNameContaining(partOfEmployeeName);
            System.out.println(foundEmployees);
            LOGGER.info("Employees search done");
    }
}
