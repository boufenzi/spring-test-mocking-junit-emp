package angular.spring.employeeManager.services;

import angular.spring.employeeManager.exceptions.UserNotFoundException;
import angular.spring.employeeManager.models.Employee;
import angular.spring.employeeManager.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee add(Employee employee){
        return employeeRepo.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Employee findById(Long id){
        return employeeRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("this employee having the id %s were not found", id)));
    }

    public Employee update(Employee employee){
        return employeeRepo.save(employee);
    }

    public void delete(Long id) {
        employeeRepo.deleteById(id);
    }


}
