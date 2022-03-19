package Pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.awt.Rectangle;

public class LoginM extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JPasswordField PasswordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginM frame = new LoginM();
                    frame.setTitle("Connexion");
                    frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginM() {


		setBounds(new Rectangle(100, 100, 100, 100));
		setResizable(false);
		setLocationByPlatform(true);
		setLocation(new Point(100, 100));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1346, 495);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(-0, -0, 0, 0);
		contentPane.add(panel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginM.class.getResource("/images/uni.jpg")));
		panel.add(label);

		JLabel lblIdentifiantOuCin = new JLabel("Email:");
		lblIdentifiantOuCin.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdentifiantOuCin.setForeground(Color.BLACK);
		lblIdentifiantOuCin.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblIdentifiantOuCin.setBounds(472, 97, 194, 15);
		contentPane.add(lblIdentifiantOuCin);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(472, 124, 236, 36);
		contentPane.add(email);

		JLabel lblMotDePasse = new JLabel("Mot de Passe :");
		lblMotDePasse.setVerticalTextPosition(SwingConstants.TOP);
		lblMotDePasse.setVerticalAlignment(SwingConstants.TOP);
		lblMotDePasse.setHorizontalAlignment(SwingConstants.LEFT);
		lblMotDePasse.setForeground(Color.BLACK);
		lblMotDePasse.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblMotDePasse.setBounds(473, 185, 99, 15);
		contentPane.add(lblMotDePasse);

		PasswordField = new JPasswordField();
		PasswordField.setBounds(472, 212, 236, 36);
		contentPane.add(PasswordField);

		JButton btnN = new JButton("S'inscrire ?");
		btnN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				RegisterM frames = new RegisterM();
                frames.setTitle("Inscription");
				frames.setVisible(true);
				dispose();

			}
		});
		btnN.setBorderPainted(false);
		btnN.setForeground(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"));
		btnN.setBackground(Color.WHITE);
		btnN.setFont(new Font("Dialog", Font.ITALIC, 11));
		btnN.setBounds(534, 359, 114, 25);
		contentPane.add(btnN);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
		panel_1.setBounds(429, 12, 304, 396);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblPlatformDinscriptionDe = new JLabel("Platforme de Connexion");
		lblPlatformDinscriptionDe.setBounds(41, 39, 239, 19);
		panel_1.add(lblPlatformDinscriptionDe);
		lblPlatformDinscriptionDe.setForeground(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"));
		lblPlatformDinscriptionDe.setFont(new Font("Dialog", Font.BOLD, 18));


		JButton button = new JButton("Se Connecter");
		button.setBounds(41, 281, 234, 48);
		panel_1.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
		        PreparedStatement pst = null;
		        ResultSet rs = null;
		        try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/exam?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
                    String sql2 = "select  *from user_en where email='"+email.getText()+"'AND password='"+PasswordField.getText()+"'";
                    pst = conn.prepareStatement(sql2);
                    ResultSet  rs2 = pst.executeQuery();
                    if (rs2.next() == true)
                    {
                    	String fname=rs2.getString(2);
                    	String lname=rs2.getString(3);
						String email=rs2.getString(2);
						if(lname.equals("Admin")){
							Position frame = new Position();
							frame.setTitle("Gestion des Positions");
							frame.setVisible(true);
							dispose();
						}
						else{
                        		Accueil frame = new Accueil(fname,lname);
							frame.setTitle("Accueil");
        						frame.setVisible(true);
        						dispose();
        						}
                    }
                    else{JOptionPane.showMessageDialog(panel,"Email ou mot de passe est incorrect") ;}

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(panel,e);
                }
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Dialog", Font.BOLD, 14));
		button.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		button.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
		button.setBackground(new Color(204, 102, 102));
	}
}
