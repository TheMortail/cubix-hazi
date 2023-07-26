package hu.cubix.spring.gyuri.hr.service;

import hu.cubix.spring.gyuri.hr.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {
    private EmployeeService employeeService;
    public SalaryService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setNewSalary(Employee employee){
        employee.setSalary(employeeService.getPayRaisePercent(employee));
    }
}
