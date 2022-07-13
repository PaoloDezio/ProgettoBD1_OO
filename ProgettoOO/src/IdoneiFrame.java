import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class IdoneiFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTable studentiIdoneiTable;
	private Vector<Vector<String>> studenti;
	private DefaultTableModel studentiDTM;
	
	//GETTERS AND SETTERS
	public Vector<Vector<String>> getStudenti() {
		return studenti;
	}

	public void setStudenti(Vector<Vector<String>> studenti) {
		this.studenti = studenti;
	}

	public DefaultTableModel getStudentiDTM() {
		return studentiDTM;
	}

	public void setStudentiDTM(DefaultTableModel studentiDTM) {
		this.studentiDTM = studentiDTM;
	}

	public JTable getStudentiIdoneiTable() {
		return studentiIdoneiTable;
	}

	
	
	public IdoneiFrame(Controller mainController) {
		
		controller = mainController;
		
		setTitle("Idonei");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 330);
		
		
		//CONTENT PANE
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 147, 131, 0, 0};
		gbl_contentPane.rowHeights = new int[]{29, 0, 0, 0, 0, 0, 0, 20, 0, 35, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		//IDONEI LABEL
		JLabel IdoneiLabel = new JLabel("Studenti Idonei");
		IdoneiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_IdoneiLabel = new GridBagConstraints();
		gbc_IdoneiLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_IdoneiLabel.insets = new Insets(0, 0, 5, 5);
		gbc_IdoneiLabel.gridx = 1;
		gbc_IdoneiLabel.gridy = 0;
		contentPane.add(IdoneiLabel, gbc_IdoneiLabel);
		
		
		//STUDENTI TABLE SCROLLA PANE
		JScrollPane studentiTableScrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(studentiTableScrollPane, gbc_scrollPane);	
		
		
		//STUDENTI DEFAULT TABLE MODEL
		studentiDTM = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		};
		studentiDTM.addColumn("Codice Studente");
		studentiDTM.addColumn("Cognome");
		studentiDTM.addColumn("Nome");
		
		
		//STUDENTI IDONEI TABLE
		studentiIdoneiTable = new JTable();
		studentiIdoneiTable.setModel(studentiDTM);
		studentiIdoneiTable.setRowSelectionAllowed(false);
		studentiIdoneiTable.setFont(new Font("Century", Font.PLAIN, 14));
		studentiTableScrollPane.setViewportView(studentiIdoneiTable);
		
		studentiIdoneiTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		studentiIdoneiTable.getColumnModel().getColumn(0).setPreferredWidth(106);
		studentiIdoneiTable.getColumnModel().getColumn(0).setResizable(false);

		studentiIdoneiTable.getColumnModel().getColumn(1).setPreferredWidth(230);
		studentiIdoneiTable.getColumnModel().getColumn(1).setResizable(false);

		studentiIdoneiTable.getColumnModel().getColumn(2).setPreferredWidth(230);
		studentiIdoneiTable.getColumnModel().getColumn(2).setResizable(false);
		
		
		//INDIETRO BUTTON
		JButton IndietroButton = new JButton("Indietro");
		
		//INDIETRO BUTTON ACTION LISTENER
		IndietroButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			
			controller.getIdoneiFrame().setVisible(false);
			controller.getStatisticheFrame().setVisible(false);
			controller.getGestioneCorsiFrame().setEnabled(true);
			controller.getGestioneCorsiFrame().setVisible(true);
			}
		});
		
		GridBagConstraints gbc_IndietroButton = new GridBagConstraints();
		gbc_IndietroButton.insets = new Insets(0, 0, 5, 5);
		gbc_IndietroButton.anchor = GridBagConstraints.WEST;
		gbc_IndietroButton.gridx = 1;
		gbc_IndietroButton.gridy = 8;
		contentPane.add(IndietroButton, gbc_IndietroButton);
	}


	
}
