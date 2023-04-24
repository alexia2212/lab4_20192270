package com.example.lab4_20192270.Controller;

import com.example.lab4_20192270.Entity.User;
import com.example.lab4_20192270.Entity.Vuelo;
import com.example.lab4_20192270.Repository.AerolineaRepository;
import com.example.lab4_20192270.Repository.ReservaRepository;
import com.example.lab4_20192270.Repository.UserRepository;
import com.example.lab4_20192270.Repository.VueloRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ReservaRepository reservaRepository;
    @Autowired
    AerolineaRepository aerolineaRepository;
    @Autowired
    VueloRepository vueloRepository;

    @GetMapping(value = "/inicio")
    public String inicio(){

        return "inicio";
    }

    @GetMapping(value = "/homepage")
    public String home(Model model, @RequestParam(name = "usuarioid") Integer id){

        model.addAttribute("usuario", userRepository.findById(id).get());
        model.addAttribute("listaVuelos", vueloRepository.findAll());
        return "homePage";
    }

    @PostMapping(value = "/inicio/prueba")
    public String valid(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttributes){
        for(User user:userRepository.findAll()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                redirectAttributes.addAttribute("usuarioid", user.getIduser());
                return "redirect:/homepage";
            }
        }
        return "redirect:/inicio";
    }


    @PostMapping(value ="/reserva")
    public String reservar(@RequestParam("vuelo_id")Integer vuelo_id, @RequestParam("user_id") Integer user_id, @RequestParam("precio_total")Integer precio_total, RedirectAttributes redirectAttributes){

        reservaRepository.reservar(vuelo_id, user_id, precio_total);

        redirectAttributes.addAttribute("usuarioid", user_id);
        ///System.out.println();
        return "redirect:/homepage";
    }




}
