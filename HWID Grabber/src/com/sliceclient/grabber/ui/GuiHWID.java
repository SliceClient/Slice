package com.sliceclient.grabber.ui;

import java.awt.BorderLayout;

import javax.swing.*;

import com.sliceclient.grabber.HWIDGrabber;

public class GuiHWID extends JFrame {
	public static JLabel HWIDLabel = new JLabel("                      HWID Copied To Clipboard!");
	 JButton save = new JButton("Copy HWID");
     public GuiHWID() {
    	 super("Slice  > HWID Grabber");
         setSize(300, 100);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
         getContentPane().add(HWIDLabel, BorderLayout.CENTER);
     }

     private static void setLookAndFeel() {
         try {
             UIManager.setLookAndFeel(
                 "javax.swing.plaf.nimbus.NimbusLookAndFeel"
             );
         } catch (Exception exc) {
             // ignore error
         }
     }

     public static void open(){
         setLookAndFeel();
         GuiHWID gh = new GuiHWID();
     }
 }
