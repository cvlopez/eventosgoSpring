package es.taw.eventosgo.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "USUARIO_EVENTO", schema = "EVENTOSGO", catalog = "")
public class UsuarioEvento {
    private Integer id;
    private String apellidos;
    private String domicilio;
    private String ciudad;
    private Date fechaNacimiento;
    private Integer sexo;
    private Collection<Entrada> entradasById;
    private Usuario usuarioById;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "APELLIDOS", nullable = false, length = 50)
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Basic
    @Column(name = "DOMICILIO", nullable = false, length = 100)
    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @Basic
    @Column(name = "CIUDAD", nullable = false, length = 50)
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Basic
    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "SEXO", nullable = false)
    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEvento that = (UsuarioEvento) o;
        return Objects.equals(id, that.id) && Objects.equals(apellidos, that.apellidos) && Objects.equals(domicilio, that.domicilio) && Objects.equals(ciudad, that.ciudad) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(sexo, that.sexo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, apellidos, domicilio, ciudad, fechaNacimiento, sexo);
    }

    @OneToMany(mappedBy = "usuarioEventoByIdUsuario")
    public Collection<Entrada> getEntradasById() {
        return entradasById;
    }

    public void setEntradasById(Collection<Entrada> entradasById) {
        this.entradasById = entradasById;
    }

    @OneToOne
    @JoinColumn(name = "ID", referencedColumnName = "ID", nullable = false)
    public Usuario getUsuarioById() {
        return usuarioById;
    }

    public void setUsuarioById(Usuario usuarioById) {
        this.usuarioById = usuarioById;
    }
}
