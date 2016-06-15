/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicinventorysystem;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author 067011551
 */
public class SuccessPanel extends javax.swing.JPanel {

    /**
     * Creates new form SuccessPanel
     */
    public static boolean login = false;
    public static boolean loginTry = false;
    
    public SuccessPanel() {
        initComponents();
    }

    public void paintComponent(Graphics g) {
        //display that the user needs to login or register
        g.drawString("Login or Register", 10, 10);
        if (loginTry == true) {
            super.paintComponent(g);
            //if the login is successful display that
            if (login == true) {
                g.setColor(Color.BLUE);
                g.drawString("Login: Successful", 10, 10);
            } else {
                //if the login is unsuccessful display that
                g.setColor(Color.RED);
                g.drawString("Login: Unsuccessful", 10, 10);
            }
            loginTry = false;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}