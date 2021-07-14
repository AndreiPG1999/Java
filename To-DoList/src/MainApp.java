import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class MainApp extends JFrame {

	JButton btnCreate = new JButton("Create a new To-Do  List");
	JButton btnAdd = new JButton("Add a new chore!");
	JButton btnDelete = new JButton("Delete");
	DefaultListModel<String> model = new DefaultListModel<String>();
	JList<String> todoList = new JList<>(model);
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField textFieldName;
	
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
		setTitle("Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  JFrame frame = new JFrame();
				  frame.setVisible(true);
				  frame.setTitle("List");
				  frame.setBounds(100, 100, 296, 392);
				  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				  frame.getContentPane().setLayout(null);
				  JLabel lblName = new JLabel("Name");
				  lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				  lblName.setBounds(48, 38, 45, 33);
			      frame.getContentPane().add(lblName);
					
				  textFieldName = new JTextField();
				  textFieldName.setBounds(103, 47, 154, 19);
				  frame.getContentPane().add(textFieldName);
				  textFieldName.setColumns(10);
				  btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 19));
				  btnAdd.setBounds(10, 304, 262, 41);
				  frame.getContentPane().add(btnAdd);
				  btnAdd.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String name = textFieldName.getText();
							ArrayList<String> list = new ArrayList<String>();
							try {
								if(model.isEmpty())
								{
									model.addElement(name);
									textFieldName.setText("");
								}
								for(int i=0;i<model.getSize();i++)
									list.add(model.getElementAt(i));
								
								if(!(model.contains(name))&&todoList.getModel().getSize() != 0)
								{
									model.addElement(name);
									textFieldName.setText("");
								}
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
				  });
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnCreate.setBounds(10, 304, 262, 41);
		contentPane.add(btnCreate);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		contentPane.add(btnNewButton);
		
		
		todoList.setBounds(32, 52, 213, 244);
		contentPane.add(todoList);
		
		JLabel lblNewLabel = new JLabel("To-Do List");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(68, 10, 129, 32);
		contentPane.add(lblNewLabel);
		
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//model.removeAllElements();
				int selectedIndex = todoList.getSelectedIndex();
				if (selectedIndex != -1) {
				    model.remove(selectedIndex);
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnDelete.setBounds(10, 355, 262, 41);
		contentPane.add(btnDelete);
		
		
		
		
		
		
		
		
	}
}
