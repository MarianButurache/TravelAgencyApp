package com.travel.controllers;



import com.travel.dto.UserDto;
import com.travel.entities.RoleTypes;
import com.travel.entities.User;
import com.travel.services.RoleService;
import com.travel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RestController;

        import javax.persistence.PersistenceContext;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @PostMapping(value = "/user")
    public UserDto save(@RequestBody UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(roleService.findByName(RoleTypes.ADMIN));
        user = userService.save(user);
        UserDto response = new UserDto();
        response.setUsername(user.getUsername());
        response.setPassword(user.getPassword());
        return response;
    }

    @PostMapping(value = "/basicauth")
    public UserDto basicAuth() {
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userService.findByUsername(user.getUsername());
        UserDto response = new UserDto();
        response.setUsername(user.getUsername());
        response.setPassword(user.getPassword());
        return response;
    }
}

