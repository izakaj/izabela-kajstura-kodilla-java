package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacadeTest {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    Facade facade;


    @Test
    public void testFacade() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee annaSmith = new Employee("Anna", "Smith");
        Employee marthaJones = new Employee("Martha", "Jones");

        Company destiny = new Company("DESTINY");
        Company destruction = new Company("DESTRUCTION");
        Company exportex = new Company("EXPORTEX");

        destiny.getEmployees().add(johnSmith);
        destruction.getEmployees().add(annaSmith);
        destruction.getEmployees().add(marthaJones);
        exportex.getEmployees().add(johnSmith);
        exportex.getEmployees().add(marthaJones);

        johnSmith.getCompanies().add(destiny);
        johnSmith.getCompanies().add(exportex);
        annaSmith.getCompanies().add(destruction);
        marthaJones.getCompanies().add(destruction);
        marthaJones.getCompanies().add(exportex);

        //When
        companyDao.save(destiny);
        companyDao.save(destruction);
        companyDao.save(exportex);

        employeeDao.save(johnSmith);
        employeeDao.save(annaSmith);
        employeeDao.save(marthaJones);


        facade.processSearch("%DES%", "%mit%");


        //Then
        //CleanUp
         companyDao.delete(destiny);
         companyDao.delete(destruction);
         companyDao.delete(exportex);
         employeeDao.delete(johnSmith);
         employeeDao.delete(annaSmith);
         employeeDao.delete(marthaJones);
    }

}