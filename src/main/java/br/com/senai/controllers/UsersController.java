package br.com.senai.controllers;

import br.com.senai.models.Users;
import br.com.senai.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersRepository usersRepository;
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)

    public List<Users>getAllUsers(){

        return usersRepository.findAll();
    }
    @PostMapping (value = "/createUsers",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Users createUsers(@RequestBody Users users ){
        Users newUsers = new Users();
        newUsers.setusername(users.getusername());
        newUsers.setpassword(users.getpassword());
        return usersRepository.save(newUsers);
    }
}
