package angular.spring.employeeManager;

import angular.spring.employeeManager.models.Employee;
import angular.spring.employeeManager.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagerApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeService.add(new Employee((long)1,"Abdel", "a@gmail.com", "engineer",
				"0654215487", "http://url.com","AA548789" ));

		employeeService.add(new Employee((long)2,"bouf", "a@gmail.com", "engineer",
				"0654215487", "http://url.com","AA548789" ));

		employeeService.add(new Employee((long)3,"enzi", "a@gmail.com", "engineer",
				"0654215487", "http://url.com","AA548789" ));

	}
}
