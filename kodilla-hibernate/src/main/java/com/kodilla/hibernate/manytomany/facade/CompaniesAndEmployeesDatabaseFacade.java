package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class CompaniesAndEmployeesDatabaseFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompaniesAndEmployeesDatabaseFacade.class);
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    public List<Company> searchCompaniesWithNamesContaining(final String partOfCompanyName) {
            LOGGER.info("Start companies search");
            String partOfCompanyName2 = "%" + partOfCompanyName + "%";
            List<Company> foundCompanies =
                    companyDao.findCompaniesWithNamesContaining(partOfCompanyName2);
            System.out.println(foundCompanies);
            LOGGER.info("Companies search done");
            return foundCompanies;
    }

    public List<Employee> searchEmployeesWithNameContaining(final String partOfEmployeeName) {
        LOGGER.info("Start employees search");
        String partOfEmployeeName2 = "%" + partOfEmployeeName + "%";
        List<Employee> foundEmployees =
                employeeDao.findEmployeeWithNameContaining(partOfEmployeeName2);
        System.out.println(foundEmployees);
        LOGGER.info("Employees search done");
        return foundEmployees;
    }
}
