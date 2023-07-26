package hu.cubix.spring.gyuri.hr.model;

import java.time.LocalDateTime;

public class Employee {
    public Employee(Long id, String job, int salary, LocalDateTime startDate) {
        this.id = id;
        this.job = job;
        this.salary = salary;
        this.startDate = startDate;
    }

    private Long id;
    private String job;
    private int salary;
    private LocalDateTime startDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
}
