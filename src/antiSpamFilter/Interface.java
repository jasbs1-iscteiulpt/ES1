package antiSpamFilter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import java.awt.SystemColor;


public class Interface {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	ArrayList<String> rules;
	private  String [][] rulesArray=new String [335] [2] ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
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
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 550, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setForeground(Color.BLACK);
		frame.setJMenuBar(menuBar);
		
		JButton btnManual = new JButton("Manual");
		btnManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManual.setForeground(new Color(0, 0, 0));
		btnManual.setBackground(new Color(169, 169, 169));
		btnManual.setEnabled(true);
		menuBar.add(btnManual);
		
		JButton btnAutomtico = new JButton("Autom\u00E1tico");
		btnAutomtico.setForeground(new Color(0, 0, 0));
		btnAutomtico.setBackground(new Color(245, 245, 245));
		menuBar.add(btnAutomtico);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblPath = new JLabel("Path:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnBrowser = new JButton("Search");
		btnBrowser.setForeground(Color.WHITE);
		btnBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBrowser.setBackground(SystemColor.textHighlight);
		
		JButton btnNewButton = new JButton("Run");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.textHighlight);
		
		JLabel lblFalsosPositivos = new JLabel("Falsos Positivos");
		
		JLabel lblFalsosNegativos = new JLabel("Falsos Negativos");
		
		JProgressBar progressBar = new JProgressBar();
		
		JProgressBar progressBar_1 = new JProgressBar();
		
		JLabel label = new JLabel("0/0");
		
		JLabel label_1 = new JLabel("0/0");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPath)
									.addGap(18)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addComponent(btnBrowser))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(99)
											.addComponent(label_1))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(67)
											.addComponent(lblFalsosNegativos))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(66)
											.addComponent(lblFalsosPositivos))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(99)
											.addComponent(label))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(37)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(progressBar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPath)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBrowser))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton)
							.addGap(9))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(lblFalsosPositivos)
							.addGap(1)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(lblFalsosNegativos)
							.addGap(1)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(progressBar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		//Lê o ficheiro e insere os valores dentro da matriz que vai para a table
		RuleScanner.readFile("rules.cf");
		ArrayList<String> rules=RuleScanner.rules;
		System.out.println(rules);
		rulesArray =new String [rules.size()] [2] ;
		for(int i=0;i<rules.size(); i++) {
			rulesArray [i][0]=rules.get(i);
			rulesArray [i][1]=null;
			
		}
		System.out.println(rulesArray);
		table = new JTable();
		table.setModel(new DefaultTableModel(rulesArray,new String[] {"Regras", "Peso"}));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		scrollPane.setColumnHeaderView(lblNewLabel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
