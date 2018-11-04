package com.vault.vaultpersonal;

import java.time.LocalDate;

import org.springframework.expression.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dbaccess.vault.EmployeeDAO;
import model.Country;
import model.Department;
import model.Employee;
import model.Job;
import model.JobHistory;
import model.Location;
import model.Region;

@RestController
public class GenerateDB {
	@RequestMapping("/generate")
    public String index() {

        
        try {
        	
        Region r1 = new Region("Europe MidleEast Africa");
  
        Region r2 = new Region("Latin america");
        
        Country c6 = new Country("Mexico",r2);
        
        Country c7 = new Country("Honduras",r2);

        Country c8 = new Country("Kuwait",r1);
             
        
        Location l3 = new Location("Avenida Libertadores", "3332", "DF", "DF District", c6);
        
        Location l7 = new Location("San Cristobal", "3111", "Caracas", "Caracas", c7);
        
        Location l8 = new Location("Level 5", "4231", "Kiwi", "Kiwi", c8);
        
        Department d1 = new Department();
        
        Department d2 = new Department();
        
        Department d3 = new Department();
        
        Department d4 = new Department();
        
        Job j1 = new Job("Manager",new Integer(1400), new Integer(3000));

        Job j2 = new Job("Developer",new Integer(900), new Integer(1000));
        
        JobHistory jh1 = new JobHistory();
        
        JobHistory jh2 = new JobHistory();
        
        JobHistory jh3 = new JobHistory();
        
        JobHistory jh4 = new JobHistory();
        
        JobHistory jh5 = new JobHistory();
        
        JobHistory jh6 = new JobHistory();
        
        JobHistory jh7 = new JobHistory();
        
        JobHistory jh8 = new JobHistory();
        
        
        Employee e1=null,e2=null,e3=null,e4=null,e5=null,e6=null;
        	
        e1 = new Employee("Ana","Gomez","email1","number1",(LocalDate.parse("2009-12-31")),j1,new Double(1500.00),new Double(20.00),null,d1);
        
        e2 = new Employee("Pedro","Perez","email2","number2",(LocalDate.parse("2010-12-31")),j1,new Double(2500.00),new Double(20.00),null,d2);;
        
        e3 = new Employee("Juan","Aguirre","email3","number3",(LocalDate.parse( "2001-12-31")),j2,new Double(950.00),new Double(15.00),e1,d3);;
        
        e4 = new Employee("Employee4","LastName4","email4","number4",(LocalDate.parse( "2008-12-31")),j2,new Double(960.00),new Double(15.00),e1,d4);
        
        e5 = new Employee("Employee5","LastName5","email5","number5",(LocalDate.parse( "2006-12-31")),j2,new Double(970.00),new Double(15.00),e2,d2);
        
        e6 = new Employee("Employee6","LastName6","email6","number6",(LocalDate.parse( "2005-12-31")),j2,new Double(980.00),new Double(15.00),e2,d3);
        

        System.out.println("Antes de imprimir el nombre de Ana");
        System.out.println("El nombre de ana es: " + e1.getFirstName());
        
        d1.setDepartmentName("department1");
        d1.setManager(e1);
        d1.setLocation(l3);
        
        d2.setDepartmentName("department2");
        d2.setManager(e1);
        d2.setLocation(l7);
        
        d3.setDepartmentName("department3");
        d3.setManager(e2);
        d3.setLocation(l8);
        
        d4.setDepartmentName("department4");
        d4.setManager(e2);
        d4.setLocation(l7);
        
        jh1.setEmployee(e1);
        jh1.setStartDate((LocalDate.parse( "2008-12-31")));
        jh1.setEndDate((LocalDate.parse( "2011-12-31")));
        jh1.setDepartment(d1);
        jh1.setJob(j2);
        
        System.out.println("Antes del primer addHistory " + e1.getJobHistories());
        e1.addJobHistory(jh1);
        
        jh2.setEmployee(e1);
        jh2.setStartDate((LocalDate.parse( "2011-12-31")));
        jh2.setEndDate((LocalDate.parse( "2018-12-31")));
        jh2.setDepartment(d2);
        jh2.setJob(j1);
        
        e1.addJobHistory(jh2);
        
        jh3.setEmployee(e2);
        jh3.setStartDate((LocalDate.parse( "2008-12-31")));
        jh3.setEndDate((LocalDate.parse( "2011-12-31")));
        jh3.setDepartment(d3);
        jh3.setJob(j2);
        
        e2.addJobHistory(jh3);
        
        jh4.setEmployee(e2);
        jh4.setStartDate((LocalDate.parse( "2011-12-31")));
        jh4.setEndDate((LocalDate.parse( "2018-12-31")));
        jh4.setDepartment(d4);
        jh4.setJob(j1);
        
        e2.addJobHistory(jh4);
        
        jh5.setEmployee(e3);
        jh5.setStartDate((LocalDate.parse("2001-12-31")));
        jh5.setEndDate((LocalDate.parse("2018-12-31")));
        jh5.setDepartment(d1);
        jh5.setJob(j2);
        
        e3.addJobHistory(jh5);
        
        jh6.setEmployee(e4);
        jh6.setStartDate((LocalDate.parse( "2008-12-31")));
        jh6.setEndDate((LocalDate.parse( "2018-12-31")));
        jh6.setDepartment(d2);
        jh6.setJob(j2);
        
        e4.addJobHistory(jh6);
        
        jh7.setEmployee(e5);
        jh7.setStartDate((LocalDate.parse( "2006-12-31")));
        jh7.setEndDate((LocalDate.parse( "2018-12-31")));
        jh7.setDepartment(d3);
        jh7.setJob(j2);
        
        e5.addJobHistory(jh7);
        
        jh8.setEmployee(e6);
        jh8.setStartDate((LocalDate.parse( "2005-12-31")));
        jh8.setEndDate((LocalDate.parse( "2018-12-31")));
        jh8.setDepartment(d4);
        jh8.setJob(j2);
        
        e6.addJobHistory(jh8);

        EmployeeDAO eDAO = new EmployeeDAO();
        eDAO.create(e1);
        eDAO.create(e2);
        eDAO.create(e3);
        eDAO.create(e4);
        eDAO.create(e5);
        eDAO.create(e6);
        }
        catch (ParseException e) {
        	e.printStackTrace();
        } 
        return "Base Generada!!";
    }
}
