package comm.agendaJPA.dao.interfaces;

import java.util.List;

public interface GenericDAO<C> {
    void guardar(C c);
    List<C> extraerTodos();
    List<C> buscarDatos(String s);
    void actualizar(C c);
    void borrar(C c);

}
