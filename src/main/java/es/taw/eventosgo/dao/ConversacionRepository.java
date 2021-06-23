package es.taw.eventosgo.dao;

import es.taw.eventosgo.entity.Conversacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversacionRepository extends JpaRepository<Conversacion, Integer> {
}
