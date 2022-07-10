import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.Insets;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PresenzeFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JButton presenteButton;
	private JTable presenzeTable;
	private DefaultTableModel presenzeDTM;
	private JScrollPane scrollPane;
	

	public JTable getPresenzeTable() {
		return presenzeTable;
	}

	public DefaultTableModel getPresenzeDTM() {
		return presenzeDTM;
	}
	
	public void setPresenzeTable(JTable presenzeTable) {
		this.presenzeTable = presenzeTable;
	}

	public void setPresenzeDTM(DefaultTableModel presenzeDTM) {
		this.presenzeDTM = presenzeDTM;
	}
	
	//PERCH� QUESTO ORA SI CHIAMA MAIN CONTROLLER?
	public PresenzeFrame(Controller mainController) {
		setTitle("Presenze");
		controller = mainController;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		presenzeDTM = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		};
		presenzeDTM.addColumn("Codice Studente");
		presenzeDTM.addColumn("Cognome");
		presenzeDTM.addColumn("Nome");
		presenzeDTM.addColumn("Presenza");
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		presenzeTable = new JTable();
		presenzeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		presenzeTable.setForeground(new Color(0, 0, 0));
		scrollPane.setViewportView(presenzeTable);
		presenzeTable.setModel(presenzeDTM);
		
		
		JButton IndietroButton = new JButton("Indietro");
		IndietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		GridBagConstraints gbc_IndietroButton = new GridBagConstraints();
		gbc_IndietroButton.insets = new Insets(0, 0, 0, 5);
		gbc_IndietroButton.gridx = 1;
		gbc_IndietroButton.gridy = 1;
		contentPane.add(IndietroButton, gbc_IndietroButton);
		
		presenteButton = new JButton("Presente");
		presenteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(presenzeTable.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(contentPane,"Selezionare uno studente","",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					if(presenzeTable.getValueAt(presenzeTable.getSelectedRow(), 3).equals("Presente")) {
						controller.eliminaPresenza(controller.getLezioniFrame().getLezioniTable().getValueAt(controller.getLezioniFrame().getLezioniTable().getSelectedRow(), 0).toString(), presenzeTable.getValueAt(presenzeTable.getSelectedRow(), 0).toString());
						presenzeTable.setValueAt("Assente", presenzeTable.getSelectedRow(), 3);
						presenzeDTM.fireTableDataChanged();
					}
					else {
						controller.inserisciPresenza(controller.getLezioniFrame().getLezioniTable().getValueAt(controller.getLezioniFrame().getLezioniTable().getSelectedRow(), 0).toString(), presenzeTable.getValueAt(presenzeTable.getSelectedRow(), 0).toString());
						presenzeTable.setValueAt("Presente", presenzeTable.getSelectedRow(), 3);
						presenzeDTM.fireTableDataChanged();
					}
				}
			}
		});
		GridBagConstraints gbc_presenteButton = new GridBagConstraints();
		gbc_presenteButton.gridx = 3;
		gbc_presenteButton.gridy = 1;
		contentPane.add(presenteButton, gbc_presenteButton);
	}



}
