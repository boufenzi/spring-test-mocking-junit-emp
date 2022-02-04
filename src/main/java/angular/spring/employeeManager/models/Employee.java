package angular.spring.employeeManager.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String jobTitle;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String imageUrl;
    @NotNull
    private String code;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
