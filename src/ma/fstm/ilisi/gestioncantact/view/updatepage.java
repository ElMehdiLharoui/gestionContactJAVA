package ma.fstm.ilisi.gestioncantact.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ma.fstm.ilisi.gestioncantact.controller.CantactController;
import ma.fstm.ilisi.gestioncantact.model.bo.Contact;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class updatepage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatepage frame = new updatepage(new Contact());
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
	public updatepage(Contact c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("nom");
		lblNom.setBounds(67, 60, 45, 13);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("prenom");
		lblPrenom.setBounds(67, 98, 45, 13);
		contentPane.add(lblPrenom);
		
		JLabel lblTele = new JLabel("numero");
		lblTele.setBounds(67, 132, 45, 13);
		contentPane.add(lblTele);
		
		JLabel lblType = new JLabel("type");
		lblType.setBounds(67, 190, 45, 13);
		contentPane.add(lblType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"pro", "academic"}));
		comboBox.setBounds(238, 186, 100, 21);
		contentPane.add(comboBox);
		comboBox.setSelectedItem(c.getType().toString());
		textField = new JTextField();
		textField.setBounds(242, 57, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(c.getNom());
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(242, 95, 96, 19);
		contentPane.add(textField_1);
		textField_1.setText(c.getPrenom());
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(242, 129, 96, 19);
		contentPane.add(textField_2);
		textField_2.setText(c.getTele());
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(142, 232, 85, 21);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CantactController().Update_page(c.getId(),textField.getText(), textField_1.getText(), textField_2.getText(), comboBox.getSelectedItem().toString());
				updatepage.this.dispose(); 
			}
		});
		
	}
}
