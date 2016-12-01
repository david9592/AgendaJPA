package comm.agendaJPA.controlador;

import comm.agendaJPA.dao.factory.AgendaJPAFactory;
import comm.agendaJPA.dao.interfaces.AgendaJPADAO;
import comm.agendaJPA.interfaz.*;
import comm.agendaJPA.modelo.Contacto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class AgendaJPAControlador extends MouseAdapter implements ActionListener, KeyListener {

    private final AgendaJPAFactory factory = new AgendaJPAFactory();
    private final AgendaJPADAO agendaDAO = factory.agendaJPAFactory();
    private final AgendaJPAdmin agendaJPAdmin;
    private final AgendaJPAContacto agendaJPAContacto;
    Contacto contacto = new Contacto();
    FuncionesControlador funciones = new FuncionesControlador();

    public AgendaJPAControlador(AgendaJPAdmin agendaJPAdmin, AgendaJPAContacto agendaJPAContacto) {
        this.agendaJPAdmin = agendaJPAdmin;
        this.agendaJPAContacto = agendaJPAContacto;
    }

    private enum Componentes {
        getTxtBuscar_Contacto,
        getBtnAgr_Contacto,
        getTablaContactos,
        getSubmenu_Modificar,
        getSubmenu_Eliminar,
        getBtnGuardar,
        getBtnModificar
    }

    public void limpiarCampos() {
        this.agendaJPAContacto.getTxtNombre().setText("");
        this.agendaJPAContacto.getTxtApellido().setText("");
        this.agendaJPAContacto.getTxtMovil().setText("");
        this.agendaJPAContacto.getTxtCasa().setText("");
        this.agendaJPAContacto.getTxtPersonal().setText("");
        this.agendaJPAContacto.getTxtTrabajo().setText("");
        this.agendaJPAContacto.getTxtPanelDireccion().setText("");
    }

    public void abrirAgendaJPA() {
        this.funciones.columnasTabla(agendaJPAdmin.getTablaContactos());
        this.funciones.listarTabla();
        this.agendaJPAdmin.setTitle("AGENDA");
        this.agendaJPAdmin.setLocationRelativeTo(agendaJPAdmin);
        this.agendaJPAdmin.setVisible(true);

        this.agendaJPAdmin.getTablaContactos().addMouseListener(this);
        this.agendaJPAdmin.getTxtBuscar_Contacto().addKeyListener(this);
        this.agendaJPAdmin.getTxtBuscar_Contacto().setActionCommand("getTxtBuscar_Contacto");
        this.agendaJPAdmin.getBtnAgr_Contacto().addActionListener(this);
        this.agendaJPAdmin.getBtnAgr_Contacto().setActionCommand("getBtnAgr_Contacto");
        this.agendaJPAdmin.getSubmenu_Modificar().addActionListener(this);
        this.agendaJPAdmin.getSubmenu_Modificar().setActionCommand("getSubmenu_Modificar");
        this.agendaJPAdmin.getSubmenu_Eliminar().addActionListener(this);
        this.agendaJPAdmin.getSubmenu_Eliminar().setActionCommand("getSubmenu_Eliminar");
        this.agendaJPAContacto.getBtnGuardar().addActionListener(this);
        this.agendaJPAContacto.getBtnGuardar().setActionCommand("getBtnGuardar");
        this.agendaJPAContacto.getBtnModificar().addActionListener(this);
        this.agendaJPAContacto.getBtnModificar().setActionCommand("getBtnModificar");
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        switch (Componentes.valueOf(evento.getActionCommand())) {

            //Eventos ventana AgendaJPAdmin
            case getBtnAgr_Contacto:
                this.limpiarCampos();
                this.agendaJPAContacto.setTitle("NUEVO CONTACTO");
                this.agendaJPAContacto.getBtnModificar().setVisible(false);
                this.agendaJPAContacto.getBtnGuardar().setVisible(true);
                this.agendaJPAContacto.setVisible(true);
                this.agendaJPAContacto.setLocationRelativeTo(agendaJPAdmin);
                break;

            //Eventos JPopupMenu de la ventana AgendaJPAdmin
            case getSubmenu_Modificar:
                this.limpiarCampos();
                this.agendaJPAContacto.setTitle("MODIFICAR CONTACTO");
                int filaSeleccionada = this.agendaJPAdmin.getTablaContactos().getSelectedRow();

                if (filaSeleccionada >= 0) {

                    List<Contacto> contactosMod = agendaDAO.extraerTodos();
                    Contacto contactoMostrado = contactosMod.get(filaSeleccionada);

                    this.agendaJPAContacto.getTxtNombre().setText(contactoMostrado.getNombre());
                    this.agendaJPAContacto.getTxtApellido().setText(contactoMostrado.getApellido());
                    this.agendaJPAContacto.getTxtMovil().setText(contactoMostrado.getMovil().toString());
                    this.agendaJPAContacto.getTxtCasa().setText(contactoMostrado.getCasa().toString());
                    this.agendaJPAContacto.getTxtPersonal().setText(contactoMostrado.getPersonal());
                    this.agendaJPAContacto.getTxtTrabajo().setText(contactoMostrado.getTrabajo());
                    this.agendaJPAContacto.getTxtPanelDireccion().setText(contactoMostrado.getDireccion());

                    this.agendaJPAContacto.setLocationRelativeTo(agendaJPAdmin);
                    this.agendaJPAContacto.getBtnGuardar().setVisible(false);
                    this.agendaJPAContacto.getBtnModificar().setVisible(true);
                    this.agendaJPAContacto.setVisible(true);

                } else {
                    //No se ha implementado nada
                }
                break;

            case getSubmenu_Eliminar:
                int filaEliminar = this.agendaJPAdmin.getTablaContactos().getSelectedRow();

                if (filaEliminar >= 0) {
                    int opcionEliminar = JOptionPane.showConfirmDialog(agendaJPAdmin,
                            "Desea eliminar este contacto?", "Borrar", JOptionPane.YES_NO_OPTION);

                    if (opcionEliminar == JOptionPane.YES_OPTION) {
                        List<Contacto> contactos = this.agendaDAO.extraerTodos();
                        Contacto contactoEliminar = contactos.get(filaEliminar);

                        if (contactoEliminar != null) {
                            this.agendaDAO.borrar(contactoEliminar);
                            this.funciones.columnasTabla(this.agendaJPAdmin.getTablaContactos());
                            this.funciones.listarTabla();
                        } else {
                            JOptionPane.showMessageDialog(agendaJPAdmin, "No se pudo eliminar el contacto");
                        }
                    } else {
                        //No se ha implementado nada
                    }
                }
                break;

            //Eventos ventana AgendaJPAContacto
            case getBtnGuardar:
                String nombre = agendaJPAContacto.getTxtNombre().getText();
                String apellido = agendaJPAContacto.getTxtApellido().getText();
                String movil = agendaJPAContacto.getTxtMovil().getText();
                String casa = agendaJPAContacto.getTxtCasa().getText();
                String personal = agendaJPAContacto.getTxtPersonal().getText();
                String trabajo = agendaJPAContacto.getTxtTrabajo().getText();
                String direccion = agendaJPAContacto.getTxtPanelDireccion().getText();

                String contactoNuevo = nombre + apellido + movil + casa + personal
                        + trabajo + direccion;
                if (contactoNuevo != null) {
                    this.agendaDAO.guardar(new Contacto(nombre, apellido,
                            Integer.valueOf(movil), Integer.parseInt(casa),
                            personal, trabajo, direccion));
                    this.funciones.columnasTabla(this.agendaJPAdmin.getTablaContactos());
                    this.funciones.listarTabla();
                } else {
                    //No se ha implementado nada
                }
                this.limpiarCampos();
                this.agendaJPAContacto.dispose();
                break;

            case getBtnModificar:
                int filaMod = this.agendaJPAdmin.getTablaContactos().getSelectedRow();

                if (filaMod >= 0) {
                    List<Contacto> contactos = this.agendaDAO.extraerTodos();
                    Contacto contactoMod = contactos.get(filaMod);
                    
                    contactoMod.setNombre(agendaJPAContacto.getTxtNombre().getText());
                    contactoMod.setApellido(agendaJPAContacto.getTxtApellido().getText());
                    contactoMod.setMovil(Integer.valueOf(agendaJPAContacto.getTxtMovil().getText()));
                    contactoMod.setCasa(Integer.valueOf(agendaJPAContacto.getTxtCasa().getText()));
                    contactoMod.setPersonal(agendaJPAContacto.getTxtPersonal().getText());
                    contactoMod.setTrabajo(agendaJPAContacto.getTxtTrabajo().getText());
                    contactoMod.setDireccion(agendaJPAContacto.getTxtPanelDireccion().getText());
                    
                    this.agendaDAO.actualizar(contactoMod);

                    this.funciones.columnasTabla(this.agendaJPAdmin.getTablaContactos());
                    this.funciones.listarTabla();
                    this.limpiarCampos();
                    this.agendaJPAContacto.dispose();
                }
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (SwingUtilities.isLeftMouseButton(me)) {

        } else if (SwingUtilities.isRightMouseButton(me)) {
            Point p = me.getPoint();
            int numColumna = this.agendaJPAdmin.getTablaContactos().rowAtPoint(p);
            ListSelectionModel modelo = this.agendaJPAdmin.getTablaContactos().getSelectionModel();
            modelo.setSelectionInterval(numColumna, numColumna);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getClickCount() >= 2) {
            int filaSeleccionada = this.agendaJPAdmin.getTablaContactos().getSelectedRow();

            if (filaSeleccionada >= 0) {
                List<Contacto> contactos = this.agendaDAO.extraerTodos();
                Contacto contactoMostrar = contactos.get(filaSeleccionada);
                
                this.agendaJPAContacto.getTxtNombre().setText(contactoMostrar.getNombre());
                this.agendaJPAContacto.getTxtApellido().setText(contactoMostrar.getApellido());
                this.agendaJPAContacto.getTxtMovil().setText(contactoMostrar.getMovil().toString());
                this.agendaJPAContacto.getTxtCasa().setText(contactoMostrar.getCasa().toString());
                this.agendaJPAContacto.getTxtPersonal().setText(contactoMostrar.getPersonal());
                this.agendaJPAContacto.getTxtTrabajo().setText(contactoMostrar.getTrabajo());
                this.agendaJPAContacto.getTxtPanelDireccion().setText(contactoMostrar.getDireccion());
                
                this.agendaJPAContacto.getBtnGuardar().setVisible(false);
                this.agendaJPAContacto.getBtnModificar().setVisible(false);
                this.agendaJPAContacto.setLocationRelativeTo(agendaJPAdmin);
                this.agendaJPAContacto.setVisible(true);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getSource()== this.agendaJPAdmin.getTxtBuscar_Contacto()) {
            String expresion= this.agendaJPAdmin.getTxtBuscar_Contacto().getText();
            
            this.funciones.buscarContactos(expresion);
        }
    }

}
