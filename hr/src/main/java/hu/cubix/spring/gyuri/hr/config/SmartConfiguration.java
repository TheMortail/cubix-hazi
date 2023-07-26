package hu.cubix.spring.gyuri.hr.config;

import hu.cubix.spring.gyuri.hr.service.EmployeeService;
import hu.cubix.spring.gyuri.hr.service.SmartEmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("smart")
public class SmartConfiguration {
    @Bean
    public EmployeeService employeeService(){
        return new SmartEmployeeService();
    }
}
