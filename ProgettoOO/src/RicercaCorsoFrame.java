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
		setTitle("Ricerca Corso");
		controller = c;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(35, 50, 1300, 635);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{238, 104, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{40, 0, 0, 0, 0, 0, 62, 55, 236, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel ricercaCorsoLabel = new JLabel("Ricerca Corso");
		ricercaCorsoLabel.setFont(new Font("Century", Font.PLAIN, 25));
		GridBagConstraints gbc_ricercaCorsoLabel = new GridBagConstraints();
		gbc_ricercaCorsoLabel.gridwidth = 2;
		gbc_ricercaCorsoLabel.anchor = GridBagConstraints.WEST;
		gbc_ricercaCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ricercaCorsoLabel.gridx = 0;
		gbc_ricercaCorsoLabel.gridy = 0;
		contentPane.add(ricercaCorsoLabel, gbc_ricercaCorsoLabel);
		
				
		JLabel selezionareUnCampoLabel = new JLabel("Selezionare un campo");
		selezionareUnCampoLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_selezionareUnCampoLabel = new GridBagConstraints();
		gbc_selezionareUnCampoLabel.anchor = GridBagConstraints.EAST;
		gbc_selezionareUnCampoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_selezionareUnCampoLabel.gridx = 0;
		gbc_selezionareUnCampoLabel.gridy = 1;
		contentPane.add(selezionareUnCampoLabel, gbc_selezionareUnCampoLabel);
		
				
		JButton tornaHomeButton = new JButton("Torna alla Home");
		tornaHomeButton.setFont(new Font("Century", Font.PLAIN, 16));
		tornaHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.getHomeFrame().setVisible(true);
				c.getRicercaCorsoFrame().setVisible(false);
			}
		});
						

		String[] campi= {"Nome","Categoria","Data","Parola Chiave"};
		
		campoCB = new JComboBox(campi);
		campoCB.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_campoCB = new GridBagConstraints();
		gbc_campoCB.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoCB.insets = new Insets(0, 0, 5, 5);
		gbc_campoCB.gridx = 1;
		gbc_campoCB.gridy = 1;
		contentPane.add(campoCB, gbc_campoCB);
		
		JLabel cercaLabel = new JLabel("Cerca");
		cercaLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_cercaLabel = new GridBagConstraints();
		gbc_cercaLabel.anchor = GridBagConstraints.EAST;
		gbc_cercaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cercaLabel.gridx = 0;
		gbc_cercaLabel.gridy = 2;
		contentPane.add(cercaLabel, gbc_cercaLabel);
		
		campoTF = new JTextField();
		campoTF.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_campoTF = new GridBagConstraints();
		gbc_campoTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoTF.insets = new Insets(0, 0, 5, 5);
		gbc_campoTF.gridx = 1;
		gbc_campoTF.gridy = 2;
		contentPane.add(campoTF, gbc_campoTF);
		campoTF.setColumns(10);


		GridBagConstraints gbc_tornaHomeButton = new GridBagConstraints();
		gbc_tornaHomeButton.insets = new Insets(0, 0, 5, 5);
		gbc_tornaHomeButton.gridx = 3;
		gbc_tornaHomeButton.gridy = 3;
		contentPane.add(tornaHomeButton, gbc_tornaHomeButton);
		
		JLabel selezionaUnCorsoLabel = new JLabel("Selezionare un corso:");
		selezionaUnCorsoLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_selezionaUnCorsoLabel = new GridBagConstraints();
		gbc_selezionaUnCorsoLabel.gridwidth = 2;
		gbc_selezionaUnCorsoLabel.anchor = GridBagConstraints.WEST;
		gbc_selezionaUnCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_selezionaUnCorsoLabel.gridx = 0;
		gbc_selezionaUnCorsoLabel.gridy = 4;
		contentPane.add(selezionaUnCorsoLabel, gbc_selezionaUnCorsoLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 5;
		contentPane.add(scrollPane, gbc_scrollPane);
		  
		
		corsiDTM = new DefaultTableModel();
		corsiDTM.addColumn("Codice");
		corsiDTM.addColumn("Nome");
		corsiDTM.addColumn("Responsabile");
		corsiDTM.addColumn("Data");
		corsiDTM.addColumn("Categoria");
		corsiDTM.addColumn("Descrizione");
		corsiDTM=resettaDefaultTableModel(corsiDTM);
		
		corsiTable = new JTable();
		corsiTable.setModel(corsiDTM);
		corsiTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		corsiTable.getColumnModel().getColumn(0).setResizable(false);
		corsiTable.getColumnModel().getColumn(0).setPreferredWidth(43);
		corsiTable.getColumnModel().getColumn(1).setResizable(false);
		corsiTable.getColumnModel().getColumn(1).setPreferredWidth(156);
		corsiTable.getColumnModel().getColumn(2).setResizable(false);
		corsiTable.getColumnModel().getColumn(3).setResizable(false);
		corsiTable.getColumnModel().getColumn(3).setPreferredWidth(110);
		corsiTable.getColumnModel().getColumn(4).setResizable(false);
		corsiTable.getColumnModel().getColumn(4).setPreferredWidth(192);
		corsiTable.getColumnModel().getColumn(5).setResizable(false);
		corsiTable.getColumnModel().getColumn(5).setPreferredWidth(192);
		corsiTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(corsiTable);
		
		JButton cercaButton = new JButton("Cerca");
		cercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				corsiDTM.getDataVector().removeAllElements();
				corsiDTM.fireTableDataChanged();

				String campo = new String(campoCB.getSelectedItem().toString());
				switch(campo) {
				case "Nome":
					corsi=c.ricercaCorsoPerNome(campoTF.getText().toUpperCase());
					for (Vector<String> vettore : corsi) {
						corsiDTM.addRow(vettore);
					}
					break;
				case "Categoria":
					corsi=c.ricercaCorsoPerCategoria(campoTF.getText().toUpperCase());
					for (Vector<String> vettore : corsi) {
						corsiDTM.addRow(vettore);
					}
					break;
				case "Data":
					corsi=c.ricercaCorsoPerData(campoTF.getText());
					for (Vector<String> vettore : corsi) {
						corsiDTM.addRow(vettore);
					}
					break;
				case "Parola Chiave":
					corsi=c.ricercaCorsoPerParolaChiave(campoTF.getText().toUpperCase());
					for (Vector<String> vettore : corsi) {
						corsiDTM.addRow(vettore);
					}
					break;
				}	
			}
		});
		cercaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_cercaButton = new GridBagConstraints();
		gbc_cercaButton.anchor = GridBagConstraints.WEST;
		gbc_cercaButton.insets = new Insets(0, 0, 5, 5);
		gbc_cercaButton.gridx = 2;
		gbc_cercaButton.gridy = 3;
		contentPane.add(cercaButton, gbc_cercaButton);
		
		
		JButton StatisticheButton = new JButton("Statistische");
		StatisticheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(corsiTable.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(contentPane,"Selezionare un corso","",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					c.getStatisticheFrame().setVisible(true);
					c.getStatisticheFrame().getCorsoTF().setText(corsiTable.getValueAt(corsiTable.getSelectedRow(),1).toString());
				}
			}
		});
		StatisticheButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_StatisticheButton = new GridBagConstraints();
		gbc_StatisticheButton.insets = new Insets(0, 0, 5, 0);
		gbc_StatisticheButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_StatisticheButton.gridx = 4;
		gbc_StatisticheButton.gridy = 5;
		contentPane.add(StatisticheButton, gbc_StatisticheButton);
		
		
		JButton ModificaButton = new JButton("Modifica");
		ModificaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(corsiTable.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(contentPane,"Selezionare un corso","",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					c.getModificaFrame().setVisible(true);
					c.getModificaFrame().setCodiceCorso(corsiTable.getValueAt(corsiTable.getSelectedRow(),0));
					c.getModificaFrame().getNomeTF().setText(corsiTable.getValueAt(corsiTable.getSelectedRow(),1).toString());
					c.getModificaFrame().getDataTF().setText(corsiTable.getValueAt(corsiTable.getSelectedRow(),3).toString());
					c.getModificaFrame().getDescrizioneTF().setText(corsiTable.getValueAt(corsiTable.getSelectedRow(),5).toString());
				}
			}			
		});
		ModificaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_ModificaButton = new GridBagConstraints();
		gbc_ModificaButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_ModificaButton.insets = new Insets(0, 0, 5, 0);
		gbc_ModificaButton.gridx = 4;
		gbc_ModificaButton.gridy = 6;
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
					c.eliminaCorsoSelezionato(codiceCorsoSelezionato);
					corsiDTM.getDataVector().removeAllElements();
					corsiTable.setModel(resettaDefaultTableModel(corsiDTM));
				}
			}
		});
		EliminaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_EliminaButton = new GridBagConstraints();
		gbc_EliminaButton.insets = new Insets(0, 0, 5, 0);
		gbc_EliminaButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_EliminaButton.gridx = 4;
		gbc_EliminaButton.gridy = 7;
		contentPane.add(EliminaButton, gbc_EliminaButton);
	}
	
	
	public DefaultTableModel resettaDefaultTableModel(DefaultTableModel defaultTableModel){
		Vector<Vector<String>> corsi = new Vector<Vector<String>>();
		
		corsi=controller.recuperaTuttiICorsi();
		for (Vector<String> vettore : corsi) {
			defaultTableModel.addRow(vettore);
		}
		
		return defaultTableModel;
	}
	

}

