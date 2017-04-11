import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class game extends JPanel implements KeyListener,ActionListener {

	public int gameover=0,var=0,level,levelscore,a,x4;
	static JFrame gameframe;
	ball b;
	racquet r;
	bricks br;
	public game(int lev,int levelscore) {
		level=lev;
		b = new ball(this,level,levelscore);
		r = new racquet(this,level);
		if(level > 2){
		br = new bricks(this,level);
		}
		setFocusable(true);
		addKeyListener(this);
		Timer time=new Timer(1000/60,this);
		time.start();
		Random ra = new Random();
		a = ra.nextInt(400) + 100;
		x4 = ra.nextInt(400)+80;
	}
	
	private void move() {
		b.move();
		if(var==1)
		r.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(gameover==0)
		{
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
			b.paint(g2d);
			r.paint(g2d,getWidth()/7,getHeight()-20);
			if(level > 2)
			br.paint(g2d,getWidth()/7,getHeight()-a,x4);
		}
		else
		{
			Graphics2D g2d = (Graphics2D) g;
			g2d.setFont(new java.awt.Font("Showcard Gothic", 1, 30));
		//	g2d.setBackground(new java.awt.Color(100, 50, 50));
			g2d.setColor(new java.awt.Color(0, 255, 102));
			g2d.drawString("Game Over", 200, 250);
			g2d.drawString("Your Score is:"+String.valueOf(b.score()), 180,300);
			g2d.setFont(new java.awt.Font("Showcard Gothic", 1, 24));
			g2d.drawString("Press 'SPACE' to restart", 160, 450);
			g2d.drawString("Press 'ESCAPE' to open Main Menu", 100, 500);
		}
	}
	
	public void gameOver(int score) {
		gameover=1;
		var=0;
		updateHighScore(score);
		Random ra = new Random();
		a = ra.nextInt(400) + 100;
		x4 = ra.nextInt(400)+80;
	}
	public void updateHighScore(int score)
	{
		String highscore="";
		try {
			File f= new File("F:/highscore.txt");
			InputStream is=new FileInputStream(f);
			int n=is.available();				
			for(int i=0;i<n;i++){
				highscore=highscore+(char)is.read();
			}
		} catch (Exception e1) {
			
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int hs=Integer.parseInt(highscore);
		if(score>hs)
		{
			highscore=String.valueOf(score);
			try {
				File f= new File("F:/highscore.txt");
				OutputStream os=new FileOutputStream(f);
				os.write(highscore.getBytes());
			} catch (Exception e1) {
				
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(gameover==0)
		{
			if(e.getKeyCode() == KeyEvent.VK_LEFT||e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				r.keyPressed(e);					
				var=1;
			}
		}
		else
		{
			if(e.getKeyCode()==KeyEvent.VK_SPACE)
			{	
				b.setVariables();
				r.setVariables();
				gameover=0;
			}
			else if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
			{
				gameframe.setVisible(false);
				gameframe.dispose();				
				new main().setVisible(true);	
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(gameover==0)
		{
			if(e.getKeyCode() == KeyEvent.VK_LEFT||e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				r.keyReleased(e);
				var=1;
			}
		}
		else
		{
			if(e.getKeyCode()==KeyEvent.VK_SPACE)
			{
				gameover=0;
				b.setVariables();
				r.setVariables();
			}			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		step();
	}

	private void step() {
		// TODO Auto-generated method stub
		this.move();
		this.repaint();
	}

	public static void setframe(JFrame frame) {
		// TODO Auto-generated method stub
		gameframe=frame;
	}
}