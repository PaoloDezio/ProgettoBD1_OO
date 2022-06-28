import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StatisticheFrame extends JFrame {
	private JPanel contentPane;
	private Controller controller;
	private JTextField presenzeMinimeTF;
	private JTextField presenzeMassimeTF;
	private JTextField frequenzaMediaTF;
	private JTextField riempimentoMedioTF;
	private JTextField nomeCorsoTF;
	private JScrollPane iscrittiScrollPane; 
	private JTable iscrittiTable;
	private DefaultTableModel iscrittiDTM;
	private Vector<Vector<String>> iscritti;
	
	
	public JTable getIscrittiTable() {
		return iscrittiTable;
	}

	public void setIscrittiTable(JTable iscrittiTable) {
		this.iscrittiTable = iscrittiTable;
	}

	public DefaultTableModel getIscrittiDTM() {
		return iscrittiDTM;
	}

	public void setIscrittiDTM(DefaultTableModel iscrittiDTM) {
		this.iscrittiDTM = iscrittiDTM;
	}

	public Vector<Vector<String>> getIscritti() {
		return iscritti;
	}

	public void setIscritti(Vector<Vector<String>> iscritti) {
		this.iscritti = iscritti;
	}

	public JTextField getNomeCorsoTF() {
		return nomeCorsoTF;
	}

	public JTextField getPresenzeMinimeTF() {
		return presenzeMinimeTF;
	}

	public JTextField getPresenzeMassimeTF() {
		return presenzeMassimeTF;
	}
	
	public JTextField getFrequenzaMediaTF() {
		return frequenzaMediaTF;
	}

	public JTextField getFrequenzaMediaInPercentualeTF() {
		return riempimentoMedioTF;
	}
	
	public StatisticheFrame(Controller mainController) {
		controller = mainController;
		
		setTitle("Statistiche");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1020, 345);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{168, 130, 120, 416, 0, 25, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 61, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel statisticheLabel = new JLabel("Statistiche\r\n");
		statisticheLabel.setFont(new Font("Century", Font.PLAIN, 25));
		GridBagConstraints gbc_statisticheLabel = new GridBagConstraints();
		gbc_statisticheLabel.anchor = GridBagConstraints.WEST;
		gbc_statisticheLabel.insets = new Insets(0, 0, 5, 5);
		gbc_statisticheLabel.gridx = 0;
		gbc_statisticheLabel.gridy = 0;
		contentPane.add(statisticheLabel, gbc_statisticheLabel);
		
		JLabel nomeCorsoLabel = new JLabel("Corso ");
		nomeCorsoLabel.setAlignmentX(0.5f);
		nomeCorsoLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_nomeCorsoLabel = new GridBagConstraints();
		gbc_nomeCorsoLabel.anchor = GridBagConstraints.EAST;
		gbc_nomeCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeCorsoLabel.gridx = 0;
		gbc_nomeCorsoLabel.gridy = 1;
		contentPane.add(nomeCorsoLabel, gbc_nomeCorsoLabel);
		
		nomeCorsoTF = new JTextField();
		nomeCorsoTF.setFont(new Font("Century", Font.PLAIN, 16));
		nomeCorsoTF.setEditable(false);
		nomeCorsoTF.setColumns(10);
		nomeCorsoTF.setBorder(null);
		nomeCorsoTF.setBackground(new Color(30, 144, 255));
		GridBagConstraints gbc_corsoTF = new GridBagConstraints();
		gbc_corsoTF.gridwidth = 2;
		gbc_corsoTF.insets = new Insets(0, 0, 5, 5);
		gbc_corsoTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_corsoTF.gridx = 1;
		gbc_corsoTF.gridy = 1;
		contentPane.add(nomeCorsoTF, gbc_corsoTF);
		
		iscrittiScrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 1;
		contentPane.add(iscrittiScrollPane, gbc_scrollPane);
		
		
		iscrittiDTM = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		};
		iscrittiDTM.addColumn("Codice Studente");
		iscrittiDTM.addColumn("Cognome");
		iscrittiDTM.addColumn("Nome");
		
		iscrittiTable = new JTable();
		iscrittiTable.setFont(new Font("Century", Font.PLAIN, 14));
		iscrittiTable.setModel(iscrittiDTM);
		iscrittiTable.setRowSelectionAllowed(false);
		iscrittiScrollPane.setViewportView(iscrittiTable);
		
		JLabel presenzeMinimeLabel = new JLabel("Presenze minime");
		presenzeMinimeLabel.setAlignmentX(0.5f);
		presenzeMinimeLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_presenzeMinimeLabel = new GridBagConstraints();
		gbc_presenzeMinimeLabel.anchor = GridBagConstraints.EAST;
		gbc_presenzeMinimeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_presenzeMinimeLabel.gridx = 0;
		gbc_presenzeMinimeLabel.gridy = 2;
		contentPane.add(presenzeMinimeLabel, gbc_presenzeMinimeLabel);
		
		presenzeMinimeTF = new JTextField();
		presenzeMinimeTF.setBorder(null);
		presenzeMinimeTF.setBackground(new Color(30, 144, 255));
		presenzeMinimeTF.setFont(new Font("Century", Font.PLAIN, 16));
		presenzeMinimeTF.setEditable(false);
		GridBagConstraints gbc_presenzeMinimeTF = new GridBagConstraints();
		gbc_presenzeMinimeTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_presenzeMinimeTF.insets = new Insets(0, 0, 5, 5);
		gbc_presenzeMinimeTF.gridx = 1;
		gbc_presenzeMinimeTF.gridy = 2;
		contentPane.add(presenzeMinimeTF, gbc_presenzeMinimeTF);
		presenzeMinimeTF.setColumns(10);
		
		JLabel presenzeMassimeLabel = new JLabel("Presenze massime");
		presenzeMassimeLabel.setAlignmentX(0.5f);
		presenzeMassimeLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_presenzeMassimeLabel = new GridBagConstraints();
		gbc_presenzeMassimeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_presenzeMassimeLabel.anchor = GridBagConstraints.EAST;
		gbc_presenzeMassimeLabel.gridx = 0;
		gbc_presenzeMassimeLabel.gridy = 3;
		contentPane.add(presenzeMassimeLabel, gbc_presenzeMassimeLabel);
		
		presenzeMassimeTF = new JTextField();
		presenzeMassimeTF.setBorder(null);
		presenzeMassimeTF.setBackground(new Color(30, 144, 255));
		presenzeMassimeTF.setFont(new Font("Century", Font.PLAIN, 16));
		presenzeMassimeTF.setEditable(false);
		GridBagConstraints gbc_presenzeMassimeTF = new GridBagConstraints();
		gbc_presenzeMassimeTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_presenzeMassimeTF.insets = new Insets(0, 0, 5, 5);
		gbc_presenzeMassimeTF.gridx = 1;
		gbc_presenzeMassimeTF.gridy = 3;
		contentPane.add(presenzeMassimeTF, gbc_presenzeMassimeTF);
		presenzeMassimeTF.setColumns(10);
		
		JLabel frequenzaMediaLabel = new JLabel("Frequenza media");
		frequenzaMediaLabel.setAlignmentX(0.5f);
		frequenzaMediaLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_frequenzaMediaLabel = new GridBagConstraints();
		gbc_frequenzaMediaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_frequenzaMediaLabel.anchor = GridBagConstraints.EAST;
		gbc_frequenzaMediaLabel.gridx = 0;
		gbc_frequenzaMediaLabel.gridy = 4;
		contentPane.add(frequenzaMediaLabel, gbc_frequenzaMediaLabel);
		
		frequenzaMediaTF = new JTextField();
		frequenzaMediaTF.setBorder(null);
		frequenzaMediaTF.setBackground(new Color(30, 144, 255));
		frequenzaMediaTF.setFont(new Font("Century", Font.PLAIN, 16));
		frequenzaMediaTF.setEditable(false);
		GridBagConstraints gbc_frequenzaMediaTF = new GridBagConstraints();
		gbc_frequenzaMediaTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_frequenzaMediaTF.insets = new Insets(0, 0, 5, 5);
		gbc_frequenzaMediaTF.gridx = 1;
		gbc_frequenzaMediaTF.gridy = 4;
		contentPane.add(frequenzaMediaTF, gbc_frequenzaMediaTF);
		frequenzaMediaTF.setColumns(10);
		
		JLabel riempimentoMedioLabel = new JLabel("Riempimento medio");
		riempimentoMedioLabel.setAlignmentX(0.5f);
		riempimentoMedioLabel.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_riempimentoMedioLabel = new GridBagConstraints();
		gbc_riempimentoMedioLabel.insets = new Insets(0, 0, 5, 5);
		gbc_riempimentoMedioLabel.anchor = GridBagConstraints.EAST;
		gbc_riempimentoMedioLabel.gridx = 0;
		gbc_riempimentoMedioLabel.gridy = 5;
		contentPane.add(riempimentoMedioLabel, gbc_riempimentoMedioLabel);
		
		riempimentoMedioTF = new JTextField();
		riempimentoMedioTF.setBorder(null);
		riempimentoMedioTF.setBackground(new Color(30, 144, 255));
		riempimentoMedioTF.setFont(new Font("Century", Font.PLAIN, 16));
		riempimentoMedioTF.setEditable(false);
		GridBagConstraints gbc_riempimentoMedioTF = new GridBagConstraints();
		gbc_riempimentoMedioTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_riempimentoMedioTF.insets = new Insets(0, 0, 5, 5);
		gbc_riempimentoMedioTF.gridx = 1;
		gbc_riempimentoMedioTF.gridy = 5;
		contentPane.add(riempimentoMedioTF, gbc_riempimentoMedioTF);
		riempimentoMedioTF.setColumns(10);

		JButton indietroButton = new JButton("Indietro");
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getStatisticheFrame().setVisible(false);
				controller.getIdoneiFrame().setVisible(false);
				controller.getRicercaCorsoFrame().setVisible(true);
			}
		});
		indietroButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_indietroButton = new GridBagConstraints();
		gbc_indietroButton.insets = new Insets(0, 0, 0, 5);
		gbc_indietroButton.gridx = 0;
		gbc_indietroButton.gridy = 7;
		contentPane.add(indietroButton, gbc_indietroButton);
		
		JButton idoneiButton = new JButton("Idonei");
		idoneiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getIdoneiFrame().setVisible(true);
				controller.getIdoneiFrame().getStudentiDTM().getDataVector().removeAllElements();
				controller.getIdoneiFrame().setStudenti(controller.recuperaStudentiIdonei(controller.getRicercaCorsoFrame().getCorsiTable().getValueAt(controller.getRicercaCorsoFrame().getCorsiTable().getSelectedRow(),0).toString()));
				controller.getIdoneiFrame().setStudentiDTM(controller.setDefaultTableModel(controller.getIdoneiFrame().getStudentiDTM(), controller.getIdoneiFrame().getStudenti()));
				controller.getIdoneiFrame().getStudentiDTM().fireTableDataChanged();
				controller.getIdoneiFrame().getStudentiIdoneiTable().setModel(controller.getIdoneiFrame().getStudentiDTM());
			}
		});
		idoneiButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_idoneiButton = new GridBagConstraints();
		gbc_idoneiButton.insets = new Insets(0, 0, 0, 5);
		gbc_idoneiButton.gridx = 4;
		gbc_idoneiButton.gridy = 7;
		contentPane.add(idoneiButton, gbc_idoneiButton);

	}


}
