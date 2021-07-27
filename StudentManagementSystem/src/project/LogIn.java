package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class LogIn extends JFrame{

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setTitle("Log in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUser.setBounds(320, 69, 207, 19);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(238, 69, 72, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(238, 118, 72, 16);
		contentPane.add(lblPassword);
		
		JButton btnUser = new JButton("Log in as User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uname = txtUser.getText();
				String upass = new String(txtPass.getPassword());
				if(uname.equals("user")&&upass.equals("pass"))
				{
					UserView uv = new UserView();
					uv.setVisible(true);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Wrong username or password!");
					txtUser.setText("");
					txtPass.setText("");
					txtUser.requestFocus();
				}
			}
		});
		btnUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUser.setBounds(263, 194, 137, 36);
		contentPane.add(btnUser);
		
		JButton btnAdmin = new JButton("Log in as Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String auser = txtUser.getText();
				String apass = new String(txtPass.getPassword());
				if(auser.equals("admin")&&apass.equals("pass"))
				{
					AdminView av = new AdminView();
					av.setVisible(true);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Wrong username or password!");
					txtUser.setText("");
					txtPass.setText("");
					txtUser.requestFocus();
				}
			}
		});
		btnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdmin.setBounds(410, 194, 150, 36);
		contentPane.add(btnAdmin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBounds(498, 290, 85, 35);
		contentPane.add(btnExit);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPass.setBounds(320, 118, 207, 19);
		contentPane.add(txtPass);
		
		JLabel lblNewLabel_1 = new JLabel("Log In");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(230, 10, 174, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		lblNewLabel_2.setBounds(44, 43, 174, 258);
		contentPane.add(lblNewLabel_2);
	}
}
