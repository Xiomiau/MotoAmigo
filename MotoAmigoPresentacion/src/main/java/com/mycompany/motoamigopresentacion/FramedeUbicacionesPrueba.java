/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.motoamigopresentacion;

import com.mycompany.cusolicitarentrega.BuscarUbicacion;
import com.mycompany.cusolicitarentrega.IBuscarUbicacion;
import com.mycompany.motoamigodto.UbicacionDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author joset
 */
public class FramedeUbicacionesPrueba extends javax.swing.JFrame {

    private final IBuscarUbicacion buscarUbicacion = new BuscarUbicacion();
    private JPopupMenu popupOrigen;
    private JPopupMenu popupDestino;
    private double origenLat, origenLng;
    private double destinoLat, destinoLng;

    /**
     * Creates new form NewJFrame
     */
    public FramedeUbicacionesPrueba() {
        initComponents();
        iniciarAutocompletado();

    }

    private void iniciarAutocompletado() {
        popupOrigen = new JPopupMenu();
        popupDestino = new JPopupMenu();
        configurarCampo(txtOrigen, popupOrigen, true);
        configurarCampo(txtDestino, popupDestino, false);
    }

    private void configurarCampo(JTextField campo, JPopupMenu popup, boolean esOrigen) {
        Timer[] timer = {null};

        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_UP
                        || key == KeyEvent.VK_DOWN
                        || key == KeyEvent.VK_ENTER
                        || key == KeyEvent.VK_ESCAPE) {
                    return;
                }

                if (timer[0] != null) {
                    timer[0].stop();
                }

                timer[0] = new Timer(400, ev -> {
                    String texto = campo.getText().trim();
                    new Thread(() -> {
                        try {
                            java.util.List<UbicacionDTO> sugerencias = buscarUbicacion.ejecutar(texto);
                            SwingUtilities.invokeLater(() -> mostrarPopup(campo, popup, sugerencias, esOrigen));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }).start();
                });
                timer[0].setRepeats(false);
                timer[0].start();
            }
        });
    }

    private void mostrarPopup(JTextField campo, JPopupMenu popup, List<UbicacionDTO> sugerencias, boolean esOrigen) {
        popup.setBorder(BorderFactory.createLineBorder(new Color(255, 102, 0), 1)); // borde naranja como tu tema
        popup.setBackground(Color.WHITE);
        popup.removeAll();

        if (sugerencias == null || sugerencias.isEmpty()) {
            popup.setVisible(false);
            return;
        }

        for (UbicacionDTO dto : sugerencias) {
            JMenuItem item = new JMenuItem(dto.getDescripcion());
            item.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            item.setBackground(java.awt.Color.WHITE);
            item.setForeground(java.awt.Color.DARK_GRAY);
            item.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));

            item.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    item.setBackground(new java.awt.Color(255, 102, 0)); // naranja
                    item.setForeground(java.awt.Color.WHITE);
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    item.setBackground(java.awt.Color.WHITE);
                    item.setForeground(java.awt.Color.DARK_GRAY);
                }
            });
            item.addActionListener(e -> {
                campo.setText(dto.getDescripcion());
                popup.setVisible(false);

                if (esOrigen) {
                    origenLat = dto.getLatitud();
                    origenLng = dto.getLongitud();
                    System.out.println("Origen seleccionado: "
                            + dto.getDescripcion()
                            + " [" + origenLng + ", " + origenLat + "]");
                } else {
                    destinoLat = dto.getLatitud();
                    destinoLng = dto.getLongitud();
                    System.out.println("Destino seleccionado: "
                            + dto.getDescripcion()
                            + " [" + destinoLng + ", " + destinoLat + "]");
                }
            });

            popup.add(item);
        }

        // Mostrar el popup justo debajo del JTextArea
        popup.show(campo, 0, campo.getHeight());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        txtOrigen = new javax.swing.JTextField();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("ORIGEN");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("DESTINO");

        txtDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinoActionPerformed(evt);
            }
        });

        txtOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrigenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(219, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(333, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(104, 104, 104)
                    .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(215, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(175, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(jLabel2)
                    .addContainerGap(243, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(93, 93, 93)
                    .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(208, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinoActionPerformed

    private void txtOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrigenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramedeUbicacionesPrueba().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtOrigen;
    // End of variables declaration//GEN-END:variables
}
