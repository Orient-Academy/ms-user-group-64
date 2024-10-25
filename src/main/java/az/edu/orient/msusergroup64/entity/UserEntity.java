package az.edu.orient.msusergroup64.entity;

import az.edu.orient.msusergroup64.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private Status status;

}
