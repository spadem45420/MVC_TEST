package com.charlie.other.test;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayout1 extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() {
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(7, 3));
		for (int i = 0; i < 20; i++)
			cp.add(new JButton("Button " + i));
	}

	public static void main(String[] args) {
//		run(new GridLayout1(), 300, 250);
		run(new GridLayout1(), 600, 500);
	}

	public static void run(JApplet applet, int width, int height) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(applet);
		frame.setSize(width, height);
		applet.init();
		applet.start();
		frame.setVisible(true);
	}
} /// :~
