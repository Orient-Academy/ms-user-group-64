package az.edu.orient.msusergroup64.controller;

import az.edu.orient.msusergroup64.request.UserCreateRequest;
import az.edu.orient.msusergroup64.response.UserResponse;
import az.edu.orient.msusergroup64.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserResponse addUser(@RequestBody UserCreateRequest request) {
        return userService.addUser(request);
    }

    @PutMapping("{id}")
    public UserResponse updateUser(@RequestParam Long id, @RequestBody UserCreateRequest request) {
        return userService.updateUser(id, request);
    }

    @GetMapping
    public List<UserResponse> getUserList(){
       return userService.getUserList();
    }

    @GetMapping("/{id}")
    public UserResponse getById(@RequestParam Long id){
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@RequestParam Long id){
        userService.deleteUser(id);
    }
}
