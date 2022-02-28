import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IscrizioneFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTextField nomeTF;
	private JTextField textField;
	private JTextField dataDiNascitaTF;
	private JTextField luogoDiNascitaTF;
	

	/**
	 * Create the frame.
	 */
	public IscrizioneFrame(Controller c) {
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 175, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{70, 0, 100, 31, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel iscrizioneLabel = new JLabel("Iscrizione ");
		iscrizioneLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_iscrizioneLabel = new GridBagConstraints();
		gbc_iscrizioneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_iscrizioneLabel.gridx = 1;
		gbc_iscrizioneLabel.gridy = 1;
		contentPane.add(iscrizioneLabel, gbc_iscrizioneLabel);
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.anchor = GridBagConstraints.EAST;
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.gridx = 1;
		gbc_nomeLabel.gridy = 3;
		contentPane.add(nomeLabel, gbc_nomeLabel);
		
		nomeTF = new JTextField();
		nomeTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeTF = new GridBagConstraints();
		gbc_nomeTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeTF.insets = new Insets(0, 0, 5, 5);
		gbc_nomeTF.gridx = 2;
		gbc_nomeTF.gridy = 3;
		contentPane.add(nomeTF, gbc_nomeTF);
		nomeTF.setColumns(10);
		
		JLabel cognomeLabel = new JLabel("Cognome");
		cognomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_cognomeLabel = new GridBagConstraints();
		gbc_cognomeLabel.anchor = GridBagConstraints.EAST;
		gbc_cognomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeLabel.gridx = 1;
		gbc_cognomeLabel.gridy = 4;
		contentPane.add(cognomeLabel, gbc_cognomeLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 4;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel dataDiNascitaLabel = new JLabel("Data di Nascita");
		dataDiNascitaLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_dataDiNascitaLabel = new GridBagConstraints();
		gbc_dataDiNascitaLabel.anchor = GridBagConstraints.EAST;
		gbc_dataDiNascitaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dataDiNascitaLabel.gridx = 1;
		gbc_dataDiNascitaLabel.gridy = 5;
		contentPane.add(dataDiNascitaLabel, gbc_dataDiNascitaLabel);
		
		dataDiNascitaTF = new JTextField();
		dataDiNascitaTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_dataDiNascitaTF = new GridBagConstraints();
		gbc_dataDiNascitaTF.insets = new Insets(0, 0, 5, 5);
		gbc_dataDiNascitaTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_dataDiNascitaTF.gridx = 2;
		gbc_dataDiNascitaTF.gridy = 5;
		contentPane.add(dataDiNascitaTF, gbc_dataDiNascitaTF);
		dataDiNascitaTF.setColumns(10);
		
		JLabel luogoDiNascitaLabel = new JLabel("Luogo di Nascita");
		luogoDiNascitaLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_luogoDiNascitaLabel = new GridBagConstraints();
		gbc_luogoDiNascitaLabel.anchor = GridBagConstraints.EAST;
		gbc_luogoDiNascitaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_luogoDiNascitaLabel.gridx = 1;
		gbc_luogoDiNascitaLabel.gridy = 6;
		contentPane.add(luogoDiNascitaLabel, gbc_luogoDiNascitaLabel);
		
		luogoDiNascitaTF = new JTextField();
		luogoDiNascitaTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_luogoDiNascitaTF = new GridBagConstraints();
		gbc_luogoDiNascitaTF.insets = new Insets(0, 0, 5, 5);
		gbc_luogoDiNascitaTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_luogoDiNascitaTF.gridx = 2;
		gbc_luogoDiNascitaTF.gridy = 6;
		contentPane.add(luogoDiNascitaTF, gbc_luogoDiNascitaTF);
		luogoDiNascitaTF.setColumns(10);
		
		JLabel codiceDelCorsoLabel = new JLabel("Codice del Corso");
		codiceDelCorsoLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_codiceDelCorsoLabel = new GridBagConstraints();
		gbc_codiceDelCorsoLabel.anchor = GridBagConstraints.EAST;
		gbc_codiceDelCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_codiceDelCorsoLabel.gridx = 1;
		gbc_codiceDelCorsoLabel.gridy = 7;
		contentPane.add(codiceDelCorsoLabel, gbc_codiceDelCorsoLabel);
		
		JComboBox codiceCorsoCB = new JComboBox();
		codiceCorsoCB.setEditable(true);
		GridBagConstraints gbc_codiceCorsoCB = new GridBagConstraints();
		gbc_codiceCorsoCB.insets = new Insets(0, 0, 5, 5);
		gbc_codiceCorsoCB.fill = GridBagConstraints.HORIZONTAL;
		gbc_codiceCorsoCB.gridx = 2;
		gbc_codiceCorsoCB.gridy = 7;
		contentPane.add(codiceCorsoCB, gbc_codiceCorsoCB);
		
		JButton tornaHomeButton = new JButton("Indietro");
		tornaHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.setVisibleHome(true);
				c.chiudiIscrizione();
			}
		});
		tornaHomeButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_tornaHomeButton = new GridBagConstraints();
		gbc_tornaHomeButton.insets = new Insets(0, 0, 5, 5);
		gbc_tornaHomeButton.gridx = 3;
		gbc_tornaHomeButton.gridy = 9;
		contentPane.add(tornaHomeButton, gbc_tornaHomeButton);
		
		JButton confermaButton = new JButton("Conferma");
		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Iscrizione avvenuta con successo");
				c.chiudiIscrizione();
				c.setVisibleHome(true);
			}
		});
		confermaButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_confermaButton = new GridBagConstraints();
		gbc_confermaButton.insets = new Insets(0, 0, 5, 5);
		gbc_confermaButton.gridx = 4;
		gbc_confermaButton.gridy = 9;
		contentPane.add(confermaButton, gbc_confermaButton);
		
		
	}

}
