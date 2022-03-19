package ma.fstm.ilisi.gestioncantact.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Resultat {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resultat window = new Resultat();
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
	public Resultat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(170, 103, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSalut = new JLabel("salut");
		lblSalut.setBounds(126, 80, 157, 79);
		frame.getContentPane().add(lblSalut);
	}

}
