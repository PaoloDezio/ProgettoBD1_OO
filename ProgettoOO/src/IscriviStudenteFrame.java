import java.awt.BorderLayout;
import java.util.ArrayList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
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
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class IscriviStudenteFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTextField nomeTF;
	private JTextField cognomeTF;
	private JTextField dataDiNascitaTF;
	private JTextField luogoDiNascitaTF;
	private JComboBox corsoCB;
	private DefaultComboBoxModel corsoCBM;
	
	public IscriviStudenteFrame(Controller c) {
		
		controller = c;
		
		setTitle("IscriviStudente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 175, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{26, 0, 100, 100, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 24, 0, 0, 0, 0, 0, 15, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel iscrizioneLabel = new JLabel("Iscrizione ");
		iscrizioneLabel.setFont(new Font("Century", Font.BOLD, 25));
		GridBagConstraints gbc_iscrizioneLabel = new GridBagConstraints();
		gbc_iscrizioneLabel.anchor = GridBagConstraints.WEST;
		gbc_iscrizioneLabel.gridwidth = 2;
		gbc_iscrizioneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_iscrizioneLabel.gridx = 1;
		gbc_iscrizioneLabel.gridy = 1;
		contentPane.add(iscrizioneLabel, gbc_iscrizioneLabel);
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setFont(new Font("Century", Font.PLAIN, 16));
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
		cognomeLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_cognomeLabel = new GridBagConstraints();
		gbc_cognomeLabel.anchor = GridBagConstraints.EAST;
		gbc_cognomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeLabel.gridx = 1;
		gbc_cognomeLabel.gridy = 4;
		contentPane.add(cognomeLabel, gbc_cognomeLabel);
		
		cognomeTF = new JTextField();
		cognomeTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_cognomeTF = new GridBagConstraints();
		gbc_cognomeTF.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cognomeTF.gridx = 2;
		gbc_cognomeTF.gridy = 4;
		contentPane.add(cognomeTF, gbc_cognomeTF);
		cognomeTF.setColumns(10);
		
		JLabel dataDiNascitaLabel = new JLabel("Data di Nascita");
		dataDiNascitaLabel.setFont(new Font("Century", Font.PLAIN, 16));
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
		luogoDiNascitaLabel.setFont(new Font("Century", Font.PLAIN, 16));
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
		
		JLabel corsoLabel = new JLabel("Corso");
		corsoLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_corsoLabel = new GridBagConstraints();
		gbc_corsoLabel.anchor = GridBagConstraints.EAST;
		gbc_corsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_corsoLabel.gridx = 1;
		gbc_corsoLabel.gridy = 7;
		contentPane.add(corsoLabel, gbc_corsoLabel);
		

		corsoCBM = new DefaultComboBoxModel();
		corsoCBM = setDefaultComboBoxModelPerCorso(corsoCBM);
		
		corsoCB = new JComboBox();
		corsoCB.setModel(corsoCBM);
		corsoCB.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_corsoCB = new GridBagConstraints();
		gbc_corsoCB.insets = new Insets(0, 0, 5, 5);
		gbc_corsoCB.fill = GridBagConstraints.HORIZONTAL;
		gbc_corsoCB.gridx = 2;
		gbc_corsoCB.gridy = 7;
		contentPane.add(corsoCB, gbc_corsoCB);
		
		JButton indietroButton = new JButton("Indietro");
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getHomeFrame().setVisible(true);	
				controller.getIscriviStudenteFrame().setVisible(false);
				nomeTF.setText("");
				cognomeTF.setText("");
				dataDiNascitaTF.setText("");
				luogoDiNascitaTF.setText("");
				corsoCBM.removeAllElements();
				corsoCBM=setDefaultComboBoxModelPerCorso(corsoCBM);
			}
		});
		indietroButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_indietroButton = new GridBagConstraints();
		gbc_indietroButton.insets = new Insets(0, 0, 0, 5);
		gbc_indietroButton.gridx = 1;
		gbc_indietroButton.gridy = 9;
		contentPane.add(indietroButton, gbc_indietroButton);
		

		JButton confermaButton = new JButton("Conferma");
		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = nomeTF.getText().toUpperCase();
				String cognome = cognomeTF.getText().toUpperCase();
				Date dataDiNascita = new Date(0);
				dataDiNascita = dataDiNascita.valueOf(dataDiNascitaTF.getText());
				String luogoDiNascita = luogoDiNascitaTF.getText().toUpperCase();
				String nomeCorso=corsoCB.getSelectedItem().toString();
				String codiceCorso=controller.recuperaCodiceCorso(nomeCorso);
				
				if(controller.isStudenteInDb(nome,cognome,dataDiNascita,luogoDiNascita)==false) {
					controller.salvaStudente(nome,cognome,dataDiNascita,luogoDiNascita);
				}
				
				String codiceStudente=controller.recuperaCodiceStudente(nome,cognome,dataDiNascita,luogoDiNascita);
				
				if(controller.isStudenteIscrittoAdUnCorso(codiceStudente,codiceCorso)==false) {
					controller.iscriviStudente(codiceStudente,codiceCorso);
					JOptionPane.showMessageDialog(null,"Iscrizione avvenuta con successo");
					nomeTF.setText("");
					cognomeTF.setText("");
					dataDiNascitaTF.setText("");
					luogoDiNascitaTF.setText("");
					corsoCBM.removeAllElements();
					corsoCBM=setDefaultComboBoxModelPerCorso(corsoCBM);
					controller.getIscriviStudenteFrame().setVisible(false);
					controller.getHomeFrame().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,cognome+" "+nome+" è già iscritto/a al corso di "+nomeCorso,"",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		confermaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_confermaButton = new GridBagConstraints();
		gbc_confermaButton.gridwidth = 2;
		gbc_confermaButton.gridx = 3;
		gbc_confermaButton.gridy = 9;
		contentPane.add(confermaButton, gbc_confermaButton);


	}

	
	public DefaultComboBoxModel setDefaultComboBoxModelPerCorso(DefaultComboBoxModel defaultComboBoxModel) {
		int numeroCorsi=controller.contaCorsi();
		String[] corsi = controller.recuperaCorsi(numeroCorsi);
		
		for(String stringa: corsi) {
			defaultComboBoxModel.addElement(stringa);
		}
		
		return defaultComboBoxModel;
	}
}
