import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AggiungiCorsoFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTextField nomeTF;
	private JTextField descrizioneTF;
	private JTextField numeroMassimoPartecipantiTF;
	private JTextField numeroDiLezioniTF;
	private JTextField dataDiInizioTF;
	private JLabel numeroMassimoPartecipantiLabel;
	private JLabel numeroDiLezioniLabel;
	private JLabel dataDiInizio;
	private JLabel responsabileLabel;
	private JComboBox responsabileCB;

	
	public AggiungiCorsoFrame(Controller c) {
		setTitle("AggiungiCorsoFrame");
	
		controller = c;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 410);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 67, 80, 77, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel aggiungiCorsoLabel = new JLabel("Aggiungi Corso");
		aggiungiCorsoLabel.setFont(new Font("Century", Font.PLAIN, 25));
		GridBagConstraints gbc_aggiungiCorsoLabel = new GridBagConstraints();
		gbc_aggiungiCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_aggiungiCorsoLabel.gridx = 1;
		gbc_aggiungiCorsoLabel.gridy = 0;
		contentPane.add(aggiungiCorsoLabel, gbc_aggiungiCorsoLabel);
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.anchor = GridBagConstraints.EAST;
		gbc_nomeLabel.gridx = 1;
		gbc_nomeLabel.gridy = 2;
		contentPane.add(nomeLabel, gbc_nomeLabel);
		
		nomeTF = new JTextField();
		nomeTF.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeTF = new GridBagConstraints();
		gbc_nomeTF.gridwidth = 3;
		gbc_nomeTF.insets = new Insets(0, 0, 5, 5);
		gbc_nomeTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeTF.gridx = 2;
		gbc_nomeTF.gridy = 2;
		contentPane.add(nomeTF, gbc_nomeTF);
		nomeTF.setColumns(10);
		
		JLabel descrizioneLabel = new JLabel("Descrizione");
		descrizioneLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_descrizioneLabel = new GridBagConstraints();
		gbc_descrizioneLabel.anchor = GridBagConstraints.EAST;
		gbc_descrizioneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_descrizioneLabel.gridx = 1;
		gbc_descrizioneLabel.gridy = 3;
		contentPane.add(descrizioneLabel, gbc_descrizioneLabel);
		
		descrizioneTF = new JTextField();
		descrizioneTF.setFont(new Font("Century", Font.PLAIN, 16));
		descrizioneTF.setColumns(10);
		GridBagConstraints gbc_descrizioneTF = new GridBagConstraints();
		gbc_descrizioneTF.gridwidth = 3;
		gbc_descrizioneTF.insets = new Insets(0, 0, 5, 5);
		gbc_descrizioneTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_descrizioneTF.gridx = 2;
		gbc_descrizioneTF.gridy = 3;
		contentPane.add(descrizioneTF, gbc_descrizioneTF);
		
		numeroMassimoPartecipantiLabel = new JLabel("N\u00B0 massimo di partecipanti");
		numeroMassimoPartecipantiLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_numeroMassimoPartecipantiLabel = new GridBagConstraints();
		gbc_numeroMassimoPartecipantiLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numeroMassimoPartecipantiLabel.anchor = GridBagConstraints.EAST;
		gbc_numeroMassimoPartecipantiLabel.gridx = 1;
		gbc_numeroMassimoPartecipantiLabel.gridy = 4;
		contentPane.add(numeroMassimoPartecipantiLabel, gbc_numeroMassimoPartecipantiLabel);
		
		numeroMassimoPartecipantiTF = new JTextField();
		numeroMassimoPartecipantiTF.setFont(new Font("Century", Font.PLAIN, 16));
		numeroMassimoPartecipantiTF.setColumns(10);
		GridBagConstraints gbc_numeroMassimoPartecipantiTF = new GridBagConstraints();
		gbc_numeroMassimoPartecipantiTF.gridwidth = 3;
		gbc_numeroMassimoPartecipantiTF.insets = new Insets(0, 0, 5, 5);
		gbc_numeroMassimoPartecipantiTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_numeroMassimoPartecipantiTF.gridx = 2;
		gbc_numeroMassimoPartecipantiTF.gridy = 4;
		contentPane.add(numeroMassimoPartecipantiTF, gbc_numeroMassimoPartecipantiTF);
		
		numeroDiLezioniLabel = new JLabel("N\u00B0 di lezioni");
		numeroDiLezioniLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_numeroDiLezioniLabel = new GridBagConstraints();
		gbc_numeroDiLezioniLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numeroDiLezioniLabel.anchor = GridBagConstraints.EAST;
		gbc_numeroDiLezioniLabel.gridx = 1;
		gbc_numeroDiLezioniLabel.gridy = 5;
		contentPane.add(numeroDiLezioniLabel, gbc_numeroDiLezioniLabel);
		
		numeroDiLezioniTF = new JTextField();
		numeroDiLezioniTF.setFont(new Font("Century", Font.PLAIN, 16));
		numeroDiLezioniTF.setColumns(10);
		GridBagConstraints gbc_numeroDiLezioniTF = new GridBagConstraints();
		gbc_numeroDiLezioniTF.gridwidth = 3;
		gbc_numeroDiLezioniTF.insets = new Insets(0, 0, 5, 5);
		gbc_numeroDiLezioniTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_numeroDiLezioniTF.gridx = 2;
		gbc_numeroDiLezioniTF.gridy = 5;
		contentPane.add(numeroDiLezioniTF, gbc_numeroDiLezioniTF);
		
		dataDiInizio = new JLabel("Data di inizio");
		dataDiInizio.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_dataDiInizio = new GridBagConstraints();
		gbc_dataDiInizio.insets = new Insets(0, 0, 5, 5);
		gbc_dataDiInizio.anchor = GridBagConstraints.EAST;
		gbc_dataDiInizio.gridx = 1;
		gbc_dataDiInizio.gridy = 6;
		contentPane.add(dataDiInizio, gbc_dataDiInizio);
		
		dataDiInizioTF = new JTextField();
		dataDiInizioTF.setFont(new Font("Century", Font.PLAIN, 16));
		dataDiInizioTF.setColumns(10);
		GridBagConstraints gbc_dataDiInizioTF = new GridBagConstraints();
		gbc_dataDiInizioTF.gridwidth = 3;
		gbc_dataDiInizioTF.insets = new Insets(0, 0, 5, 5);
		gbc_dataDiInizioTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_dataDiInizioTF.gridx = 2;
		gbc_dataDiInizioTF.gridy = 6;
		contentPane.add(dataDiInizioTF, gbc_dataDiInizioTF);
		
		responsabileLabel = new JLabel("Responsabile");
		responsabileLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_responsabileLabel = new GridBagConstraints();
		gbc_responsabileLabel.anchor = GridBagConstraints.EAST;
		gbc_responsabileLabel.insets = new Insets(0, 0, 0, 5);
		gbc_responsabileLabel.gridx = 1;
		gbc_responsabileLabel.gridy = 7;
		contentPane.add(responsabileLabel, gbc_responsabileLabel);
		
		responsabileCB = new JComboBox();
		responsabileCB.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_responsabileCB = new GridBagConstraints();
		gbc_responsabileCB.gridwidth = 3;
		gbc_responsabileCB.insets = new Insets(0, 0, 0, 5);
		gbc_responsabileCB.fill = GridBagConstraints.HORIZONTAL;
		gbc_responsabileCB.gridx = 2;
		gbc_responsabileCB.gridy = 7;
		contentPane.add(responsabileCB, gbc_responsabileCB);
	}

}
