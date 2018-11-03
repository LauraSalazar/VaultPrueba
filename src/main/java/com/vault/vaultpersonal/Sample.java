package com.vault.vaultpersonal;
import org.springframework.web.bind.annotation.RestController;

import dbaccess.vault.EmployeeDAO;
import model.Employee;


import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Sample {


    @RequestMapping("/")
    public String index() {

        
        Employee e = new Employee();
        e.setFirstName("Carmen");
        
        EmployeeDAO eDAO = new EmployeeDAO();
        eDAO.create(e);
        
        return "Greetings from Spring Boot! 2";
    }

}
