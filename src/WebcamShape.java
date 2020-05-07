package com.galkins.webcam;

import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

public class WebcamShape {

	public static Picture bg;
	static JFrame window = new JFrame("Webcam Stream");

	public static void main(String[] args) throws IOException {

		Webcam webcam = Webcam.getDefault();
		webcam.setViewSize(WebcamResolution.VGA.getSize());

		WebcamPanel panel = new WebcamPanel(webcam);
		panel.setMirrored(true);

		System.out.println(webcam.getViewSize().getWidth());

		bg = new Picture(((int) webcam.getViewSize().getWidth() - 1000) / 2,
				-200, 1000, 1000,
				"http://galkins.fr/img/sioxox/rond.png");

		window.add(bg);
		window.add(panel);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
		window.setIconImage(ImageIO.read(new URL("http://galkins.fr/img/sioxox/icon.png")));
	}
}
