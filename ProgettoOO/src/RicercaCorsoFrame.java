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

public class RicercaCorsoFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JComboBox campoCB;
	private JTextField nomeTF;
	private JLabel nomeLabel;
	private JTextField campoTF;
	private JTable corsiTable;
	private Vector<Vector<String>> corsi;
	private DefaultTableModel corsiDTM;
	private JRadioButton codiceCorsoRadioButton;
	private JRadioButton nomeRadioButton;
	private JRadioButton dataRadioButton;
	
	
	public JComboBox getCampoCB() {
		return campoCB;
	}

	public DefaultTableModel getCorsiDTM() {
		return corsiDTM;
	}

	public JTable getCorsiTable() {
		return corsiTable;
	}


	public JTextField getCampoTF() {
		return campoTF;
	}

	public RicercaCorsoFrame(Controller c){
		
		controller = c;
		
		setTitle("Gestione Corsi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(35, 50, 1300, 635);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 156, 0, 0, 0, 0, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{21, 0, 0, 0, 0, 19, 0, 0, 0, 0, 40, 40, 26, 84, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel gestioneCorsiLabel = new JLabel("Gestione Corsi");
		gestioneCorsiLabel.setFont(new Font("Century", Font.PLAIN, 25));
		GridBagConstraints gbc_gestioneCorsiLabel = new GridBagConstraints();
		gbc_gestioneCorsiLabel.anchor = GridBagConstraints.WEST;
		gbc_gestioneCorsiLabel.insets = new Insets(0, 0, 5, 5);
		gbc_gestioneCorsiLabel.gridx = 1;
		gbc_gestioneCorsiLabel.gridy = 1;
		contentPane.add(gestioneCorsiLabel, gbc_gestioneCorsiLabel);

		String[] campi= {"Nome","Categoria","Data","Parola Chiave"};
		
		JLabel selezionareUnCampoLabel = new JLabel("Selezionare un campo");
		selezionareUnCampoLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_selezionareUnCampoLabel = new GridBagConstraints();
		gbc_selezionareUnCampoLabel.anchor = GridBagConstraints.EAST;
		gbc_selezionareUnCampoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_selezionareUnCampoLabel.gridx = 6;
		gbc_selezionareUnCampoLabel.gridy = 3;
		contentPane.add(selezionareUnCampoLabel, gbc_selezionareUnCampoLabel);
		
		campoCB = new JComboBox(campi);
		campoCB.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_campoCB = new GridBagConstraints();
		gbc_campoCB.gridwidth = 9;
		gbc_campoCB.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoCB.insets = new Insets(0, 0, 5, 5);
		gbc_campoCB.gridx = 7;
		gbc_campoCB.gridy = 3;
		contentPane.add(campoCB, gbc_campoCB);
		
		JLabel ricercareLabel = new JLabel("Ricercare");
		ricercareLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_ricercareLabel = new GridBagConstraints();
		gbc_ricercareLabel.anchor = GridBagConstraints.EAST;
		gbc_ricercareLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ricercareLabel.gridx = 6;
		gbc_ricercareLabel.gridy = 4;
		contentPane.add(ricercareLabel, gbc_ricercareLabel);
		
		campoTF = new JTextField();
		campoTF.setName("");
		campoTF.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_campoTF = new GridBagConstraints();
		gbc_campoTF.gridwidth = 9;
		gbc_campoTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoTF.insets = new Insets(0, 0, 5, 5);
		gbc_campoTF.gridx = 7;
		gbc_campoTF.gridy = 4;
		contentPane.add(campoTF, gbc_campoTF);
		campoTF.setColumns(10);
		
		JButton cercaButton = new JButton("Cerca");
		cercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				corsiDTM.getDataVector().removeAllElements();

				String campo = new String(campoCB.getSelectedItem().toString());
				switch(campo) {
				case "Nome":
					corsi=controller.ricercaCorsoPerNome(campoTF.getText().toUpperCase());
					for (Vector<String> vettore : corsi) {
						corsiDTM.addRow(vettore);
					}
					break;
				case "Categoria":
					corsi=controller.ricercaCorsoPerCategoria(campoTF.getText().toUpperCase());
					for (Vector<String> vettore : corsi) {
						corsiDTM.addRow(vettore);
					}
					break;
				case "Data":
					corsi=controller.ricercaCorsoPerData(campoTF.getText());
					for (Vector<String> vettore : corsi) {
						corsiDTM.addRow(vettore);
					}
					break;
				case "Parola Chiave":
					corsi=controller.ricercaCorsoPerParolaChiave(campoTF.getText().toUpperCase());
					for (Vector<String> vettore : corsi) {
						corsiDTM.addRow(vettore);
					}
					break;
				}	
			}
		});
		
		JButton tornaHomeButton = new JButton("Indietro");
		tornaHomeButton.setFont(new Font("Century", Font.PLAIN, 16));
		tornaHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getHomeFrame().setVisible(true);
				controller.getRicercaCorsoFrame().setVisible(false);
			}
		});
		GridBagConstraints gbc_tornaHomeButton = new GridBagConstraints();
		gbc_tornaHomeButton.anchor = GridBagConstraints.EAST;
		gbc_tornaHomeButton.insets = new Insets(0, 0, 5, 5);
		gbc_tornaHomeButton.gridx = 6;
		gbc_tornaHomeButton.gridy = 6;
		contentPane.add(tornaHomeButton, gbc_tornaHomeButton);
		cercaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_cercaButton = new GridBagConstraints();
		gbc_cercaButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_cercaButton.insets = new Insets(0, 0, 5, 5);
		gbc_cercaButton.gridx = 16;
		gbc_cercaButton.gridy = 6;
		contentPane.add(cercaButton, gbc_cercaButton);
		
		JLabel ordinaPerLabel = new JLabel("Ordina per");
		ordinaPerLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_ordinaPerLabel = new GridBagConstraints();
		gbc_ordinaPerLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ordinaPerLabel.gridx = 1;
		gbc_ordinaPerLabel.gridy = 8;
		contentPane.add(ordinaPerLabel, gbc_ordinaPerLabel);
		
		codiceCorsoRadioButton = new JRadioButton("Codice Corso");
		codiceCorsoRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				corsiDTM.getDataVector().removeAllElements();
				corsi=controller.recuperaCorsiOrdinatiPerCodiceCorso();
				for (Vector<String> vettore : corsi) {
					corsiDTM.addRow(vettore);
				}
				corsiTable.setModel(corsiDTM);				
				nomeRadioButton.setSelected(false);
				dataRadioButton.setSelected(false);
			}
		});
		codiceCorsoRadioButton.setFont(new Font("Century", Font.PLAIN, 16));
		codiceCorsoRadioButton.setBackground(new Color(30, 144, 255));
		GridBagConstraints gbc_codiceCorsoRadioButton = new GridBagConstraints();
		gbc_codiceCorsoRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_codiceCorsoRadioButton.gridx = 2;
		gbc_codiceCorsoRadioButton.gridy = 8;
		contentPane.add(codiceCorsoRadioButton, gbc_codiceCorsoRadioButton);
		
		nomeRadioButton = new JRadioButton("Nome");
		nomeRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				corsiDTM.getDataVector().removeAllElements();
				corsi=controller.recuperaCorsiOrdinatiPerNome();
				for (Vector<String> vettore : corsi) {
					corsiDTM.addRow(vettore);
				}
				corsiTable.setModel(corsiDTM);
				codiceCorsoRadioButton.setSelected(false);
				dataRadioButton.setSelected(false);
			}
		});
		nomeRadioButton.setBackground(new Color(30, 144, 255));
		nomeRadioButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeRadioButton = new GridBagConstraints();
		gbc_nomeRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_nomeRadioButton.gridx = 3;
		gbc_nomeRadioButton.gridy = 8;
		contentPane.add(nomeRadioButton, gbc_nomeRadioButton);
		
		dataRadioButton = new JRadioButton("Data");
		dataRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				corsiDTM.getDataVector().removeAllElements();
				corsi=controller.recuperaCorsiOrdinatiPerData();
				for (Vector<String> vettore : corsi) {
					corsiDTM.addRow(vettore);
				}
				corsiTable.setModel(corsiDTM);
				nomeRadioButton.setSelected(false);
				codiceCorsoRadioButton.setSelected(false);
			}
		});
		dataRadioButton.setFont(new Font("Century", Font.PLAIN, 16));
		dataRadioButton.setBackground(new Color(30, 144, 255));
		GridBagConstraints gbc_dataRadioButton = new GridBagConstraints();
		gbc_dataRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_dataRadioButton.gridx = 4;
		gbc_dataRadioButton.gridy = 8;
		contentPane.add(dataRadioButton, gbc_dataRadioButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.gridwidth = 17;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 9;
		contentPane.add(scrollPane, gbc_scrollPane);
		  
		
		corsiDTM = new DefaultTableModel();
		corsiDTM.addColumn("Codice");
		corsiDTM.addColumn("Nome");
		corsiDTM.addColumn("Descrizione");
		corsiDTM.addColumn("Data");
		corsiDTM.addColumn("Categoria");
		corsiDTM.addColumn("Responsabile");
		corsiDTM=setDefaultTableModel(corsiDTM);
		
		corsiTable = new JTable();
		corsiTable.setModel(corsiDTM);
		corsiTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		corsiTable.getColumnModel().getColumn(0).setResizable(false);
		corsiTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		
		corsiTable.getColumnModel().getColumn(1).setResizable(false);
		corsiTable.getColumnModel().getColumn(1).setPreferredWidth(145);
		
		corsiTable.getColumnModel().getColumn(2).setResizable(false);
		corsiTable.getColumnModel().getColumn(2).setPreferredWidth(310);
		
		corsiTable.getColumnModel().getColumn(3).setResizable(false);
		
		corsiTable.getColumnModel().getColumn(4).setResizable(false);
		corsiTable.getColumnModel().getColumn(4).setPreferredWidth(160);
		
		corsiTable.getColumnModel().getColumn(5).setResizable(false);
		corsiTable.getColumnModel().getColumn(5).setPreferredWidth(160);
		
		corsiTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(corsiTable);
		
		JButton AggiungiButton = new JButton("Aggiungi");
		AggiungiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getAggiungiCorsoFrame().setVisible(true);
			}
		});
		AggiungiButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_AggiungiButton = new GridBagConstraints();
		gbc_AggiungiButton.anchor = GridBagConstraints.WEST;
		gbc_AggiungiButton.gridwidth = 2;
		gbc_AggiungiButton.insets = new Insets(0, 0, 5, 5);
		gbc_AggiungiButton.gridx = 18;
		gbc_AggiungiButton.gridy = 9;
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
		gbc_ModificaButton.gridwidth = 2;
		gbc_ModificaButton.anchor = GridBagConstraints.WEST;
		gbc_ModificaButton.insets = new Insets(0, 0, 5, 5);
		gbc_ModificaButton.gridx = 18;
		gbc_ModificaButton.gridy = 10;
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
					corsiTable.setModel(setDefaultTableModel(corsiDTM));
				}
			}
		});
		EliminaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_EliminaButton = new GridBagConstraints();
		gbc_EliminaButton.gridwidth = 2;
		gbc_EliminaButton.insets = new Insets(0, 0, 5, 5);
		gbc_EliminaButton.anchor = GridBagConstraints.WEST;
		gbc_EliminaButton.gridx = 18;
		gbc_EliminaButton.gridy = 11;
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
				}
			}
		});
		StatisticheButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_StatisticheButton = new GridBagConstraints();
		gbc_StatisticheButton.gridwidth = 2;
		gbc_StatisticheButton.insets = new Insets(0, 0, 5, 5);
		gbc_StatisticheButton.anchor = GridBagConstraints.WEST;
		gbc_StatisticheButton.gridx = 18;
		gbc_StatisticheButton.gridy = 12;
		contentPane.add(StatisticheButton, gbc_StatisticheButton);
	
	}
	
	
	public DefaultTableModel setDefaultTableModel(DefaultTableModel defaultTableModel){
		Vector<Vector<String>> corsi = new Vector<Vector<String>>();
		
		corsi=controller.recuperaCorsi();
		for (Vector<String> vettore : corsi) {
			defaultTableModel.addRow(vettore);
		}
		
		return defaultTableModel;
	}
	

}

