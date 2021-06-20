package es.taw.eventosgo.service;

import es.taw.eventosgo.dao.UsuarioEventoRepository;
import es.taw.eventosgo.dto.UsuarioEventoDTO;
import es.taw.eventosgo.entity.UsuarioEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioEventoService {

    private UsuarioEventoRepository usuarioEventoRepository;

    @Autowired
    public void setUsuarioEventoRepository(UsuarioEventoRepository usuarioEventoRepository) {
        this.usuarioEventoRepository = usuarioEventoRepository;
    }

    public UsuarioEventoDTO buscarUsuarioEventoId(Integer id){
        UsuarioEvento usuarioEvento = this.usuarioEventoRepository.findById(id).orElse(null);
        if(usuarioEvento != null){
            return usuarioEvento.getDTO();
        } else{
            return null;
        }
    }

    public void guardarUsuarioEvento(UsuarioEventoDTO dto){
        UsuarioEvento usuarioEvento;
        if(dto.getId() == null){
            usuarioEvento = new UsuarioEvento();
        } else{
            usuarioEvento = this.usuarioEventoRepository.findById(dto.getId()).orElse(new UsuarioEvento());
        }

        usuarioEvento.setId(dto.getId());
        usuarioEvento.setApellidos(dto.getApellidos());
        usuarioEvento.setDomicilio(dto.getDomicilio());
        usuarioEvento.setFechaNacimiento(dto.getFechaNacimiento());
        usuarioEvento.setCiudad(dto.getCiudad());
        usuarioEvento.setSexo(dto.getSexo());

        this.usuarioEventoRepository.save(usuarioEvento);
    }
}
