package com.galkins.webcam;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Picture extends JButton {

	private static final long serialVersionUID = 1L;
	private Image img;

	public Picture(int x, int y, int w, int h, String file) {
		setBounds(x, y, w, h);

		try {
			img = ImageIO.read((new URL(file)));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		setBackground(new Color(0, 0, 0, 0));
		setBorderPainted(false);
		setVisible(true);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		WebcamShape.window.repaint();
	}
}
