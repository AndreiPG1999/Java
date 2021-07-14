
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MainApp extends JFrame {
	JButton btn1 = new JButton("");
	JButton btn2 = new JButton("");
	JButton btn3 = new JButton("");
	JButton btn4 = new JButton("");
	JButton btn5 = new JButton("");
	JButton btn6 = new JButton("");
	JButton btn7 = new JButton("");
	JButton btn8 = new JButton("");
	JButton btn9 = new JButton("");
	private int clicks = 0;
	private String startGame = "X";
	private JPanel contentPane;
	private void choose_a_player()
	{
		if(startGame.equalsIgnoreCase("X"))
		{
			startGame = "O";
		}
		else
		{
			startGame = "X";
		}
	}
	private void Win()
	{
		boolean win = false;
		String b1=btn1.getText();
		String b2=btn2.getText();
		String b3=btn3.getText();
		String b4=btn4.getText();
		String b5=btn5.getText();
		String b6=btn6.getText();
		String b7=btn7.getText();
		String b8=btn8.getText();
		String b9=btn9.getText();
		
		if(b1.equals("O")&&b2.equals("O")&&b3.equals("O"))
		{
			btn1.setBackground(Color.red);
			btn2.setBackground(Color.red);
			btn3.setBackground(Color.red);
			JOptionPane.showMessageDialog(contentPane, "O PLAYER WINS!");
			win = true;
		}
		else if(b1.equals("X")&&b2.equals("X")&&b3.equals("X"))
		{
			btn1.setBackground(Color.blue);
			btn2.setBackground(Color.blue);
			btn3.setBackground(Color.blue);
			JOptionPane.showMessageDialog(contentPane, "X PLAYER WINS!");
			win = true;
		}
		else if(b4.equals("O")&&b5.equals("XO")&&b6.equals("O"))
		{
			btn4.setBackground(Color.red);
			btn5.setBackground(Color.red);
			btn6.setBackground(Color.red);
			JOptionPane.showMessageDialog(contentPane, "O PLAYER WINS!");
			win = true;
		}
		else if(b4.equals("X")&&b5.equals("X")&&b6.equals("X"))
		{
			btn4.setBackground(Color.blue);
			btn5.setBackground(Color.blue);
			btn6.setBackground(Color.blue);
			JOptionPane.showMessageDialog(contentPane, "X PLAYER WINS!");
			win = true;
		}
		else if(b7.equals("O")&&b8.equals("O")&&b9.equals("O"))
		{
			btn7.setBackground(Color.red);
			btn8.setBackground(Color.red);
			btn9.setBackground(Color.red);
			JOptionPane.showMessageDialog(contentPane, "O PLAYER WINS!");
			win = true;
		}
		else if(b7.equals("X")&&b8.equals("X")&&b9.equals("X"))
		{
			btn7.setBackground(Color.blue);
			btn8.setBackground(Color.blue);
			btn9.setBackground(Color.blue);
			JOptionPane.showMessageDialog(contentPane, "X PLAYER WINS!");
			win = true;
		}
		else if(b1.equals("O")&&b4.equals("O")&&b7.equals("O"))
		{
			btn1.setBackground(Color.red);
			btn4.setBackground(Color.red);
			btn7.setBackground(Color.red);
			JOptionPane.showMessageDialog(contentPane, "O PLAYER WINS!");
			win = true;
		}
		else if(b1.equals("X")&&b4.equals("X")&&b7.equals("X"))
		{
			btn1.setBackground(Color.blue);
			btn4.setBackground(Color.blue);
			btn7.setBackground(Color.blue);
			JOptionPane.showMessageDialog(contentPane, "X PLAYER WINS!");
			win = true;
		}
		else if(b2.equals("O")&&b5.equals("O")&&b8.equals("O"))
		{
			btn2.setBackground(Color.red);
			btn5.setBackground(Color.red);
			btn8.setBackground(Color.red);
			JOptionPane.showMessageDialog(contentPane, "O PLAYER WINS!");
			win = true;
		}
		else if(b2.equals("X")&&b5.equals("X")&&b8.equals("X"))
		{
			btn2.setBackground(Color.blue);
			btn5.setBackground(Color.blue);
			btn8.setBackground(Color.blue);
			JOptionPane.showMessageDialog(contentPane, "X PLAYER WINS!");
			win = true;
		}
		else if(b3.equals("O")&&b6.equals("O")&&b9.equals("O"))
		{
			btn3.setBackground(Color.red);
			btn6.setBackground(Color.red);
			btn9.setBackground(Color.red);
			JOptionPane.showMessageDialog(contentPane, "O PLAYER WINS!");
			win = true;
		}
		else if(b3.equals("X")&&b6.equals("X")&&b9.equals("X"))
		{
			btn3.setBackground(Color.blue);
			btn6.setBackground(Color.blue);
			btn9.setBackground(Color.blue);
			JOptionPane.showMessageDialog(contentPane, "X PLAYER WINS!");
			win = true;
		}
		else if(b1.equals("O")&&b5.equals("O")&&b9.equals("O"))
		{
			btn1.setBackground(Color.red);
			btn5.setBackground(Color.red);
			btn9.setBackground(Color.red);
			JOptionPane.showMessageDialog(contentPane, "O PLAYER WINS!");
			win = true;
		}
		else if(b1.equals("X")&&b5.equals("X")&&b9.equals("X"))
		{
			btn1.setBackground(Color.blue);
			btn5.setBackground(Color.blue);
			btn9.setBackground(Color.blue);
			JOptionPane.showMessageDialog(contentPane, "X PLAYER WINS!");
			win = true;
		}
		else if(b3.equals("O")&&b5.equals("O")&&b7.equals("O"))
		{
			btn3.setBackground(Color.red);
			btn5.setBackground(Color.red);
			btn7.setBackground(Color.red);
			JOptionPane.showMessageDialog(contentPane, "O PLAYER WINS!");
			win = true;
		}
		else if(b3.equals("X")&&b5.equals("X")&&b7.equals("X"))
		{
			btn3.setBackground(Color.blue);
			btn5.setBackground(Color.blue);
			btn7.setBackground(Color.blue);
			JOptionPane.showMessageDialog(contentPane, "X PLAYER WINS!");
			win = true;
		}
		if (win==true)
		{
			btn1.setText("");
			btn2.setText("");
			btn3.setText("");
			btn4.setText("");
			btn5.setText("");
			btn6.setText("");
			btn7.setText("");
			btn8.setText("");
			btn9.setText("");
			btn1.setBackground(null);
			btn2.setBackground(null);
			btn3.setBackground(null);
			btn4.setBackground(null);
			btn5.setBackground(null);
			btn6.setBackground(null);
			btn7.setBackground(null);
			btn8.setBackground(null);
			btn9.setBackground(null);
			clicks = 0;
		}
		if (win == false&&clicks == 9)
		{
			JOptionPane.showMessageDialog(contentPane, "Cats game!");
			btn1.setText("");
			btn2.setText("");
			btn3.setText("");
			btn4.setText("");
			btn5.setText("");
			btn6.setText("");
			btn7.setText("");
			btn8.setText("");
			btn9.setText("");
			btn1.setBackground(null);
			btn2.setBackground(null);
			btn3.setBackground(null);
			btn4.setBackground(null);
			btn5.setBackground(null);
			btn6.setBackground(null);
			btn7.setBackground(null);
			btn8.setBackground(null);
			btn9.setBackground(null);
			clicks = 0;
		}

		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainApp() {
		setTitle("TIC TAC TOE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clicks++;
				btn1.setText(startGame);
				if(startGame.equalsIgnoreCase("X"))
				{
					btn1.setForeground(Color.red);
				}
				else
				{
					btn1.setForeground(Color.black);
				}
				choose_a_player();
				Win();
			}
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 60));
		btn1.setBounds(47, 39, 107, 82);
		contentPane.add(btn1);
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clicks++;
				btn2.setText(startGame);
				if(startGame.equalsIgnoreCase("X"))
				{
					btn2.setForeground(Color.red);
				}
				else
				{
					btn2.setForeground(Color.black);
				}
				choose_a_player();
				Win();
			}
		});
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 60));
		btn2.setBounds(181, 39, 107, 82);
		contentPane.add(btn2);
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clicks++;
				btn3.setText(startGame);
				if(startGame.equalsIgnoreCase("X"))
				{
					btn3.setForeground(Color.red);
				}
				else
				{
					btn3.setForeground(Color.black);
				}
				choose_a_player();
				Win();
			}
		});
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 60));
		btn3.setBounds(315, 39, 107, 82);
		contentPane.add(btn3);
		
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clicks++;
				btn4.setText(startGame);
				if(startGame.equalsIgnoreCase("X"))
				{
					btn4.setForeground(Color.red);
				}
				else
				{
					btn4.setForeground(Color.black);
				}
				choose_a_player();
				Win();
			}
		});
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 60));
		btn4.setBounds(47, 150, 107, 82);
		contentPane.add(btn4);
		
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clicks++;
				btn5.setText(startGame);
				if(startGame.equalsIgnoreCase("X"))
				{
					btn5.setForeground(Color.red);
				}
				else
				{
					btn5.setForeground(Color.black);
				}
				choose_a_player();
				Win();
			}
		});
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 60));
		btn5.setBounds(181, 150, 107, 82);
		contentPane.add(btn5);
		
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clicks++;
				btn6.setText(startGame);
				if(startGame.equalsIgnoreCase("X"))
				{
					btn6.setForeground(Color.red);
				}
				else
				{
					btn6.setForeground(Color.black);
				}
				choose_a_player();
				Win();
			}
		});
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 60));
		btn6.setBounds(315, 150, 107, 82);
		contentPane.add(btn6);
		
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clicks++;
				btn7.setText(startGame);
				if(startGame.equalsIgnoreCase("X"))
				{
					btn7.setForeground(Color.red);
				}
				else
				{
					btn7.setForeground(Color.black);
				}
				choose_a_player();
				Win();
			}
		});
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 60));
		btn7.setBounds(47, 258, 107, 82);
		contentPane.add(btn7);
		
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clicks++;
				btn8.setText(startGame);
				if(startGame.equalsIgnoreCase("X"))
				{
					btn8.setForeground(Color.red);
				}
				else
				{
					btn8.setForeground(Color.black);
				}
				choose_a_player();
				Win();
			}
		});
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 60));
		btn8.setBounds(181, 258, 107, 82);
		contentPane.add(btn8);
		
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clicks++;
				btn9.setText(startGame);
				if(startGame.equalsIgnoreCase("X"))
				{
					btn9.setForeground(Color.red);
				}
				else
				{
					btn9.setForeground(Color.black);
				}
				choose_a_player();
				Win();
			}
		});
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 60));
		btn9.setBounds(315, 258, 107, 82);
		contentPane.add(btn9);
		
		JButton btnReset = new JButton("RESET ");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(contentPane, "Do you really want to reset?", "TIC TAC TOE", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{	
					btn1.setText("");
					btn2.setText("");
					btn3.setText("");
					btn4.setText("");
					btn5.setText("");
					btn6.setText("");
					btn7.setText("");
					btn8.setText("");
					btn9.setText("");
					btn1.setBackground(null);
					btn2.setBackground(null);
					btn3.setBackground(null);
					btn4.setBackground(null);
					btn5.setBackground(null);
					btn6.setBackground(null);
					btn7.setBackground(null);
					btn8.setBackground(null);
					btn9.setBackground(null);
					clicks = 0;
				}
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnReset.setBounds(100, 367, 122, 49);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new JFrame("Exit");
				
				if(JOptionPane.showConfirmDialog(frame, "Do you want to exit?", "TIC TAC TOE", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnExit.setBounds(257, 367, 122, 49);
		contentPane.add(btnExit);
	}
}
