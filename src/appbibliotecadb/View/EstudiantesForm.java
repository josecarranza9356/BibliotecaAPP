
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package appbibliotecadb.View;

import appbibliotecadb.Controller.EstudianteController;
import appbibliotecadb.Model.Estudiante;
import appbibliotecadb.Model.Persona;
import conection.DatabaseConnection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author JoseCv14
 */
public class EstudiantesForm extends javax.swing.JDialog {

    private Menu menu;
    private int idEstudianteRecibido;

    public EstudiantesForm(java.awt.Frame parent, boolean modal, Menu menu, int idEstudiante) {
        super(parent, modal);
        this.menu = menu;
        //recibimos el valor de idEstudiante
        this.idEstudianteRecibido = idEstudiante;
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Permite cerrar solo este formulario sin afectar a otros
        setLocationRelativeTo(null);

        System.out.println("id recibido: -- " + idEstudiante);

        //metodo para validar los datos del id y cargar el estudiante
        validadDatos();
        cargarDatosEstudiante(idEstudianteRecibido);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        txtDireccion = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        cbxNivel = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        cbxGrado = new javax.swing.JComboBox<>();
        cbxSeccion = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        cbxTurno = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        cbxGenero = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        btnCancelar.setBackground(new java.awt.Color(186, 84, 77));
        btnCancelar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/cancelar-24px.png"))); // NOI18N
        btnCancelar.setText("Cancelar   ");
        btnCancelar.setActionCommand("");
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(78, 101, 226));
        btnNuevo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/nuevo_24px.png"))); // NOI18N
        btnNuevo.setText("Nuevo   ");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEnviar.setBackground(new java.awt.Color(0, 101, 0));
        btnEnviar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/save_24px.png"))); // NOI18N
        btnEnviar.setText("Guardar   ");
        btnEnviar.setToolTipText("");
        btnEnviar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        txtDireccion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel37.setText("Dirección");

        jLabel40.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel40.setText("Nivel/Ciclo");

        txtApellidos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel39.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel39.setText("Apellidos");

        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel34.setText("Nombre ");

        jLabel33.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel33.setText("Documento");

        txtDocumento.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel36.setText("Telefono");

        txtTelefono.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(153, 153, 153));
        lblTitulo.setText("Ingrese los Datos a Registrar.");

        cbxNivel.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbxNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inicial", "Primaria", "Secundaria" }));

        jLabel42.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel42.setText("Grado/Edad");

        cbxGrado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbxGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "-" }));

        cbxSeccion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbxSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "A", "B", "C", "D", "E", "F", "G" }));

        jLabel43.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel43.setText("Seccion");

        jLabel44.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel44.setText("Turno");

        cbxTurno.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "T", "N" }));

        jLabel41.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel41.setText("Genero");

        cbxGenero.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "Otros" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblTitulo)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(318, 318, 318)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(jLabel39))
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel33)
                                .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel36)
                                .addComponent(txtTelefono)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbxNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel40))
                            .addGap(15, 15, 15)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel42)
                                .addComponent(cbxGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(15, 15, 15)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel43)
                                .addComponent(cbxSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(15, 15, 15)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel44)
                                .addComponent(cbxTurno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion)
                            .addComponent(jLabel37))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(6, 6, 6)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(6, 6, 6)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel41)
                        .addGap(6, 6, 6)
                        .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel37)
                        .addGap(6, 6, 6)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarDatos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        guardarDatos();
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        limpiarDatos();
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void guardarDatos() {
        // Obtener los datos del formulario
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String documento = txtDocumento.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();
        String genero = cbxGenero.getSelectedItem().toString();
        String estado = "A"; // Estado basado en el checkbox

        String codigo = txtDocumento.getText();
        String nivel_Ciclo = cbxNivel.getSelectedItem().toString();
        String grado_Edad = cbxGrado.getSelectedItem().toString();
        String seccion = cbxSeccion.getSelectedItem().toString();
        String turno = cbxTurno.getSelectedItem().toString();

        // Validar los datos del formulario
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo nombre no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (apellidos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo apellidos no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!documento.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(this, "El documento debe tener 8 dígitos numéricos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!telefono.matches("\\d{9}")) {
            JOptionPane.showMessageDialog(this, "El teléfono debe tener 9 dígitos numéricos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo dirección no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        EstudianteController estudianteController = new EstudianteController(DatabaseConnection.getConnection());

        if (idEstudianteRecibido == 0) { // Si idEstudianteRecibido es 0, se está creando un nuevo estudiante
            // Verificar que el documento no exista
            if (estudianteController.documentoExiste(documento)) {
                JOptionPane.showMessageDialog(this, "El documento ya existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verificar que el código no exista
            if (estudianteController.codigoExiste(codigo)) {
                JOptionPane.showMessageDialog(this, "El código ya existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear objetos Persona y Estudiante
            Persona persona = new Persona(documento, nombre, apellidos, genero, telefono, direccion, estado);
            int id_persona = estudianteController.createPersona(persona);

            if (id_persona != -1) { // Verificar si se obtuvo un ID válido
                Estudiante estudiante = new Estudiante(id_persona, codigo, nivel_Ciclo, grado_Edad, seccion, turno, estado);
                if (estudianteController.createEstudiante(estudiante)) {
                    // Mostrar mensaje de confirmación
                    JOptionPane.showMessageDialog(this, "Datos guardados satisfactoriamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    limpiarDatos(); // Limpiar los campos del formulario si se guardan correctamente
                    // Llamar al método listarEstudiantes en la instancia de Menu
                    menu.listarEstudiantes();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar los datos del estudiante", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar los datos de la persona", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else { // Si idEstudianteRecibido no es 0, se está actualizando un estudiante existente
            // Obtener el id_persona del estudiante existente
            Estudiante estudianteExistente = estudianteController.readById(idEstudianteRecibido);
            int id_persona = estudianteExistente.getId_persona();

            // Crear objetos Persona y Estudiante para la actualización
            Persona persona = new Persona(documento, nombre, apellidos, genero, telefono, direccion, estado);
            persona.setId(id_persona); // Asegurarse de establecer el id de la persona
            Estudiante estudiante = new Estudiante(id_persona, codigo, nivel_Ciclo, grado_Edad, seccion, turno, estado);

            // Actualizar la persona y el estudiante en la base de datos
            estudianteController.updatePersona(persona);
            estudianteController.updateEstudiante(estudiante);

            JOptionPane.showMessageDialog(this, "Datos actualizados satisfactoriamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            limpiarDatos(); // Limpiar los campos del formulario si se actualizan correctamente
            dispose();
            menu.listarEstudiantes();
        }
    }

    public void limpiarDatos() {
        txtNombre.setText("");
        txtApellidos.setText("");
        txtDocumento.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        cbxGenero.setSelectedIndex(0);
        cbxNivel.setSelectedIndex(0);
        cbxGrado.setSelectedIndex(0);
        cbxSeccion.setSelectedIndex(0);
        cbxTurno.setSelectedIndex(0);
        //chkEstado.setSelected(true);  
        lblTitulo.setText("Ingrese los Datos a Registrar.");
        btnNuevo.setEnabled(true);
    }

    // validar datos formulario 
    private void validadDatos() {
        if (idEstudianteRecibido == 0) {
            lblTitulo.setText("Ingrese los Datos a Registrar.");
        }
        if (idEstudianteRecibido != 0) {
            lblTitulo.setText("Modificar los datos de estudiantes");
            btnEnviar.setText("Editar");
            btnNuevo.setEnabled(false);
        }

    }

    private void cargarDatosEstudiante(int idEstudianteRecibido) {
        if (idEstudianteRecibido != 0) {
            EstudianteController estudianteController = new EstudianteController(DatabaseConnection.getConnection());
            Estudiante estudiante = estudianteController.readById(idEstudianteRecibido);

            if (estudiante != null) {
                // Cargar datos en los campos de texto y comboboxes
                String[] nombreCompleto = estudiante.getNombre_completo().split(" ", 2);
                if (nombreCompleto.length == 2) {
                    txtNombre.setText(nombreCompleto[0]);
                    txtApellidos.setText(nombreCompleto[1]);
                } else if (nombreCompleto.length == 1) {
                    txtNombre.setText(nombreCompleto[0]);
                    txtApellidos.setText("");
                } else {
                    txtNombre.setText("");
                    txtApellidos.setText("");
                }
                txtDocumento.setText(estudiante.getDocumento());
                txtTelefono.setText(estudiante.getTelefono());
                txtDireccion.setText(estudiante.getDireccion());
                cbxGenero.setSelectedItem(estudiante.getGenero());

                // Datos específicos del estudiante
                //txtCodigo.setText(estudiante.getCodigo());
                cbxNivel.setSelectedItem(estudiante.getNivel_Ciclo());
                cbxGrado.setSelectedItem(estudiante.getGrado_Edad());
                cbxSeccion.setSelectedItem(estudiante.getSeccion());
                cbxTurno.setSelectedItem(estudiante.getTurno());
            } else {
                JOptionPane.showMessageDialog(this, "Estudiante no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            return;
        }
    }

    
    /**
     * @param args the command line arguments
     */
    // Método main solo para pruebas
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    // Obtener el idEstudiante (simulado para pruebas)
                    int idEstudiante = 0; // Aquí debes obtener el idEstudiante de donde sea necesario
                    idEstudiante = idEstudiante;
                    Menu menu = new Menu(); // Crear instancia de Menu para pruebas
                    EstudiantesForm dialog = new EstudiantesForm(new javax.swing.JFrame(), true, menu, idEstudiante);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(EstudiantesForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cbxGenero;
    private javax.swing.JComboBox<String> cbxGrado;
    private javax.swing.JComboBox<String> cbxNivel;
    private javax.swing.JComboBox<String> cbxSeccion;
    private javax.swing.JComboBox<String> cbxTurno;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
