import java.awt.BorderLayout;
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

public class LezioniFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTable lezioniTable;
	private DefaultTableModel lezioniDTM;
	private Vector<Vector<String>> listaLezioni = new Vector<Vector<String>>();
	private JButton EliminaButton;
	private JButton AggiungiButton;
	private JButton modificaButton;
	private JButton presenzeButton;
	
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


	public LezioniFrame(Controller c) {
		controller=c;
		setTitle("Lezioni");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{265, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{38, 0, 251, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lezioniDTM = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		};
		lezioniDTM.addColumn("Codice Lezione");
		lezioniDTM.addColumn("Titolo");
		lezioniDTM.addColumn("Descrizione");
		lezioniDTM.addColumn("Data Inizio");
		lezioniDTM.addColumn("Sede");
		lezioniDTM.addColumn("Aula");
		
		EliminaButton = new JButton("Elimina");
		EliminaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.eliminaLezione(lezioniTable.getValueAt(lezioniTable.getSelectedRow(),0).toString());
				lezioniDTM.getDataVector().removeAllElements();
				listaLezioni=controller.recuperaLezioni(controller.getRicercaCorsoFrame().getCorsiTable().getValueAt(controller.getRicercaCorsoFrame().getCorsiTable().getSelectedRow(), 0).toString());
				lezioniDTM=controller.setDefaultTableModel(lezioniDTM, listaLezioni);
				
				lezioniTable.setModel(lezioniDTM);
			}
		});
		GridBagConstraints gbc_EliminaButton = new GridBagConstraints();
		gbc_EliminaButton.insets = new Insets(0, 0, 5, 5);
		gbc_EliminaButton.gridx = 0;
		gbc_EliminaButton.gridy = 1;
		contentPane.add(EliminaButton, gbc_EliminaButton);
		
		AggiungiButton = new JButton("Aggiungi");
		AggiungiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getAggiungiLezioneFrame().setVisible(true);
			}
		});
		GridBagConstraints gbc_AggiungiButton = new GridBagConstraints();
		gbc_AggiungiButton.insets = new Insets(0, 0, 5, 5);
		gbc_AggiungiButton.gridx = 1;
		gbc_AggiungiButton.gridy = 1;
		contentPane.add(AggiungiButton, gbc_AggiungiButton);
		
		modificaButton = new JButton("Modifica");
		modificaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getModificaLezioneFrame().setVisible(true);
			}
		});
		GridBagConstraints gbc_modificaButton = new GridBagConstraints();
		gbc_modificaButton.insets = new Insets(0, 0, 5, 0);
		gbc_modificaButton.gridx = 2;
		gbc_modificaButton.gridy = 1;
		contentPane.add(modificaButton, gbc_modificaButton);
		
		JScrollPane lezioniScrollPane = new JScrollPane();
		GridBagConstraints gbc_lezioniScrollPane = new GridBagConstraints();
		gbc_lezioniScrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_lezioniScrollPane.fill = GridBagConstraints.BOTH;
		gbc_lezioniScrollPane.gridx = 0;
		gbc_lezioniScrollPane.gridy = 2;
		contentPane.add(lezioniScrollPane, gbc_lezioniScrollPane);
		
		lezioniTable = new JTable();
		lezioniScrollPane.setViewportView(lezioniTable);
		
		lezioniTable.setModel(lezioniDTM);
		
		presenzeButton = new JButton("presenze");
		presenzeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getPresenzeFrame().setVisible(true);
			}
		});
		GridBagConstraints gbc_presenzeButton = new GridBagConstraints();
		gbc_presenzeButton.gridx = 2;
		gbc_presenzeButton.gridy = 2;
		contentPane.add(presenzeButton, gbc_presenzeButton);
		
		
		
	}




}
