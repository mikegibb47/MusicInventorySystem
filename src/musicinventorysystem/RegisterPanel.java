/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicinventorysystem;

import java.awt.*;

/**
 *
 * @author 067011551
 */
public class RegisterPanel extends javax.swing.JPanel {

    //creates booleans to show
    //if the user has tried to register
    static Boolean regisTry = false;
    //if the registration was successful
    static Boolean register = false;
    /**
     * Creates new form RegisterPanel
     */
    public RegisterPanel() {
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g){
        //when the window is opened display register
        g.drawString("Register", 10, 10);
        if (regisTry == true) {
            super.paintComponent(g);
            if (register == true) {
                //if the registration is successful display that
                g.setColor(Color.BLUE);
                g.drawString("Registration: Successful", 0, 10);
            } else {
                //if the registration is unsuccessful display that
                g.setColor(Color.RED);
                g.drawString("Registration: Unsuccessful", 0, 10);
            }
            regisTry = false;
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
