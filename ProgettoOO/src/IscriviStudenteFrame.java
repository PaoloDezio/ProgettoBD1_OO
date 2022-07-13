import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class IscriviStudenteFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTextField nomeTF;
	private JTextField cognomeTF;
	private JTextField dataDiNascitaTF;
	private JTextField luogoDiNascitaTF;
	private JComboBox<String> corsoCB;
	private DefaultComboBoxModel<String> corsoCBM;
	private JTextField codiceFiscaleTF;
	
	public IscriviStudenteFrame(Controller mainController) {
		
		controller = mainController;
		
		setTitle("IscriviStudente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 175, 600, 365);
		
		
		//CONTENT PANE
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{21, 122, 100, 100, 40, 0};
		gbl_contentPane.rowHeights = new int[]{0, 24, 0, 0, 0, 0, 0, 15, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		//ISCRIZIONE LABEL
		JLabel iscrizioneLabel = new JLabel("Iscrizione ");
		iscrizioneLabel.setFont(new Font("Century", Font.BOLD, 25));
		GridBagConstraints gbc_iscrizioneLabel = new GridBagConstraints();
		gbc_iscrizioneLabel.anchor = GridBagConstraints.WEST;
		gbc_iscrizioneLabel.gridwidth = 2;
		gbc_iscrizioneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_iscrizioneLabel.gridx = 1;
		gbc_iscrizioneLabel.gridy = 0;
		contentPane.add(iscrizioneLabel, gbc_iscrizioneLabel);
		
		
		//NOME LABEL
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.anchor = GridBagConstraints.EAST;
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.gridx = 1;
		gbc_nomeLabel.gridy = 2;
		contentPane.add(nomeLabel, gbc_nomeLabel);
		
		
		//NOME TEXT FIELD
		nomeTF = new JTextField();
		nomeTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeTF = new GridBagConstraints();
		gbc_nomeTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeTF.insets = new Insets(0, 0, 5, 5);
		gbc_nomeTF.gridx = 2;
		gbc_nomeTF.gridy = 2;
		contentPane.add(nomeTF, gbc_nomeTF);
		nomeTF.setColumns(10);
		
		
		//COGNOME LABEL
		JLabel cognomeLabel = new JLabel("Cognome");
		cognomeLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_cognomeLabel = new GridBagConstraints();
		gbc_cognomeLabel.anchor = GridBagConstraints.EAST;
		gbc_cognomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeLabel.gridx = 1;
		gbc_cognomeLabel.gridy = 3;
		contentPane.add(cognomeLabel, gbc_cognomeLabel);
		
		
		//COGNOME TEXT FIELD
		cognomeTF = new JTextField();
		cognomeTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_cognomeTF = new GridBagConstraints();
		gbc_cognomeTF.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cognomeTF.gridx = 2;
		gbc_cognomeTF.gridy = 3;
		contentPane.add(cognomeTF, gbc_cognomeTF);
		cognomeTF.setColumns(10);
		
		
		//DATA DI NASCITA LABEL
		JLabel dataDiNascitaLabel = new JLabel("Data di Nascita");
		dataDiNascitaLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_dataDiNascitaLabel = new GridBagConstraints();
		gbc_dataDiNascitaLabel.anchor = GridBagConstraints.EAST;
		gbc_dataDiNascitaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dataDiNascitaLabel.gridx = 1;
		gbc_dataDiNascitaLabel.gridy = 4;
		contentPane.add(dataDiNascitaLabel, gbc_dataDiNascitaLabel);
		
		
		//DATA DI NASCITA TEXT FIELD
		dataDiNascitaTF = new JTextField();
		dataDiNascitaTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_dataDiNascitaTF = new GridBagConstraints();
		gbc_dataDiNascitaTF.insets = new Insets(0, 0, 5, 5);
		gbc_dataDiNascitaTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_dataDiNascitaTF.gridx = 2;
		gbc_dataDiNascitaTF.gridy = 4;
		contentPane.add(dataDiNascitaTF, gbc_dataDiNascitaTF);
		dataDiNascitaTF.setColumns(10);
		
		
		//LUOGO DI NASCITA LABEL
		JLabel luogoDiNascitaLabel = new JLabel("Luogo di Nascita");
		luogoDiNascitaLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_luogoDiNascitaLabel = new GridBagConstraints();
		gbc_luogoDiNascitaLabel.anchor = GridBagConstraints.EAST;
		gbc_luogoDiNascitaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_luogoDiNascitaLabel.gridx = 1;
		gbc_luogoDiNascitaLabel.gridy = 5;
		contentPane.add(luogoDiNascitaLabel, gbc_luogoDiNascitaLabel);
		
		
		//LUOGO DI NASCITA TEXT FIELD
		luogoDiNascitaTF = new JTextField();
		luogoDiNascitaTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_luogoDiNascitaTF = new GridBagConstraints();
		gbc_luogoDiNascitaTF.insets = new Insets(0, 0, 5, 5);
		gbc_luogoDiNascitaTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_luogoDiNascitaTF.gridx = 2;
		gbc_luogoDiNascitaTF.gridy = 5;
		contentPane.add(luogoDiNascitaTF, gbc_luogoDiNascitaTF);
		luogoDiNascitaTF.setColumns(10);
		
		//CORSO DEFAULT COMBO BOX MODEL
		corsoCBM = new DefaultComboBoxModel<String>();
		
		int numeroCorsi=controller.contaCorsi();
		String[] corsi = controller.recuperaCorsi(numeroCorsi);
		
		corsoCBM = controller.setDefaultComboBoxModel(corsoCBM,corsi);
		
		
		//INDIETRO BUTTON
		JButton indietroButton = new JButton("Indietro");
		
		//INDIETRO BUTTON ACTION LISTENER
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getIscriviStudenteFrame().setVisible(false);
				controller.getHomeFrame().setVisible(true);	
				
				nomeTF.setText("");
				cognomeTF.setText("");
				dataDiNascitaTF.setText("");
				luogoDiNascitaTF.setText("");
				corsoCBM.removeAllElements();
				
				int numeroCorsi=controller.contaCorsi();
				String[] corsi = controller.recuperaCorsi(numeroCorsi);
				
				corsoCBM=controller.setDefaultComboBoxModel(corsoCBM,corsi);
			}
		});
		
		indietroButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_indietroButton = new GridBagConstraints();
		gbc_indietroButton.insets = new Insets(0, 0, 0, 5);
		gbc_indietroButton.gridx = 1;
		gbc_indietroButton.gridy = 8;
		contentPane.add(indietroButton, gbc_indietroButton);
		
		//CODICE FISCALE LABEL
		JLabel codiceFiscaleLabel = new JLabel("codiceFiscale");
		GridBagConstraints gbc_codiceFiscaleLabel = new GridBagConstraints();
		gbc_codiceFiscaleLabel.anchor = GridBagConstraints.EAST;
		gbc_codiceFiscaleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_codiceFiscaleLabel.gridx = 1;
		gbc_codiceFiscaleLabel.gridy = 6;
		contentPane.add(codiceFiscaleLabel, gbc_codiceFiscaleLabel);
		
		
		//CODICE FISCALE TEXT FIELD
		codiceFiscaleTF = new JTextField();
		GridBagConstraints gbc_codiceFiscaleTF = new GridBagConstraints();
		gbc_codiceFiscaleTF.insets = new Insets(0, 0, 5, 5);
		gbc_codiceFiscaleTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_codiceFiscaleTF.gridx = 2;
		gbc_codiceFiscaleTF.gridy = 6;
		contentPane.add(codiceFiscaleTF, gbc_codiceFiscaleTF);
		codiceFiscaleTF.setColumns(10);
		
		
		//CORSO LABEL
		JLabel corsoLabel = new JLabel("Corso");
		corsoLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_corsoLabel = new GridBagConstraints();
		gbc_corsoLabel.anchor = GridBagConstraints.EAST;
		gbc_corsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_corsoLabel.gridx = 1;
		gbc_corsoLabel.gridy = 7;
		contentPane.add(corsoLabel, gbc_corsoLabel);
		
		
		//CORSO COMBO BOX
		corsoCB = new JComboBox<String>();
		corsoCB.setModel(corsoCBM);
		corsoCB.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_corsoCB = new GridBagConstraints();
		gbc_corsoCB.insets = new Insets(0, 0, 5, 5);
		gbc_corsoCB.fill = GridBagConstraints.HORIZONTAL;
		gbc_corsoCB.gridx = 2;
		gbc_corsoCB.gridy = 7;
		contentPane.add(corsoCB, gbc_corsoCB);
		
	
		//CONFERMA BUTTON
		JButton confermaButton = new JButton("Conferma");
		
		//CONFERMA BUTTON ACTION LISTENER
		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(nomeTF.getText().isEmpty()||cognomeTF.getText().isEmpty()||dataDiNascitaTF.getText().isEmpty()||codiceFiscaleTF.getText().isEmpty()||luogoDiNascitaTF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(contentPane,"Riempi tutti i campi","",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					if(codiceFiscaleTF.getText().length()!=16) {
						JOptionPane.showMessageDialog(contentPane,"Codice fiscale non valido","",JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						String nome = nomeTF.getText().toUpperCase();
						String cognome = cognomeTF.getText().toUpperCase();
						Date dataDiNascita = new Date(0);
						dataDiNascita = dataDiNascita.valueOf(dataDiNascitaTF.getText());
						String luogoDiNascita = luogoDiNascitaTF.getText().toUpperCase();
						String codiceFiscale = codiceFiscaleTF.getText().toUpperCase();
						String nomeCorso=corsoCB.getSelectedItem().toString();
						String codiceCorso=controller.recuperaCodiceCorso(nomeCorso);
						
						if(controller.isStudenteInDb(nome,cognome,dataDiNascita,luogoDiNascita)==false) {
							controller.salvaStudente(nome,cognome,dataDiNascita,luogoDiNascita,codiceFiscale);
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
							
							int numeroCorsi=controller.contaCorsi();
							String[] corsi = controller.recuperaCorsi(numeroCorsi);
							
							corsoCBM= controller.setDefaultComboBoxModel(corsoCBM,corsi);
							controller.getIscriviStudenteFrame().setVisible(false);
							controller.getHomeFrame().setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null,cognome+" "+nome+" è già iscritto/a al corso di "+nomeCorso,"",JOptionPane.WARNING_MESSAGE);
						}
					}
				}}});
		
		confermaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_confermaButton = new GridBagConstraints();
		gbc_confermaButton.gridwidth = 2;
		gbc_confermaButton.gridx = 3;
		gbc_confermaButton.gridy = 8;
		contentPane.add(confermaButton, gbc_confermaButton);

	}

	
	
}
