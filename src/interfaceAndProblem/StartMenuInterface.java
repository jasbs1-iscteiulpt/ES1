package interfaceAndProblem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Starter GUI of the Anti Spam Filter For Professional MailBox (Optional)
 * @author ES1-METI-PL-106
 *
 */

public class StartMenuInterface {

	public JFrame frame;

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
		
		JButton btnManual = new JButton("Launch");
		btnManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Interface window = new Interface();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnManual.setBounds(152, 138, 85, 21);
		frame.getContentPane().add(btnManual);
		
		JLabel lblAntispamFiilterFor = new JLabel("Anti-Spam FIilter For Professional Mailbox");
		lblAntispamFiilterFor.setBounds(74, 10, 320, 13);
		frame.getContentPane().add(lblAntispamFiilterFor);
		
		JLabel lblEsmetipl = new JLabel("ES1-METI-PL-106");
		lblEsmetipl.setBounds(142, 37, 150, 13);
		frame.getContentPane().add(lblEsmetipl);
		
		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("mailicon.png");
		label.setIcon(icon);
		label.setBounds(171, 69, 83, 36);
		frame.getContentPane().add(label);
	}
}
