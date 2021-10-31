package com.sliceclient.grabber;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import com.sliceclient.grabber.ui.GuiHWID;
import com.sliceclient.grabber.util.HWIDUtil;


public class HWIDGrabber  {
	public static final String HWID = HWIDUtil.getHWID();
	public static JLabel HWIDLabel = new JLabel(HWID);
	//public static JLabel SendToLabel = new JLabel("Send this to a support member or developer!");
	public static void main(String[] args) {
	            System.out.println("Slice HWID Grabber > HWID: " + HWID);
	            GuiHWID.open();
	            StringSelection stringSelection = new StringSelection(HWID);
	            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	            clipboard.setContents(stringSelection, null);
	            /*JFrame frame = new JFrame("Slice HWID Grabber");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.getContentPane().add(HWIDLabel, BorderLayout.CENTER);
//	            /frame.getContentPane().add(SendToLabel, BorderLayout.CENTER);
	            HWIDLabel.setPreferredSize(new Dimension(500, 200));
	            frame.setLocationRelativeTo(null); 
	            frame.pack();
	            frame.setVisible(true);*/
	}
}