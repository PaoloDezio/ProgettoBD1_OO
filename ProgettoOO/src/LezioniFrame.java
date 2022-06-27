import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class LezioniFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTable lezioniTable;
	private DefaultTableModel lezioniDTM;
	private Vector<Vector<String>> listaLezioni = new Vector<Vector<String>>();
	private JButton eliminaButton;
	private JButton aggiungiButton;
	private JButton modificaButton;
	private JButton presenzeButton;
	private JLabel lezioniLabel;
	private JButton indietroButton;
	private JLabel nomeCorsoLabel;
	
	public JTable getLezioniTable() {
		return lezioniTable;
	}

	public void setLezioniTable(JTable lezioniTable) {
		this.lezioniTable = lezioniTable;
	}

	public DefaultTableModel getLezioniDTM() {
		return lezioniDTM;
	}

	public void setLezioniDTM(DefaultTableModel lezioniDTM) {
		this.lezioniDTM = lezioniDTM;
	}
	
	public Vector<Vector<String>> getListaLezioni() {
		return listaLezioni;
	}

	public void setListaLezioni(Vector<Vector<String>> listaLezioni) {
		this.listaLezioni = listaLezioni;
	}


	public JLabel getNomeCorsoLabel() {
		return nomeCorsoLabel;
	}

	public void setNomeCorsoLabel(JLabel nomeCorsoLabel) {
		this.nomeCorsoLabel = nomeCorsoLabel;
	}

	public LezioniFrame(Controller c) {
		controller=c;
		setTitle("Lezioni");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 370);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{22, 34, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 27, 0, 0, 39, 34, 36, 26, 25, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lezioniDTM = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		};
		lezioniDTM.addColumn("Codice");
		lezioniDTM.addColumn("Titolo");
		lezioniDTM.addColumn("Descrizione");
		lezioniDTM.addColumn("Data Inizio");
		lezioniDTM.addColumn("Sede");
		lezioniDTM.addColumn("Aula");
		
		aggiungiButton = new JButton("Aggiungi");
		aggiungiButton.setFont(new Font("Century", Font.PLAIN, 16));
		aggiungiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getAggiungiLezioneFrame().getNomeCorsoLabel().setText(nomeCorsoLabel.getText());;
				controller.getAggiungiLezioneFrame().setVisible(true);
			}
		});
		GridBagConstraints gbc_aggiungiButton = new GridBagConstraints();
		gbc_aggiungiButton.anchor = GridBagConstraints.WEST;
		gbc_aggiungiButton.insets = new Insets(0, 0, 5, 5);
		gbc_aggiungiButton.gridx = 9;
		gbc_aggiungiButton.gridy = 3;
		contentPane.add(aggiungiButton, gbc_aggiungiButton);
		
		nomeCorsoLabel = new JLabel("");
		nomeCorsoLabel.setFont(new Font("Century", Font.PLAIN, 23));
		GridBagConstraints gbc_nomeCorsoLabel = new GridBagConstraints();
		gbc_nomeCorsoLabel.gridwidth = 2;
		gbc_nomeCorsoLabel.anchor = GridBagConstraints.WEST;
		gbc_nomeCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeCorsoLabel.gridx = 1;
		gbc_nomeCorsoLabel.gridy = 1;
		contentPane.add(nomeCorsoLabel, gbc_nomeCorsoLabel);
	
		
		lezioniLabel = new JLabel("Lezioni");
		lezioniLabel.setFont(new Font("Century", Font.PLAIN, 22));
		GridBagConstraints gbc_lezioniLabel = new GridBagConstraints();
		gbc_lezioniLabel.anchor = GridBagConstraints.WEST;
		gbc_lezioniLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lezioniLabel.gridx = 1;
		gbc_lezioniLabel.gridy = 2;
		contentPane.add(lezioniLabel, gbc_lezioniLabel);
		
		JScrollPane lezioniScrollPane = new JScrollPane();
		GridBagConstraints gbc_lezioniScrollPane = new GridBagConstraints();
		gbc_lezioniScrollPane.gridheight = 5;
		gbc_lezioniScrollPane.gridwidth = 7;
		gbc_lezioniScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_lezioniScrollPane.fill = GridBagConstraints.BOTH;
		gbc_lezioniScrollPane.gridx = 1;
		gbc_lezioniScrollPane.gridy = 3;
		contentPane.add(lezioniScrollPane, gbc_lezioniScrollPane);
		
		lezioniTable = new JTable();
		lezioniTable.setFont(new Font("Century", Font.PLAIN, 14));
		lezioniScrollPane.setViewportView(lezioniTable);
		
		lezioniTable.setModel(lezioniDTM);
		lezioniTable.getColumnModel().getColumn(0).setPreferredWidth(20);
		lezioniTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		lezioniTable.getColumnModel().getColumn(3).setPreferredWidth(100);
		lezioniTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		lezioniTable.getColumnModel().getColumn(5).setPreferredWidth(50);



		
		modificaButton = new JButton("Modifica");
		modificaButton.setFont(new Font("Century", Font.PLAIN, 16));
		modificaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lezioniTable.getSelectedRow()>-1) {
					controller.getModificaLezioneFrame().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(contentPane,"Selezionare un corso","",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		GridBagConstraints gbc_modificaButton = new GridBagConstraints();
		gbc_modificaButton.anchor = GridBagConstraints.WEST;
		gbc_modificaButton.insets = new Insets(0, 0, 5, 5);
		gbc_modificaButton.gridx = 9;
		gbc_modificaButton.gridy = 4;
		contentPane.add(modificaButton, gbc_modificaButton);
		
		eliminaButton = new JButton("Elimina");
		eliminaButton.setFont(new Font("Century", Font.PLAIN, 16));
		eliminaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lezioniTable.getSelectedRow()>-1) {
					controller.eliminaLezione(lezioniTable.getValueAt(lezioniTable.getSelectedRow(),0).toString());
					lezioniDTM.getDataVector().removeAllElements();
					listaLezioni=controller.recuperaLezioni(controller.getRicercaCorsoFrame().getCorsiTable().getValueAt(controller.getRicercaCorsoFrame().getCorsiTable().getSelectedRow(), 0).toString());
					lezioniDTM=controller.setDefaultTableModel(lezioniDTM, listaLezioni);
					
					lezioniTable.setModel(lezioniDTM);
				}
				else {
					JOptionPane.showMessageDialog(contentPane,"Selezionare un corso","",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_eliminaButton = new GridBagConstraints();
		gbc_eliminaButton.anchor = GridBagConstraints.WEST;
		gbc_eliminaButton.insets = new Insets(0, 0, 5, 5);
		gbc_eliminaButton.gridx = 9;
		gbc_eliminaButton.gridy = 5;
		contentPane.add(eliminaButton, gbc_eliminaButton);
		
		presenzeButton = new JButton("Presenze");
		presenzeButton.setFont(new Font("Century", Font.PLAIN, 16));
		presenzeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lezioniTable.getSelectedRow()>-1) {
					controller.getPresenzeFrame().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(contentPane,"Selezionare un corso","",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_presenzeButton = new GridBagConstraints();
		gbc_presenzeButton.anchor = GridBagConstraints.WEST;
		gbc_presenzeButton.insets = new Insets(0, 0, 5, 5);
		gbc_presenzeButton.gridx = 9;
		gbc_presenzeButton.gridy = 6;
		contentPane.add(presenzeButton, gbc_presenzeButton);
		
		indietroButton = new JButton("Indietro");
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getLezioniFrame().setVisible(false);
			}
		});
		indietroButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_indietroButton = new GridBagConstraints();
		gbc_indietroButton.insets = new Insets(0, 0, 0, 5);
		gbc_indietroButton.gridx = 1;
		gbc_indietroButton.gridy = 9;
		contentPane.add(indietroButton, gbc_indietroButton);
	
	}




}
