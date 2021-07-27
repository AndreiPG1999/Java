package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdminIndividual extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
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
					AdminIndividual frame = new AdminIndividual();
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
	public AdminIndividual() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1059, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search student by ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 41, 150, 25);
		contentPane.add(lblNewLabel);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ResultSet r = null;
				PreparedStatement ps = null;
				try(Connection con = DbConnect.java_db())
				{
					String sql = "select * from infotable where student_id=? ";
					
					ps = con.prepareStatement(sql);
					ps.setString(1, txtSearch.getText());
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
		txtSearch.setColumns(10);
		txtSearch.setBounds(170, 46, 169, 19);
		contentPane.add(txtSearch);
		
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
				AdminView av = new AdminView();
				av.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(381, 41, 150, 33);
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
				txtSearch.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBounds(554, 41, 150, 33);
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
		btnLogout.setBounds(726, 41, 150, 33);
		contentPane.add(btnLogout);
		
		JButton btnDelete = new JButton("Delete");
		Image imgD;
		try {
			imgD = ImageIO.read(getClass().getResource("/delete.png"));
			Image newimgD = imgD.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			btnDelete.setIcon(new ImageIcon(newimgD));
		} catch (IOException e) {
			e.printStackTrace();
		}
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtSearch.getText().equals(""))
					JOptionPane.showMessageDialog(null, "No student selected!");
				else if(JOptionPane.showConfirmDialog(null, "Do you really want to delete?","WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					delete();
					JOptionPane.showMessageDialog(null, "Student deleted successfully!");
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(895, 41, 150, 33);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("Form ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(67, 136, 68, 25);
		contentPane.add(lblNewLabel_1);
		
		txtFormID = new JTextField();
		txtFormID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFormID.setColumns(10);
		txtFormID.setBounds(170, 141, 106, 19);
		contentPane.add(txtFormID);
		
		JLabel lblNewLabel_1_1 = new JLabel("Batch No.");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(67, 205, 68, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Student ID");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(67, 284, 81, 25);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtBatchNo = new JTextField();
		txtBatchNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBatchNo.setColumns(10);
		txtBatchNo.setBounds(170, 210, 106, 19);
		contentPane.add(txtBatchNo);
		
		txtStudentID = new JTextField();
		txtStudentID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtStudentID.setColumns(10);
		txtStudentID.setBounds(170, 289, 106, 19);
		contentPane.add(txtStudentID);
		
		JLabel lblNewLabel_1_2 = new JLabel("First Name");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(321, 136, 89, 25);
		contentPane.add(lblNewLabel_1_2);
		
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(427, 141, 104, 19);
		contentPane.add(txtFirstName);
		
		JLabel lblNewLabel_1_3 = new JLabel("Middle Name");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(321, 205, 88, 25);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Last Name");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(321, 284, 88, 25);
		contentPane.add(lblNewLabel_1_4);
		
		txtMiddleName = new JTextField();
		txtMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMiddleName.setColumns(10);
		txtMiddleName.setBounds(427, 210, 104, 19);
		contentPane.add(txtMiddleName);
		
		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtLastName.setColumns(10);
		txtLastName.setBounds(427, 289, 104, 19);
		contentPane.add(txtLastName);
		
		JLabel lblNewLabel_1_5 = new JLabel("Email");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_5.setBounds(554, 136, 68, 25);
		contentPane.add(lblNewLabel_1_5);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(647, 141, 98, 19);
		contentPane.add(txtEmail);
		
		txtContact = new JTextField();
		txtContact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtContact.setColumns(10);
		txtContact.setBounds(647, 210, 98, 19);
		contentPane.add(txtContact);
		
		JLabel lblNewLabel_1_6 = new JLabel("Contact");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_6.setBounds(554, 205, 68, 25);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Date of Birth");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_7.setBounds(558, 284, 89, 25);
		contentPane.add(lblNewLabel_1_7);
		
		txtDateOfBirth = new JTextField();
		txtDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDateOfBirth.setColumns(10);
		txtDateOfBirth.setBounds(647, 289, 98, 19);
		contentPane.add(txtDateOfBirth);
		
		JLabel lblNewLabel_1_8 = new JLabel("School Name");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_8.setBounds(785, 205, 98, 25);
		contentPane.add(lblNewLabel_1_8);
		
		txtSchoolName = new JTextField();
		txtSchoolName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSchoolName.setColumns(10);
		txtSchoolName.setBounds(895, 209, 98, 19);
		contentPane.add(txtSchoolName);
		
		JButton btnUpdate = new JButton("Update");
		Image imgU;
		try {
			imgU = ImageIO.read(getClass().getResource("/update.png"));
			Image newimgU = imgU.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			btnUpdate.setIcon(new ImageIcon(newimgU));
		} catch (IOException e) {
			e.printStackTrace();
		}
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure that you want to update?","WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					updateStudent();
					JOptionPane.showMessageDialog(null, "Updated successfully!");
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(895, 95, 150, 33);
		contentPane.add(btnUpdate);
	}
	private void updateStudent() {
		PreparedStatement ps = null;
		Connection con = DbConnect.java_db();
		try {
			String v0=txtSearch.getText();
			String v1=txtFormID.getText();
			String v2=txtBatchNo.getText();
			String v3 = txtStudentID.getText();
			String v4 = txtFirstName.getText();
			String v5 = txtMiddleName.getText();
			String v6 = txtLastName.getText();
			String v7 = txtEmail.getText();
			String v8 = txtContact.getText();
			String v9 = txtDateOfBirth.getText();
			String v10 = txtSchoolName.getText();
			String sql = "update infotable set form_id='" + v1 + "',batch_no='" + v2 + "',student_id='" + v3
					+ "',first_name='" + v4 + "',middle_name='" + v5 + "',last_name='" + v6 + "',email='" + v7
					+ "',contact='" + v8 + "',dob='" + v9 + "',name_of_school='" + v10 + "'" + "where student_id='" + v0
					+ "'";
			ps = con.prepareStatement(sql);
			ps.execute();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		finally {
			try {
				ps.close();
			} catch (Exception e) {
			}
		}
	}
	private void delete()
	{
		PreparedStatement ps = null;
		Connection con = DbConnect.java_db();
		try {

			String sql = "delete from infotable where student_id=?";
			
			ps = con.prepareStatement(sql);
			String deletedID = txtSearch.getText();
			ps.setString(1, deletedID);
			ps.execute();
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
			txtSearch.setText("");

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
