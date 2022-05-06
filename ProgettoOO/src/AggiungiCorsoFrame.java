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

public class AggiungiCorsoFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTextField nomeTF;
	private JTextField descrizioneTF;
	private JTextField numeroMassimoIscrittiTF;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel numeroMassimoPartecipantiLabel;
	private JLabel numeroDiLezioniLabel;
	private JLabel dataDiInizio;

	
	public AggiungiCorsoFrame(Controller c) {
		setTitle("AggiungiCorsoFrame");
	
		controller = c;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 410);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_nomeTF.insets = new Insets(0, 0, 5, 0);
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
		gbc_descrizioneTF.insets = new Insets(0, 0, 5, 0);
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
		
		numeroMassimoIscrittiTF = new JTextField();
		numeroMassimoIscrittiTF.setFont(new Font("Century", Font.PLAIN, 16));
		numeroMassimoIscrittiTF.setColumns(10);
		GridBagConstraints gbc_numeroMassimoIscrittiTF = new GridBagConstraints();
		gbc_numeroMassimoIscrittiTF.insets = new Insets(0, 0, 5, 0);
		gbc_numeroMassimoIscrittiTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_numeroMassimoIscrittiTF.gridx = 2;
		gbc_numeroMassimoIscrittiTF.gridy = 4;
		contentPane.add(numeroMassimoIscrittiTF, gbc_numeroMassimoIscrittiTF);
		
		numeroDiLezioniLabel = new JLabel("N\u00B0 di lezioni");
		numeroDiLezioniLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_numeroDiLezioniLabel = new GridBagConstraints();
		gbc_numeroDiLezioniLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numeroDiLezioniLabel.anchor = GridBagConstraints.EAST;
		gbc_numeroDiLezioniLabel.gridx = 1;
		gbc_numeroDiLezioniLabel.gridy = 5;
		contentPane.add(numeroDiLezioniLabel, gbc_numeroDiLezioniLabel);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Century", Font.PLAIN, 16));
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 5;
		contentPane.add(textField_2, gbc_textField_2);
		
		dataDiInizio = new JLabel("N\u00B0 di lezioni");
		dataDiInizio.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_dataDiInizio = new GridBagConstraints();
		gbc_dataDiInizio.insets = new Insets(0, 0, 0, 5);
		gbc_dataDiInizio.anchor = GridBagConstraints.EAST;
		gbc_dataDiInizio.gridx = 1;
		gbc_dataDiInizio.gridy = 6;
		contentPane.add(dataDiInizio, gbc_dataDiInizio);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Century", Font.PLAIN, 16));
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 6;
		contentPane.add(textField_3, gbc_textField_3);
	}

}
