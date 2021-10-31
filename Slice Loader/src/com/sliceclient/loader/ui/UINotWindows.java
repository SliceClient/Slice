package com.sliceclient.loader.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;


public class UINotWindows extends JFrame {
	public static JLabel HWIDLabel = new JLabel("                        You Arent Running Windows! This May Cause Issues Later.");
	 JButton save = new JButton("Copy HWID");
    public UINotWindows() {
   	 super("Slice  > Loader");
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
        UINotWindows unw = new UINotWindows();
    }
}
