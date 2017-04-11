import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	/* the default image to use */
	String imageFile = "pro.jpg";

	public ImagePanel() {
		super();
	}

	public ImagePanel(String image) {
		super();
		this.imageFile = image;
	}

	public ImagePanel(LayoutManager layout) {
		super(layout);
	}

	public void paintComponent(Graphics g) {
		/* create image icon to get image */
		ImageIcon imageicon = new ImageIcon(imageFile);
		Image image = imageicon.getImage();

		/* Draw image on the panel */
		super.paintComponent(g);

		if (image != null)
			g.drawImage(image, 10, 10, getWidth(), getHeight(), this);
	}
}