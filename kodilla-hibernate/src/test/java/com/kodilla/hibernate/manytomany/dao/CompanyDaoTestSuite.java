package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;


    @Test
    public void testNamedQueries() {
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

        List<Employee> theSmiths = employeeDao.retrieveEmployeesWithLastnameBeing("Smith");
        System.out.println(theSmiths.size());

        List<Company> companiesDes = companyDao.retrieveCompaniesWithNamesBeginningWith("DES");

        //Then
        try {
            Assert.assertEquals(2, theSmiths.size());
            Assert.assertEquals(2, companiesDes.size());
        } finally {
            //CleanUp
            companyDao.delete(destiny);
            companyDao.delete(destruction);
            companyDao.delete(exportex);
            employeeDao.delete(johnSmith);
            employeeDao.delete(annaSmith);
            employeeDao.delete(marthaJones);
        }

    }

        /* test Kodilli

    @Test
    public void testSaveManyToMany() {


        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    */
}
