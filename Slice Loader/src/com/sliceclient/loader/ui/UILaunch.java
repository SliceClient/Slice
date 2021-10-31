package com.sliceclient.loader.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import com.sliceclient.loader.util.FileUtil;
import com.sliceclient.loader.util.GameUtil;


public class UILaunch extends JFrame {
	private String[] launchArgs;
	private final File minecraftFolder = FileUtil.getMinecraftFolder();
    private final File sliceFolder = new File(this.minecraftFolder.getAbsolutePath() + "/Slice");
	
	//public static JLabel HWIDLabel = new JLabel("                        Slice Client Jar Not Found!");
	 JButton button = new JButton("Launch Game");
    public UILaunch() {
   	 super("Slice  > Loader");
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        button.setBounds(250, 100, 200, 100);
        //button.setSize(200, 100);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Slice Loader > Game Launching");
                //GameUtil.util.launchGame();
            }
        });
        add(button);
        //getContentPane().add(button, BorderLayout.CENTER);
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
        UILaunch unw = new UILaunch();
    }
    
    public void launchGame(String[] args) {
    	
    }
}
