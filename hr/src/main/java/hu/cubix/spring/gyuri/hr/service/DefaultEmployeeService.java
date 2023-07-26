package hu.cubix.spring.gyuri.hr.service;

import hu.cubix.spring.gyuri.hr.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class DefaultEmployeeService implements EmployeeService{
    @Override
    public int getPayRaisePercent(Employee employee) {
        return (int)(employee.getSalary() * 1.05);
    }
}
