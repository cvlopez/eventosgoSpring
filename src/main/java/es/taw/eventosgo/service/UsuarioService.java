package es.taw.eventosgo.service;

import es.taw.eventosgo.dao.UsuarioRepository;
import es.taw.eventosgo.dto.UsuarioDTO;
import es.taw.eventosgo.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO comprobarCredenciales(String correo, String pass){
        Usuario user = this.usuarioRepository.findByCorreoPass(correo, pass);
        if(user!=null){
            return user.getDTO();
        } else{
            return null;
        }
    }
}
