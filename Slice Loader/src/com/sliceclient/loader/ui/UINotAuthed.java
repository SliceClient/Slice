package com.sliceclient.loader.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;


public class UINotAuthed extends JFrame {
	public static JLabel HWIDLabel = new JLabel("                            You Arent Authenticated! Did You Submit Your HWID?");
	 JButton save = new JButton("Copy HWID");
    public UINotAuthed() {
   	 super("Slice  > Security");
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
        UINotAuthed unw = new UINotAuthed();
        try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
