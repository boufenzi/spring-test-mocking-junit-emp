package angular.spring.employeeManager.controllers;

import angular.spring.employeeManager.models.Employee;
import angular.spring.employeeManager.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


@WebMvcTest()
@ActiveProfiles("test")
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    EmployeeService employeeService;

    @Test
    void getAll() throws Exception {
        Mockito.when(employeeService.findAll())
                .thenReturn(List.of(new Employee((long)1,"Abdel", "a@gmail.com", "engineer",
                        "0654215487", "http://url.com","AA548789" )));

        mockMvc.perform(MockMvcRequestBuilders.get("/employee/getEmployees").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("Abdel")));
    }

    @Test
    void employeeById() throws Exception {
        Mockito.when(employeeService.findById(any(Long.class)))
                .thenReturn(new Employee((long)1,"Abdel", "a@gmail.com", "engineer",
                        "0654215487", "http://url.com","AA548789" ));

        mockMvc.perform(MockMvcRequestBuilders.get("/employee/getEmployeeById?id=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Abdel")));
    }

    @Test
    void addEmployee() throws Exception {

        Mockito.when(employeeService.add(any(Employee.class)))
                .thenReturn(new Employee((long)1,"Abdel", "a@gmail.com", "engineer",
                        "0654215487", "http://url.com","AA548789" ));
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders.post("/employee/addEmployee").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new Employee((long)1,"Abdel", "a@gmail.com",
                                "engineer",
                                "0654215487", "http://url.com","AA548789" ))))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Abdel")));

    }

    @Test
    void updateEmployee() {
    }

    @Test
    void deleteEmployeeById() {
    }
}