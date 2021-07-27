package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SuppressWarnings("serial")
public class UserIndividual extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtFormID;
	private JTextField txtBatchNo;
	private JTextField txtStudentID;
	private JTextField txtFirstName;
	private JTextField txtMiddleName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtContact;
	private JTextField txtDateOfBirth;
	private JTextField txtSchoolName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserIndividual frame = new UserIndividual();
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
	public UserIndividual() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ResultSet r = null;
				PreparedStatement ps = null;
				try(Connection con = DbConnect.java_db())
				{
					String sql = "select * from infotable where student_id=? ";
					
					ps = con.prepareStatement(sql);
					ps.setString(1, textField.getText());
					r = ps.executeQuery();
					
					while(r.next())
					{
						String add1=r.getString("form_id");
						txtFormID.setText(add1);
						String add2=r.getString("batch_no");
						txtBatchNo.setText(add2);
						String add3 = r.getString("student_id");
						txtStudentID.setText(add3);
						String add4 = r.getString("first_name");
						txtFirstName.setText(add4);
						String add5 = r.getString("middle_name");
						txtMiddleName.setText(add5);
						String add6 = r.getString("last_name");
						txtLastName.setText(add6);
						String add7 = r.getString("email");
						txtEmail.setText(add7);
						String add8 = r.getString("contact");
						txtContact.setText(add8);
						String add9 =  r.getString("dob");
						txtDateOfBirth.setText(add9);
						String add10 = r.getString("name_of_school");
						txtSchoolName.setText(add10);
					}
				}
				catch (Exception ex) {
				} 
				finally {
				}

				try {

					r.close();
					ps.close();

				} catch (Exception ex) {}
			}
		});
		textField.setColumns(10);
		textField.setBounds(170, 58, 169, 19);
		contentPane.add(textField);
		
		JLabel lblNewLabel = new JLabel("Search student by ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 53, 150, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		Image imgB;
		try {
			imgB = ImageIO.read(getClass().getResource("/back.png"));
			btnBack.setIcon(new ImageIcon(imgB));
		} catch (IOException e) {
			e.printStackTrace();
		}
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserView usr = new UserView();
				usr.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(384, 53, 150, 33);
		contentPane.add(btnBack);
		
		JButton btnReset = new JButton("Reset");
		Image imgR;
		try {
			imgR = ImageIO.read(getClass().getResource("/reset.png"));
			btnReset.setIcon(new ImageIcon(imgR));
		} catch (IOException e) {
			e.printStackTrace();
		}
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtBatchNo.setText("");
				txtContact.setText("");
				txtDateOfBirth.setText("");
				txtEmail.setText("");
				txtFirstName.setText("");
				txtFormID.setText("");
				txtLastName.setText("");
				txtMiddleName.setText("");
				txtSchoolName.setText("");
				txtStudentID.setText("");
				textField.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBounds(564, 53, 150, 33);
		contentPane.add(btnReset);
		
		JButton btnLogout = new JButton("Logout");
		Image imgL;
		try {
			imgL = ImageIO.read(getClass().getResource("/logout.png"));
			btnLogout.setIcon(new ImageIcon(imgL));
		} catch (IOException e) {
			e.printStackTrace();
		}
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogIn log = new LogIn();
				log.setVisible(true);
				dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setBounds(738, 53, 150, 33);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel_1 = new JLabel("Form ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(75, 139, 68, 25);
		contentPane.add(lblNewLabel_1);
		
		txtFormID = new JTextField();
		txtFormID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFormID.setEditable(false);
		txtFormID.setBounds(175, 144, 106, 19);
		contentPane.add(txtFormID);
		txtFormID.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Batch No.");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(75, 216, 68, 25);
		contentPane.add(lblNewLabel_1_1);
		
		txtBatchNo = new JTextField();
		txtBatchNo.setEditable(false);
		txtBatchNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBatchNo.setColumns(10);
		txtBatchNo.setBounds(175, 219, 106, 19);
		contentPane.add(txtBatchNo);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Student ID");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(75, 294, 81, 25);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtStudentID = new JTextField();
		txtStudentID.setEditable(false);
		txtStudentID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtStudentID.setColumns(10);
		txtStudentID.setBounds(175, 297, 106, 19);
		contentPane.add(txtStudentID);
		
		JLabel lblNewLabel_1_2 = new JLabel("First Name");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(307, 139, 89, 25);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Middle Name");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(308, 216, 88, 25);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Last Name");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(308, 292, 88, 25);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Email");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_5.setBounds(520, 139, 68, 25);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Contact");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_6.setBounds(520, 216, 68, 25);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Date of Birth");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_7.setBounds(520, 292, 89, 25);
		contentPane.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("School Name");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_8.setBounds(738, 216, 98, 25);
		contentPane.add(lblNewLabel_1_8);
		
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFirstName.setEditable(false);
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(406, 144, 104, 19);
		contentPane.add(txtFirstName);
		
		txtMiddleName = new JTextField();
		txtMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMiddleName.setEditable(false);
		txtMiddleName.setColumns(10);
		txtMiddleName.setBounds(406, 221, 104, 19);
		contentPane.add(txtMiddleName);
		
		txtLastName = new JTextField();
		txtLastName.setEditable(false);
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtLastName.setColumns(10);
		txtLastName.setBounds(406, 297, 104, 19);
		contentPane.add(txtLastName);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(616, 144, 98, 19);
		contentPane.add(txtEmail);
		
		txtContact = new JTextField();
		txtContact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtContact.setEditable(false);
		txtContact.setColumns(10);
		txtContact.setBounds(616, 221, 98, 19);
		contentPane.add(txtContact);
		
		txtDateOfBirth = new JTextField();
		txtDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDateOfBirth.setEditable(false);
		txtDateOfBirth.setColumns(10);
		txtDateOfBirth.setBounds(616, 297, 98, 19);
		contentPane.add(txtDateOfBirth);
		
		txtSchoolName = new JTextField();
		txtSchoolName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSchoolName.setEditable(false);
		txtSchoolName.setColumns(10);
		txtSchoolName.setBounds(846, 221, 98, 19);
		contentPane.add(txtSchoolName);
	}
}
