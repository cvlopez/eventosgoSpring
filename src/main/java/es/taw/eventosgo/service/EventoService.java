package es.taw.eventosgo.service;

import es.taw.eventosgo.dao.EventoRepository;
import es.taw.eventosgo.dto.EventoDTO;
import es.taw.eventosgo.entity.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EventoService {
    private EventoRepository eventoRepository;

    @Autowired
    public void setEventoRepository(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    protected List<EventoDTO> convertirAListaDTO(List<Evento> eventosDisponibles){
        if(eventosDisponibles!=null){
            List<EventoDTO> eventosDTO = new ArrayList<>();
            for(Evento e : eventosDisponibles){
                eventosDTO.add(e.getDTO());
            }
            return eventosDTO;
        } else{
            return null;
        }
    }

    public List<EventoDTO> listarEventosDisponibles(){
        Date fechaActual = new Date();
        List<Evento> listaEventosDisponibles = this.eventoRepository.findEventosDisponibles(fechaActual);

        return this.convertirAListaDTO(listaEventosDisponibles);
    }
}
