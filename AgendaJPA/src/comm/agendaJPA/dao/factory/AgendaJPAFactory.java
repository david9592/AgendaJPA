package comm.agendaJPA.dao.factory;

import comm.agendaJPA.dao.impl.AgendaJPADAOImpl;
import comm.agendaJPA.dao.interfaces.AgendaJPADAO;

public class AgendaJPAFactory {

    public AgendaJPADAO agendaJPAFactory() {
        return new AgendaJPADAOImpl();
    }
    
//    public  funcionesControlador(){
//        return new 
//    }

}
