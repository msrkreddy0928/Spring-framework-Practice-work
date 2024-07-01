package com.example.UnitTestingdemo.Integration;

import com.example.UnitTestingdemo.dto.EmployeeDetailRequest;
import com.example.UnitTestingdemo.entity.Address;
import com.example.UnitTestingdemo.entity.Employee;
import com.example.UnitTestingdemo.repo.EmployeeRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Abstract2DArrayAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = ("classpath:application-it.properties")
)
public class IntegrationTest {
   @Autowired
    private MockMvc mockMvc;
    @Autowired
    private EmployeeRepo employeeRepo;
    private Employee employee;
    private EmployeeDetailRequest employeeDetailRequest;

    @BeforeEach
    public  void setup(){
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
    @Test
    public void testCreateEmpAPI() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonData = objectMapper.writeValueAsString(employeeDetailRequest);

        mockMvc.perform(post("/emp")
                .contentType("application/json")
                .content(jsonData))
                .andDo(print()).andExpect(status().isOk());
              Employee employee1 =employeeRepo.findByEmail("emp1@yopmail.com");
              assertThat(employee1).isEqualTo(employee);






    }



    }








