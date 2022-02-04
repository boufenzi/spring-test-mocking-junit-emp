package angular.spring.employeeManager.controllers;

import angular.spring.employeeManager.models.Employee;
import angular.spring.employeeManager.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping(value = "/getEmployees")
    public ResponseEntity<List<Employee>> getAll() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/getEmployeeById")
    public ResponseEntity<Employee> employeeById(@RequestParam("id") Long id) {
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.add(employee), HttpStatus.CREATED);
    }
    @PutMapping(value = "/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.update(employee), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<?> deleteEmployeeById(@RequestParam("id") Long id) {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
