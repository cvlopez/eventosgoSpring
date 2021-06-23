package es.taw.eventosgo.dao;

import es.taw.eventosgo.entity.Estudio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudioRepository extends JpaRepository<Estudio,Integer> {
}
