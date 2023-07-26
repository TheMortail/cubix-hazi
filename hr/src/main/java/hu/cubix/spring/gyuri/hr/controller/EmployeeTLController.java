package hu.cubix.spring.gyuri.hr.controller;

import hu.cubix.spring.gyuri.hr.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeTLController {

    private List<Employee> employeeList = new ArrayList<>();

    {
        employeeList.add(new Employee(1L,"junior developer", 	100000 , LocalDateTime.of(2023, 4, 18, 14, 0)));
        employeeList.add(new Employee(2L,"junior developer", 	100000 , LocalDateTime.of(2020, 10, 15, 12, 0)));
        employeeList.add(new Employee(3L,"developer",		 	200000 , LocalDateTime.of(2016, 8, 5, 17, 0)));
        employeeList.add(new Employee(4L,"senior developer", 	400000 , LocalDateTime.of(1995, 2, 21, 13, 0)));
    }

    @GetMapping("/")
    public String home(Map<String, Object> model){
        model.put("employeeList", employeeList);
        return "index";
    }
}
