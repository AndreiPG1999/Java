import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField txtOperand1;
	private JTextField txtOperand2;
	private JTextField txtRezultat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	public Calculator() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\andre\\OneDrive\\Desktop\\download.png"));
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(11, 11, 11, 11));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOperand1 = new JLabel("Operand 1");
		lblOperand1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblOperand1.setBounds(56, 30, 70, 22);
		contentPane.add(lblOperand1);
		
		JLabel lblOperand2 = new JLabel("Operand 2");
		lblOperand2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblOperand2.setBounds(56, 72, 70, 22);
		contentPane.add(lblOperand2);
		
		txtOperand1 = new JTextField();
		txtOperand1.setFont(new Font("Arial", Font.PLAIN, 12));
		txtOperand1.setBounds(136, 28, 130, 27);
		contentPane.add(txtOperand1);
		txtOperand1.setColumns(10);
		
		txtOperand2 = new JTextField();
		txtOperand2.setFont(new Font("Arial", Font.PLAIN, 12));
		txtOperand2.setColumns(10);
		txtOperand2.setBounds(136, 70, 130, 27);
		contentPane.add(txtOperand2);
		
		JButton btnAdunare = new JButton("Adunare");
		btnAdunare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				double operand1=Double.parseDouble(txtOperand1.getText());
				double operand2=Double.parseDouble(txtOperand2.getText());
				double suma=operand1+operand2;
				txtRezultat.setText(Double.toString(suma));
				}
				catch(NumberFormatException e)
				{
					txtOperand1.setText("");
					txtOperand2.setText("");
					JOptionPane.showMessageDialog(rootPane, "Operanzii trebuie sa fie numere!");
					JOptionPane.showMessageDialog(rootPane,"Introduceti alte numere!");
				}
			}
		});
		btnAdunare.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAdunare.setBounds(38, 122, 114, 34);
		contentPane.add(btnAdunare);
		
		JButton btnScadere = new JButton("Scadere");
		btnScadere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				double operand1=Double.parseDouble(txtOperand1.getText());
				double operand2=Double.parseDouble(txtOperand2.getText());
				double diferenta=operand1-operand2;
				txtRezultat.setText(Double.toString(diferenta));
				}
				catch(NumberFormatException e)
				{
					txtOperand1.setText("");
					txtOperand2.setText("");
					JOptionPane.showMessageDialog(rootPane, "Operanzii trebuie sa fie numere!");
					JOptionPane.showMessageDialog(rootPane,"Introduceti alte numere!");
				}
			}
		});
		btnScadere.setFont(new Font("Arial", Font.PLAIN, 14));
		btnScadere.setBounds(169, 122, 114, 34);
		contentPane.add(btnScadere);
		
		JButton btnInmultire = new JButton("Inmultire");
		btnInmultire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				double operand1=Double.parseDouble(txtOperand1.getText());
				double operand2=Double.parseDouble(txtOperand2.getText());
				double produs=operand1*operand2;
				txtRezultat.setText(Double.toString(produs));
				}
				catch(NumberFormatException e)
				{
					txtOperand1.setText("");
					txtOperand2.setText("");
					JOptionPane.showMessageDialog(rootPane, "Operanzii trebuie sa fie numere!");
					JOptionPane.showMessageDialog(rootPane,"Introduceti alte numere!");
				}
			}
		});
		btnInmultire.setFont(new Font("Arial", Font.PLAIN, 14));
		btnInmultire.setBounds(38, 166, 114, 34);
		contentPane.add(btnInmultire);
		
		JButton btnImpartire = new JButton("Impartire");
		btnImpartire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
						double operand1=Double.parseDouble(txtOperand1.getText());
						double operand2=Double.parseDouble(txtOperand2.getText());
						double cat=operand1/operand2;
						System.out.println(operand2!=0 ? cat=operand1/operand2:cat<=(int)operand1/(int)operand2);
						txtRezultat.setText(Double.toString(cat));
					}
					
					catch(ArithmeticException e)
					{
						txtOperand2.setText("");
						JOptionPane.showMessageDialog(rootPane,"Impartitorul nu poate sa fie 0!");
						JOptionPane.showMessageDialog(rootPane,"Introduceti alt impartitor!");
					}
					catch(NumberFormatException e)
					{
						txtOperand1.setText("");
						txtOperand2.setText("");
						JOptionPane.showMessageDialog(rootPane, "Operanzii trebuie sa fie numere!");
						JOptionPane.showMessageDialog(rootPane,"Introduceti alte numere!");
					}
			}
		});
		btnImpartire.setFont(new Font("Arial", Font.PLAIN, 14));
		btnImpartire.setBounds(169, 166, 114, 34);
		contentPane.add(btnImpartire);
		
		txtRezultat = new JTextField();
		txtRezultat.setFont(new Font("Arial", Font.PLAIN, 12));
		txtRezultat.setBounds(38, 226, 245, 22);
		contentPane.add(txtRezultat);
		txtRezultat.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtOperand1.setText("");
				txtOperand2.setText("");
				txtRezultat.setText("");
			}
		});
		btnClear.setFont(new Font("Arial", Font.PLAIN, 18));
		btnClear.setBounds(38, 260, 245, 37);
		contentPane.add(btnClear);
	}
}
