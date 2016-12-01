package comm.agendaJPA.controlador;

import comm.agendaJPA.dao.factory.AgendaJPAFactory;
import comm.agendaJPA.dao.interfaces.AgendaJPADAO;
import comm.agendaJPA.interfaz.*;

public class FuncionesControlador {

    private final AgendaJPAFactory factory= new AgendaJPAFactory();
    private final AgendaJPADAO agendaDAO= factory.agendaJPAFactory();
    private javax.swing.table.DefaultTableModel modeloTabla;
    private AgendaJPAContacto agendaJPAContacto;

    public void limpiarCampos() {
        this.agendaJPAContacto.getTxtNombre().setText("");
        this.agendaJPAContacto.getTxtApellido().setText("");
        this.agendaJPAContacto.getTxtMovil().setText("");
        this.agendaJPAContacto.getTxtCasa().setText("");
        this.agendaJPAContacto.getTxtPersonal().setText("");
        this.agendaJPAContacto.getTxtTrabajo().setText("");
        this.agendaJPAContacto.getTxtPanelDireccion().setText("");
    }

    public javax.swing.JTable columnasTabla(javax.swing.JTable tabla) {

        modeloTabla = new javax.swing.table.DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        tabla.setModel(modeloTabla);

        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("NOMBRE");
        modeloTabla.addColumn("APELLIDO");
        modeloTabla.addColumn("MOVIL");
        
        return tabla;
    }
    
    public void listarTabla(){
        Object[] columnas = new Object[4];

        int objetos = agendaDAO.extraerTodos().size();

        for (int i = 0; i < objetos; i++) {

            columnas[0] = this.agendaDAO.extraerTodos().get(i).getId();
            columnas[1] = this.agendaDAO.extraerTodos().get(i).getNombre();
            columnas[2] = this.agendaDAO.extraerTodos().get(i).getApellido();
            columnas[3] = this.agendaDAO.extraerTodos().get(i).getMovil();

            modeloTabla.addRow(columnas);
        }
    }
    
    public void buscarContactos(String expresion) {

        Object[] columnas = new Object[4];

        int objetos = this.agendaDAO.buscarDatos(expresion).size();

        for (int i = 0; i < objetos; i++) {

            columnas[0] = this.agendaDAO.buscarDatos(expresion).get(i).getId();
            columnas[1] = this.agendaDAO.buscarDatos(expresion).get(i).getNombre();
            columnas[2] = this.agendaDAO.buscarDatos(expresion).get(i).getApellido();
            columnas[3] = this.agendaDAO.buscarDatos(expresion).get(i).getMovil();

            modeloTabla.addRow(columnas);
        }
    }

}
