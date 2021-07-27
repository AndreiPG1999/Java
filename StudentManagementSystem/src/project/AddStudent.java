package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AddStudent extends JFrame {

	private JPanel contentPane;
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
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1077, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Add a new student");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(322, 10, 276, 52);
		contentPane.add(lblNewLabel);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminView av = new AdminView();
				av.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(10, 354, 150, 33);
		contentPane.add(btnBack);

		JButton btnReset = new JButton("Reset");
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
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBounds(448, 354, 150, 33);
		contentPane.add(btnReset);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogIn log = new LogIn();
				log.setVisible(true);
				dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setBounds(912, 354, 150, 33);
		contentPane.add(btnLogout);

		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to add this student?","WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					add_student();
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
					JOptionPane.showMessageDialog(null, "Student added!");
				}
			}
		});
		btnAddStudent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddStudent.setBounds(10, 311, 1052, 33);
		contentPane.add(btnAddStudent);

		JLabel lblNewLabel_1 = new JLabel("Form ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(92, 80, 68, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Batch No.");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(92, 150, 68, 25);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Student ID");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(92, 228, 81, 25);
		contentPane.add(lblNewLabel_1_1_1);

		txtFormID = new JTextField();
		txtFormID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFormID.setColumns(10);
		txtFormID.setBounds(188, 84, 106, 19);
		contentPane.add(txtFormID);

		txtBatchNo = new JTextField();
		txtBatchNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBatchNo.setColumns(10);
		txtBatchNo.setBounds(188, 154, 106, 19);
		contentPane.add(txtBatchNo);

		txtStudentID = new JTextField();
		txtStudentID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtStudentID.setColumns(10);
		txtStudentID.setBounds(188, 232, 106, 19);
		contentPane.add(txtStudentID);

		JLabel lblNewLabel_1_2 = new JLabel("First Name");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(356, 80, 89, 25);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Middle Name");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(357, 150, 88, 25);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Last Name");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(357, 227, 88, 25);
		contentPane.add(lblNewLabel_1_4);

		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(455, 85, 106, 19);
		contentPane.add(txtFirstName);

		txtMiddleName = new JTextField();
		txtMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMiddleName.setColumns(10);
		txtMiddleName.setBounds(455, 155, 106, 19);
		contentPane.add(txtMiddleName);

		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtLastName.setColumns(10);
		txtLastName.setBounds(455, 232, 106, 19);
		contentPane.add(txtLastName);

		JLabel lblNewLabel_1_5 = new JLabel("Email");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_5.setBounds(601, 80, 68, 25);
		contentPane.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("Contact");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_6.setBounds(601, 150, 68, 25);
		contentPane.add(lblNewLabel_1_6);

		JLabel lblNewLabel_1_7 = new JLabel("Date of Birth");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_7.setBounds(601, 227, 89, 25);
		contentPane.add(lblNewLabel_1_7);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(702, 84, 176, 19);
		contentPane.add(txtEmail);

		txtContact = new JTextField();
		txtContact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtContact.setColumns(10);
		txtContact.setBounds(702, 154, 106, 19);
		contentPane.add(txtContact);

		txtDateOfBirth = new JTextField();
		txtDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDateOfBirth.setColumns(10);
		txtDateOfBirth.setBounds(702, 232, 106, 19);
		contentPane.add(txtDateOfBirth);

		JLabel lblNewLabel_1_8 = new JLabel("School Name");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_8.setBounds(825, 150, 98, 25);
		contentPane.add(lblNewLabel_1_8);

		txtSchoolName = new JTextField();
		txtSchoolName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSchoolName.setColumns(10);
		txtSchoolName.setBounds(933, 155, 129, 19);
		contentPane.add(txtSchoolName);
	}

	private void add_student() {
		PreparedStatement ps = null;
		Connection con = DbConnect.java_db();
		try {
			int v1 = Integer.parseInt(txtFormID.getText());
			int v2 = Integer.parseInt(txtBatchNo.getText());
			int v3 = Integer.parseInt(txtStudentID.getText());
			String v4 = txtFirstName.getText();
			String v5 = txtMiddleName.getText();
			String v6 = txtLastName.getText();
			String v7 = txtEmail.getText();
			String v8 = txtContact.getText();
			String v9 = txtDateOfBirth.getText();
			String v10 = txtSchoolName.getText();
			String sql = "insert into infotable (form_id,batch_no,student_id,first_name,middle_name,last_name,email,contact,dob,name_of_school)"
					+"values(?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, v1);
			ps.setInt(2, v2);
			ps.setInt(3, v3);
			ps.setString(4, v4);
			ps.setString(5, v5);
			ps.setString(6, v6);
			ps.setString(7, v7);
			ps.setString(8, v8);
			ps.setString(9, v9);
			ps.setString(10, v10);
			ps.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {
			try {
				ps.close();
			} catch (Exception e) {
			}
		}
	}
}
