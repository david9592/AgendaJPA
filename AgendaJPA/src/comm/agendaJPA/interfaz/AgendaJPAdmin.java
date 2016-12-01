
package comm.agendaJPA.interfaz;

public class AgendaJPAdmin extends javax.swing.JFrame {
    
    public AgendaJPAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        submenu_Modificar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        submenu_Eliminar = new javax.swing.JMenuItem();
        txtBuscar_Contactos = new javax.swing.JTextField();
        btnAgr_Contacto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Contactos = new javax.swing.JTable();

        submenu_Modificar.setText("Modificar");
        jPopupMenu1.add(submenu_Modificar);
        jPopupMenu1.add(jSeparator1);

        submenu_Eliminar.setText("Eliminar");
        jPopupMenu1.add(submenu_Eliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAgr_Contacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comm/agendaJPA/interfaz/imagenes/Nuevo Contacto.jpg"))); // NOI18N
        btnAgr_Contacto.setText("Nuevo Contacto");

        tabla_Contactos.setComponentPopupMenu(jPopupMenu1);
        tabla_Contactos.setFocusable(false);
        jScrollPane1.setViewportView(tabla_Contactos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar_Contactos)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 200, Short.MAX_VALUE)
                        .addComponent(btnAgr_Contacto))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar_Contactos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgr_Contacto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtBuscar_Contactos.getAccessibleContext().setAccessibleName("Introduzca el nombre del contacto para buscar");
        txtBuscar_Contactos.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgendaJPAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendaJPAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendaJPAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendaJPAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendaJPAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgr_Contacto;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem submenu_Eliminar;
    private javax.swing.JMenuItem submenu_Modificar;
    private javax.swing.JTable tabla_Contactos;
    private javax.swing.JTextField txtBuscar_Contactos;
    // End of variables declaration//GEN-END:variables
    
    public javax.swing.JButton getBtnAgr_Contacto(){
        return btnAgr_Contacto;
    }
    
    public javax.swing.JTextField getTxtBuscar_Contacto(){
        return txtBuscar_Contactos;
    }
    
    public javax.swing.JTable getTablaContactos(){
        return tabla_Contactos;
    }
    
    public javax.swing.JMenuItem getSubmenu_Modificar(){
        return submenu_Modificar;
    }
    
    public javax.swing.JMenuItem getSubmenu_Eliminar(){
        return submenu_Eliminar;
    }
}