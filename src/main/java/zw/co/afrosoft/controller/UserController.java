package zw.co.afrosoft.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.dto.UserDto;
import zw.co.afrosoft.model.requests.UserDetailsRequest;
import zw.co.afrosoft.model.responses.UserResponse;
import zw.co.afrosoft.service.UserService;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {
    @Autowired
    private UserService serviceUser;

    @GetMapping
    public String getUser(){
        return "User Returned";
    }
    @PostMapping
    public UserResponse createUser(@RequestBody UserDetailsRequest userDetailsRequest){
        UserResponse returnValue = new UserResponse();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetailsRequest,userDto);

        UserDto createdUser = serviceUser.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);
        return returnValue;
    }
    @PutMapping
    public String updateUser(){
        return " User Updated";
    }
    @DeleteMapping
    public String deleteUser(){
        return "User Deleted";
    }
}
