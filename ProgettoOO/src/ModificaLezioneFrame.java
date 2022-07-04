import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class ModificaLezioneFrame extends JFrame {
	private Controller controller;
	private JPanel contentPane;
	private JTextField titoloTF;
	private JTextField descrizioneTF;
	private JComboBox<String> durataCB;
	private JTextField dataTF;
	private DefaultComboBoxModel<String> oraCBM;
	private JComboBox<String> oraCB;
	private DefaultComboBoxModel<String> docentiCBM;
	private JComboBox<String> docentiCB;
	private JTextField sedeTF;
	private JTextField aulaTF;
	private JLabel piattaformaLabel;
	private JTextField piattaformaTF;
	private JButton confermaButton;


	public JTextField getTitoloTF() {
		return titoloTF;
	}


	public void setTitoloTF(JTextField titoloTF) {
		this.titoloTF = titoloTF;
	}


	public JTextField getDescrizioneTF() {
		return descrizioneTF;
	}


	public void setDescrizioneTF(JTextField descrizioneTF) {
		this.descrizioneTF = descrizioneTF;
	}


	public JComboBox<String> getDurataCB() {
		return durataCB;
	}


	public void setDurataCB(JComboBox<String> durataCB) {
		this.durataCB = durataCB;
	}


	public JTextField getDataTF() {
		return dataTF;
	}


	public void setDataTF(JTextField dataTF) {
		this.dataTF = dataTF;
	}


	public DefaultComboBoxModel<String> getOraCBM() {
		return oraCBM;
	}


	public void setOraCBM(DefaultComboBoxModel<String> oraCBM) {
		this.oraCBM = oraCBM;
	}


	public JComboBox<String> getOraCB() {
		return oraCB;
	}


	public void setOraCB(JComboBox<String> oraCB) {
		this.oraCB = oraCB;
	}


	public DefaultComboBoxModel<String> getDocentiCBM() {
		return docentiCBM;
	}


	public void setDocentiCBM(DefaultComboBoxModel<String> docentiCBM) {
		this.docentiCBM = docentiCBM;
	}


	public JComboBox<String> getDocentiCB() {
		return docentiCB;
	}


	public void setDocentiCB(JComboBox<String> docentiCB) {
		this.docentiCB = docentiCB;
	}


	public JTextField getSedeTF() {
		return sedeTF;
	}


	public void setSedeTF(JTextField sedeTF) {
		this.sedeTF = sedeTF;
	}


	public JTextField getAulaTF() {
		return aulaTF;
	}


	public void setAulaTF(JTextField aulaTF) {
		this.aulaTF = aulaTF;
	}


	public JTextField getPiattaformaTF() {
		return piattaformaTF;
	}


	public void setPiattaformaTF(JTextField piattaformaTF) {
		this.piattaformaTF = piattaformaTF;
	}


	public ModificaLezioneFrame(Controller mainController) {
		setTitle("AggiungiLezione");
		controller=mainController;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{37, 72, 0, 0, 47, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 24, 32, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel modificaLezioneLabel = new JLabel("Modifica Lezione");
		modificaLezioneLabel.setFont(new Font("Century", Font.PLAIN, 25));
		GridBagConstraints gbc_modificaLezioneLabel = new GridBagConstraints();
		gbc_modificaLezioneLabel.gridheight = 2;
		gbc_modificaLezioneLabel.gridwidth = 2;
		gbc_modificaLezioneLabel.anchor = GridBagConstraints.WEST;
		gbc_modificaLezioneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_modificaLezioneLabel.gridx = 1;
		gbc_modificaLezioneLabel.gridy = 0;
		contentPane.add(modificaLezioneLabel, gbc_modificaLezioneLabel);
		
		
		JLabel titoloLabel = new JLabel("Titolo");
		titoloLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_titoloLabel = new GridBagConstraints();
		gbc_titoloLabel.gridwidth = 2;
		gbc_titoloLabel.anchor = GridBagConstraints.EAST;
		gbc_titoloLabel.insets = new Insets(0, 0, 5, 5);
		gbc_titoloLabel.gridx = 0;
		gbc_titoloLabel.gridy = 2;
		contentPane.add(titoloLabel, gbc_titoloLabel);
		
		titoloTF = new JTextField();
		titoloTF.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_titoloTF = new GridBagConstraints();
		gbc_titoloTF.insets = new Insets(0, 0, 5, 5);
		gbc_titoloTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_titoloTF.gridx = 2;
		gbc_titoloTF.gridy = 2;
		contentPane.add(titoloTF, gbc_titoloTF);
		titoloTF.setColumns(10);
		
		JLabel descrizioneLabel = new JLabel("Descrizione");
		descrizioneLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_descrizioneLabel = new GridBagConstraints();
		gbc_descrizioneLabel.gridwidth = 2;
		gbc_descrizioneLabel.anchor = GridBagConstraints.EAST;
		gbc_descrizioneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_descrizioneLabel.gridx = 0;
		gbc_descrizioneLabel.gridy = 3;
		contentPane.add(descrizioneLabel, gbc_descrizioneLabel);
		
		descrizioneTF = new JTextField();
		descrizioneTF.setFont(new Font("Century", Font.PLAIN, 16));
		descrizioneTF.setColumns(10);
		GridBagConstraints gbc_descrizioneTF = new GridBagConstraints();
		gbc_descrizioneTF.insets = new Insets(0, 0, 5, 5);
		gbc_descrizioneTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_descrizioneTF.gridx = 2;
		gbc_descrizioneTF.gridy = 3;
		contentPane.add(descrizioneTF, gbc_descrizioneTF);
		
		JLabel durataLabel = new JLabel("Durata");
		durataLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_durataLabel = new GridBagConstraints();
		gbc_durataLabel.gridwidth = 2;
		gbc_durataLabel.anchor = GridBagConstraints.EAST;
		gbc_durataLabel.insets = new Insets(0, 0, 5, 5);
		gbc_durataLabel.gridx = 0;
		gbc_durataLabel.gridy = 4;
		contentPane.add(durataLabel, gbc_durataLabel);
		
		
		oraCBM = new DefaultComboBoxModel<String>();
		oraCBM.addElement("60 minuti");
		oraCBM.addElement("90 minuti");
		oraCBM.addElement("120 minuti");
		oraCBM.addElement("150 minuti");
		oraCBM.addElement("180 minuti");
		
		durataCB = new JComboBox<String>();
		durataCB.setModel(oraCBM);
		durataCB.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_durataCB = new GridBagConstraints();
		gbc_durataCB.insets = new Insets(0, 0, 5, 5);
		gbc_durataCB.fill = GridBagConstraints.HORIZONTAL;
		gbc_durataCB.gridx = 2;
		gbc_durataCB.gridy = 4;
		contentPane.add(durataCB, gbc_durataCB);
		
		JLabel dataOraInizioLabel = new JLabel("Data e Ora");
		dataOraInizioLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_dataOraInizioLabel = new GridBagConstraints();
		gbc_dataOraInizioLabel.gridwidth = 2;
		gbc_dataOraInizioLabel.anchor = GridBagConstraints.EAST;
		gbc_dataOraInizioLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dataOraInizioLabel.gridx = 0;
		gbc_dataOraInizioLabel.gridy = 5;
		contentPane.add(dataOraInizioLabel, gbc_dataOraInizioLabel);
		
		dataTF = new JTextField();
		dataTF.setFont(new Font("Century", Font.PLAIN, 16));
		dataTF.setColumns(10);
		GridBagConstraints gbc_dataLabel = new GridBagConstraints();
		gbc_dataLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dataLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_dataLabel.gridx = 2;
		gbc_dataLabel.gridy = 5;
		contentPane.add(dataTF, gbc_dataLabel);
		
		
		oraCBM = new DefaultComboBoxModel<String>();
		oraCBM.addElement("8:00");
		oraCBM.addElement("8:30");
		oraCBM.addElement("9:00");
		oraCBM.addElement("9:30");
		oraCBM.addElement("10:00");
		oraCBM.addElement("10:30");
		oraCBM.addElement("11:00");
		oraCBM.addElement("11:30");
		oraCBM.addElement("12:00");
		oraCBM.addElement("12:30");
		oraCBM.addElement("13:00");
		oraCBM.addElement("13:30");
		oraCBM.addElement("14:00");
		oraCBM.addElement("14:30");
		oraCBM.addElement("15:00");
		oraCBM.addElement("15:30");
		oraCBM.addElement("16:00");
		oraCBM.addElement("16:30");
		oraCBM.addElement("17:00");
		oraCBM.addElement("17:30");
		oraCBM.addElement("18:00");
		
		
		oraCB = new JComboBox<String>();
		oraCB.setModel(oraCBM);
		oraCB.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_oraCB = new GridBagConstraints();
		gbc_oraCB.insets = new Insets(0, 0, 5, 5);
		gbc_oraCB.fill = GridBagConstraints.HORIZONTAL;
		gbc_oraCB.gridx = 3;
		gbc_oraCB.gridy = 5;
		contentPane.add(oraCB, gbc_oraCB);
		
		JLabel docenteLabel = new JLabel("Docente");
		docenteLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_docenteLabel = new GridBagConstraints();
		gbc_docenteLabel.gridwidth = 2;
		gbc_docenteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_docenteLabel.anchor = GridBagConstraints.EAST;
		gbc_docenteLabel.gridx = 0;
		gbc_docenteLabel.gridy = 6;
		contentPane.add(docenteLabel, gbc_docenteLabel);
		
		
		docentiCBM = new DefaultComboBoxModel<String>();
		int numeroDocenti=controller.contaDocenti();
		String[] docenti = controller.recuperaDocenti(numeroDocenti);
		docentiCBM = controller.setDefaultComboBoxModel(docentiCBM, docenti);
				
		docentiCB = new JComboBox<String>();
		docentiCB.setModel(docentiCBM);
		docentiCB.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_docentiCB = new GridBagConstraints();
		gbc_docentiCB.insets = new Insets(0, 0, 5, 5);
		gbc_docentiCB.fill = GridBagConstraints.HORIZONTAL;
		gbc_docentiCB.gridx = 2;
		gbc_docentiCB.gridy = 6;
		contentPane.add(docentiCB, gbc_docentiCB);
		
		JLabel sedeLabel = new JLabel("Sede");
		sedeLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_sedeLabel = new GridBagConstraints();
		gbc_sedeLabel.gridwidth = 2;
		gbc_sedeLabel.anchor = GridBagConstraints.EAST;
		gbc_sedeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_sedeLabel.gridx = 0;
		gbc_sedeLabel.gridy = 7;
		contentPane.add(sedeLabel, gbc_sedeLabel);
		
		sedeTF = new JTextField();
		sedeTF.setFont(new Font("Century", Font.PLAIN, 16));
		sedeTF.setColumns(10);
		GridBagConstraints gbc_sedeTF = new GridBagConstraints();
		gbc_sedeTF.insets = new Insets(0, 0, 5, 5);
		gbc_sedeTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_sedeTF.gridx = 2;
		gbc_sedeTF.gridy = 7;
		contentPane.add(sedeTF, gbc_sedeTF);
		
		JLabel aulaLabel = new JLabel("Aula");
		aulaLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_aulaLabel = new GridBagConstraints();
		gbc_aulaLabel.gridwidth = 2;
		gbc_aulaLabel.anchor = GridBagConstraints.EAST;
		gbc_aulaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_aulaLabel.gridx = 0;
		gbc_aulaLabel.gridy = 8;
		contentPane.add(aulaLabel, gbc_aulaLabel);
		
		aulaTF = new JTextField();
		aulaTF.setFont(new Font("Century", Font.PLAIN, 16));
		aulaTF.setColumns(10);
		GridBagConstraints gbc_aulaTF = new GridBagConstraints();
		gbc_aulaTF.insets = new Insets(0, 0, 5, 5);
		gbc_aulaTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_aulaTF.gridx = 2;
		gbc_aulaTF.gridy = 8;
		contentPane.add(aulaTF, gbc_aulaTF);
		
		JLabel onlineLabel = new JLabel("Online");
		onlineLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_onlineLabel = new GridBagConstraints();
		gbc_onlineLabel.gridwidth = 2;
		gbc_onlineLabel.anchor = GridBagConstraints.EAST;
		gbc_onlineLabel.insets = new Insets(0, 0, 5, 5);
		gbc_onlineLabel.gridx = 0;
		gbc_onlineLabel.gridy = 9;
		contentPane.add(onlineLabel, gbc_onlineLabel);
		
		JCheckBox onlineCheckBox = new JCheckBox("Si");
		onlineCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(onlineCheckBox.isSelected()) {
					piattaformaLabel.setVisible(true);
					piattaformaTF.setVisible(true);
				}
				else {
					piattaformaLabel.setVisible(false);
					piattaformaTF.setVisible(false);
				}
			}
		});
		onlineCheckBox.setBackground(new Color(30, 144, 255));
		onlineCheckBox.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 2;
		gbc_chckbxNewCheckBox.gridy = 9;
		contentPane.add(onlineCheckBox, gbc_chckbxNewCheckBox);
		
		
		piattaformaLabel = new JLabel("Piattaforma");
		piattaformaLabel.setVisible(false);
		piattaformaLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_piattaformaLabel = new GridBagConstraints();
		gbc_piattaformaLabel.gridwidth = 2;
		gbc_piattaformaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_piattaformaLabel.anchor = GridBagConstraints.EAST;
		gbc_piattaformaLabel.gridx = 0;
		gbc_piattaformaLabel.gridy = 10;
		contentPane.add(piattaformaLabel, gbc_piattaformaLabel);
		
		piattaformaTF = new JTextField();
		piattaformaTF.setVisible(false);
		piattaformaTF.setFont(new Font("Century", Font.PLAIN, 16));
		piattaformaTF.setColumns(10);
		GridBagConstraints gbc_piattaformaTF = new GridBagConstraints();
		gbc_piattaformaTF.insets = new Insets(0, 0, 5, 5);
		gbc_piattaformaTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_piattaformaTF.gridx = 2;
		gbc_piattaformaTF.gridy = 10;
		contentPane.add(piattaformaTF, gbc_piattaformaTF);
		
		JButton indietroButton = new JButton("Indietro");
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getAggiungiLezioneFrame().setVisible(false);
				titoloTF.setText("");
				descrizioneTF.setText("");
				durataCB.setSelectedIndex(0);
				dataTF.setText("");
				oraCB.setSelectedIndex(0);
				docentiCB.setSelectedIndex(0);
				sedeTF.setText("");
				aulaTF.setText("");
				onlineCheckBox.setSelected(false);
				piattaformaLabel.setVisible(false);
				piattaformaTF.setVisible(false);
				piattaformaTF.setText("");
			}
		});
		indietroButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_indietroButton = new GridBagConstraints();
		gbc_indietroButton.insets = new Insets(0, 0, 0, 5);
		gbc_indietroButton.gridx = 1;
		gbc_indietroButton.gridy = 12;
		contentPane.add(indietroButton, gbc_indietroButton);
		
		confermaButton = new JButton("Conferma");
		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codiceLezione = controller.getLezioniFrame().getLezioniTable().getValueAt(controller.getLezioniFrame().getLezioniTable().getSelectedRow(),0).toString();
				String titolo = titoloTF.getText();
				String descrizione = descrizioneTF.getText();
				String durata = durataCB.getSelectedItem().toString();
				String dataEOra = dataTF.getText()+" "+oraCB.getSelectedItem();
				String codiceDocente = controller.recuperaCodiceDocente(docentiCB.getSelectedItem().toString());
				String sede = sedeTF.getText();
				String aula = aulaTF.getText();
				String piattaforma = piattaformaTF.getText();
				
				controller.getModificaLezioneFrame().setVisible(false);
				
			}
		});
		confermaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_confermaButton = new GridBagConstraints();
		gbc_confermaButton.anchor = GridBagConstraints.EAST;
		gbc_confermaButton.insets = new Insets(0, 0, 0, 5);
		gbc_confermaButton.gridx = 3;
		gbc_confermaButton.gridy = 12;
		contentPane.add(confermaButton, gbc_confermaButton);
		
	
	}

}
