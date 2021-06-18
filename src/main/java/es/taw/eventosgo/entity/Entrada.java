package es.taw.eventosgo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Entrada {
    private Integer id;
    private Evento eventoByIdEvento;
    private UsuarioEvento usuarioEventoByIdUsuario;
    private EntradaAforo entradaAforoById;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrada entrada = (Entrada) o;
        return Objects.equals(id, entrada.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "ID_EVENTO", referencedColumnName = "ID", nullable = false)
    public Evento getEventoByIdEvento() {
        return eventoByIdEvento;
    }

    public void setEventoByIdEvento(Evento eventoByIdEvento) {
        this.eventoByIdEvento = eventoByIdEvento;
    }

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID", nullable = false)
    public UsuarioEvento getUsuarioEventoByIdUsuario() {
        return usuarioEventoByIdUsuario;
    }

    public void setUsuarioEventoByIdUsuario(UsuarioEvento usuarioEventoByIdUsuario) {
        this.usuarioEventoByIdUsuario = usuarioEventoByIdUsuario;
    }

    @OneToOne(mappedBy = "entradaById")
    public EntradaAforo getEntradaAforoById() {
        return entradaAforoById;
    }

    public void setEntradaAforoById(EntradaAforo entradaAforoById) {
        this.entradaAforoById = entradaAforoById;
    }
}
