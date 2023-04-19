package com.example.lab4_20192270.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/inicio")
    public String inicioSesion(){



        return "inicio";
    }


}
