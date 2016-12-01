package comm.agendaJPA;

import comm.agendaJPA.controlador.AgendaJPAControlador;
import comm.agendaJPA.interfaz.AgendaJPAContacto;
import comm.agendaJPA.interfaz.AgendaJPAdmin;

public class AgendaJPA {

    public static void main(String[] args) {

        AgendaJPAdmin agendaAdmin = new AgendaJPAdmin();
        AgendaJPAContacto agendaContacto = new AgendaJPAContacto();

        new AgendaJPAControlador(agendaAdmin, agendaContacto).abrirAgendaJPA();

    }

}
