import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

public class bricks {
	int WIDTH = 40;
	private static final int HEIGHT = 5;
	int x,xa,level,levelscore,Y=100;
	private game g;

	public bricks(game g,int lev) {
		this.g = g;
		//level=lev+3;
		setVariables();
	}
	public void setVariables()
	{
		//x=level+5;xa=level+5;
	}
	/*public void move() {
		if (x + xa > 0 && x + xa < g.getWidth() - WIDTH)
			x = x + xa;
	}*/

	public void paint(Graphics2D g,int x1,int y,int x2) {
		g.fillRect(x2, y, x1, HEIGHT);
		Y=y;
		x = x2;
		WIDTH=x1;
		g.setColor(new Color(100,00,00));
	}
/*
	public void keyReleased(KeyEvent e) {
		xa=0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -level;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = level;
	}
*/
	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}

	public int getTopY() {
		return Y;
	}
}