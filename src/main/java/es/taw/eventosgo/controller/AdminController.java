package es.taw.eventosgo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {


    @GetMapping("/UsuariosCargar")
    public String UsuariosCargar(Model model, HttpSession session){

        return "adminUsuarios.jsp";
    }





}

