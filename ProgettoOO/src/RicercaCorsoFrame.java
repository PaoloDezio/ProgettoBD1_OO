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
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Choice;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JList;

public class RicercaCorsoFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTable corsiTable;
	private Vector<Vector<String>> corsi;
	private DefaultTableModel corsiDTM;
	private JRadioButton codiceCorsoRadioButton;
	private JRadioButton nomeRadioButton;
	private JRadioButton dataRadioButton;
	private JComboBox campoCB;
	private JTable categorieTable;
	private DefaultTableModel categorieDTM;
	private Vector<Vector<String>> categorie;

	
	public JComboBox getCampoCB() {
		return campoCB;
	}

	public DefaultTableModel getCorsiDTM() {
		return corsiDTM;
	}

	public JTable getCorsiTable() {
		return corsiTable;
	}

	public Vector<Vector<String>> getCorsi() {
		return corsi;
	}

	public RicercaCorsoFrame(Controller c){
		setName("");
		
		controller = c;
		
		setTitle("Gestione Corsi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(35, 50, 1301, 470);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 156, 0, 0, 0, 76, 18, 110, 130, 73, 114, 100, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 23, 0, 19, 0, 26, 0, 0, 0, 0, 26, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel gestioneCorsiLabel = new JLabel("Gestione Corsi");
		gestioneCorsiLabel.setFont(new Font("Century", Font.BOLD, 25));
		GridBagConstraints gbc_gestioneCorsiLabel = new GridBagConstraints();
		gbc_gestioneCorsiLabel.anchor = GridBagConstraints.EAST;
		gbc_gestioneCorsiLabel.insets = new Insets(0, 0, 5, 5);
		gbc_gestioneCorsiLabel.gridx = 1;
		gbc_gestioneCorsiLabel.gridy = 0;
		contentPane.add(gestioneCorsiLabel, gbc_gestioneCorsiLabel);
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.anchor = GridBagConstraints.EAST;
		gbc_nomeLabel.gridx = 1;
		gbc_nomeLabel.gridy = 1;
		contentPane.add(nomeLabel, gbc_nomeLabel);
		
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
		
		JLabel categoriaLabel = new JLabel("Categoria");
		categoriaLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_categoriaLabel = new GridBagConstraints();
		gbc_categoriaLabel.anchor = GridBagConstraints.EAST;
		gbc_categoriaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_categoriaLabel.gridx = 6;
		gbc_categoriaLabel.gridy = 1;
		contentPane.add(categoriaLabel, gbc_categoriaLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.gridheight = 3;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 7;
		gbc_scrollPane_1.gridy = 1;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		
		JLabel dataLabel = new JLabel("Data");
		dataLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_dataLabel = new GridBagConstraints();
		gbc_dataLabel.anchor = GridBagConstraints.EAST;
		gbc_dataLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dataLabel.gridx = 1;
		gbc_dataLabel.gridy = 2;
		contentPane.add(dataLabel, gbc_dataLabel);
		
		JTextField dataTF = new JTextField();
		dataTF.setFont(new Font("Century", Font.PLAIN, 16));
		dataTF.setColumns(10);
		GridBagConstraints gbc_dataTF = new GridBagConstraints();
		gbc_dataTF.gridwidth = 3;
		gbc_dataTF.insets = new Insets(0, 0, 5, 5);
		gbc_dataTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_dataTF.gridx = 2;
		gbc_dataTF.gridy = 2;
		contentPane.add(dataTF, gbc_dataTF);
		
		JLabel parolaChiaveLabel = new JLabel("Parola Chiave");
		parolaChiaveLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_parolaChiaveLabel = new GridBagConstraints();
		gbc_parolaChiaveLabel.anchor = GridBagConstraints.EAST;
		gbc_parolaChiaveLabel.insets = new Insets(0, 0, 5, 5);
		gbc_parolaChiaveLabel.gridx = 1;
		gbc_parolaChiaveLabel.gridy = 3;
		contentPane.add(parolaChiaveLabel, gbc_parolaChiaveLabel);
		
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
	
		JLabel ordinaPerLabel = new JLabel("Ordina per");
		ordinaPerLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_ordinaPerLabel = new GridBagConstraints();
		gbc_ordinaPerLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ordinaPerLabel.gridx = 1;
		gbc_ordinaPerLabel.gridy = 5;
		contentPane.add(ordinaPerLabel, gbc_ordinaPerLabel);
		
		codiceCorsoRadioButton = new JRadioButton("Codice Corso");
		codiceCorsoRadioButton.setSelected(true);
		codiceCorsoRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(codiceCorsoRadioButton.isSelected()) {	
					corsiDTM.getDataVector().removeAllElements();
					corsi=controller.recuperaCorsiOrdinatiPerCodiceCorso();
					for (Vector<String> vettore : corsi) {
						corsiDTM.addRow(vettore);
					}
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
		
		nomeRadioButton = new JRadioButton("Nome");
		nomeRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nomeRadioButton.isSelected()) {
					corsiDTM.getDataVector().removeAllElements();
					corsi=controller.recuperaCorsiOrdinatiPerNome();
					for (Vector<String> vettore : corsi) {
						corsiDTM.addRow(vettore);
					}
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
		
		dataRadioButton = new JRadioButton("Data");
		dataRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dataRadioButton.isSelected()) {
					corsiDTM.getDataVector().removeAllElements();
					corsi=controller.recuperaCorsiOrdinatiPerData();
					for (Vector<String> vettore : corsi) {
						corsiDTM.addRow(vettore);
					}
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
		
		

		categorieDTM = new DefaultTableModel();
		categorieDTM.addColumn("Categoria");

		categorie=controller.recuperaAreeTematiche2(controller.contaCategorie());
		categorieDTM=setDefaultTableModel(categorieDTM,categorie);
		
		categorieTable = new JTable();
		categorieTable.setFont(new Font("Century", Font.PLAIN, 16));
		categorieTable.setModel(categorieDTM);
		scrollPane_1.setViewportView(categorieTable);
		
		
		JButton cercaButton = new JButton("Cerca");
		cercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nomeTF.getText().isEmpty()==false||dataTF.getText().isEmpty()==false||parolaChiaveTF.getText().isEmpty()==false||categorieTable.getSelectedRow()==-1) {
					corsiDTM.getDataVector().removeAllElements();

					corsi=controller.ricercaCorsi(nomeTF.getText().toUpperCase(),dataTF.getText(), parolaChiaveTF.getText().toUpperCase());
					corsiDTM=setDefaultTableModel(corsiDTM,corsi);

					corsiTable.setModel(corsiDTM);
					
				}

			}
		});
		cercaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_cercaButton = new GridBagConstraints();
		gbc_cercaButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_cercaButton.insets = new Insets(0, 0, 5, 5);
		gbc_cercaButton.gridx = 10;
		gbc_cercaButton.gridy = 1;
		contentPane.add(cercaButton, gbc_cercaButton);
		
		
		JScrollPane tableCorsiScrollPane = new JScrollPane();
		tableCorsiScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 11;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 6;
		contentPane.add(tableCorsiScrollPane, gbc_scrollPane);

		corsiDTM = new DefaultTableModel();
		corsiDTM.addColumn("Codice");
		corsiDTM.addColumn("Nome");
		corsiDTM.addColumn("Descrizione");
		corsiDTM.addColumn("Data");
		corsiDTM.addColumn("Categoria");
		corsiDTM.addColumn("Responsabile");
		corsi=controller.recuperaCorsi();
		corsiDTM=setDefaultTableModel(corsiDTM,corsi);
		
		corsiTable = new JTable();
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
		tableCorsiScrollPane.setViewportView(corsiTable);

		JButton AggiungiButton = new JButton("Aggiungi");
		AggiungiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getAggiungiCorsoFrame().setVisible(true);
			}
		});
		AggiungiButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_AggiungiButton = new GridBagConstraints();
		gbc_AggiungiButton.anchor = GridBagConstraints.WEST;
		gbc_AggiungiButton.insets = new Insets(0, 0, 5, 0);
		gbc_AggiungiButton.gridx = 12;
		gbc_AggiungiButton.gridy = 6;
		contentPane.add(AggiungiButton, gbc_AggiungiButton);

		JButton ModificaButton = new JButton("Modifica");
		ModificaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(corsiTable.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(contentPane,"Selezionare un corso","",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					controller.getModificaFrame().setVisible(true);
					controller.getModificaFrame().getNomeTF().setText(corsiTable.getValueAt(corsiTable.getSelectedRow(),1).toString());
					controller.getModificaFrame().getDescrizioneTF().setText(corsiTable.getValueAt(corsiTable.getSelectedRow(),2).toString());
					controller.getModificaFrame().getDataTF().setText(corsiTable.getValueAt(corsiTable.getSelectedRow(),3).toString());
					controller.getModificaFrame().getCategoriaCB().setSelectedItem(c.getRicercaCorsoFrame().getCorsiTable().getValueAt(c.getRicercaCorsoFrame().getCorsiTable().getSelectedRow(),4));
					controller.getModificaFrame().getResponsabileCB().setSelectedItem(c.getRicercaCorsoFrame().getCorsiTable().getValueAt(c.getRicercaCorsoFrame().getCorsiTable().getSelectedRow(),5));
				}
			}			
		});
		ModificaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_ModificaButton = new GridBagConstraints();
		gbc_ModificaButton.anchor = GridBagConstraints.WEST;
		gbc_ModificaButton.insets = new Insets(0, 0, 5, 0);
		gbc_ModificaButton.gridx = 12;
		gbc_ModificaButton.gridy = 7;
		contentPane.add(ModificaButton, gbc_ModificaButton);

		JButton EliminaButton = new JButton("Elimina");
		EliminaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(corsiTable.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(contentPane,"Selezionare un corso","",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					Object codiceCorsoSelezionato;
					codiceCorsoSelezionato = corsiTable.getValueAt(corsiTable.getSelectedRow(),0);
					controller.eliminaCorsoSelezionato(codiceCorsoSelezionato);
					corsiDTM.getDataVector().removeAllElements();
					corsiTable.setModel(setDefaultTableModel(corsiDTM,corsi));
				}
			}
		});
		EliminaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_EliminaButton = new GridBagConstraints();
		gbc_EliminaButton.insets = new Insets(0, 0, 5, 0);
		gbc_EliminaButton.anchor = GridBagConstraints.WEST;
		gbc_EliminaButton.gridx = 12;
		gbc_EliminaButton.gridy = 8;
		contentPane.add(EliminaButton, gbc_EliminaButton);
		
		JButton StatisticheButton = new JButton("Statistische");
		StatisticheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(corsiTable.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(contentPane,"Selezionare un corso","",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					controller.getStatisticheFrame().setVisible(true);
					controller.getStatisticheFrame().getCorsoTF().setText(corsiTable.getValueAt(corsiTable.getSelectedRow(),1).toString());
					controller.getStatisticheFrame().getPresenzeMinimeTF().setText("10");
					controller.getStatisticheFrame().getPresenzeMassimeTF().setText("45");
					controller.getStatisticheFrame().getFrequenzaMediaTF().setText("25");
					controller.getStatisticheFrame().getFrequenzaMediaInPercentualeTF().setText("10%");
				}
			}
		});
		StatisticheButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_StatisticheButton = new GridBagConstraints();
		gbc_StatisticheButton.insets = new Insets(0, 0, 5, 0);
		gbc_StatisticheButton.anchor = GridBagConstraints.WEST;
		gbc_StatisticheButton.gridx = 12;
		gbc_StatisticheButton.gridy = 9;
		contentPane.add(StatisticheButton, gbc_StatisticheButton);
		
		JButton tornaHomeButton = new JButton("Torna alla HomePage");
		tornaHomeButton.setFont(new Font("Century", Font.PLAIN, 16));
		tornaHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getHomeFrame().setVisible(true);
				controller.getRicercaCorsoFrame().setVisible(false);
				nomeTF.setText("");
				dataTF.setText("");
				parolaChiaveTF.setText("");
				categorieTable.clearSelection();
			}
		});
		GridBagConstraints gbc_tornaHomeButton = new GridBagConstraints();
		gbc_tornaHomeButton.insets = new Insets(0, 0, 5, 5);
		gbc_tornaHomeButton.gridx = 1;
		gbc_tornaHomeButton.gridy = 11;
		contentPane.add(tornaHomeButton, gbc_tornaHomeButton);
	
	}
	
	
	public DefaultTableModel setDefaultTableModel(DefaultTableModel defaultTableModel,Vector<Vector<String>> vector){
		for (Vector<String> vettore : vector) {
			defaultTableModel.addRow(vettore);
		}
		
		return defaultTableModel;
	}
	

}

