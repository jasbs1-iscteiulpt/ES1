package antiSpamFilter;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;


public class Interface {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	ArrayList<String> rules;
	private  String [][] rulesArray=new String [335] [2] ;
	private DefaultTableModel model;
	
	public File file;
	
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
		frame.setBounds(100, 100, 680, 479);
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
		
		JLabel lblPath = new JLabel("Output File Path:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		JButton btnBrowser = new JButton("Load Configuration");
		btnBrowser.setForeground(Color.BLACK);
		btnBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//In response to a button click set outputfile, filepath
				int returnVal = fileChooser.showOpenDialog(frame);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            file = fileChooser.getSelectedFile();
		            textField.setText(file.getAbsolutePath());
				}
			}
		});
		btnBrowser.setBackground(SystemColor.textHighlight);
		
		
		JButton btnNewButton = new JButton("Run");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Main Run!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Já cria o vetor manualmente aqui quando clicas run!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				for(int i=0; i<rulesArray.length; i++) {
					rulesArray[i][1]=model.getValueAt(i, 1).toString();
					//System.out.print(rulesArray[i][0] + " " + rulesArray[i][1] + "\n");
				}
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
		
		JButton btnSave = new JButton("Save Configuration");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSave))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(lblPath)
									.addGap(18)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(28)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(28)
													.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(progressBar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(89)
													.addComponent(label_1))
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(56)
													.addComponent(lblFalsosNegativos))))
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(label)
											.addGap(67))
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblFalsosPositivos)
											.addGap(24)))))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBrowser)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPath)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBrowser))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(lblFalsosPositivos)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblFalsosNegativos)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(progressBar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(9))
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
		model = new DefaultTableModel(rulesArray,new String[] {"Regras", "Peso"});
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		scrollPane.setColumnHeaderView(lblNewLabel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
