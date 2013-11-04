import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

public class Zoom {

	// VARIABLES
	BufferedImage image;
	ImagePanel imagePanel = new ImagePanel();

	JFrame window = new JFrame();
	JPanel topPanel = new JPanel();
	JScrollPane scrollPane = new JScrollPane(imagePanel);
	
	private static final BorderLayout LAYOUT_STYLE_BORDER = new BorderLayout();

	// CONSTRUCTOR
	public Zoom() {

		window.setSize(600, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = window.getContentPane();

		c.setLayout(LAYOUT_STYLE_BORDER);
		
		c.add(topPanel, BorderLayout.CENTER);

		topPanel.add(scrollPane);

		window.setVisible(true);

	}

	// LOAD IMAGE
	public void loadImage() {

		String fileName = "mukmuk2.bmp";
		try {
			URL url = getClass().getResource(fileName);
			image = ImageIO.read(url);
		} catch (MalformedURLException mue) {
			System.out.println("URL trouble: " + mue.getMessage());
		} catch (IOException ioe) {
			System.out.println("read trouble: " + ioe.getMessage());
		}

	}

	// CUSTOM PANEL FOR IMAGES
	public class ImagePanel extends JPanel {

		double scale;
		
		public ImagePanel() {
			
			// SCALE
			scale = 1.0;
			
			loadImage();
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			//g.drawImage(image, 0, 0, null);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
			
//			Graphics2D g2 = (Graphics2D) g;
//			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
//					RenderingHints.VALUE_INTERPOLATION_BICUBIC);
//			int w = getWidth();
//			int h = getHeight();
//			int imageWidth = image.getWidth();
//			int imageHeight = image.getHeight();
//			double x = (w - scale * imageWidth) / 2;
//			double y = (h - scale * imageHeight) / 2;
//			AffineTransform at = AffineTransform.getTranslateInstance(x, y);
//			at.scale(scale, scale);
//			g2.drawRenderedImage(image, at);
		}
		
		// set dimensions of ImagePanel
		public Dimension getPreferredSize() {
			int w = (int) (scale * image.getWidth());
			int h = (int) (scale * image.getHeight());
			return new Dimension(w, h);
		}

	}

	public static void main(String[] args) {
		Zoom zoom1 = new Zoom();

	}

}
