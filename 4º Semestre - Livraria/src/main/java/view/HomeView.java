package view;

import java.beans.PropertyVetoException;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class HomeView extends javax.swing.JFrame {

    public HomeView() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuLivros = new javax.swing.JMenu();
        jMenuItemLivros = new javax.swing.JMenuItem();
        jMenuAutores = new javax.swing.JMenu();
        jMenuItemAutores = new javax.swing.JMenuItem();
        jMenuEditoras = new javax.swing.JMenu();
        jMenuItemEditoras = new javax.swing.JMenuItem();
        jMenuSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jDesktopPane1.setBackground(new java.awt.Color(51, 51, 51));
        jDesktopPane1.setName("jDesktopPanel"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Seja Bem-Vindo ao Sistema de Gerenciamento de Livrarias!");

        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel2)
                .addContainerGap(462, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jMenuLivros.setText("Livros");

        jMenuItemLivros.setText("Menu Livros");
        jMenuItemLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLivrosActionPerformed(evt);
            }
        });
        jMenuLivros.add(jMenuItemLivros);

        jMenuBar1.add(jMenuLivros);

        jMenuAutores.setText("Autores");

        jMenuItemAutores.setText("Menu Autores");
        jMenuItemAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAutoresActionPerformed(evt);
            }
        });
        jMenuAutores.add(jMenuItemAutores);

        jMenuBar1.add(jMenuAutores);

        jMenuEditoras.setText("Editoras");

        jMenuItemEditoras.setText("Menu Editoras");
        jMenuItemEditoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditorasActionPerformed(evt);
            }
        });
        jMenuEditoras.add(jMenuItemEditoras);

        jMenuBar1.add(jMenuEditoras);

        jMenuSobre.setText("Sobre");
        jMenuSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSobreMouseClicked(evt);
            }
        });
        jMenuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSobreActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenuSobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    String msgErroJanelaAberta = "Já existe uma janela aberta";
    
    ListBookView listBook = new ListBookView();
    ListAuthorView listAuthor = new ListAuthorView();
    ListPublisherView listPublisher = new ListPublisherView();
    AboutView aboutView = new AboutView();
    
    List<JInternalFrame> screens = Arrays.asList(listBook, listAuthor, listPublisher, aboutView);
    
    public boolean checkScreenOpened(){
        return screens.stream().filter(screen -> screen.isVisible()).toArray().length > 0;  
    }
     
    private void jMenuItemLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLivrosActionPerformed
                 
        if(checkScreenOpened()){
            JOptionPane.showMessageDialog(null, msgErroJanelaAberta);
            return;
        } 
        else {
            jDesktopPane1.add(listBook);  
            listBook.setVisible(true);  
             try {
                listBook.setMaximum(true);
                } 
             catch (PropertyVetoException ex) {          
                }
        }                  
    }//GEN-LAST:event_jMenuItemLivrosActionPerformed

    private void jMenuItemAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAutoresActionPerformed
        
        if(checkScreenOpened()){
            JOptionPane.showMessageDialog(null, msgErroJanelaAberta);
            return;
        } 
        else {
            jDesktopPane1.add(listAuthor);  
            listAuthor.setVisible(true);  
             try {
                listAuthor.setMaximum(true);
                } 
             catch (PropertyVetoException ex) {          
                }
        }     
        
    }//GEN-LAST:event_jMenuItemAutoresActionPerformed

    private void jMenuItemEditorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditorasActionPerformed
        
        if(checkScreenOpened()){
            JOptionPane.showMessageDialog(null, msgErroJanelaAberta);
            return;
        } 
        else {
            jDesktopPane1.add(listPublisher);  
            listPublisher.setVisible(true);  
             try {
                listPublisher.setMaximum(true);
                } 
             catch (PropertyVetoException ex) {          
                }
        }    
    }//GEN-LAST:event_jMenuItemEditorasActionPerformed

    private void jMenuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSobreActionPerformed
        if(checkScreenOpened()){
            JOptionPane.showMessageDialog(null, msgErroJanelaAberta);
            return;
        } 
        else {
            jDesktopPane1.add(aboutView);  
            aboutView.setVisible(true);  
             try {
                aboutView.setMaximum(true);
                } 
             catch (PropertyVetoException ex) {          
                }
        }    
    }//GEN-LAST:event_jMenuSobreActionPerformed

    private void jMenuSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSobreMouseClicked
        if(checkScreenOpened()){
            JOptionPane.showMessageDialog(null, msgErroJanelaAberta);
            return;
        } 
        else {
            jDesktopPane1.add(aboutView);  
            aboutView.setVisible(true);  
             try {
                aboutView.setMaximum(true);
                } 
             catch (PropertyVetoException ex) {          
                }
        }    
    }//GEN-LAST:event_jMenuSobreMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenuAutores;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEditoras;
    private javax.swing.JMenuItem jMenuItemAutores;
    private javax.swing.JMenuItem jMenuItemEditoras;
    private javax.swing.JMenuItem jMenuItemLivros;
    private javax.swing.JMenu jMenuLivros;
    private javax.swing.JMenu jMenuSobre;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
