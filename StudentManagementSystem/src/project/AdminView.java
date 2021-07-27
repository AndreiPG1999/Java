package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class AdminView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection con = null;
	ResultSet r = null;
	PreparedStatement st = null;
	String sql;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView frame = new AdminView();
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
	public AdminView() {
		setForeground(Color.BLACK);
		setTitle("Admin View");
		con = DbConnect.java_db();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 916, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIndividual = new JButton("Show Individual");
		Image imgS;
		try {
			imgS = ImageIO.read(getClass().getResource("/student.png"));
			Image newimgS = imgS.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			btnIndividual.setIcon(new ImageIcon(newimgS));
		} catch (IOException e) {
			e.printStackTrace();
		}
		btnIndividual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminIndividual ai = new AdminIndividual();
				ai.setVisible(true);
				dispose();
			}
		});
		btnIndividual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIndividual.setBounds(20, 422, 199, 33);
		contentPane.add(btnIndividual);
		
		JButton btnInsert = new JButton("Add new Student");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddStudent add = new AddStudent();
				add.setVisible(true);
				dispose();
			}
		});
		Image imgA;
		try {
			imgA = ImageIO.read(getClass().getResource("/add.png"));
			Image newimgA = imgA.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			btnInsert.setIcon(new ImageIcon(newimgA));
		} catch (IOException e) {
			e.printStackTrace();
		}
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInsert.setBounds(361, 422, 206, 33);
		contentPane.add(btnInsert);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(20, 54, 872, 365);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
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
		btnLogout.setBounds(737, 422, 155, 33);
		contentPane.add(btnLogout);
		
		JLabel lblYouAreLogged = new JLabel("You are logged in as admin");
		lblYouAreLogged.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblYouAreLogged.setBounds(271, 10, 446, 40);
		contentPane.add(lblYouAreLogged);
		updatetable();
	}
	private void updatetable() {
		try {

			String sql = "select * from infoTable";

			st = con.prepareStatement(sql);
			r = st.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(r));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {

			try {
				r.close();
				st.close();

			} catch (Exception e) {

			}
		}
		
	}
}
