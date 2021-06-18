package es.taw.eventosgo.controller;

import es.taw.eventosgo.dto.UsuarioDTO;
import es.taw.eventosgo.entity.Usuario;
import es.taw.eventosgo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AutenticarController {
    private UsuarioService usuarioService;

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public String doInit(){
        return "inicioSesion";
    }

    @PostMapping("/autenticar")
    public String doAutenticar (@RequestParam ("correo") String correo,
                                @RequestParam ("password") String pass,
                                Model model, HttpSession sesion){

        String strTo="", strError="";

        if(correo == null || correo.isEmpty() || pass == null || pass.isEmpty()){
            strError="Error de autentificación: alguno de los campos está vacío.";
            model.addAttribute("error", strError);
            strTo = "inicioSesion";
        } else{
            UsuarioDTO user = this.usuarioService.comprobarCredenciales(correo, pass);

            if(user == null){
                strError = "Error de autentificación: credenciales incorrectas.";
                model.addAttribute("error", strError);
                strTo = "inicioSesion";
            } else{
                sesion.setAttribute("usuario", user);
                strTo="redirect:evento/listarEventos";
            }
        }

        return strTo;
    }
}
