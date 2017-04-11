import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
public class racquet {
	int WIDTH = 60;
	private static final int HEIGHT = 10;
	int x,xa,level,level1,levelscore,Y=300;
	
	private game g;

	public racquet(game g,int lev) {
		this.g = g;
		level=lev+3;
		level1 = lev+3;
		setVariables();
	}
	public void setVariables()
	{
		x=level1;xa=level1;
		level = level1;
	}
	public void move() {
		if (x + xa > 0 && x + xa < g.getWidth() - WIDTH)
			x = x + xa;
	}

	public void paint(Graphics2D g,int x1,int y) {
		g.fillRect(x, y, x1, HEIGHT);
		Y=y;
		WIDTH=x1;
		g.setColor(new Color(174,0,1));
	}

	public void keyReleased(KeyEvent e) {
		xa=0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -level;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = level;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}

	public int getTopY() {
		return Y;
	}
}