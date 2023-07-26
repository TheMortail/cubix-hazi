package hu.cubix.spring.gyuri.hr;

import hu.cubix.spring.gyuri.hr.model.Employee;
import hu.cubix.spring.gyuri.hr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class HrApplication implements CommandLineRunner {

	@Autowired
	private SalaryService salaryService;

	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee1 = new Employee(1L,"junior developer", 	100000 , LocalDateTime.of(2023, 4, 18, 14, 0));
		Employee employee2 = new Employee(1L,"junior developer", 	100000 , LocalDateTime.of(2020, 10, 15, 12, 0));
		Employee employee3 = new Employee(2L,"developer",		 	200000 , LocalDateTime.of(2016, 8, 5, 17, 0));
		Employee employee4 = new Employee(3L,"senior developer", 	400000 , LocalDateTime.of(1995, 2, 21, 13, 0));

		System.out.println("Before");
		System.out.println("----------");
		System.out.printf("id:%d, job:%s, salary:%d, start:%s%n",employee1.getId(), employee1.getJob(), employee1.getSalary(), employee1.getStartDate());
		System.out.printf("id:%d, job:%s, salary:%d, start:%s%n",employee2.getId(), employee2.getJob(), employee2.getSalary(), employee2.getStartDate());
		System.out.printf("id:%d, job:%s, salary:%d, start:%s%n",employee3.getId(), employee3.getJob(), employee3.getSalary(), employee3.getStartDate());
		System.out.printf("id:%d, job:%s, salary:%d, start:%s%n",employee4.getId(), employee4.getJob(), employee4.getSalary(), employee4.getStartDate());
		System.out.println("----------");

		salaryService.setNewSalary(employee1);
		salaryService.setNewSalary(employee2);
		salaryService.setNewSalary(employee3);
		salaryService.setNewSalary(employee4);

		System.out.println("After");
		System.out.println("----------");
		System.out.printf("id:%d, job:%s, salary:%d, start:%s%n",employee1.getId(), employee1.getJob(), employee1.getSalary(), employee1.getStartDate());
		System.out.printf("id:%d, job:%s, salary:%d, start:%s%n",employee2.getId(), employee2.getJob(), employee2.getSalary(), employee2.getStartDate());
		System.out.printf("id:%d, job:%s, salary:%d, start:%s%n",employee3.getId(), employee3.getJob(), employee3.getSalary(), employee3.getStartDate());
		System.out.printf("id:%d, job:%s, salary:%d, start:%s%n",employee4.getId(), employee4.getJob(), employee4.getSalary(), employee4.getStartDate());
		System.out.println("----------");
	}
}
