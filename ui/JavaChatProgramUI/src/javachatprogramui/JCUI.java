package javachatprogramui;

import java.awt.Color;
import java.util.Vector;
import java.net.*;
import java.io.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edsel
 */
public class JCUI extends javax.swing.JFrame {

    /**
     * Creates new form mainJFrame
     */
    private Vector<String> vsMsg;
    private String message;
    private ChatClient cc;

    public JCUI() {
        vsMsg = new Vector<String>();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        f_connect = new javax.swing.JFrame();
        lbld_server = new javax.swing.JLabel();
        tfd_server = new javax.swing.JTextField();
        lbld_port = new javax.swing.JLabel();
        tfd_port = new javax.swing.JTextField();
        lbld_name = new javax.swing.JLabel();
        tfd_name = new javax.swing.JTextField();
        btn_connect = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        f_Doc = new javax.swing.JFrame();
        ta_Doc = new java.awt.TextArea();
        f_about = new javax.swing.JFrame();
        ta_about = new java.awt.TextArea();
        tab_server = new javax.swing.JTabbedPane();
        sp_server = new javax.swing.JScrollPane();
        ta_server = new javax.swing.JTextArea();
        pnl_message = new javax.swing.JPanel();
        lbl_message = new javax.swing.JLabel();
        tf_msg = new javax.swing.JTextField();
        pnl_client = new javax.swing.JPanel();
        lbl_client = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        clients_jList = new javax.swing.JList<>();
        jMenuBar = new javax.swing.JMenuBar();
        menu_main = new javax.swing.JMenu();
        mi_connect = new javax.swing.JMenuItem();
        mi_disconnect = new javax.swing.JMenuItem();
        mi_exit = new javax.swing.JMenuItem();
        menu_help = new javax.swing.JMenu();
        mi_docs = new javax.swing.JMenuItem();
        mi_about = new javax.swing.JMenuItem();

        lbld_server.setText("Server:");

        tfd_server.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfd_serverActionPerformed(evt);
            }
        });

        lbld_port.setText("Port:");

        lbld_name.setText("Name:");

        btn_connect.setText("Connect");
        btn_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connectActionPerformed(evt);
            }
        });

        btn_cancel.setText("Cancel");

        javax.swing.GroupLayout f_connectLayout = new javax.swing.GroupLayout(f_connect.getContentPane());
        f_connect.getContentPane().setLayout(f_connectLayout);
        f_connectLayout.setHorizontalGroup(
            f_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f_connectLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(f_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(f_connectLayout.createSequentialGroup()
                        .addComponent(btn_connect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cancel))
                    .addGroup(f_connectLayout.createSequentialGroup()
                        .addGroup(f_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbld_server)
                            .addComponent(lbld_port)
                            .addComponent(lbld_name))
                        .addGap(47, 47, 47)
                        .addGroup(f_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfd_server)
                            .addComponent(tfd_port)
                            .addComponent(tfd_name, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        f_connectLayout.setVerticalGroup(
            f_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f_connectLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(f_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbld_server)
                    .addComponent(tfd_server, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(f_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbld_port)
                    .addComponent(tfd_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(f_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbld_name)
                    .addComponent(tfd_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(f_connectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_connect)
                    .addComponent(btn_cancel))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout f_DocLayout = new javax.swing.GroupLayout(f_Doc.getContentPane());
        f_Doc.getContentPane().setLayout(f_DocLayout);
        f_DocLayout.setHorizontalGroup(
            f_DocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f_DocLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(ta_Doc, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        f_DocLayout.setVerticalGroup(
            f_DocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f_DocLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(ta_Doc, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        f_about.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f_aboutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout f_aboutLayout = new javax.swing.GroupLayout(f_about.getContentPane());
        f_about.getContentPane().setLayout(f_aboutLayout);
        f_aboutLayout.setHorizontalGroup(
            f_aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f_aboutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ta_about, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addContainerGap())
        );
        f_aboutLayout.setVerticalGroup(
            f_aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f_aboutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ta_about, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new AbsoluteLayout());

        ta_server.setEditable(false);
        ta_server.setColumns(20);
        ta_server.setRows(5);
        sp_server.setViewportView(ta_server);

        tab_server.addTab("Server Name", sp_server);

        getContentPane().add(tab_server, new AbsoluteConstraints(150, 0, 1140, 453));

        lbl_message.setText("Message:");

        tf_msg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_msgActionPerformed(evt);
            }
        });
        tf_msg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_msgKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnl_messageLayout = new javax.swing.GroupLayout(pnl_message);
        pnl_message.setLayout(pnl_messageLayout);
        pnl_messageLayout.setHorizontalGroup(
            pnl_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_messageLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lbl_message)
                .addGap(51, 51, 51)
                .addComponent(tf_msg, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_messageLayout.setVerticalGroup(
            pnl_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tf_msg, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbl_message))
        );

        getContentPane().add(pnl_message, new AbsoluteConstraints(1, 459, 1301, -1));

        pnl_client.setEnabled(false);

        javax.swing.GroupLayout pnl_clientLayout = new javax.swing.GroupLayout(pnl_client);
        pnl_client.setLayout(pnl_clientLayout);
        pnl_clientLayout.setHorizontalGroup(
            pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_clientLayout.setVerticalGroup(
            pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(pnl_client, new AbsoluteConstraints(153, 0, -1, -1));

        lbl_client.setText("Users");
        lbl_client.setEnabled(false);
        getContentPane().add(lbl_client, new AbsoluteConstraints(50, 0, 50, 35));

        jScrollPane2.setViewportView(clients_jList);

        getContentPane().add(jScrollPane2, new AbsoluteConstraints(10, 30, 140, 410));

        menu_main.setText("Server");

        mi_connect.setText("Connect");
        mi_connect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mi_connectMouseClicked(evt);
            }
        });
        mi_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_connectActionPerformed(evt);
            }
        });
        menu_main.add(mi_connect);

        mi_disconnect.setText("Disconnect");
        mi_disconnect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mi_connectMouseClicked(evt);
            }
        });
        mi_disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_disconnectActionPerformed(evt);
            }
        });
        menu_main.add(mi_disconnect);

        mi_exit.setText("Exit");
        menu_main.add(mi_exit);

        jMenuBar.add(menu_main);

        menu_help.setText("Help");

        mi_docs.setText("Docs");
        mi_docs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_docsActionPerformed(evt);
            }
        });
        menu_help.add(mi_docs);

        mi_about.setText("About");
        mi_about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_aboutActionPerformed(evt);
            }
        });
        menu_help.add(mi_about);

        jMenuBar.add(menu_help);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_msgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_msgActionPerformed
        // TODO add your handling code here:
            //this.ta_server.append(message + "\n");
            this.repaint();

    }//GEN-LAST:event_tf_msgActionPerformed

    private void mi_docsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_docsActionPerformed
        // TODO add your handling code here:
        f_Doc.setSize(530,500);
        ta_Doc.setSize(350, 350);

        f_Doc.setTitle("Documentation.");
        f_Doc.setDefaultCloseOperation(1);
        f_Doc.setVisible(true);
        f_Doc.show(true);
        ta_Doc.setText("Server Menu -> Server -> Server name or ip to connect to.\n"
                + "Server Menu -> Port -> Port number to connect to.\n"
                + "Server Menu -> Name -> User nickname to use.\n"
                + "Connect -> Initiate a connection.\n"
                + "Cancel -> Cancel a setup.\n");

        ta_Doc.append("\n");
        ta_Doc.append("Help Menu -> Docs -> Opens this help overview\n"
                + "Help Menu -> About -> Credits the author and contributor of this program.\n");
        f_Doc.repaint();
    }//GEN-LAST:event_mi_docsActionPerformed

    private void tf_msgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_msgKeyPressed
        // TODO add your handling code here:
            message = tf_msg.getText();
             if( evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER )
             {

                 if(vsMsg.size() < 50)
                     vsMsg.addElement(message);

                 cc.msg = message;

                 try{
                    cc.streamOut.writeUTF(message);
                    cc.streamOut.flush();
                 }catch (IOException ioe){

                 }
             tf_msg.setText(null);
             }


    }//GEN-LAST:event_tf_msgKeyPressed

    private void tfd_serverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfd_serverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfd_serverActionPerformed

    private void mi_connectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mi_connectMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_mi_connectMouseClicked

    private void mi_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_connectActionPerformed
        // TODO add your handling code here:
        f_connect.setSize(400,400);

        f_connect.setTitle("Set Username and connect to server.");
        f_connect.setDefaultCloseOperation(1);
        f_connect.setVisible(true);
        f_connect.show(true);
        f_connect.repaint();

    }//GEN-LAST:event_mi_connectActionPerformed

    private void mi_disconnectActionPerformed(java.awt.event.ActionEvent evt) {
        cc.stop();
    }

    private void btn_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connectActionPerformed
        // TODO add your handling code here:
        cc = new ChatClient(tfd_server.getText(), Integer.parseInt(tfd_port.getText()), tfd_name.getText(), this);
        f_connect.setVisible(false);
        tab_server.setTitleAt(0, tfd_server.getText());
        clients_jList.setModel(cc.model);
    }//GEN-LAST:event_btn_connectActionPerformed

    private void mi_aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_aboutActionPerformed
        // TODO add your handling code here:
        f_about.setSize(400,400);
        f_about.setTitle("About the credits of this program.");
        f_about.setDefaultCloseOperation(1);
        f_about.setVisible(true);
        f_about.show(true);
        f_about.setTitle("Java Chat Program");
        ta_about.setText("Java Chat Program\n"
                + "Conceptualized, researched and developed by Edsel Malasig\n"
                + "Resources where taken from tenouk.com\n"
                + "as well as Carannos book\n"
                + "and O'Reileys Network Programming for Java\n"
                + "This software is licensed under GPL2\n"
                + "It is free and opensource.");
        f_about.repaint();
    }//GEN-LAST:event_mi_aboutActionPerformed

    private void f_aboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f_aboutMouseClicked
        // TODO add your handling code here:
        f_about.setSize(400,400);

        f_about.setTitle("About the credits of this program.");
        f_about.setDefaultCloseOperation(1);
        f_about.setVisible(true);
        f_about.show(true);
        f_about.setTitle("Java Chat Program");
        ta_about.setText("Java Chat Program\n"
                + "Conceptualized, researched and developed by Edsel Malasig\n"
                + "Resources where taken from tenouk.com\n"
                + "as well as Carannos book\n"
                + "and O'Reileys Network Programming for Java\n"
                + "This software is licensed under GPL2\n"
                + "It is free and opensource.");
        f_about.repaint();
    }//GEN-LAST:event_f_aboutMouseClicked


    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        // If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        // For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /// Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainJFrame().setVisible(true);
            }
        });
    }
    */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_connect;
    private javax.swing.JList<String> clients_jList;
    private javax.swing.JFrame f_Doc;
    private javax.swing.JFrame f_about;
    private javax.swing.JFrame f_connect;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_client;
    private javax.swing.JLabel lbl_message;
    private javax.swing.JLabel lbld_name;
    private javax.swing.JLabel lbld_port;
    private javax.swing.JLabel lbld_server;
    private javax.swing.JMenu menu_help;
    private javax.swing.JMenu menu_main;
    private javax.swing.JMenuItem mi_about;
    private javax.swing.JMenuItem mi_connect;
    private javax.swing.JMenuItem mi_disconnect;
    private javax.swing.JMenuItem mi_docs;
    private javax.swing.JMenuItem mi_exit;
    private javax.swing.JPanel pnl_client;
    private javax.swing.JPanel pnl_message;
    private javax.swing.JScrollPane sp_server;
    private java.awt.TextArea ta_Doc;
    private java.awt.TextArea ta_about;
    private javax.swing.JTextArea ta_server;
    private javax.swing.JTabbedPane tab_server;
    private javax.swing.JTextField tf_msg;
    private javax.swing.JTextField tfd_name;
    private javax.swing.JTextField tfd_port;
    private javax.swing.JTextField tfd_server;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextArea get_ta_server(){
        return ta_server;
    }


    public javax.swing.JTextField get_tf_msg(){
        return tf_msg;
    }

    public javax.swing.JTabbedPane get_tab_server(){
        return tab_server;
    }

}
