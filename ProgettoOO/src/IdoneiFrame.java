import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class IdoneiFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTable StudentiIdoeiTable;
	
	/**
	 * Create the frame.
	 */
	public IdoneiFrame(Controller c) {
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 147, 131, 0, 0};
		gbl_contentPane.rowHeights = new int[]{29, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		//		contentPane.setLayout(new MigLayout("", "[16.00][251.00,grow][][85.00][]", "[][][122.00,grow][][]"));
				
		JLabel IdoneiLabel = new JLabel("Studenti Idonei");
		IdoneiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_IdoneiLabel = new GridBagConstraints();
		gbc_IdoneiLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_IdoneiLabel.insets = new Insets(0, 0, 5, 5);
		gbc_IdoneiLabel.gridx = 1;
		gbc_IdoneiLabel.gridy = 0;
		contentPane.add(IdoneiLabel, gbc_IdoneiLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		StudentiIdoeiTable = new JTable();
		scrollPane.setViewportView(StudentiIdoeiTable);
		StudentiIdoeiTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Cognome", "Matricola"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		StudentiIdoeiTable.setEnabled(false);
						
						JButton IndietroButton = new JButton("Indietro");
						IndietroButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								c.getIdoneiFrame().setVisible(false);
								c.getStatisticheFrame().setVisible(false);
								c.getRicercaCorsoFrame().setVisible(true);
							}
						});
						
								GridBagConstraints gbc_IndietroButton = new GridBagConstraints();
								gbc_IndietroButton.insets = new Insets(0, 0, 0, 5);
								gbc_IndietroButton.anchor = GridBagConstraints.EAST;
								gbc_IndietroButton.gridx = 2;
								gbc_IndietroButton.gridy = 8;
								contentPane.add(IndietroButton, gbc_IndietroButton);
	}

}
