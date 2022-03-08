import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class RicercaCorsoFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTextField nomeTF;
	private JTextField parolaChiaveTF;
	private JTextField dataTF;
	private JTextField categoriaTF;
	private JTable ListaCorsiTable;

	/**
	 * Create the frame.
	 */
	public RicercaCorsoFrame(Controller c) {
		setTitle("Ricerca Corso");
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 175, 565, 526);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{23, 91, 130, 69, 0, 0};
		gbl_contentPane.rowHeights = new int[]{40, 0, 0, 0, 0, 0, 0, 0, 0, 55, 55, 55, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		nomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nomeLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.anchor = GridBagConstraints.EAST;
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.gridx = 1;
		gbc_nomeLabel.gridy = 2;
		contentPane.add(nomeLabel, gbc_nomeLabel);
		
		nomeTF = new JTextField();
		nomeTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeTF = new GridBagConstraints();
		gbc_nomeTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeTF.insets = new Insets(0, 0, 5, 5);
		gbc_nomeTF.gridx = 2;
		gbc_nomeTF.gridy = 2;
		contentPane.add(nomeTF, gbc_nomeTF);
		nomeTF.setColumns(10);
		
		JLabel CategoriaLabel = new JLabel("Categoria");
		CategoriaLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_CategoriaLabel = new GridBagConstraints();
		gbc_CategoriaLabel.anchor = GridBagConstraints.EAST;
		gbc_CategoriaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_CategoriaLabel.gridx = 1;
		gbc_CategoriaLabel.gridy = 3;
		contentPane.add(CategoriaLabel, gbc_CategoriaLabel);
		
		categoriaTF = new JTextField();
		categoriaTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_categoriaTF = new GridBagConstraints();
		gbc_categoriaTF.insets = new Insets(0, 0, 5, 5);
		gbc_categoriaTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_categoriaTF.gridx = 2;
		gbc_categoriaTF.gridy = 3;
		contentPane.add(categoriaTF, gbc_categoriaTF);
		categoriaTF.setColumns(10);
		
		JLabel dataLabel = new JLabel("Data");
		dataLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_dataLabel = new GridBagConstraints();
		gbc_dataLabel.anchor = GridBagConstraints.EAST;
		gbc_dataLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dataLabel.gridx = 1;
		gbc_dataLabel.gridy = 4;
		contentPane.add(dataLabel, gbc_dataLabel);
		
		JButton cercaButton = new JButton("Cerca");
		cercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = nomeTF.getText();
				String categoria= categoriaTF.getText();
				String data = dataTF.getText();  
				String parolaChiave = parolaChiaveTF.getText();
				
				if(nome.isEmpty() && categoria.isEmpty() && data.isEmpty() && parolaChiave.isEmpty() ) {
					JOptionPane.showMessageDialog(contentPane, "Inserisci almeno un campo", "", JOptionPane.WARNING_MESSAGE);
				}
				else {
//				ricercaCorso(nome, areaTematica, parolaChiave, data);
			}
			
			}});
		
		dataTF = new JTextField();
		dataTF.setName("");
		dataTF.setToolTipText("AAAA-MM-GG");
		dataTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_dataTF = new GridBagConstraints();
		gbc_dataTF.insets = new Insets(0, 0, 5, 5);
		gbc_dataTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_dataTF.gridx = 2;
		gbc_dataTF.gridy = 4;
		contentPane.add(dataTF, gbc_dataTF);
		dataTF.setColumns(10);
		
		JLabel parolaChiaveLabel = new JLabel("Parola Chiave");
		parolaChiaveLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_parolaChiaveLabel = new GridBagConstraints();
		gbc_parolaChiaveLabel.anchor = GridBagConstraints.EAST;
		gbc_parolaChiaveLabel.insets = new Insets(0, 0, 5, 5);
		gbc_parolaChiaveLabel.gridx = 1;
		gbc_parolaChiaveLabel.gridy = 5;
		contentPane.add(parolaChiaveLabel, gbc_parolaChiaveLabel);
		
		parolaChiaveTF = new JTextField();
		parolaChiaveTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_parolaChiaveTF = new GridBagConstraints();
		gbc_parolaChiaveTF.insets = new Insets(0, 0, 5, 5);
		gbc_parolaChiaveTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_parolaChiaveTF.gridx = 2;
		gbc_parolaChiaveTF.gridy = 5;
		contentPane.add(parolaChiaveTF, gbc_parolaChiaveTF);
		parolaChiaveTF.setColumns(10);

		cercaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_cercaButton = new GridBagConstraints();
		gbc_cercaButton.anchor = GridBagConstraints.WEST;
		gbc_cercaButton.insets = new Insets(0, 0, 5, 5);
		gbc_cercaButton.gridx = 3;
		gbc_cercaButton.gridy = 6;
		contentPane.add(cercaButton, gbc_cercaButton);
		
		JButton tornaHomeButton = new JButton("Torna alla Home");
		tornaHomeButton.setFont(new Font("Century", Font.PLAIN, 16));
		tornaHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.setVisibleHome(true);
				c.setVisibleRicercaCorso(false);
			}
		});
		GridBagConstraints gbc_tornaHomeButton = new GridBagConstraints();
		gbc_tornaHomeButton.insets = new Insets(0, 0, 5, 0);
		gbc_tornaHomeButton.gridx = 4;
		gbc_tornaHomeButton.gridy = 6;
		contentPane.add(tornaHomeButton, gbc_tornaHomeButton);
		
		JLabel selezionaUnCorsoLabel = new JLabel("Selezionare un corso:");
		selezionaUnCorsoLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_selezionaUnCorsoLabel = new GridBagConstraints();
		gbc_selezionaUnCorsoLabel.gridwidth = 2;
		gbc_selezionaUnCorsoLabel.anchor = GridBagConstraints.WEST;
		gbc_selezionaUnCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_selezionaUnCorsoLabel.gridx = 1;
		gbc_selezionaUnCorsoLabel.gridy = 8;
		contentPane.add(selezionaUnCorsoLabel, gbc_selezionaUnCorsoLabel);
		
		
//		String[][] data={{" "}};
//		String[] colonne= {"Nome","",""};
		ListaCorsiTable = new JTable();
		GridBagConstraints gbc_ListaCorsiTable = new GridBagConstraints();
		gbc_ListaCorsiTable.gridheight = 3;
		gbc_ListaCorsiTable.gridwidth = 3;
		gbc_ListaCorsiTable.insets = new Insets(0, 0, 5, 5);
		gbc_ListaCorsiTable.fill = GridBagConstraints.BOTH;
		gbc_ListaCorsiTable.gridx = 1;
		gbc_ListaCorsiTable.gridy = 9;
		contentPane.add(ListaCorsiTable, gbc_ListaCorsiTable);
		
		JButton StatisticheButton = new JButton("Statistische");
		StatisticheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			c.setVisibleStatistiche(true);
			
			}
			
			
		});
		StatisticheButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_StatisticheButton = new GridBagConstraints();
		gbc_StatisticheButton.insets = new Insets(0, 0, 5, 0);
		gbc_StatisticheButton.anchor = GridBagConstraints.WEST;
		gbc_StatisticheButton.gridx = 4;
		gbc_StatisticheButton.gridy = 9;
		contentPane.add(StatisticheButton, gbc_StatisticheButton);
		
		JButton ModificaButton = new JButton("Modifica");
		ModificaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_ModificaButton = new GridBagConstraints();
		gbc_ModificaButton.anchor = GridBagConstraints.WEST;
		gbc_ModificaButton.insets = new Insets(0, 0, 5, 0);
		gbc_ModificaButton.gridx = 4;
		gbc_ModificaButton.gridy = 10;
		contentPane.add(ModificaButton, gbc_ModificaButton);
		
		JButton EliminaButton = new JButton("Elimina");
		EliminaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_EliminaButton = new GridBagConstraints();
		gbc_EliminaButton.anchor = GridBagConstraints.WEST;
		gbc_EliminaButton.insets = new Insets(0, 0, 5, 0);
		gbc_EliminaButton.gridx = 4;
		gbc_EliminaButton.gridy = 11;
		contentPane.add(EliminaButton, gbc_EliminaButton);
	}

}
