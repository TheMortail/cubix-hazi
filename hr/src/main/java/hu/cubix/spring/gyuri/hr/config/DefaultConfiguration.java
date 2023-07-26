package hu.cubix.spring.gyuri.hr.config;

import hu.cubix.spring.gyuri.hr.service.DefaultEmployeeService;
import hu.cubix.spring.gyuri.hr.service.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!smart")
public class DefaultConfiguration {
    @Bean
    public EmployeeService employeeService(){
        return new DefaultEmployeeService();
    }
}
