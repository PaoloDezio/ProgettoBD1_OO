import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AggiungiCorsoFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTextField nomeTF;
	private JTextField descrizioneTF;
	private JTextField numeroMassimoPartecipantiTF;
	private JTextField numeroDiLezioniTF;
	private JTextField dataDiInizioTF;
	private JComboBox<String> responsabiliCB;
	private JButton confermaButton;
	private JButton indietroButton;
	private JComboBox<String> categorieCB;
	private DefaultComboBoxModel<String> categorieCBM;
	private Vector<Vector<String>> categorie;
	private DefaultTableModel categorieDTM;
	private JTable categorieTable;
	private JScrollPane categorieTableScrollPane;
	private JButton aggiungiAreaTematicaButton;
	
	//GETTERS AND SETTERS
	public Vector<Vector<String>> getCategorie() {
		return categorie;
	}
	
	public void setCategorie(Vector<Vector<String>> categorie) {
		this.categorie = categorie;
	}

	public DefaultTableModel getCategorieDTM() {
		return categorieDTM;
	}

	public void setCategorieDTM(DefaultTableModel categorieDTM) {
		this.categorieDTM = categorieDTM;
	}

	public JTable getCategorieTable() {
		return categorieTable;
	}

	public void setCategorieTable(JTable categorieTable) {
		this.categorieTable = categorieTable;
	}
	
	
	
	public AggiungiCorsoFrame(Controller mainController) {
		
		controller = mainController;
		
		
		setTitle("AggiungiCorsoFrame");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 440);
		
		
		//CONTENT PANE
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 67, 80, 77, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 30, 33, 29, 20, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		//AGGIUNGI CORSO LABEL
		JLabel aggiungiCorsoLabel = new JLabel("Aggiungi Corso");
		aggiungiCorsoLabel.setFont(new Font("Century", Font.PLAIN, 25));
		GridBagConstraints gbc_aggiungiCorsoLabel = new GridBagConstraints();
		gbc_aggiungiCorsoLabel.fill = GridBagConstraints.VERTICAL;
		gbc_aggiungiCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_aggiungiCorsoLabel.gridx = 1;
		gbc_aggiungiCorsoLabel.gridy = 0;
		contentPane.add(aggiungiCorsoLabel, gbc_aggiungiCorsoLabel);
		
		
		//NOME LABEL
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.anchor = GridBagConstraints.EAST;
		gbc_nomeLabel.gridx = 1;
		gbc_nomeLabel.gridy = 1;
		contentPane.add(nomeLabel, gbc_nomeLabel);
		
		
		//NOME TEXTFIELD
		nomeTF = new JTextField();
		nomeTF.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeTF = new GridBagConstraints();
		gbc_nomeTF.gridwidth = 3;
		gbc_nomeTF.insets = new Insets(0, 0, 5, 5);
		gbc_nomeTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeTF.gridx = 2;
		gbc_nomeTF.gridy = 1;
		contentPane.add(nomeTF, gbc_nomeTF);
		nomeTF.setColumns(10);
		
		
		//DESCRIZIONE LABEL
		JLabel descrizioneLabel = new JLabel("Descrizione");
		descrizioneLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_descrizioneLabel = new GridBagConstraints();
		gbc_descrizioneLabel.anchor = GridBagConstraints.EAST;
		gbc_descrizioneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_descrizioneLabel.gridx = 1;
		gbc_descrizioneLabel.gridy = 2;
		contentPane.add(descrizioneLabel, gbc_descrizioneLabel);
		
		
		//DESCRIZIONE TEXT FIELD
		descrizioneTF = new JTextField();
		descrizioneTF.setFont(new Font("Century", Font.PLAIN, 16));
		descrizioneTF.setColumns(10);
		GridBagConstraints gbc_descrizioneTF = new GridBagConstraints();
		gbc_descrizioneTF.gridwidth = 3;
		gbc_descrizioneTF.insets = new Insets(0, 0, 5, 5);
		gbc_descrizioneTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_descrizioneTF.gridx = 2;
		gbc_descrizioneTF.gridy = 2;
		contentPane.add(descrizioneTF, gbc_descrizioneTF);
		
		
		//NUMERO MASSIMO PARTECIPANTI LABEL
		JLabel numeroMassimoPartecipantiLabel = new JLabel("N\u00B0 massimo di partecipanti");
		numeroMassimoPartecipantiLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_numeroMassimoPartecipantiLabel = new GridBagConstraints();
		gbc_numeroMassimoPartecipantiLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numeroMassimoPartecipantiLabel.anchor = GridBagConstraints.EAST;
		gbc_numeroMassimoPartecipantiLabel.gridx = 1;
		gbc_numeroMassimoPartecipantiLabel.gridy = 3;
		contentPane.add(numeroMassimoPartecipantiLabel, gbc_numeroMassimoPartecipantiLabel);
		
		
		//NUMERO MASSIMO PARTECIPANTI TEXT FIELD
		numeroMassimoPartecipantiTF = new JTextField();
		numeroMassimoPartecipantiTF.setFont(new Font("Century", Font.PLAIN, 16));
		numeroMassimoPartecipantiTF.setColumns(10);
		GridBagConstraints gbc_numeroMassimoPartecipantiTF = new GridBagConstraints();
		gbc_numeroMassimoPartecipantiTF.gridwidth = 3;
		gbc_numeroMassimoPartecipantiTF.insets = new Insets(0, 0, 5, 5);
		gbc_numeroMassimoPartecipantiTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_numeroMassimoPartecipantiTF.gridx = 2;
		gbc_numeroMassimoPartecipantiTF.gridy = 3;
		contentPane.add(numeroMassimoPartecipantiTF, gbc_numeroMassimoPartecipantiTF);
		
		
		//NUMERO DI LEZIONI LABEL
		JLabel numeroDiLezioniLabel = new JLabel("N\u00B0 di lezioni");
		numeroDiLezioniLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_numeroDiLezioniLabel = new GridBagConstraints();
		gbc_numeroDiLezioniLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numeroDiLezioniLabel.anchor = GridBagConstraints.EAST;
		gbc_numeroDiLezioniLabel.gridx = 1;
		gbc_numeroDiLezioniLabel.gridy = 4;
		contentPane.add(numeroDiLezioniLabel, gbc_numeroDiLezioniLabel);
		
		
		//NUMERO DI LEZIONI TEXTFIELD
		numeroDiLezioniTF = new JTextField();
		numeroDiLezioniTF.setFont(new Font("Century", Font.PLAIN, 16));
		numeroDiLezioniTF.setColumns(10);
		GridBagConstraints gbc_numeroDiLezioniTF = new GridBagConstraints();
		gbc_numeroDiLezioniTF.gridwidth = 3;
		gbc_numeroDiLezioniTF.insets = new Insets(0, 0, 5, 5);
		gbc_numeroDiLezioniTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_numeroDiLezioniTF.gridx = 2;
		gbc_numeroDiLezioniTF.gridy = 4;
		contentPane.add(numeroDiLezioniTF, gbc_numeroDiLezioniTF);
		
		
		//DATA DI INIZIO LABEL
		JLabel dataDiInizio = new JLabel("Data di inizio");
		dataDiInizio.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_dataDiInizio = new GridBagConstraints();
		gbc_dataDiInizio.insets = new Insets(0, 0, 5, 5);
		gbc_dataDiInizio.anchor = GridBagConstraints.EAST;
		gbc_dataDiInizio.gridx = 1;
		gbc_dataDiInizio.gridy = 5;
		contentPane.add(dataDiInizio, gbc_dataDiInizio);
		
		
		//DATA DI INIZIO TEXTFIELD
		dataDiInizioTF = new JTextField();
		dataDiInizioTF.setFont(new Font("Century", Font.PLAIN, 16));
		dataDiInizioTF.setColumns(10);
		GridBagConstraints gbc_dataDiInizioTF = new GridBagConstraints();
		gbc_dataDiInizioTF.gridwidth = 3;
		gbc_dataDiInizioTF.insets = new Insets(0, 0, 5, 5);
		gbc_dataDiInizioTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_dataDiInizioTF.gridx = 2;
		gbc_dataDiInizioTF.gridy = 5;
		contentPane.add(dataDiInizioTF, gbc_dataDiInizioTF);
		
		
		//CATEGORIA LABEL
		JLabel categoriaLabel = new JLabel("Categoria");
		categoriaLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_categoriaLabel = new GridBagConstraints();
		gbc_categoriaLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_categoriaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_categoriaLabel.gridx = 1;
		gbc_categoriaLabel.gridy = 6;
		contentPane.add(categoriaLabel, gbc_categoriaLabel);
		

		//CATEGORIE TABLE SCROLL PANE
		categorieTableScrollPane = new JScrollPane();
		GridBagConstraints gbc_categorieTableScrollPane = new GridBagConstraints();
		gbc_categorieTableScrollPane.gridheight = 3;
		gbc_categorieTableScrollPane.gridwidth = 3;
		gbc_categorieTableScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_categorieTableScrollPane.fill = GridBagConstraints.BOTH;
		gbc_categorieTableScrollPane.gridx = 2;
		gbc_categorieTableScrollPane.gridy = 6;
		contentPane.add(categorieTableScrollPane, gbc_categorieTableScrollPane);
		
		
		//CATEGORIE DEFAULT TABLE MODEL
		categorieDTM = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		};
		categorieDTM.addColumn("Categoria");
		categorie=controller.recuperaAreeTematicheInVettoreDiVettoreDiStringhe(controller.contaCategorie());
		categorieDTM=controller.setDefaultTableModel(categorieDTM,categorie);
		
		
		//CATEGORIE TABLE
		categorieTable = new JTable();
		categorieTable.setModel(categorieDTM);
		categorieTable.setFont(new Font("Century", Font.PLAIN, 16));
		categorieTableScrollPane.setViewportView(categorieTable);
		
		
		//AGGIUNGI AREA TEMATICA BUTTON
		aggiungiAreaTematicaButton = new JButton("Aggiungi Area Tematica");
		
		//AGGIUNGI AREA TEMATICA ACTION LISTENER
		aggiungiAreaTematicaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setAlwaysOnTop(false);
				controller.getAggiungiAreaTematicaFrame().setAlwaysOnTop(true);
				controller.getAggiungiAreaTematicaFrame().setVisible(true);
			}
		});
		
		aggiungiAreaTematicaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_aggiungiAreaTematicaButton = new GridBagConstraints();
		gbc_aggiungiAreaTematicaButton.insets = new Insets(0, 0, 5, 5);
		gbc_aggiungiAreaTematicaButton.gridx = 5;
		gbc_aggiungiAreaTematicaButton.gridy = 6;
		contentPane.add(aggiungiAreaTematicaButton, gbc_aggiungiAreaTematicaButton);
		
		
		//RESPONSABILE LABEL
		JLabel responsabileLabel = new JLabel("Responsabile");
		responsabileLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_responsabileLabel = new GridBagConstraints();
		gbc_responsabileLabel.anchor = GridBagConstraints.EAST;
		gbc_responsabileLabel.insets = new Insets(0, 0, 5, 5);
		gbc_responsabileLabel.gridx = 1;
		gbc_responsabileLabel.gridy = 9;
		contentPane.add(responsabileLabel, gbc_responsabileLabel);
		
		
		//RESPONSABILI COMBO BOX
		int numeroResponsabili=mainController.contaResponsabili();
		String[] responsabili=mainController.salvaResponsabili(numeroResponsabili);
		
		responsabiliCB = new JComboBox<String>(responsabili);
		responsabiliCB.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_responsabileCB = new GridBagConstraints();
		gbc_responsabileCB.gridwidth = 3;
		gbc_responsabileCB.insets = new Insets(0, 0, 5, 5);
		gbc_responsabileCB.fill = GridBagConstraints.HORIZONTAL;
		gbc_responsabileCB.gridx = 2;
		gbc_responsabileCB.gridy = 9;
		contentPane.add(responsabiliCB, gbc_responsabileCB);
		
		
		//INDIETRO BUTTON
		indietroButton = new JButton("Indietro");
		
		//INDIETRO BUTTON ACTION LISTENER
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.getAggiungiCorsoFrame().setVisible(false);
				controller.getAggiungiAreaTematicaFrame().setVisible(false);
				resettaAggiungiCorsoFrame();
			}
		});
		
		indietroButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_indietroButton = new GridBagConstraints();
		gbc_indietroButton.insets = new Insets(0, 0, 5, 5);
		gbc_indietroButton.gridx = 1;
		gbc_indietroButton.gridy = 11;
		contentPane.add(indietroButton, gbc_indietroButton);
		
		
		//CONFERMA BUTTON
		confermaButton = new JButton("Conferma");
		
		//CONFERMA BUTTON ACTION LISTENER
		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(nomeTF.getText().isEmpty()||descrizioneTF.getText().isEmpty()||numeroMassimoPartecipantiTF.getText().isEmpty()||numeroDiLezioniTF.getText().isEmpty()||dataDiInizioTF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(contentPane,"Compilare tutti i campi prima di confermare!","",JOptionPane.ERROR_MESSAGE);
				}
				else {
					if(categorieTable.getSelectedRow()==-1) {
						JOptionPane.showMessageDialog(contentPane,"Selezionare una categoria!","",JOptionPane.ERROR_MESSAGE);
					}
					else {
						controller.aggiungiCorso(nomeTF.getText().toUpperCase(), descrizioneTF.getText().toUpperCase(), numeroMassimoPartecipantiTF.getText(), numeroDiLezioniTF.getText(), dataDiInizioTF.getText(), controller.recuperaCodiceResponsabile(responsabiliCB.getSelectedItem().toString()));
						
						String categorieSelezionate = new String();
						
						for (int indiceCategoria : categorieTable.getSelectedRows()) {
							categorieSelezionate= categorieSelezionate +","+categorieTable.getValueAt(indiceCategoria, 0).toString();
						}	
						
						categorieSelezionate= categorieSelezionate.substring(1);
						controller.assegnaAreeTematicheAdUnCorso(categorieSelezionate,controller.recuperaCodiceCorso(nomeTF.getText().toString().toUpperCase()));
				
						controller.getGestioneCorsiFrame().getCorsiDTM().getDataVector().removeAllElements();
						controller.getGestioneCorsiFrame().setCorsi(controller.recuperaCorsiOrdinatiPer("codicecorso","","",""));
						controller.getGestioneCorsiFrame().setCorsiDTM(controller.setDefaultTableModel(controller.getGestioneCorsiFrame().getCorsiDTM(), controller.getGestioneCorsiFrame().getCorsi()));
						controller.getGestioneCorsiFrame().getCorsiTable().setModel(controller.getGestioneCorsiFrame().getCorsiDTM());

						controller.getAggiungiCorsoFrame().setVisible(false);

						controller.getAggiungiAreaTematicaFrame().setVisible(false);
						
						resettaAggiungiCorsoFrame();
					}}}
		});
		
		confermaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_confermaButton = new GridBagConstraints();
		gbc_confermaButton.insets = new Insets(0, 0, 5, 5);
		gbc_confermaButton.gridx = 5;
		gbc_confermaButton.gridy = 11;
		contentPane.add(confermaButton, gbc_confermaButton);

	}
	
	
	//METODO RESETTA AGGIUNGI CORSO FRAME
	public void resettaAggiungiCorsoFrame() {
		nomeTF.setText("");
		descrizioneTF.setText("");
		numeroMassimoPartecipantiTF.setText("");
		numeroDiLezioniTF.setText("");
		dataDiInizioTF.setText("");
		categorieTable.clearSelection();
		responsabiliCB.setSelectedItem(responsabiliCB.getItemAt(0));
	}

	
	
}
