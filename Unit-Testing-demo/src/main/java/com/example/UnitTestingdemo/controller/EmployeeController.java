package com.example.UnitTestingdemo.controller;
import com.example.UnitTestingdemo.dto.EmployeeDetailRequest;
import com.example.UnitTestingdemo.entity.Employee;
import com.example.UnitTestingdemo.exception.IdCardNotAllocatedException;
import com.example.UnitTestingdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    ResponseEntity<Long> createEmp(@RequestBody EmployeeDetailRequest request) throws IdCardNotAllocatedException {
        Long id = employeeService.createEmpTxn(request);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getBranchById(@PathVariable Long id){
        Employee employee = employeeService.getById(id);
        return ResponseEntity.ok(employee);
    }


    @GetMapping("/getAll")
    ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }
}
