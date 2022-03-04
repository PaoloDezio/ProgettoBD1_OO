import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class RicercaCorsoFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTextField nomeTF;
	private JTextField parolaChiaveTF;
	private JTextField dataTF;
	private JTable table;
	private JTextField areaTematicaTF;

	/**
	 * Create the frame.
	 */
	public RicercaCorsoFrame(Controller c) {
		setTitle("Ricerca Corso");
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 175, 650, 575);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{10, 100, 130, 90, 0, 0};
		gbl_contentPane.rowHeights = new int[]{50, 0, 0, 0, 0, 0, 0, 0, 0, 180, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel ricercaCorsoLabel = new JLabel("Ricerca Corso");
		ricercaCorsoLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_ricercaCorsoLabel = new GridBagConstraints();
		gbc_ricercaCorsoLabel.anchor = GridBagConstraints.WEST;
		gbc_ricercaCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ricercaCorsoLabel.gridx = 1;
		gbc_ricercaCorsoLabel.gridy = 0;
		contentPane.add(ricercaCorsoLabel, gbc_ricercaCorsoLabel);
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		nomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		
		JLabel areaTematicaLabel = new JLabel("Area Tematica");
		areaTematicaLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_areaTematicaLabel = new GridBagConstraints();
		gbc_areaTematicaLabel.anchor = GridBagConstraints.EAST;
		gbc_areaTematicaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_areaTematicaLabel.gridx = 1;
		gbc_areaTematicaLabel.gridy = 3;
		contentPane.add(areaTematicaLabel, gbc_areaTematicaLabel);
		
		areaTematicaTF = new JTextField();
		areaTematicaTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_areaTematicaTF = new GridBagConstraints();
		gbc_areaTematicaTF.insets = new Insets(0, 0, 5, 5);
		gbc_areaTematicaTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_areaTematicaTF.gridx = 2;
		gbc_areaTematicaTF.gridy = 3;
		contentPane.add(areaTematicaTF, gbc_areaTematicaTF);
		areaTematicaTF.setColumns(10);
		
		JComboBox areaTematicaCB = new JComboBox();
		areaTematicaCB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_areaTematicaCB = new GridBagConstraints();
		gbc_areaTematicaCB.insets = new Insets(0, 0, 5, 5);
		gbc_areaTematicaCB.fill = GridBagConstraints.HORIZONTAL;
		gbc_areaTematicaCB.gridx = 3;
		gbc_areaTematicaCB.gridy = 3;
		contentPane.add(areaTematicaCB, gbc_areaTematicaCB);
		
		JLabel parolaChiaveLabel = new JLabel("Parola Chiave");
		parolaChiaveLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_parolaChiaveLabel = new GridBagConstraints();
		gbc_parolaChiaveLabel.anchor = GridBagConstraints.EAST;
		gbc_parolaChiaveLabel.insets = new Insets(0, 0, 5, 5);
		gbc_parolaChiaveLabel.gridx = 1;
		gbc_parolaChiaveLabel.gridy = 4;
		contentPane.add(parolaChiaveLabel, gbc_parolaChiaveLabel);
		
		parolaChiaveTF = new JTextField();
		parolaChiaveTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_parolaChiaveTF = new GridBagConstraints();
		gbc_parolaChiaveTF.insets = new Insets(0, 0, 5, 5);
		gbc_parolaChiaveTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_parolaChiaveTF.gridx = 2;
		gbc_parolaChiaveTF.gridy = 4;
		contentPane.add(parolaChiaveTF, gbc_parolaChiaveTF);
		parolaChiaveTF.setColumns(10);
		
		JLabel dataLabel = new JLabel("Data");
		dataLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_dataLabel = new GridBagConstraints();
		gbc_dataLabel.anchor = GridBagConstraints.EAST;
		gbc_dataLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dataLabel.gridx = 1;
		gbc_dataLabel.gridy = 5;
		contentPane.add(dataLabel, gbc_dataLabel);
		
		dataTF = new JTextField();
		dataTF.setToolTipText("01-01-22");
		dataTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_dataTF = new GridBagConstraints();
		gbc_dataTF.insets = new Insets(0, 0, 5, 5);
		gbc_dataTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_dataTF.gridx = 2;
		gbc_dataTF.gridy = 5;
		contentPane.add(dataTF, gbc_dataTF);
		dataTF.setColumns(10);
		
		JButton cercaButton = new JButton("Cerca");
		cercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = nomeTF.getText();
				String areaTematica= areaTematicaTF.getText();
				String parolaChiave = parolaChiaveTF.getText();
				String data = dataTF.getText();
				
				if(nome.isEmpty() && areaTematica.isEmpty() && parolaChiave.isEmpty() && data.isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Inserisci almeno un campo", "", JOptionPane.WARNING_MESSAGE);
				}
				else {
//				ricercaCorso(nome, areaTematica, parolaChiave, data);
			}
			
			}});
		cercaButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_cercaButton = new GridBagConstraints();
		gbc_cercaButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_cercaButton.insets = new Insets(0, 0, 5, 5);
		gbc_cercaButton.gridx = 3;
		gbc_cercaButton.gridy = 6;
		contentPane.add(cercaButton, gbc_cercaButton);
		
		JButton tornaHomeButton = new JButton("Torna alla Home");
		tornaHomeButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		selezionaUnCorsoLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_selezionaUnCorsoLabel = new GridBagConstraints();
		gbc_selezionaUnCorsoLabel.anchor = GridBagConstraints.WEST;
		gbc_selezionaUnCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_selezionaUnCorsoLabel.gridx = 1;
		gbc_selezionaUnCorsoLabel.gridy = 8;
		contentPane.add(selezionaUnCorsoLabel, gbc_selezionaUnCorsoLabel);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 9;
		contentPane.add(table, gbc_table);
		
		JButton StatisticheButton = new JButton("Statistische");
		StatisticheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		StatisticheButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_StatisticheButton = new GridBagConstraints();
		gbc_StatisticheButton.anchor = GridBagConstraints.WEST;
		gbc_StatisticheButton.insets = new Insets(0, 0, 0, 5);
		gbc_StatisticheButton.gridx = 1;
		gbc_StatisticheButton.gridy = 10;
		contentPane.add(StatisticheButton, gbc_StatisticheButton);
		
		JButton ModificaButton = new JButton("Modifica");
		ModificaButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_ModificaButton = new GridBagConstraints();
		gbc_ModificaButton.anchor = GridBagConstraints.WEST;
		gbc_ModificaButton.insets = new Insets(0, 0, 0, 5);
		gbc_ModificaButton.gridx = 2;
		gbc_ModificaButton.gridy = 10;
		contentPane.add(ModificaButton, gbc_ModificaButton);
		
		JButton EliminaButton = new JButton("Elimina");
		EliminaButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_EliminaButton = new GridBagConstraints();
		gbc_EliminaButton.insets = new Insets(0, 0, 0, 5);
		gbc_EliminaButton.gridx = 3;
		gbc_EliminaButton.gridy = 10;
		contentPane.add(EliminaButton, gbc_EliminaButton);
	}

}
