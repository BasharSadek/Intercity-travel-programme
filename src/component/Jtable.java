/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Mohammed
 */
public class Jtable extends javax.swing.JTable{
//    JScrollPane jp=  new JScrollPane(this);
    public Jtable(){
     this.setBackground(new Color(0,0,0,0));
    ((DefaultTableCellRenderer)this.getDefaultRenderer(Object.class)).setBackground(new Color(0, 0, 0, 0));
 this. setBackground(Color.WHITE);
  this.setForeground(Color.white);
//  jp.setBackground(new Color(0, 0, 0, 0));
//  jp.setOpaque(false);
    ((DefaultTableCellRenderer)this.getDefaultRenderer(Object.class)).setOpaque(false);
//    jp.getViewport().setOpaque(false);
  this.setOpaque(false);
    }
}
