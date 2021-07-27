package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class UserView extends JFrame {

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
					UserView frame = new UserView();
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
	public UserView() {
		setTitle("UserView");
		con = DbConnect.java_db();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 501);
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
				UserIndividual user = new UserIndividual();
				user.setVisible(true);
				dispose();
			}
		});
		btnIndividual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIndividual.setBounds(27, 421, 184, 33);
		contentPane.add(btnIndividual);
		
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
		btnLogout.setBounds(647, 421, 206, 33);
		contentPane.add(btnLogout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(27, 60, 826, 360);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel = new JLabel("You are logged in as user");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(250, 10, 446, 40);
		contentPane.add(lblNewLabel);
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
