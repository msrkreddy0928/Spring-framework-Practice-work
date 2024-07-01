package com.example.UnitTestingdemo.Service;

import com.example.UnitTestingdemo.dto.EmployeeDetailRequest;
import com.example.UnitTestingdemo.entity.Address;
import com.example.UnitTestingdemo.entity.Employee;
import com.example.UnitTestingdemo.repo.EmployeeRepo;
import com.example.UnitTestingdemo.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {
    private AutoCloseable autoCloseable;

    @Mock
    private EmployeeRepo employeeRepoMock;
    private EmployeeService employeeService;

    private Employee employee;
    private EmployeeDetailRequest employeeDetailRequest;


    @BeforeEach
    public void setup(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeService(employeeRepoMock);

        Address address = Address.builder()
                .id(1l)
                .line1("A-1")
                .line2("Sector-10")
                .city("Delhi")
                .build();

        employee = Employee.builder()
                .id(11l)
                .email("emp1@yopmail.com")
                .name("Rahul")
                .address(address)
                .build();

        employeeDetailRequest = EmployeeDetailRequest.builder()
                .empEmail("emp1@yopmail.com")
                .empName("Rahul")
                .line1("A-1")
                .line2("Sector-10")
                .city("Delhi")
                .build();

    }

    @AfterEach
    public void tearDown() throws Exception {
        autoCloseable.close();;
    }

    @Test
    public void testCreateEmp(){
        when(employeeRepoMock.save(any())).thenReturn(employee);
        Employee actualEmp = employeeService.createEmp(employeeDetailRequest);
        assertThat(actualEmp.getId()).isEqualTo(employee.getId());
    }

    @Test
    public void testGetId(){
        when(employeeRepoMock.findById(11l)).thenReturn(Optional.of(employee));
        Employee actualEmp = employeeService.getById(11l);
        assertThat(actualEmp).isEqualTo(employee);
    }


}
