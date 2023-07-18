/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author Mohammed
 */
public class jpanel extends JPanel{
   JPanel jp;

    public jpanel() {
    jp=new  JPanel();
jp.setBackground(new java.awt.Color(255, 25, 55));
jp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
jp.setSize(1060, 103);
        jp.setLocation(0, 23);
        jp.setBackground(Color.red);
JLabel jL=new JLabel();
 jp.add(jL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, -1, 50));
    }
    
}
