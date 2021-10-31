package com.sliceclient.loader.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;


public class UIJarNotFound extends JFrame {
	public static JLabel HWIDLabel = new JLabel("                        Slice Client Jar Not Found!");
	 JButton save = new JButton("Copy HWID");
    public UIJarNotFound() {
   	 super("Slice  > Loader");
        setSize(500, 200);
        setLocationRelativeTo(null);
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

    public static void openUI(){
        //setLookAndFeel();
        UIJarNotFound unw = new UIJarNotFound();
    }
}
