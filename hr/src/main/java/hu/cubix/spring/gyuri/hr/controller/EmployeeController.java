package hu.cubix.spring.gyuri.hr.controller;

import hu.cubix.spring.gyuri.hr.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private Map<Long, EmployeeDto> employeeList = new HashMap<>();

    {
        employeeList.put(1L, new EmployeeDto(1L,"junior developer", 	100000 , LocalDateTime.of(2023, 4, 18, 14, 0)));
        employeeList.put(2L, new EmployeeDto(2L,"junior developer", 	100000 , LocalDateTime.of(2020, 10, 15, 12, 0)));
        employeeList.put(3L, new EmployeeDto(3L,"developer",		 	200000 , LocalDateTime.of(2016, 8, 5, 17, 0)));
        employeeList.put(4L, new EmployeeDto(4L,"senior developer", 	400000 , LocalDateTime.of(1995, 2, 21, 13, 0)));
    }

    @GetMapping
    public List<EmployeeDto> getAll(){
        return new ArrayList<>(employeeList.values());
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto dto){
        if (employeeList.containsKey(dto.getId())){
            return ResponseEntity.badRequest().build();
        }
        employeeList.put(dto.getId(), dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable Long id){
        if (!employeeList.containsKey(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeList.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable Long id, @RequestBody EmployeeDto dto){
       dto.setId(id);
       if (!employeeList.containsKey(id)){
           return ResponseEntity.notFound().build();
       }
       employeeList.put(id, dto);
       return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        employeeList.remove(id);
    }

    @GetMapping("/higherThan/{value}")
    public List<EmployeeDto> findAllWithHigherSalary(@PathVariable Long value){
        return employeeList.values().stream().filter(employee->employee.getSalary()>value).collect(Collectors.toList());
    }

}
