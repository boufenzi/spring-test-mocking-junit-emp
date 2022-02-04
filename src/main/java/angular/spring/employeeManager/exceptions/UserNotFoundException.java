package angular.spring.employeeManager.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String format) {
        super(format);
    }
}
