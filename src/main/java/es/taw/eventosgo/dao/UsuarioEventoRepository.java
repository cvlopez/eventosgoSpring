package es.taw.eventosgo.dao;

import es.taw.eventosgo.entity.UsuarioEvento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioEventoRepository extends JpaRepository<UsuarioEvento, Integer> {

}
