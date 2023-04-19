package com.example.lab4_20192270.Controller;

import com.example.lab4_20192270.Entity.User;
import com.example.lab4_20192270.Repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    final UserRepository userRepository;

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @GetMapping(value = "/inicio")
    public String index(){
        return "inicio";
    }

    @PostMapping(value = "/inicio/prueba")
    public String valid(@RequestParam("correo") String correo, @RequestParam("contrasena") String password){
        for(User u:userRepository.findAll()){
            if(u.getEmail().equals(correo) && u.getPassword().equals(password)){
                return "homePage";
            }
        }
        return "inicio";
    }

}
