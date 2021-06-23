package es.taw.eventosgo.dao;

import es.taw.eventosgo.entity.EventoAforo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoAforoRepository extends JpaRepository<EventoAforo,Integer> {
}
