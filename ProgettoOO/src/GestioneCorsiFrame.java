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
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestioneCorsiFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTable corsiTable;
	private Vector<Vector<String>> corsi;
	private DefaultTableModel corsiDTM;
	private JRadioButton codiceCorsoRadioButton;
	private JRadioButton nomeRadioButton;
	private JRadioButton dataRadioButton;
	private JTable categorieTable;
	private DefaultTableModel categorieDTM;
	private Vector<Vector<String>> categorie;
	private JScrollPane corsiTableScrollPane;
	private JScrollPane categorieTableScrollPane;
	private String nome="";
	private String data="";
	private String parolaChiave="";
	private String categorieSelezionate="";
	private int numeroCategorieSelezionate;

	//GETTERS AND SETTERS
	public DefaultTableModel getCorsiDTM() {
		return corsiDTM;
	}

	public void setCorsiDTM(DefaultTableModel corsiDTM) {
		this.corsiDTM = corsiDTM;
	}

	public JTable getCorsiTable() {
		return corsiTable;
	}

	public Vector<Vector<String>> getCorsi() {
		return corsi;
	}

	public void setCorsi(Vector<Vector<String>> corsi) {
		this.corsi = corsi;
	}

	public JTable getCategorieTable() {
		return categorieTable;
	}

	public void setCategorieTable(JTable categorieTable) {
		this.categorieTable = categorieTable;
	}

	public DefaultTableModel getCategorieDTM() {
		return categorieDTM;
	}

	public void setCategorieDTM(DefaultTableModel categorieDTM) {
		this.categorieDTM = categorieDTM;
	}

	public Vector<Vector<String>> getCategorie() {
		return categorie;
	}

	public void setCategorie(Vector<Vector<String>> categorie) {
		this.categorie = categorie;
	}

	
	
	public GestioneCorsiFrame(Controller mainController){
		
		controller = mainController;
		
		setTitle("Gestione Corsi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(35, 50, 1300, 495);
		
		
		//CONTENT PANE
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);	
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 156, 0, 0, 0, 0, 0, 76, 18, 110, 130, 44, 114, 100, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 23, 0, 19, 33, 26, 0, 0, 27, 27, 26, 11, 0, 9};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		
		//GESTIONE CORSI LABEL
		JLabel gestioneCorsiLabel = new JLabel("Gestione Corsi");
		gestioneCorsiLabel.setFont(new Font("Century", Font.BOLD, 25));
		GridBagConstraints gbc_gestioneCorsiLabel = new GridBagConstraints();
		gbc_gestioneCorsiLabel.anchor = GridBagConstraints.EAST;
		gbc_gestioneCorsiLabel.insets = new Insets(0, 0, 5, 5);
		gbc_gestioneCorsiLabel.gridx = 1;
		gbc_gestioneCorsiLabel.gridy = 0;
		contentPane.add(gestioneCorsiLabel, gbc_gestioneCorsiLabel);
		
		
		//NOME LABEL
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.anchor = GridBagConstraints.EAST;
		gbc_nomeLabel.gridx = 1;
		gbc_nomeLabel.gridy = 1;
		contentPane.add(nomeLabel, gbc_nomeLabel);
		
		
		//NOME TEXT FIELD
		JTextField nomeTF = new JTextField();
		nomeTF.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeTF = new GridBagConstraints();
		gbc_nomeTF.gridwidth = 3;
		gbc_nomeTF.insets = new Insets(0, 0, 5, 5);
		gbc_nomeTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeTF.gridx = 2;
		gbc_nomeTF.gridy = 1;
		contentPane.add(nomeTF, gbc_nomeTF);
		nomeTF.setColumns(10);
		
		
		//CLEAR NOME BUTTON
		JButton clearNomeButton = new JButton("X");
		clearNomeButton.setToolTipText("Premere per cancellare il testo");
		
		//CLEAR NOME BUTTON ACTION LISTENER
		clearNomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nomeTF.setText("");
			}
		});
		
		clearNomeButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_clearNomeButton = new GridBagConstraints();
		gbc_clearNomeButton.insets = new Insets(0, 0, 5, 5);
		gbc_clearNomeButton.gridx = 5;
		gbc_clearNomeButton.gridy = 1;
		contentPane.add(clearNomeButton, gbc_clearNomeButton);
		
		
		//CATEGORIA LABEL
		JLabel categoriaLabel = new JLabel("Categoria");
		categoriaLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_categoriaLabel = new GridBagConstraints();
		gbc_categoriaLabel.anchor = GridBagConstraints.EAST;
		gbc_categoriaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_categoriaLabel.gridx = 8;
		gbc_categoriaLabel.gridy = 1;
		contentPane.add(categoriaLabel, gbc_categoriaLabel);
		
		
		//CATEGORIE TABLE SCROLL PANE
		categorieTableScrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.gridheight = 4;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 9;
		gbc_scrollPane_1.gridy = 1;
		contentPane.add(categorieTableScrollPane, gbc_scrollPane_1);
		
		
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
		categorieTable.setFont(new Font("Century", Font.PLAIN, 16));
		categorieTable.setModel(categorieDTM);
		categorieTableScrollPane.setViewportView(categorieTable);
		
		
		//DATA LABEL
		JLabel dataLabel = new JLabel("Data");
		dataLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_dataLabel = new GridBagConstraints();
		gbc_dataLabel.anchor = GridBagConstraints.EAST;
		gbc_dataLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dataLabel.gridx = 1;
		gbc_dataLabel.gridy = 2;
		contentPane.add(dataLabel, gbc_dataLabel);
		
		
		//DATA TEXT FIELD
		JTextField dataTF = new JTextField();
		dataTF.setToolTipText("YYYY-MM-DD");
		dataTF.setFont(new Font("Century", Font.PLAIN, 16));
		dataTF.setColumns(10);
		GridBagConstraints gbc_dataTF = new GridBagConstraints();
		gbc_dataTF.gridwidth = 3;
		gbc_dataTF.insets = new Insets(0, 0, 5, 5);
		gbc_dataTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_dataTF.gridx = 2;
		gbc_dataTF.gridy = 2;
		contentPane.add(dataTF, gbc_dataTF);
		
		
		//CLEAR DATA BUTTON
		JButton clearDataButton = new JButton("X");
		clearDataButton.setToolTipText("Premere per cancellare il testo");
		
		//CLEAR DATA BUTTON ACTION LISTENER
		clearDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataTF.setText("");
			}
		});
		
		clearDataButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_clearDataButton = new GridBagConstraints();
		gbc_clearDataButton.insets = new Insets(0, 0, 5, 5);
		gbc_clearDataButton.gridx = 5;
		gbc_clearDataButton.gridy = 2;
		contentPane.add(clearDataButton, gbc_clearDataButton);
		
		
		//PAROLA CHIAVE LABEL
		JLabel parolaChiaveLabel = new JLabel("Parola Chiave");
		parolaChiaveLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_parolaChiaveLabel = new GridBagConstraints();
		gbc_parolaChiaveLabel.anchor = GridBagConstraints.EAST;
		gbc_parolaChiaveLabel.insets = new Insets(0, 0, 5, 5);
		gbc_parolaChiaveLabel.gridx = 1;
		gbc_parolaChiaveLabel.gridy = 3;
		contentPane.add(parolaChiaveLabel, gbc_parolaChiaveLabel);
		
		
		//PAROLA CHIAVE TEXT FIELD
		JTextField parolaChiaveTF = new JTextField();
		parolaChiaveTF.setFont(new Font("Century", Font.PLAIN, 16));
		parolaChiaveTF.setColumns(10);
		GridBagConstraints gbc_parolaChiaveTF = new GridBagConstraints();
		gbc_parolaChiaveTF.gridwidth = 3;
		gbc_parolaChiaveTF.insets = new Insets(0, 0, 5, 5);
		gbc_parolaChiaveTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_parolaChiaveTF.gridx = 2;
		gbc_parolaChiaveTF.gridy = 3;
		contentPane.add(parolaChiaveTF, gbc_parolaChiaveTF);
	
		
		//CERCA BUTTON
		JButton cercaButton = new JButton("Cerca");
		
		//CERCA BUTTON ACTION LISTENER
		cercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				codiceCorsoRadioButton.setSelected(true);
				nomeRadioButton.setSelected(false);
				dataRadioButton.setSelected(false);
				
				categorieSelezionate="";
				nome=nomeTF.getText().toUpperCase();
				data=dataTF.getText();
				parolaChiave=parolaChiaveTF.getText().toUpperCase();
				
				corsiDTM.getDataVector().removeAllElements();
				
				if(categorieTable.getSelectedRow()>-1) {
					for (int indiceCategoria : categorieTable.getSelectedRows()) {
						categorieSelezionate = categorieSelezionate +","+categorieTable.getValueAt(indiceCategoria, 0).toString();
					}
					
					categorieSelezionate= categorieSelezionate.substring(1);
					numeroCategorieSelezionate=categorieTable.getSelectedRows().length;
					
					if(categorieTable.getSelectedRows().length==1) {						
						corsi=controller.recuperaCorsiPerUnaCategoriaOrdinatiPer("codicecorso", categorieSelezionate, nome, data, parolaChiave);
					}
					else {
						corsi=controller.recuperaCorsiPerCategorieOrdinatiPer("codiceCorso",categorieSelezionate,nome,data,parolaChiave);
					}		
				}
				else {			
					corsi=controller.recuperaCorsiOrdinatiPer("codicecorso",nome,data,parolaChiave);
				}
				
				corsiDTM=controller.setDefaultTableModel(corsiDTM,corsi);
				corsiDTM.fireTableDataChanged();
				corsiTable.setModel(corsiDTM);
				categorieTable.clearSelection();
			}
		});
		
		cercaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_cercaButton = new GridBagConstraints();
		gbc_cercaButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_cercaButton.insets = new Insets(0, 0, 5, 5);
		gbc_cercaButton.gridx = 12;
		gbc_cercaButton.gridy = 1;
		contentPane.add(cercaButton, gbc_cercaButton);
		
		
		//CLEAR PAROLA CHIAVE BUTTON
		JButton clearParolaChiaveButton = new JButton("X");
		clearParolaChiaveButton.setToolTipText("Premere per cancellare il testo");
		
		//CLEAR PAROLA CHIAVE BUTTON ACTION LISTENER
		clearParolaChiaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				parolaChiaveTF.setText("");
			}
		});
		
		clearParolaChiaveButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_clearParolaChiaveButton = new GridBagConstraints();
		gbc_clearParolaChiaveButton.insets = new Insets(0, 0, 5, 5);
		gbc_clearParolaChiaveButton.gridx = 5;
		gbc_clearParolaChiaveButton.gridy = 3;
		contentPane.add(clearParolaChiaveButton, gbc_clearParolaChiaveButton);
		
		
		//ORDINA PER LABEL
		JLabel ordinaPerLabel = new JLabel("Ordina per");
		ordinaPerLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_ordinaPerLabel = new GridBagConstraints();
		gbc_ordinaPerLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ordinaPerLabel.gridx = 1;
		gbc_ordinaPerLabel.gridy = 5;
		contentPane.add(ordinaPerLabel, gbc_ordinaPerLabel);
		
		
		//CODICE CORSO RADIO BUTTON
		codiceCorsoRadioButton = new JRadioButton("Codice Corso");
		codiceCorsoRadioButton.setSelected(true);
		
		//CODICE CORSO RADIO BUTTON ACTION LISTENER
		codiceCorsoRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(codiceCorsoRadioButton.isSelected()) {
					corsiTableScrollPane.getVerticalScrollBar().setValue(corsiTableScrollPane.getVerticalScrollBar().getMinimum());
					corsiDTM.getDataVector().removeAllElements();
					
					if(categorieSelezionate.isEmpty()==false) {		
						if(numeroCategorieSelezionate==1) {
							corsi=controller.recuperaCorsiPerUnaCategoriaOrdinatiPer("codicecorso", categorieSelezionate, nome, data, parolaChiave);
						}
						else {
							corsi=controller.recuperaCorsiPerCategorieOrdinatiPer("codiceCorso",categorieSelezionate,nome,data,parolaChiave);
						}
					}
					else {
						corsi=controller.recuperaCorsiOrdinatiPer("codicecorso",nome,data,parolaChiave);
					}
					
					corsiDTM=controller.setDefaultTableModel(corsiDTM,corsi);
					corsiDTM.fireTableDataChanged();
					corsiTable.setModel(corsiDTM);
					
					nomeRadioButton.setSelected(false);
					dataRadioButton.setSelected(false);
				}
				else {
					codiceCorsoRadioButton.setSelected(true);
				}
			}
		});
		
		codiceCorsoRadioButton.setFont(new Font("Century", Font.PLAIN, 16));
		codiceCorsoRadioButton.setBackground(new Color(30, 144, 255));
		GridBagConstraints gbc_codiceCorsoRadioButton = new GridBagConstraints();
		gbc_codiceCorsoRadioButton.anchor = GridBagConstraints.WEST;
		gbc_codiceCorsoRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_codiceCorsoRadioButton.gridx = 2;
		gbc_codiceCorsoRadioButton.gridy = 5;
		contentPane.add(codiceCorsoRadioButton, gbc_codiceCorsoRadioButton);
		
		
		//NOME RADIO BUTTON
		nomeRadioButton = new JRadioButton("Nome");
		
		//NOME RADIO BUTTON ACTION LISTENER
		nomeRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(nomeRadioButton.isSelected()) {
					corsiTableScrollPane.getVerticalScrollBar().setValue(corsiTableScrollPane.getVerticalScrollBar().getMinimum());
					corsiDTM.getDataVector().removeAllElements();
					
					if(categorieSelezionate.isEmpty()==false) {		
						if(numeroCategorieSelezionate==1) {
							corsi=controller.recuperaCorsiPerUnaCategoriaOrdinatiPer("nome", categorieSelezionate, nome, data, parolaChiave);
						}
						else {
							corsi=controller.recuperaCorsiPerCategorieOrdinatiPer("nome",categorieSelezionate,nome,data,parolaChiave);
						}
					}
					else {
						corsi=controller.recuperaCorsiOrdinatiPer("nome",nome,data,parolaChiave);
					}
					
					corsiDTM=controller.setDefaultTableModel(corsiDTM,corsi);
					corsiDTM.fireTableDataChanged();
					corsiTable.setModel(corsiDTM);
					
					codiceCorsoRadioButton.setSelected(false);
					dataRadioButton.setSelected(false);
				}
				else {
					nomeRadioButton.setSelected(true);
				}
			}
		});
		
		nomeRadioButton.setBackground(new Color(30, 144, 255));
		nomeRadioButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeRadioButton = new GridBagConstraints();
		gbc_nomeRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_nomeRadioButton.gridx = 3;
		gbc_nomeRadioButton.gridy = 5;
		contentPane.add(nomeRadioButton, gbc_nomeRadioButton);
		
		
		//DATA RADIO BUTTON
		dataRadioButton = new JRadioButton("Data");
		
		//DATA RADIO BUTTON ACTION LISTENER
		dataRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(dataRadioButton.isSelected()) {
					corsiTableScrollPane.getVerticalScrollBar().setValue(corsiTableScrollPane.getVerticalScrollBar().getMinimum());
					corsiDTM.getDataVector().removeAllElements();
					
					if(categorieSelezionate.isEmpty()==false) {		
						if(numeroCategorieSelezionate==1) {
							corsi=controller.recuperaCorsiPerUnaCategoriaOrdinatiPer("datainizio", categorieSelezionate, nome, data, parolaChiave);
						}
						else {
							corsi=controller.recuperaCorsiPerCategorieOrdinatiPer("datainizio",categorieSelezionate,nome,data,parolaChiave);
						}
					}
					else {
						corsi=controller.recuperaCorsiOrdinatiPer("datainizio",nome,data,parolaChiave);
					}
					
					corsiDTM=controller.setDefaultTableModel(corsiDTM,corsi);
					corsiDTM.fireTableDataChanged();
					corsiTable.setModel(corsiDTM);
					
					nomeRadioButton.setSelected(false);
					codiceCorsoRadioButton.setSelected(false);
				}
				else {
					dataRadioButton.setSelected(true);
				}
			}
		});
		
		dataRadioButton.setFont(new Font("Century", Font.PLAIN, 16));
		dataRadioButton.setBackground(new Color(30, 144, 255));
		GridBagConstraints gbc_dataRadioButton = new GridBagConstraints();
		gbc_dataRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_dataRadioButton.gridx = 4;
		gbc_dataRadioButton.gridy = 5;
		contentPane.add(dataRadioButton, gbc_dataRadioButton);
		
		
		//CORSI TABLE SCROLL PANE
		corsiTableScrollPane = new JScrollPane();
		corsiTableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.gridwidth = 13;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 6;
		contentPane.add(corsiTableScrollPane, gbc_scrollPane);
		
		//CORSI DEFAULT TABLE MODEL
		corsiDTM = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		};
		corsiDTM.addColumn("Codice");
		corsiDTM.addColumn("Nome");
		corsiDTM.addColumn("Descrizione");
		corsiDTM.addColumn("Data");
		corsiDTM.addColumn("Categoria");
		corsiDTM.addColumn("Responsabile");
		corsi=controller.recuperaCorsiOrdinatiPer("codicecorso", nome, data, parolaChiave);
		corsiDTM=controller.setDefaultTableModel(corsiDTM,corsi);
		
		//CORSI TABLE
		corsiTable = new JTable();
		
		//CORSI TABLE MOUSE LISTENER
		corsiTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(controller.getAggiungiCorsoFrame().isVisible() || controller.getModificaCorsoFrame().isVisible() || controller.getLezioniFrame().isVisible() ||controller.getStatisticheFrame().isVisible()) {
					corsiTable.setEnabled(false);
				}
				else {
					corsiTable.setEnabled(true);
				}
			}
		});
		
		corsiTable.setModel(corsiDTM);
		corsiTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		corsiTable.getColumnModel().getColumn(0).setResizable(false);
		corsiTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		
		corsiTable.getColumnModel().getColumn(1).setResizable(false);
		corsiTable.getColumnModel().getColumn(1).setPreferredWidth(165);
		
		corsiTable.getColumnModel().getColumn(2).setResizable(false);
		corsiTable.getColumnModel().getColumn(2).setPreferredWidth(310);
		
		corsiTable.getColumnModel().getColumn(3).setResizable(false);
		
		corsiTable.getColumnModel().getColumn(4).setResizable(false);
		corsiTable.getColumnModel().getColumn(4).setPreferredWidth(160);
		
		corsiTable.getColumnModel().getColumn(5).setResizable(false);
		corsiTable.getColumnModel().getColumn(5).setPreferredWidth(120);
		
		corsiTable.setFont(new Font("Century", Font.PLAIN, 15));
		corsiTableScrollPane.setViewportView(corsiTable);

		
		//AGGIUNGI BUTTON
		JButton AggiungiButton = new JButton("Aggiungi");
		
		//AGGIUNGI BUTTON ACTION LISTENER
		AggiungiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				corsiTable.clearSelection();
				controller.getAggiungiCorsoFrame().setVisible(true);
				controller.getAggiungiCorsoFrame().setAlwaysOnTop(true);
				corsiTable.setEnabled(false);
			}
		});
		
		AggiungiButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_AggiungiButton = new GridBagConstraints();
		gbc_AggiungiButton.anchor = GridBagConstraints.WEST;
		gbc_AggiungiButton.insets = new Insets(0, 0, 5, 0);
		gbc_AggiungiButton.gridx = 14;
		gbc_AggiungiButton.gridy = 6;
		contentPane.add(AggiungiButton, gbc_AggiungiButton);
		
		
		//MODIFICA BUTTON
		JButton ModificaButton = new JButton("Modifica");
		
		//MODIFICA BUTTON ACTION LISTENER
		ModificaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(corsiTable.getSelectedRow()==-1||corsiTable.getSelectedRow()>corsiTable.getRowCount()) {
					JOptionPane.showMessageDialog(contentPane,"Selezionare un corso","",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					controller.getModificaFrame().setVisible(true);
					controller.getModificaFrame().setAlwaysOnTop(true);
					controller.getModificaFrame().getNomeTF().setText(corsiTable.getValueAt(corsiTable.getSelectedRow(),1).toString().toLowerCase());
					controller.getModificaFrame().getDescrizioneTF().setText(corsiTable.getValueAt(corsiTable.getSelectedRow(),2).toString().toLowerCase());
					controller.getModificaFrame().getDataTF().setText(corsiTable.getValueAt(corsiTable.getSelectedRow(),3).toString());
					controller.getModificaFrame().getCategoriaCB().setSelectedItem(corsiTable.getValueAt(corsiTable.getSelectedRow(),4));
					controller.getModificaFrame().getResponsabileCB().setSelectedItem(corsiTable.getValueAt(corsiTable.getSelectedRow(),5));
				}
			}			
		});
		
		ModificaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_ModificaButton = new GridBagConstraints();
		gbc_ModificaButton.anchor = GridBagConstraints.WEST;
		gbc_ModificaButton.insets = new Insets(0, 0, 5, 0);
		gbc_ModificaButton.gridx = 14;
		gbc_ModificaButton.gridy = 7;
		contentPane.add(ModificaButton, gbc_ModificaButton);
		
		
		//ELIMINA BUTTON
		JButton EliminaButton = new JButton("Elimina");
		
		//ELIMINA BUTTON ACTION LISTENER
		EliminaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(corsiTable.getSelectedRow()==-1||corsiTable.getSelectedRow()>corsiTable.getRowCount()) {
					JOptionPane.showMessageDialog(contentPane,"Selezionare un corso","",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
				
					String codiceCorsoSelezionato = corsiTable.getValueAt(corsiTable.getSelectedRow(),0).toString();
					
					controller.eliminaCorsoSelezionato(codiceCorsoSelezionato);
					corsiTable.clearSelection();
					corsiDTM.getDataVector().removeAllElements();
					corsi=controller.recuperaCorsiOrdinatiPer("codicecorso", nome, data, parolaChiave);
					corsiDTM=controller.setDefaultTableModel(corsiDTM,corsi);
					corsiTable.setModel(corsiDTM);
				}
			}
		});
		
		EliminaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_EliminaButton = new GridBagConstraints();
		gbc_EliminaButton.insets = new Insets(0, 0, 5, 0);
		gbc_EliminaButton.anchor = GridBagConstraints.WEST;
		gbc_EliminaButton.gridx = 14;
		gbc_EliminaButton.gridy = 8;
		contentPane.add(EliminaButton, gbc_EliminaButton);
		
		
		//LEZIONI BUTTON
		JButton LezioniButton = new JButton("Lezioni");
		LezioniButton.setFont(new Font("Century", Font.PLAIN, 16));
		
		//LEZIONI BUTTON ACTION LISTENER
		LezioniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(corsiTable.getSelectedRow()<=-1||corsiTable.getSelectedRow()>corsiTable.getRowCount()) {
					JOptionPane.showMessageDialog(contentPane,"Selezionare un corso","",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					controller.getLezioniFrame().setVisible(true);										
					controller.getLezioniFrame().setAlwaysOnTop(true);
					controller.getLezioniFrame().getLezioniDTM().getDataVector().removeAllElements();
					controller.getLezioniFrame().getNomeCorsoLabel().setText(corsiTable.getValueAt(corsiTable.getSelectedRow(), 1).toString());
					controller.getLezioniFrame().setListaLezioni(controller.recuperaLezioni(corsiTable.getValueAt(corsiTable.getSelectedRow(), 0).toString()));
					controller.setDefaultTableModel(controller.getLezioniFrame().getLezioniDTM(), controller.getLezioniFrame().getListaLezioni());
					controller.getLezioniFrame().getLezioniTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					controller.getLezioniFrame().getLezioniDTM().fireTableDataChanged();
				}
		}});
		
		GridBagConstraints gbc_LezioniButton = new GridBagConstraints();
		gbc_LezioniButton.anchor = GridBagConstraints.WEST;
		gbc_LezioniButton.insets = new Insets(0, 0, 5, 0);
		gbc_LezioniButton.gridx = 14;
		gbc_LezioniButton.gridy = 9;
		contentPane.add(LezioniButton, gbc_LezioniButton);
		
		
		//STATISTICHE BUTTON
		JButton StatisticheButton = new JButton("Statistische");
		
		//STATISTICHE BUTTON ACTION LISTENER
		StatisticheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(corsiTable.getSelectedRow()<=-1||corsiTable.getSelectedRow()>corsiTable.getRowCount()) {
					JOptionPane.showMessageDialog(contentPane,"Selezionare un corso","",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					controller.getStatisticheFrame().setVisible(true);
					controller.getStatisticheFrame().getNomeCorsoTF().setText(corsiTable.getValueAt(corsiTable.getSelectedRow(),1).toString());
					controller.getStatisticheFrame().getPresenzeMinimeTF().setText(controller.calcolaPresenzeMinime(corsiTable.getValueAt(corsiTable.getSelectedRow(),0).toString()));
					controller.getStatisticheFrame().getPresenzeMassimeTF().setText(controller.calcolaPresenzeMassime(corsiTable.getValueAt(corsiTable.getSelectedRow(),0).toString()));
					controller.getStatisticheFrame().getFrequenzaMediaTF().setText(controller.calcolaFrequenzaMedia(corsiTable.getValueAt(corsiTable.getSelectedRow(),0).toString()));
					controller.getStatisticheFrame().getFrequenzaMediaInPercentualeTF().setText(controller.calcolaPercentualeRiempimentoMedia(corsiTable.getValueAt(corsiTable.getSelectedRow(),0).toString())+"%");					
					controller.getStatisticheFrame().getIscrittiDTM().getDataVector().removeAllElements();
					controller.getStatisticheFrame().setIscritti(controller.recuperaIscrittiAdUnCorso(corsiTable.getValueAt(corsiTable.getSelectedRow(), 0).toString()));
					controller.getStatisticheFrame().setIscrittiDTM(controller.setDefaultTableModel(controller.getStatisticheFrame().getIscrittiDTM(), controller.getStatisticheFrame().getIscritti()));
					controller.getStatisticheFrame().getIscrittiDTM().fireTableDataChanged();
					controller.getStatisticheFrame().getIscrittiTable().setModel(controller.getStatisticheFrame().getIscrittiDTM());
				}
			}
		});
		
		StatisticheButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_StatisticheButton = new GridBagConstraints();
		gbc_StatisticheButton.insets = new Insets(0, 0, 5, 0);
		gbc_StatisticheButton.anchor = GridBagConstraints.WEST;
		gbc_StatisticheButton.gridx = 14;
		gbc_StatisticheButton.gridy = 10;
		contentPane.add(StatisticheButton, gbc_StatisticheButton);
		
		
		//TORNA HOME BUTTON
		JButton tornaHomeButton = new JButton("Torna alla HomePage");
		tornaHomeButton.setFont(new Font("Century", Font.PLAIN, 16));
		
		//TORNA HOME BUTTON ACTION LISTENER
		tornaHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.getHomeFrame().setVisible(true);
				controller.getGestioneCorsiFrame().setVisible(false);
				
				nomeTF.setText("");
				dataTF.setText("");
				parolaChiaveTF.setText("");
				
				categorieTable.clearSelection();
				corsiTable.clearSelection();
			}
		});
		
		GridBagConstraints gbc_tornaHomeButton = new GridBagConstraints();
		gbc_tornaHomeButton.insets = new Insets(0, 0, 5, 5);
		gbc_tornaHomeButton.gridx = 1;
		gbc_tornaHomeButton.gridy = 12;
		contentPane.add(tornaHomeButton, gbc_tornaHomeButton);
	
	}
	
	

}

