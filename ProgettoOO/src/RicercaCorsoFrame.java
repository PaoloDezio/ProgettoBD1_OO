import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;

public class RicercaCorsoFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
//	private JTextField nomeTF;
//	private JTextField parolaChiaveTF;
//	private JTextField dataTF;
//	private JTextField categoria1TF;
	private JTable table;
//	private JTextField categoria2TF;
	private JComboBox campoCB;
	private JTextField nomeTF;
	private JLabel nomeLabel;
	private JTextField campoTF;
	
	/**
	 * Create the frame.
	 */
	public RicercaCorsoFrame(Controller c) {
		setTitle("Ricerca Corso");
		controller = c;
		
		CorsoDAO corso= new CorsoDAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 175, 740, 626);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{23, 238, 104, 64, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 55, 55, 55, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel ricercaCorsoLabel = new JLabel("Ricerca Corso");
		ricercaCorsoLabel.setFont(new Font("Century", Font.PLAIN, 25));
		GridBagConstraints gbc_ricercaCorsoLabel = new GridBagConstraints();
		gbc_ricercaCorsoLabel.gridwidth = 2;
		gbc_ricercaCorsoLabel.anchor = GridBagConstraints.WEST;
		gbc_ricercaCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ricercaCorsoLabel.gridx = 1;
		gbc_ricercaCorsoLabel.gridy = 0;
		contentPane.add(ricercaCorsoLabel, gbc_ricercaCorsoLabel);
		
		
		String[] campi= {"Nome","Categoria","Data","Parola Chiave"};
		
		JLabel selezionareUnCampoLabel = new JLabel("Selezionare un campo");
		selezionareUnCampoLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_selezionareUnCampoLabel = new GridBagConstraints();
		gbc_selezionareUnCampoLabel.anchor = GridBagConstraints.EAST;
		gbc_selezionareUnCampoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_selezionareUnCampoLabel.gridx = 1;
		gbc_selezionareUnCampoLabel.gridy = 2;
		contentPane.add(selezionareUnCampoLabel, gbc_selezionareUnCampoLabel);
		
				
		JButton tornaHomeButton = new JButton("Torna alla Home");
		tornaHomeButton.setFont(new Font("Century", Font.PLAIN, 16));
		tornaHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.setVisibleHome(true);
				c.setVisibleRicercaCorso(false);
			}
		});
				
//		JLabel nomeLabel = new JLabel("Nome");
//		nomeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
//		nomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		nomeLabel.setFont(new Font("Century", Font.PLAIN, 16));
//		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
//		gbc_nomeLabel.anchor = GridBagConstraints.EAST;
//		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
//		gbc_nomeLabel.gridx = 1;
//		gbc_nomeLabel.gridy = 2;
//		contentPane.add(nomeLabel, gbc_nomeLabel);
//		
//		nomeTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		GridBagConstraints gbc_nomeTF = new GridBagConstraints();
//		gbc_nomeTF.fill = GridBagConstraints.HORIZONTAL;
//		gbc_nomeTF.insets = new Insets(0, 0, 5, 5);
//		gbc_nomeTF.gridx = 2;
//		gbc_nomeTF.gridy = 2;
//		contentPane.add(nomeTF, gbc_nomeTF);
//		nomeTF.setColumns(10);
//		
//		JLabel Categoria1Label = new JLabel("Categoria n.1");
//		Categoria1Label.setFont(new Font("Century", Font.PLAIN, 16));
//		GridBagConstraints gbc_Categoria1Label = new GridBagConstraints();
//		gbc_Categoria1Label.anchor = GridBagConstraints.EAST;
//		gbc_Categoria1Label.insets = new Insets(0, 0, 5, 5);
//		gbc_Categoria1Label.gridx = 1;
//		gbc_Categoria1Label.gridy = 3;
//		contentPane.add(Categoria1Label, gbc_Categoria1Label);
//		
//		categoria1TF = new JTextField();
//		categoria1TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		GridBagConstraints gbc_categoria1TF = new GridBagConstraints();
//		gbc_categoria1TF.insets = new Insets(0, 0, 5, 5);
//		gbc_categoria1TF.fill = GridBagConstraints.HORIZONTAL;
//		gbc_categoria1TF.gridx = 2;
//		gbc_categoria1TF.gridy = 3;
//		contentPane.add(categoria1TF, gbc_categoria1TF);
//		categoria1TF.setColumns(10);
//		
//		JLabel Categoria2Label = new JLabel("Categoria n.2");
//		Categoria2Label.setFont(new Font("Century", Font.PLAIN, 16));
//		GridBagConstraints gbc_Categoria2Label = new GridBagConstraints();
//		gbc_Categoria2Label.anchor = GridBagConstraints.EAST;
//		gbc_Categoria2Label.insets = new Insets(0, 0, 5, 5);
//		gbc_Categoria2Label.gridx = 1;
//		gbc_Categoria2Label.gridy = 4;
//		contentPane.add(Categoria2Label, gbc_Categoria2Label);
//		
//		categoria2TF = new JTextField();
//		categoria2TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		categoria2TF.setColumns(10);
//		GridBagConstraints gbc_categoria2TF = new GridBagConstraints();
//		gbc_categoria2TF.insets = new Insets(0, 0, 5, 5);
//		gbc_categoria2TF.fill = GridBagConstraints.HORIZONTAL;
//		gbc_categoria2TF.gridx = 2;
//		gbc_categoria2TF.gridy = 4;
//		contentPane.add(categoria2TF, gbc_categoria2TF);
//		
//		JLabel dataLabel = new JLabel("Data");
//		dataLabel.setFont(new Font("Century", Font.PLAIN, 16));
//		GridBagConstraints gbc_dataLabel = new GridBagConstraints();
//		gbc_dataLabel.anchor = GridBagConstraints.EAST;
//		gbc_dataLabel.insets = new Insets(0, 0, 5, 5);
//		gbc_dataLabel.gridx = 1;
//		gbc_dataLabel.gridy = 5;
//		contentPane.add(dataLabel, gbc_dataLabel);
//	

//		dataTF = new JTextField();
//		dataTF.setName("");
//		dataTF.setToolTipText("AAAA-MM-GG");
//		dataTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		GridBagConstraints gbc_dataTF = new GridBagConstraints();
//		gbc_dataTF.insets = new Insets(0, 0, 5, 5);
//		gbc_dataTF.fill = GridBagConstraints.HORIZONTAL;
//		gbc_dataTF.gridx = 2;
//		gbc_dataTF.gridy = 5;
//		contentPane.add(dataTF, gbc_dataTF);
//		dataTF.setColumns(10);
//		
//		JLabel parolaChiaveLabel = new JLabel("Parola Chiave");
//		parolaChiaveLabel.setFont(new Font("Century", Font.PLAIN, 16));
//		GridBagConstraints gbc_parolaChiaveLabel = new GridBagConstraints();
//		gbc_parolaChiaveLabel.anchor = GridBagConstraints.EAST;
//		gbc_parolaChiaveLabel.insets = new Insets(0, 0, 5, 5);
//		gbc_parolaChiaveLabel.gridx = 1;
//		gbc_parolaChiaveLabel.gridy = 6;
//		contentPane.add(parolaChiaveLabel, gbc_parolaChiaveLabel);
//		
//		parolaChiaveTF = new JTextField();
//		parolaChiaveTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		GridBagConstraints gbc_parolaChiaveTF = new GridBagConstraints();
//		gbc_parolaChiaveTF.insets = new Insets(0, 0, 5, 5);
//		gbc_parolaChiaveTF.fill = GridBagConstraints.HORIZONTAL;
//		gbc_parolaChiaveTF.gridx = 2;
//		gbc_parolaChiaveTF.gridy = 6;
//		contentPane.add(parolaChiaveTF, gbc_parolaChiaveTF);
//		parolaChiaveTF.setColumns(10);
						
		JButton cercaButton = new JButton("Cerca");
		cercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String parolachiave = campoTF.getText();
				try {
					corso.ricercaCorsoPerParolaChiave(parolachiave);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		

		campoCB = new JComboBox(campi);	
		campoCB.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_campoCB = new GridBagConstraints();
		gbc_campoCB.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoCB.insets = new Insets(0, 0, 5, 5);
		gbc_campoCB.gridx = 2;
		gbc_campoCB.gridy = 2;
		contentPane.add(campoCB, gbc_campoCB);
		
		JLabel cercaLabel = new JLabel("Cerca");
		cercaLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_cercaLabel = new GridBagConstraints();
		gbc_cercaLabel.anchor = GridBagConstraints.EAST;
		gbc_cercaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cercaLabel.gridx = 1;
		gbc_cercaLabel.gridy = 3;
		contentPane.add(cercaLabel, gbc_cercaLabel);
		
		campoTF = new JTextField();
		campoTF.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_campoTF = new GridBagConstraints();
		gbc_campoTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoTF.insets = new Insets(0, 0, 5, 5);
		gbc_campoTF.gridx = 2;
		gbc_campoTF.gridy = 3;
		contentPane.add(campoTF, gbc_campoTF);
		campoTF.setColumns(10);


		cercaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_cercaButton = new GridBagConstraints();
		gbc_cercaButton.anchor = GridBagConstraints.WEST;
		gbc_cercaButton.insets = new Insets(0, 0, 5, 5);
		gbc_cercaButton.gridx = 4;
		gbc_cercaButton.gridy = 7;
		contentPane.add(cercaButton, gbc_cercaButton);
		GridBagConstraints gbc_tornaHomeButton = new GridBagConstraints();
		gbc_tornaHomeButton.insets = new Insets(0, 0, 5, 5);
		gbc_tornaHomeButton.gridx = 5;
		gbc_tornaHomeButton.gridy = 7;
		contentPane.add(tornaHomeButton, gbc_tornaHomeButton);
		
		JLabel selezionaUnCorsoLabel = new JLabel("Selezionare un corso:");
		selezionaUnCorsoLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_selezionaUnCorsoLabel = new GridBagConstraints();
		gbc_selezionaUnCorsoLabel.gridwidth = 2;
		gbc_selezionaUnCorsoLabel.anchor = GridBagConstraints.WEST;
		gbc_selezionaUnCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_selezionaUnCorsoLabel.gridx = 1;
		gbc_selezionaUnCorsoLabel.gridy = 9;
		contentPane.add(selezionaUnCorsoLabel, gbc_selezionaUnCorsoLabel);
		
		
		String[] nomeColonne= {"Nome","Categoria","Data","Parola Chiave"};
		Object[][] dati= {{"Pippo","Math","2022-03-08","Cartoni"},
						  {"Pluto","Italiano","2021-04-11","Cartoni"},	
						  {"Paperino","Inglese","2020-09-24","Cartoni"},
						  {"Pippo","Math","2022-03-08","Cartoni"},
						  {"Pluto","Italiano","2021-04-11","Cartoni"},	
						  {"Paperino","Inglese","2020-09-24","Cartoni"},
						  {"Pippo","Math","2022-03-08","Cartoni"},
						  {"Pluto","Italiano","2021-04-11","Cartoni"},	
						  {"Paperino","Inglese","2020-09-24","Cartoni"},
						  {"Pippo","Math","2022-03-08","Cartoni"},
						  {"Pluto","Italiano","2021-04-11","Cartoni"},	
						  {"Paperino","Inglese","2020-09-24","Cartoni"}};
		
		
		table = new JTable(dati,nomeColonne);// {
//			public boolean isCellEditable(int dati,int nomeColonne) {
//				return false;
//			}
//		};
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"Pippo", "Math", "2022-03-08", "Cartoni"},
//				{"Pluto", "Italiano", "2021-04-11", "Cartoni"},
//				{"Paperino", "Inglese", "2020-09-24", "Cartoni"},
//				{"Pippo", "Math", "2022-03-08", "Cartoni"},
//				{"Pluto", "Italiano", "2021-04-11", "Cartoni"},
//				{"Paperino", "Inglese", "2020-09-24", "Cartoni"},
//				{"Pippo", "Math", "2022-03-08", "Cartoni"},
//				{"Pluto", "Italiano", "2021-04-11", "Cartoni"},
//				{"Paperino", "Inglese", "2020-09-24", "Cartoni"},
//				{"Pippo", "Math", "2022-03-08", "Cartoni"},
//				{"Pluto", "Italiano", "2021-04-11", "Cartoni"},
//				{"Paperino", "Inglese", "2020-09-24", "Cartoni"},
//				{"Pluto", "Italiano", "2021-04-11", "Cartoni"},
//				{"Paperino", "Inglese", "2020-09-24", "Cartoni"},
//				{"Pippo", "Math", "2022-03-08", "Cartoni"},
//				{"Pluto", "Italiano", "2021-04-11", "Cartoni"},
//				{"Paperino", "Inglese", "2020-09-24", "Cartoni"},
//				{"Pippo", "Math", "2022-03-08", "Cartoni"},
//				{"Pluto", "Italiano", "2021-04-11", "Cartoni"},
//				{"Paperino", "Inglese", "2020-09-24", "Cartoni"},
//				{null, null, null, null},
//				{null, null, null, null},
//			},
//			new String[] {
//				"Nome", "Categoria", "Data", "Parola Chiave"
//			}
//		) {
//			boolean[] columnEditables = new boolean[] {
//				false, false, false, false
//			};
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
//		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setFillsViewportHeight(true);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 3;
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 9;
		contentPane.add(table, gbc_table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 10;
		getContentPane().add(scrollPane, gbc_scrollPane);
		

		JButton StatisticheButton = new JButton("Statistische");
		StatisticheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.setVisibleStatistiche(true);
				c.setVisibleRicercaCorso(false);
			}
		});
		StatisticheButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_StatisticheButton = new GridBagConstraints();
		gbc_StatisticheButton.insets = new Insets(0, 0, 5, 0);
		gbc_StatisticheButton.anchor = GridBagConstraints.WEST;
		gbc_StatisticheButton.gridx = 6;
		gbc_StatisticheButton.gridy = 10;
		contentPane.add(StatisticheButton, gbc_StatisticheButton);
		
		JButton ModificaButton = new JButton("Modifica");
		ModificaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_ModificaButton = new GridBagConstraints();
		gbc_ModificaButton.anchor = GridBagConstraints.WEST;
		gbc_ModificaButton.insets = new Insets(0, 0, 5, 0);
		gbc_ModificaButton.gridx = 6;
		gbc_ModificaButton.gridy = 11;
		contentPane.add(ModificaButton, gbc_ModificaButton);
		
		JButton EliminaButton = new JButton("Elimina");
		EliminaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_EliminaButton = new GridBagConstraints();
		gbc_EliminaButton.anchor = GridBagConstraints.WEST;
		gbc_EliminaButton.insets = new Insets(0, 0, 5, 0);
		gbc_EliminaButton.gridx = 6;
		gbc_EliminaButton.gridy = 12;
		contentPane.add(EliminaButton, gbc_EliminaButton);
	}
	
	
	
	

}

