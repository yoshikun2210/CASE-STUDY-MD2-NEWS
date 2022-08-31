package rikkei.academy.controller;


import rikkei.academy.config.Config;
import rikkei.academy.dto.request.SignInDTO;
import rikkei.academy.dto.request.SignUpDTO;
import rikkei.academy.dto.response.ResponseMessenger;
import rikkei.academy.model.role.Role;
import rikkei.academy.model.role.RoleName;
import rikkei.academy.model.role.User;
import rikkei.academy.service.role.IRoleService;
import rikkei.academy.service.role.RoleServiceIMPL;
import rikkei.academy.user.IUserService;
import rikkei.academy.user.UserServiceIMPL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserController {
    private final IUserService userService = new UserServiceIMPL();
    private IRoleService roleService = new RoleServiceIMPL();
    public List<User> showListUser(){
        return userService.findALl();
    }
    public ResponseMessenger register(SignUpDTO signUpDTO){
        if(userService.existedByUsername(signUpDTO.getUsername())){
            return new ResponseMessenger("username_existed");
        }
        if(userService.existedByEmail(signUpDTO.getEmail())){
            return new ResponseMessenger("email_existed");
        }
        Set<String> strRoles = signUpDTO.getStrRole();
        Set<rikkei.academy.model.role.Role> roles = new HashSet<>();
        strRoles.forEach(role->{
            switch (role){
                case "admin":
                    Role adminRole = roleService.findByName(RoleName.ADMIN);
                    roles.add(adminRole);
                    break;
                case "pm":
                    rikkei.academy.model.role.Role pmRole = roleService.findByName(RoleName.PM);
                    roles.add(pmRole);
                    break;
                default:
                    rikkei.academy.model.role.Role userRole = roleService.findByName(RoleName.USER);
                    roles.add(userRole);
            }
        });
        User user = new User(signUpDTO.getId(), signUpDTO.getName(), signUpDTO.getUsername(), signUpDTO.getEmail(), signUpDTO.getPassword(), roles);
        userService.save(user);
        showListUser();
        return new ResponseMessenger("success");
    }
    public ResponseMessenger login(SignInDTO signInDTO){
        if(userService.checkLogin(signInDTO.getUsername(), signInDTO.getPassword())){
            User user = userService.findByUsername(signInDTO.getUsername());
            List<User> userLogin = new ArrayList<>();
            userLogin.add(user);
            new Config<User>().writeFile(Config.PATH_USER_PRINCIPAL,userLogin);
            return new ResponseMessenger("login_success");
        } else {
            return new ResponseMessenger("login_failed");
        }
    }
    public User getCurrentUser(){
        return userService.getCurrentUser();
    }



}
