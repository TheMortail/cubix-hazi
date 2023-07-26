package hu.cubix.spring.gyuri.hr.service;

import hu.cubix.spring.gyuri.hr.config.HrConfigurationProperties;
import hu.cubix.spring.gyuri.hr.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SmartEmployeeService implements EmployeeService{

//    @Value("${hr.salary.limit1}")
//    private float limit1;
//    @Value("${hr.salary.limit2}")
//    private float limit2;
//    @Value("${hr.salary.limit3}")
//    private float limit3;

    @Autowired
    private HrConfigurationProperties config;

    @Override
    public int getPayRaisePercent(Employee employee) {
        int difference = LocalDate.now().getYear() - employee.getStartDate().getYear();
        if (config.getSalary().getLimit3() <= difference){
            return (int)(employee.getSalary() * 1.1);
        }else if (config.getSalary().getLimit2() <= difference){
            return (int)(employee.getSalary() * 1.05);
        }else if (config.getSalary().getLimit1() <= difference){
            return (int)(employee.getSalary() * 1.02);
        }else{
            return employee.getSalary();
        }
    }
}
