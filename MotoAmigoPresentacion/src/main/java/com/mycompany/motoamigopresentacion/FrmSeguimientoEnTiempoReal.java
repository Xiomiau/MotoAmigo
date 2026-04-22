/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.motoamigopresentacion;

import Utilerias.OSMTileFactoryCustom;
import Utilerias.utileriasBotones;
import com.consultarruta.servicios.mapBox.MapBoxMock;
import com.mycompany.cusolicitarentrega.FuncionalidadSeguimiento;
import com.mycompany.cusolicitarentrega.IFuncionalidadSeguimiento;
import com.mycompany.motoamigodto.UbicacionDTO;
import com.mycompany.motoamigopresentacion.controladores.ControlRegistrarIncidente;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.WaypointPainter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import panelesUtilerias.PanelHeader;

/**
 *
 * @author joset
 */
public class FrmSeguimientoEnTiempoReal extends javax.swing.JFrame {

    private JXMapViewer mapViewer;
    private WaypointPainter<DefaultWaypoint> waypointPainter;
    private DefaultWaypoint marcador;

    private final IFuncionalidadSeguimiento funcionalidad;
    private ControlRegistrarIncidente control;

    public FrmSeguimientoEnTiempoReal() {
        this.control = new ControlRegistrarIncidente();
        this.funcionalidad = new FuncionalidadSeguimiento(new MapBoxMock());
        initComponents();
        inicializarUI();
        inicializarMapa();
        setLocationRelativeTo(null);
    }

    /**
     * Aplica estilos visuales de los componentes.
     */
    private void inicializarUI() {
        utileriasBotones.btnNaranja(btnContactarRepa);
        utileriasBotones.btnNaranja(btnVolverMenu);
        utileriasBotones.btnRojo(btnReportar);
        panPrincipal.add(new PanelHeader(), new AbsoluteConstraints(0, 0, 1366, 130));
        txtSeguimiento.setEditable(false);

    }

    private void inicializarMapa() {
        mapViewer = new JXMapViewer();

        OSMTileFactoryCustom tileFactory = new OSMTileFactoryCustom();
        tileFactory.setThreadPoolSize(4);
        mapViewer.setTileFactory(tileFactory);

        GeoPosition posicionInicial = new GeoPosition(27.486, -109.939);
        mapViewer.setZoom(7);
        mapViewer.setAddressLocation(posicionInicial);

        marcador = new DefaultWaypoint(posicionInicial);
        waypointPainter = new WaypointPainter<>();
        waypointPainter.setWaypoints(new HashSet<>(Arrays.asList(marcador)));
        mapViewer.setOverlayPainter(waypointPainter);

        panelMapa.setLayout(new BorderLayout());
        panelMapa.add(mapViewer, BorderLayout.CENTER);
        panelMapa.revalidate();
        panelMapa.repaint();
        agregarInteraccionMapa();
        iniciarSeguimiento();
    }

    /**
     * Agrega zoom con rueda del mouse y desplazamiento con arrastre al mapa.
     */
    private void agregarInteraccionMapa() {
        // Zoom con rueda del mouse
        mapViewer.addMouseWheelListener(e -> {
            int zoom = mapViewer.getZoom();
            if (e.getWheelRotation() < 0) {
                mapViewer.setZoom(Math.max(1, zoom - 1));
            } else {
                mapViewer.setZoom(Math.min(15, zoom + 1));
            }
        });
    }

    /**
     * Crea temporizador que cada 3 segundos consulta la siguiente ubicación del
     * repartidor usando el modulo de funcionalidad. Actualiza el estado y el
     * historial de texto y mueve el marcador en el mapa usando mover(lat, lng)
     *
     */
    private void iniciarSeguimiento() {
        Timer timer = new Timer(3000, null);

        timer.addActionListener(e -> {
            if (funcionalidad.haTerminado()) {
                timer.stop();
                lblEstado.setText("Estado: Entregado");
                txtSeguimiento.append(" Pedido entregado\n");
                return;
            }

            UbicacionDTO ubi = funcionalidad.obtenerSiguiente();

            lblEstado.setText("Estado: " + ubi.getDescripcion());
            txtSeguimiento.append("[" + LocalTime.now().withNano(0) + "] "
                    + ubi.getDescripcion() + "\n");

            moverMarcador(ubi);
        });

        timer.start();
    }

    /**
     * Mueve el marcador en el mapa al hilo de. Solo actúa si el mapa ya terminó
     * de cargar.
     */
    private void moverMarcador(UbicacionDTO ubi) {
        if (mapViewer == null) {
            return;
        }

        GeoPosition nuevaPos = new GeoPosition(ubi.getLatitud(), ubi.getLongitud());
        marcador = new DefaultWaypoint(nuevaPos);
        waypointPainter.setWaypoints(new HashSet<>(Arrays.asList(marcador)));
        mapViewer.setAddressLocation(nuevaPos);
        mapViewer.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panPrincipal = new javax.swing.JPanel();
        panelSuperior = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelMapa = new javax.swing.JPanel();
        panelInformacionRuta = new javax.swing.JPanel();
        lblEstado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSeguimiento = new javax.swing.JTextArea();
        btnContactarRepa = new javax.swing.JButton();
        btnVolverMenu = new javax.swing.JButton();
        btnReportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 732));
        setResizable(false);

        panPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        panelSuperior.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MotoAmigo");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 0));
        jLabel3.setText("Calculo de Ruta");

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(14, 14, 14))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelMapa.setBackground(new java.awt.Color(255, 255, 255));
        panelMapa.setInheritsPopupMenu(true);
        panelMapa.setMaximumSize(new java.awt.Dimension(1008, 438));
        panelMapa.setMinimumSize(new java.awt.Dimension(1008, 438));
        panelMapa.setName(""); // NOI18N
        panelMapa.setPreferredSize(new java.awt.Dimension(1008, 438));

        javax.swing.GroupLayout panelMapaLayout = new javax.swing.GroupLayout(panelMapa);
        panelMapa.setLayout(panelMapaLayout);
        panelMapaLayout.setHorizontalGroup(
            panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelMapaLayout.setVerticalGroup(
            panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(102, 102, 102));
        lblEstado.setText("Estado");

        txtSeguimiento.setBackground(new java.awt.Color(245, 245, 245));
        txtSeguimiento.setColumns(20);
        txtSeguimiento.setRows(5);
        jScrollPane1.setViewportView(txtSeguimiento);

        javax.swing.GroupLayout panelInformacionRutaLayout = new javax.swing.GroupLayout(panelInformacionRuta);
        panelInformacionRuta.setLayout(panelInformacionRutaLayout);
        panelInformacionRutaLayout.setHorizontalGroup(
            panelInformacionRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionRutaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInformacionRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInformacionRutaLayout.createSequentialGroup()
                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        panelInformacionRutaLayout.setVerticalGroup(
            panelInformacionRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionRutaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnContactarRepa.setBackground(new java.awt.Color(255, 102, 0));
        btnContactarRepa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnContactarRepa.setForeground(new java.awt.Color(255, 255, 255));
        btnContactarRepa.setText("Contactar Repartidor");
        btnContactarRepa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContactarRepaActionPerformed(evt);
            }
        });

        btnVolverMenu.setBackground(new java.awt.Color(255, 102, 0));
        btnVolverMenu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVolverMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnVolverMenu.setText("Volver al menu");
        btnVolverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverMenuActionPerformed(evt);
            }
        });

        btnReportar.setBackground(new java.awt.Color(204, 0, 51));
        btnReportar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReportar.setForeground(new java.awt.Color(255, 255, 255));
        btnReportar.setText("Reportar");
        btnReportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panPrincipalLayout = new javax.swing.GroupLayout(panPrincipal);
        panPrincipal.setLayout(panPrincipalLayout);
        panPrincipalLayout.setHorizontalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelInformacionRuta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(btnContactarRepa)
                        .addGap(99, 99, 99)
                        .addComponent(btnVolverMenu))
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnReportar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(314, Short.MAX_VALUE))
        );
        panPrincipalLayout.setVerticalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnReportar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(panelInformacionRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnContactarRepa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolverMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(panPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContactarRepaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContactarRepaActionPerformed
        JOptionPane.showMessageDialog(
                this,
                "Contactando con el repartidor",
                "",
                javax.swing.JOptionPane.INFORMATION_MESSAGE
        );

    }//GEN-LAST:event_btnContactarRepaActionPerformed

    private void btnVolverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverMenuActionPerformed

    private void btnReportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportarActionPerformed
        control.irAFormularioIncidente();
    }//GEN-LAST:event_btnReportarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */


 /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSeguimientoEnTiempoReal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContactarRepa;
    private javax.swing.JButton btnReportar;
    private javax.swing.JButton btnVolverMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JPanel panPrincipal;
    private javax.swing.JPanel panelInformacionRuta;
    private javax.swing.JPanel panelMapa;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTextArea txtSeguimiento;
    // End of variables declaration//GEN-END:variables
}
