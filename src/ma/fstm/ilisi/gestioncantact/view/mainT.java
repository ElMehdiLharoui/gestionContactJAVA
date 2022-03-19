package ma.fstm.ilisi.gestioncantact.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ma.fstm.ilisi.gestioncantact.controller.CantactController;
import ma.fstm.ilisi.gestioncantact.model.bo.Contact;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class mainT extends JFrame {

	private static mainT mainJframe=null;
	public static mainT GetMain() 
	{
		if(mainJframe==null)mainJframe=new mainT();
		return mainJframe;
	}
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainT frame = GetMain();
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
	private mainT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel dlm = new DefaultListModel();
		
			for(Contact c : new CantactController().retrve()){
			     dlm.addElement(c);
		
			} 
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CantactController().redirection();
			}  
		});
		btnAjouter.setBounds(54, 232, 85, 21);
		contentPane.add(btnAjouter); 
		
		JButton button = new JButton("Delete");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int id_row= table.getSelectedRow(); 
			int id=(int) table.getModel().getValueAt(id_row, 0);
			new CantactController().deleteContact(id);
			}
		});
		button.setBounds(161, 229, 85, 21);
		contentPane.add(button);
		JButton button_1 = new JButton("uPDATE");
		button_1.setBounds(288, 229, 85, 21);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int id_row= table.getSelectedRow();
		
			if(id_row >= 0) {
				int id=(int) table.getModel().getValueAt(id_row, 0);
				new CantactController().update(id);
				mainT.this.dispose();
				
			}
			else JOptionPane.showMessageDialog(mainT.this, "please select a row");
			}
		});
		
		
		
		table = new JTable();
		Refrech_Table();
		table.setBounds(24, 10, 375, 212);
		contentPane.add(table); 
		
		
	}
	public void Refrech_Table() {
		List<Contact> contacts = new CantactController().retrve();
        Object[][] sq = new Object[contacts.size()][5];
        int i = 0;
        for (Contact entry : contacts)
        {
        	sq[i][0] = entry.getId();
            sq[i][1] = entry.getNom();
            sq[i][2] = entry.getPrenom();
            sq[i][3] = entry.getTele();
            sq[i][4] = entry.getType(); 
            i++;  
        } 
        table.setModel(new DefaultTableModel(
        	sq,
        	new String[] {
        		"", "Nom", "Prenom", "Tel", "Type"
        	}
        ));
	}
}
