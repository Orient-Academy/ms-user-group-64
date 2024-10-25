package az.edu.orient.msusergroup64.response;

import az.edu.orient.msusergroup64.enums.Status;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Status status;
}
