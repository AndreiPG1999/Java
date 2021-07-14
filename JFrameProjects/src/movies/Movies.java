package movies;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class Movies extends JFrame {

	private JPanel contentPane;
	private JTextField txtFilm;
	private JTextField txtActori;
	private DefaultTableModel model;
	private JTable tblFilme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movies frame = new Movies();
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
	public Movies() {
		setTitle("Filme");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\andre\\OneDrive\\Desktop\\download.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblFilm = new JLabel("Film");
		lblFilm.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFilm.setBounds(96, 10, 66, 20);
		contentPane.add(lblFilm);
		
		JLabel lblActori = new JLabel("Actori");
		lblActori.setFont(new Font("Arial", Font.PLAIN, 12));
		lblActori.setBounds(96, 40, 66, 20);
		contentPane.add(lblActori);
		
		JLabel lblAn_Lansare = new JLabel("An lansare");
		lblAn_Lansare.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAn_Lansare.setBounds(96, 76, 66, 20);
		contentPane.add(lblAn_Lansare);
		
		txtFilm = new JTextField();
		txtFilm.setFont(new Font("Arial", Font.PLAIN, 12));
		txtFilm.setBounds(156, 11, 237, 19);
		contentPane.add(txtFilm);
		txtFilm.setColumns(10);
		
		txtActori = new JTextField();
		txtActori.setFont(new Font("Arial", Font.PLAIN, 12));
		txtActori.setColumns(10);
		txtActori.setBounds(156, 41, 237, 19);
		contentPane.add(txtActori);
		
		JSpinner spnAn_Lansare = new JSpinner();
		spnAn_Lansare.setModel(new SpinnerNumberModel(2015, 2015, 2020, 1));
		spnAn_Lansare.setFont(new Font("Arial", Font.PLAIN, 12));
		spnAn_Lansare.setBounds(211, 77, 66, 20);
		contentPane.add(spnAn_Lansare);
		
		JCheckBox chckbxComedie = new JCheckBox("Comedie");
		chckbxComedie.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxComedie.setBounds(96, 128, 93, 21);
		contentPane.add(chckbxComedie);
		
		JCheckBox chckbxDrama = new JCheckBox("Drama");
		chckbxDrama.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxDrama.setBounds(186, 128, 93, 21);
		contentPane.add(chckbxDrama);
		
		JCheckBox chckbxIstoric = new JCheckBox("Istoric");
		chckbxIstoric.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxIstoric.setBounds(281, 128, 93, 21);
		contentPane.add(chckbxIstoric);
		
		JCheckBox chckbxRomantic = new JCheckBox("Romantic");
		chckbxRomantic.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxRomantic.setBounds(378, 128, 93, 21);
		contentPane.add(chckbxRomantic);
		
		JCheckBox chckbxActiune = new JCheckBox("Actiune");
		chckbxActiune.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxActiune.setBounds(227, 169, 93, 21);
		contentPane.add(chckbxActiune);
		
		
		JButton btnAdauga = new JButton("Adauga");
		btnAdauga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model=(DefaultTableModel)tblFilme.getModel();
				Vector<Object> rowlist=new Vector<Object>(4);
				if(chckbxActiune.isSelected())
					rowlist.add(chckbxActiune.getText());
				if(chckbxComedie.isSelected())
					rowlist.add(chckbxComedie.getText());
				if(chckbxDrama.isSelected())
					rowlist.add(chckbxDrama.getText());
				if(chckbxIstoric.isSelected())
					rowlist.add(chckbxIstoric.getText());
				if(chckbxRomantic.isSelected())
					rowlist.add(chckbxRomantic.getText());
				if(txtFilm.getText().isEmpty()||txtActori.getText().isEmpty()||rowlist.isEmpty())
					JOptionPane.showMessageDialog(null, "Introduceti valori pentru toate coloanele!");
				else
				{
					model.addRow(new Object[] {txtFilm.getText(),txtActori.getText(),spnAn_Lansare.getValue(),rowlist});
					txtFilm.setText(null);
					txtActori.setText(null);
					chckbxActiune.setSelected(false);
					chckbxComedie.setSelected(false);
					chckbxIstoric.setSelected(false);
					chckbxDrama.setSelected(false);
					chckbxRomantic.setSelected(false);
				}
			}

		});
		btnAdauga.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAdauga.setBounds(96, 226, 111, 36);
		contentPane.add(btnAdauga);
		
		JButton btnSterge = new JButton("Sterge");
		btnSterge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(tblFilme.getSelectedRow()!=-1&&JOptionPane.showConfirmDialog(null, "Sigur doriti sa stergeti acest film?")==0)
				{
					
					model.removeRow(tblFilme.getSelectedRow());
					JOptionPane.showMessageDialog(null, "Film sters!");
				}
				else if(tblFilme.getSelectedRow()==-1)
				{
					JOptionPane.showMessageDialog(null, "Nici un film nu a fost selectat pentru stergere!");
				}
			}
		});
		btnSterge.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSterge.setBounds(298, 226, 111, 36);
		contentPane.add(btnSterge);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 282, 484, 125);
		contentPane.add(scrollPane);
		
		tblFilme = new JTable();
		tblFilme.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Film", "Actori", "An lansare", "Genuri"
			}
		));
		tblFilme.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(tblFilme);
	}
}
