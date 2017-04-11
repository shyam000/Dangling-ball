

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.management.timer.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class main extends JFrame implements ActionListener{
	private JButton btn1 = new JButton("EASY");
	private JButton btn6 = new JButton("HELP");
	private JButton btn3 = new JButton("HARD");
	private JButton btn4 = new JButton("HIGH SCORE");
	private JButton btn2 = new JButton("MEDIUM");
	private JButton btn5 = new JButton("EXIT");
	JFrame frame = new JFrame("Dangling Ball");						
	public main() {
		super("Dangling Ball-Main Menu");
	

		/* Create a panel to add the button panel */
		JPanel panel = new ImagePanel(new FlowLayout(FlowLayout.CENTER, 50, 180));

		/* this button panel is to add in the buttons */
		JPanel panelbtn = new JPanel(new GridLayout(4, 1));

		/* Add the button to the button panel */
		/* these buttons are customized font and color */
	//	addKeyListener(this);
		btn1.setBackground(new java.awt.Color(192, 192,192));
		btn1.setFont(new java.awt.Font("showcard gothic", 1, 24));
		btn1.setForeground(new java.awt.Color(0, 0, 0));
		btn2.setBackground(new java.awt.Color(192, 192,192));
		btn2.setFont(new java.awt.Font("showcard gothic", 1, 24));
		btn2.setForeground(new java.awt.Color(0, 0, 0));
		btn3.setBackground(new java.awt.Color(192, 192,192));
		btn3.setFont(new java.awt.Font("showcard gothic", 1, 24));
		btn3.setForeground(new java.awt.Color(0, 0, 0));
		btn4.setBackground(new java.awt.Color(192, 192,192));
		btn4.setFont(new java.awt.Font("showcard gothic", 1, 24));
		btn4.setForeground(new java.awt.Color(0, 0, 0));
		btn5.setBackground(new java.awt.Color(192, 192,192));
		btn5.setFont(new java.awt.Font("showcard gothic", 1, 24));
		btn5.setForeground(new java.awt.Color(0, 0, 0));
		btn6.setBackground(new java.awt.Color(192, 192,192));
		btn6.setFont(new java.awt.Font("showcard gothic", 1, 24));
		btn6.setForeground(new java.awt.Color(0, 0, 0));
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		panel.add(panelbtn);

		panelbtn.add(btn1);
		panelbtn.add(btn6);
		
		panelbtn.add(btn2);
		panelbtn.add(btn4);
		
		panelbtn.add(btn3);
		panelbtn.add(btn5);
		
		/* Add the panel to the frame */
		add(panel, BorderLayout.CENTER);

		/* set size of the frame */
		setSize(600, 600);
		/* close operation */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String... args) {
		new main().setVisible(true);		
	}
	public void mainmenu()
	{
		new main().setVisible(true);		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String action=e.getActionCommand();
		int level=0,levelscore=0;	
		if(action.equals("HIGH SCORE"))
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
			
			frame.setTitle("HIGH SCORE");
			JPanel panel = new ImagePanel(new FlowLayout(FlowLayout.CENTER, 50, 180));			
			JPanel panelbtn = new JPanel(new GridLayout(2, 1));			
			JButton label=new JButton("Your High Score is :"+highscore);
			//JLabel label=new JLabel("Your score is 30");			
			label.setBackground(Color.BLACK);
			label.setFont(new java.awt.Font("showcard gothic", 1, 24));			
			label.setForeground(new java.awt.Color(0, 255, 102));	
			panel.add(panelbtn);
			panel.setBackground(Color.PINK);
			panelbtn.add(label);
			JButton button=new JButton("EXIT");
			button.setBackground(Color.BLACK);
			button.setFont(new java.awt.Font("showcard gothic", 1, 24));			
			button.setForeground(new java.awt.Color(0, 255, 102));
			button.addActionListener(this);			
			panelbtn.add(button);
			frame.add(panel, BorderLayout.CENTER);
			frame.setSize(600,600);
			frame.setBackground(Color.RED);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		}
		else if(action.equals("EXIT"))
		{
			frame.setVisible(false);
			frame.dispose();			
			new main().setVisible(true);
			return ;
		}
		else if(action.equals("EASY")){
			level=2;
			levelscore=1;
		}
		else if(action.equals("MEDIUM")){
			level=5;
			levelscore=3;			
		}
		else if(action.equals("HARD")){
			level=10;
			levelscore=7;			
		}
		else if(action.equals("HELP"))
		{
			//JTextArea t;
	        JPanel p;
			setLayout(new BorderLayout());
			p = new ImagePanel();
			/*t = new JTextArea("Move the Racquet such that the ball hits and is rebounded \n Left Arrow ---> To Move the Racquet to left \n RIght Arrow ---> To Move the Racquet to right \n",4,5);
			p.add(t);
			t.setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);*/
			frame.setTitle("Help");
			JPanel pb = new JPanel(new GridLayout(2, 3));			
			JTextArea label = new JTextArea("Move the Racquet such that the\n ball hits and is rebounded \n Left Arrow ---> To Move the Racquet to left \n RIght Arrow ---> To Move the Racquet to right \n",4,5);
			//JLabel label=new JLabel("Your score is 30");			
			label.setBackground(Color.BLACK);
			label.setFont(new java.awt.Font("showcard gothic", 3, 20));			
			label.setForeground(new java.awt.Color(0, 255, 102));	
			//p.add(pb);
			pb.add(label);
			JButton button=new JButton("EXIT");
			button.setBackground(Color.BLACK);
			button.setFont(new java.awt.Font("showcard gothic", 1, 24));			
			button.setForeground(new java.awt.Color(0, 255, 102));
			button.setAlignmentX(CENTER_ALIGNMENT);
			button.addActionListener(this);			
			p.add(button);

			frame.add(p, BorderLayout.CENTER);
			frame.setSize(600,600);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		if((!action.equals("HIGH SCORE"))&&(!action.equals("EXIT")) &&(!action.equals("HELP"))){
			game g = new game(level,levelscore);
			frame.add(g);
		}
		frame.setSize(600,600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		game.setframe(frame);		
		this.setVisible(false);
		this.dispose();
		return ;
	}
}