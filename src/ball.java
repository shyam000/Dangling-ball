import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class ball {
	private static final int DIAMETER = 30;
	int x,y;
	double levelscore,xa,ya,level,level1;
	private game g;
	public int count;
	public ball(game g,int lev,int levelscore) {
		this.g= g;
		level=lev;
		level1 = lev;
		this.levelscore=levelscore;
		this.setVariables();
	}
	public void setVariables()
	{
		x=(int)level1;
		y=(int)level1;
		xa=level1;
		ya=level1;
		level = level1;
		count=0;
	}
	void move() {
		if (x + xa < 0)
			xa = level;
		if (x + xa > g.getWidth() - DIAMETER)
			xa = -level;
		if (y + ya < 0)
			ya = level;
		if (y + ya > g.getHeight() - DIAMETER)
		{
			g.gameOver(count);
		}
		
		if (collision()){
		//SoundClipTest s = new SoundClipTest();//ball hit sound;
			
			ya = -level;
			y = g.r.getTopY() - DIAMETER;
			count+=levelscore;
			//if(level1 < 10){
				if(level < 0){
					level = level - 0.50;
				}
				if(level > 0){
					level = level + 0.50;
				}
			//}
		}
		if(level1 > 2)
		if(collision1()){
			ya = -ya;
			//y = g.r.getTopY() - DIAMETER;
			
		}
		x = x + (int)xa;
		y = y + (int)ya;
	}

	int score() {
		return count;
	}

	private boolean collision() {
		return g.r.getBounds().intersects(getBounds());
	}
	private boolean collision1(){
		return   g.br.getBounds().intersects(getBounds());
	}
	
	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
		g.setColor(new Color(180,64,100));
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}

	
}