package ma.fstm.ilisi.gestioncantact.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactView window = new ContactView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ContactView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1080, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel.setBounds(81, 50, 79, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPrenom = new JLabel("prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblPrenom.setBounds(81, 113, 96, 48);
		frame.getContentPane().add(lblPrenom);
		
		JLabel lblAdresse = new JLabel("adresse");
		lblAdresse.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblAdresse.setBounds(81, 211, 123, 58);
		frame.getContentPane().add(lblAdresse);
		
		JLabel lblNumero = new JLabel("numero");
		lblNumero.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNumero.setBounds(81, 304, 96, 48);
		frame.getContentPane().add(lblNumero);
		
		textField = new JTextField();
		textField.setBounds(283, 63, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(283, 130, 96, 19);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(283, 233, 96, 19);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(283, 321, 96, 19);
		frame.getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(210, 429, 115, 41);
		frame.getContentPane().add(btnNewButton);
	}
}
