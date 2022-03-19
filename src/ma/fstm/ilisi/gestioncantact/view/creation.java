package ma.fstm.ilisi.gestioncantact.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ma.fstm.ilisi.gestioncantact.controller.CantactController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class creation extends JFrame {

	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField tele;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creation frame = new creation();
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
	public creation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(46, 37, 45, 13);
		contentPane.add(label);
		
		JLabel lblJf = new JLabel("nom");
		lblJf.setBounds(69, 24, 45, 13);
		contentPane.add(lblJf);
		
		JLabel lblPrenom = new JLabel("prenom");
		lblPrenom.setBounds(69, 99, 45, 13);
		contentPane.add(lblPrenom);
		
		JLabel label_1 = new JLabel("tele");
		label_1.setBounds(69, 158, 45, 13);
		contentPane.add(label_1);
		
		nom = new JTextField();
		nom.setBounds(199, 21, 96, 19);
		contentPane.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(199, 96, 96, 19);
		contentPane.add(prenom);
		prenom.setColumns(10);
		
		tele = new JTextField();
		tele.setBounds(199, 155, 96, 19);
		contentPane.add(tele);
		tele.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"pro", "academic"}));
		comboBox.setBounds(199, 201, 96, 21);
		contentPane.add(comboBox); 
		JButton btnNewButton = new JButton("AJOUTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new CantactController().creation(nom.getText(), prenom.getText(),tele.getText(),comboBox.getSelectedItem().toString());
					creation.this.dispose(); 
			}
		});   
		btnNewButton.setBounds(143, 232, 85, 21); 
		contentPane.add(btnNewButton); 
		
		JLabel lblType = new JLabel("type");
		lblType.setBounds(58, 202, 68, 13);
		contentPane.add(lblType);
		 
	
	}
}
