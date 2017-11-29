package antiSpamFilter;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StartMenuInterface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartMenuInterface window = new StartMenuInterface();
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
	public StartMenuInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Anti Spam Filter For Professional MailBox");
		frame.setBounds(100, 100, 412, 207);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JButton btnAutomatic = new JButton("Automatic");
		btnAutomatic.setBounds(87, 138, 106, 21);
		frame.getContentPane().add(btnAutomatic);
		
		JButton btnManual = new JButton("Manual");
		btnManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Interface window = new Interface();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnManual.setBounds(203, 138, 85, 21);
		frame.getContentPane().add(btnManual);
		
		JLabel lblAntispamFiilterFor = new JLabel("Anti-Spam FIilter For Professional Mailbox");
		lblAntispamFiilterFor.setBounds(74, 10, 260, 13);
		frame.getContentPane().add(lblAntispamFiilterFor);
		
		JLabel lblRunIn = new JLabel("Run in:");
		lblRunIn.setBounds(172, 115, 45, 13);
		frame.getContentPane().add(lblRunIn);
		
		JLabel lblEsmetipl = new JLabel("ES1-METI-PL-106");
		lblEsmetipl.setBounds(142, 37, 100, 13);
		frame.getContentPane().add(lblEsmetipl);
		
		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("mailicon.png");
		label.setIcon(icon);
		label.setBounds(171, 69, 83, 36);
		frame.getContentPane().add(label);
	}
}
