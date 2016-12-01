package comm.agendaJPA.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity(name = "ContactoAgenda")
@Table(name = "contacto")
@NamedQueries({
    @NamedQuery(name = "AgendaJPA.getAll", query = "SELECT c FROM ContactoAgenda c"),
//    @NamedQuery(name="AgendaJPA.search", query = "SELECT c FROM ContactoAgenda c WHERE c.nombre LIKE ?1 AND c.apellido LIKE ?2 AND c.movil LIKE ?3"),
//    @NamedQuery(name="AgendaJPA.searchAll", query = "SELECT c FROM ContactoAgenda c WHERE c.id LIKE ':50'")
        @NamedQuery(name="AgendaJPA.searchAll", query = "SELECT c FROM ContactoAgenda c WHERE c.id LIKE CONCAT ('%',:expresion,'%')")
})
public class Contacto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "movil")
    private Integer movil;
    @Column(name = "casa")
    private Integer casa;
    @Column(name = "personal")
    private String personal;
    @Column(name = "trabajo")
    private String trabajo;
    @Column(name = "direccion")
    private String direccion;

    public Contacto() {
    }

    public Contacto(String nombre, String apellido, int movil, int casa, String personal, String trabajo, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.movil = movil;
        this.casa = casa;
        this.personal = personal;
        this.trabajo = trabajo;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getMovil() {
        return movil;
    }

    public void setMovil(Integer movil) {
        this.movil = movil;
    }

    public Integer getCasa() {
        return casa;
    }

    public void setCasa(Integer casa) {
        this.casa = casa;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
