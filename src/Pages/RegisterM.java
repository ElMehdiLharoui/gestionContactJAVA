package Pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class RegisterM extends JFrame {

	private JPanel contentPane;
	private JPasswordField PasswordField;
	private JPasswordField PasswordField1;
	private JTextField Nom;
	private JTextField Prenom;
	private JTextField email;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterM frame = new RegisterM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RegisterM() {
		setResizable(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1346, 495);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, -0, 0, 0);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RegisterM.class.getResource("/images/uni.jpg")));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, -28, 746, 501);
		contentPane.add(panel_1);
		
		JButton btnSinscrire = new JButton("Valider l'Inscription ");
		btnSinscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
						PreparedStatement pst = null;
						PreparedStatement pst3 = null;
						ResultSet rs = null;
						PreparedStatement pst4 = null;
						PreparedStatement pst5 = null;
						String pass=PasswordField.getText();
						String pass1=PasswordField1.getText();
						if(Nom.getText().equals("")||Prenom.getText().equals("")||email.getText().equals("")||pass.equals("")||pass1.equals("")){JOptionPane.showMessageDialog(panel,"Veulliez remplir tous les champs !!");}
						else{
				if(!pass.equals(pass1)){ JOptionPane.showMessageDialog(panel,"Votre mot de passe n'est pas confirme!!"); }
				else{
				try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							conn = DriverManager.getConnection("jdbc:mysql://localhost/exam?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
							String sql3 = "select  *from user_en where email='"+email.getText()+"'OR lname='"+Nom.getText()+"'";
							pst3 = conn.prepareStatement(sql3);
							ResultSet  rs3 = pst3.executeQuery();
							if (rs3.next() == true)
							{
								JOptionPane.showMessageDialog(panel,"cet utilisateur est déja inscrit!!");
							}
							else{
						String sql4 = "insert into user_en (fname,lname,email,password) values('"+Nom.getText()+"','"+Prenom.getText()+"','"+email.getText()+"','"+PasswordField.getText()+"')";
							pst4 = conn.prepareStatement(sql4);
							pst4.executeUpdate();

								JOptionPane.showMessageDialog(panel,"vous etes incrit");
								LoginM frames = new LoginM();
								frames.setTitle("Connexion");
								frames.setVisible(true);
								dispose();
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(panel,e);
						}}}
					}
				});
		btnSinscrire.setForeground(Color.WHITE);
		btnSinscrire.setFont(new Font("Dialog", Font.BOLD, 14));
		btnSinscrire.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnSinscrire.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
		btnSinscrire.setBackground(new Color(204, 102, 102));
		btnSinscrire.setBounds(443, 414, 234, 48);
		panel_1.add(btnSinscrire);



		JButton btnN = new JButton("Se connecter ?");
		btnN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				LoginM frames = new LoginM();
				frames.setVisible(true);
				frames.setTitle("Connexion");
				dispose();

			}
		});
		btnN.setBorderPainted(false);
		btnN.setForeground(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"));
		btnN.setBackground(Color.WHITE);
		btnN.setFont(new Font("Dialog", Font.ITALIC, 11));
		btnN.setBounds(443, 450, 234, 48);
		panel_1.add(btnN);



		JLabel lblNom = new JLabel("      Nom :                            Prenom :");
		lblNom.setHorizontalAlignment(SwingConstants.LEFT);
		lblNom.setForeground(Color.BLACK);
		lblNom.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNom.setBounds(443, 105, 302, 15);
		panel_1.add(lblNom);

		Nom = new JTextField();
		Nom.setColumns(10);
		Nom.setBounds(429, 132, 127, 36);
		panel_1.add(Nom);

		Prenom = new JTextField();
		Prenom.setColumns(10);
		Prenom.setBounds(568, 132, 127, 36);
		panel_1.add(Prenom);


		JLabel lblConfirmerLeMot = new JLabel("Email : ");
		lblConfirmerLeMot.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmerLeMot.setForeground(Color.BLACK);
		lblConfirmerLeMot.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblConfirmerLeMot.setBounds(441, 170, 223, 15);
		panel_1.add(lblConfirmerLeMot);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(443, 200, 236, 36);
		panel_1.add(email);

		JLabel lblMotDePasse = new JLabel("Mot de Passe :");
		lblMotDePasse.setVerticalTextPosition(SwingConstants.TOP);
		lblMotDePasse.setVerticalAlignment(SwingConstants.TOP);
		lblMotDePasse.setHorizontalAlignment(SwingConstants.LEFT);
		lblMotDePasse.setForeground(Color.BLACK);
		lblMotDePasse.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblMotDePasse.setBounds(445, 250, 200, 15);
		panel_1.add(lblMotDePasse);
		
		PasswordField = new JPasswordField();
		PasswordField.setBounds(443, 280, 236, 36);
		panel_1.add(PasswordField);

		JLabel lblMotDePasse1 = new JLabel("Confirmer le mot de passe :");
		lblMotDePasse1.setVerticalTextPosition(SwingConstants.TOP);
		lblMotDePasse1.setVerticalAlignment(SwingConstants.TOP);
		lblMotDePasse1.setHorizontalAlignment(SwingConstants.LEFT);
		lblMotDePasse1.setForeground(Color.BLACK);
		lblMotDePasse1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblMotDePasse1.setBounds(445, 320, 200, 15);
		panel_1.add(lblMotDePasse1);

		PasswordField1 = new JPasswordField();
		PasswordField1.setBounds(443, 350, 236, 36);
		panel_1.add(PasswordField1);



	}
}
