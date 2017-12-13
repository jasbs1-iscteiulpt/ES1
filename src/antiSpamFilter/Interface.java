package antiSpamFilter;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import interfaceAndProblem.AntiSpamFilterAutomaticConfiguration;

/**
 * Main GUI of the Anti Spam Filter For Professional MailBox
 * @author ES1-METI-PL-106
 *
 */

public class Interface {

	public JFrame frame;
	private JTable table;
	private JTextField textField;
	private  HashMap<String, Double> rulesArray=new HashMap<String, Double>();
	private DefaultTableModel model;
	private JRadioButton rdbtnAutomatic;
	private JRadioButton rdbtnManual;
	
	boolean auto=false; //auto=false ==> manual, auto=true ==> automatic
	public File file;
	
	/**
	 * Launch the application.
	 * @param args main arguments
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
		frame = new JFrame("Anti Spam Filter For Professional MailBox");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 622, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblPath = new JLabel("rules.cf File Path:");
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setEditable(false);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		JButton btnBrowser = new JButton("Load Configuration");
		btnBrowser.setForeground(Color.BLACK);
		btnBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//In response to a button click set outputfile, filepath
				int returnVal = fileChooser.showOpenDialog(frame);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            file = fileChooser.getSelectedFile();
		            textField.setText(file.getAbsolutePath());
		            if(file.isFile()){
		            	rulesArray=RuleScanner.readFile(file.getAbsolutePath());
		            	model.setDataVector(RuleScanner.MapToArray(rulesArray), new String[] {"Regras", "Peso"});
		            	model.fireTableDataChanged();
		            }
				}
			}
		});
		btnBrowser.setBackground(SystemColor.textHighlight);
		
		JLabel label = new JLabel("0");
		label.setForeground(Color.RED);
		
		JLabel label_1 = new JLabel("0");
		label_1.setForeground(Color.RED);
		
		JButton btnNewButton = new JButton("Run");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Main Run!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Ja cria o vetor manualmente aqui quando clicas run!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				if(file!=null){
					
					if(auto) {
						try {
							AntiSpamFilterAutomaticConfiguration.run(file.getAbsolutePath());
							String [] falses =RuleScanner.resultReader();
							label.setText(falses[0]);
							label_1.setText(falses[1]);
							rulesArray=RuleScanner.resultConfig(rulesArray, Integer.parseInt(falses[2]));
							model.setDataVector(RuleScanner.MapToArray(rulesArray), new String[] {"Regras", "Peso"});
			            	model.fireTableDataChanged();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						} else {
								for(int i=0; i<rulesArray.size(); i++) {
										rulesArray.put(model.getValueAt(i, 0).toString(), Double.parseDouble(model.getValueAt(i, 1).toString()));
								}
								MailTest test=new MailTest(rulesArray);
								label.setText(Integer.toString(test.getFP()));
								label_1.setText(Integer.toString(test.getFN())); 
						}
				}
				else {
					JOptionPane.showMessageDialog(frame, "No Configuration Loaded","Unnable to Run",JOptionPane.WARNING_MESSAGE);
				}
		}});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(SystemColor.textHighlight);
		
		
		JLabel lblFalsosPositivos = new JLabel("Falsos Positivos");
		
		JLabel lblFalsosNegativos = new JLabel("Falsos Negativos");
		
		JButton btnSave = new JButton("Save Configuration");
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<rulesArray.size(); i++) {
					rulesArray.put(model.getValueAt(i, 0).toString(), Double.parseDouble(model.getValueAt(i, 1).toString()));
				}
				if(file!=null){
					RuleScanner.writeFile(file.getAbsolutePath(), RuleScanner.MapToArray(rulesArray));
					JOptionPane.showMessageDialog(frame, "Configuration Saved","Success",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frame, "File location not specified","Error while saving",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		rdbtnAutomatic = new JRadioButton("Automatic");
		rdbtnAutomatic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				rdbtnManual.setSelected(false);
				auto=true;
			}
		});
		
		rdbtnManual = new JRadioButton("Manual");
		rdbtnManual.setSelected(true);
		rdbtnManual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				rdbtnAutomatic.setSelected(false);
				auto=false;
			}
		});
		
		JLabel lblRunningMode = new JLabel("Running Mode:");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSave)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblRunningMode, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnManual, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnAutomatic, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(19))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPath)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, Alignment.TRAILING, 0, 0, Short.MAX_VALUE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblFalsosPositivos)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblFalsosNegativos)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
									.addGap(21))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(btnBrowser)))))
					.addGap(66))
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
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFalsosPositivos)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFalsosNegativos)
								.addComponent(label_1)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRunningMode)
						.addComponent(rdbtnManual)
						.addComponent(rdbtnAutomatic))
					.addGap(5))
		);
		
		table = new JTable();
		String[][] modeling=new String[335][2];
		model = new DefaultTableModel(modeling,new String[] {"Regras", "Peso"});
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		scrollPane.setColumnHeaderView(lblNewLabel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
