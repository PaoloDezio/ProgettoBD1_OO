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

public class RicercaCorsoFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTable table;
	private JComboBox campoCB;
	private JTextField nomeTF;
	private JLabel nomeLabel;
	private JTextField campoTF;
	private JTable CorsiTable;
	
	/**
	 * Create the frame.
	 * 
	 */
	public RicercaCorsoFrame(Controller c) throws SQLException {
		setTitle("Ricerca Corso");
		controller = c;
		
		CorsoDAO corso= new CorsoDAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 175, 740, 626);
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

		JButton cercaButton = new JButton("Cerca");
		cercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String parolachiave = campoTF.getText();
				try {
					Vector nomeColonne = new Vector();
					nomeColonne.add("Nome");
					nomeColonne.add("CodiceCorso");
		
					Vector dati;		
					
					dati = corso.ricercaCorsoPerNome(campoTF.getText());
					table = new JTable(dati,nomeColonne);	
					table.setFont(new Font("Tahoma", Font.PLAIN, 14));
					table.setFillsViewportHeight(true);
					GridBagConstraints gbc_table = new GridBagConstraints();
					gbc_table.gridheight = 3;
					gbc_table.gridwidth = 3;
					gbc_table.insets = new Insets(0, 0, 5, 5);
					gbc_table.fill = GridBagConstraints.BOTH;
					gbc_table.gridx = 1;
					gbc_table.gridy = 9;
					contentPane.add(table, gbc_table);
					
					JScrollPane scrollPane = new JScrollPane(table);
					GridBagConstraints gbc_scrollPane = new GridBagConstraints();
					gbc_scrollPane.fill = GridBagConstraints.BOTH;
					gbc_scrollPane.gridwidth = 5;
					gbc_scrollPane.gridheight = 3;
					gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
					gbc_scrollPane.gridx = 1;
					gbc_scrollPane.gridy = 10;
					getContentPane().add(scrollPane, gbc_scrollPane);
					//corso.ricercaCorsoPerParolaChiave(parolachiave);
				} catch (SQLException e1) {
					e1.printStackTrace();
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
		  
		CorsiTable = new JTable();
		CorsiTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codice", "Nome", "Area Tematica"
			}
		));
		scrollPane.setViewportView(CorsiTable);
		
		
	
//		try {
//			Vector nomeColonne = new Vector();
//			nomeColonne.add("Nome");
//			nomeColonne.add("CodiceCorso");
//
//			Vector dati;
//			String ciao=campoTF.getText();
//			System.out.print("prova"+ciao+"prova");
//
//			
//			dati = corso.ricercaCorsoPerNome(ciao);
//		
		
//		table = new JTable(dati,nomeColonne);	
//		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		table.setFillsViewportHeight(true);
//		GridBagConstraints gbc_table = new GridBagConstraints();
//		gbc_table.gridheight = 3;
//		gbc_table.gridwidth = 3;
//		gbc_table.insets = new Insets(0, 0, 5, 5);
//		gbc_table.fill = GridBagConstraints.BOTH;
//		gbc_table.gridx = 1;
//		gbc_table.gridy = 9;
//		contentPane.add(table, gbc_table);
		
//		JScrollPane scrollPane = new JScrollPane(table);
//		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
//		gbc_scrollPane.fill = GridBagConstraints.BOTH;
//		gbc_scrollPane.gridwidth = 5;
//		gbc_scrollPane.gridheight = 3;
//		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
//		gbc_scrollPane.gridx = 1;
//		gbc_scrollPane.gridy = 10;
//		getContentPane().add(scrollPane, gbc_scrollPane);
//		} catch (SQLException e1) {
//			
//		}

		JButton StatisticheButton = new JButton("Statistische");
		StatisticheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.getStatisticheFrame().setVisible(true);
				c.getRicercaCorsoFrame().setVisible(false);
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
//		NON TOCCARE NIENTE FUNZIONA NON TI PERMETTERE		
//				DefaultTableModel model = (DefaultTableModel) CorsiTable.getModel();
//				Vector<String> row = new Vector<String>();
//			    row.add("Enter data to column 1");
//			    row.add("Enter data to column 2");
//			    row.add("Enter data to column 3");
//			    model.addRow(row);
//				
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
		EliminaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_EliminaButton = new GridBagConstraints();
		gbc_EliminaButton.insets = new Insets(0, 0, 5, 0);
		gbc_EliminaButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_EliminaButton.gridx = 4;
		gbc_EliminaButton.gridy = 7;
		contentPane.add(EliminaButton, gbc_EliminaButton);
	}
	
	
	
	

}

