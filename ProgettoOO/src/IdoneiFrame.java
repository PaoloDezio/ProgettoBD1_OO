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
import javax.swing.JScrollPane;

public class IdoneiFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTable table;
	
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
		gbl_contentPane.columnWidths = new int[]{146, 0, 0};
		gbl_contentPane.rowHeights = new int[]{29, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		//		contentPane.setLayout(new MigLayout("", "[16.00][251.00,grow][][85.00][]", "[][][122.00,grow][][]"));
				
		JLabel IdoneiLabel = new JLabel("Studenti Idonei");
		IdoneiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		GridBagConstraints gbc_IdoneiLabel = new GridBagConstraints();
		gbc_IdoneiLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_IdoneiLabel.insets = new Insets(0, 0, 5, 5);
		gbc_IdoneiLabel.gridx = 0;
		gbc_IdoneiLabel.gridy = 0;
		contentPane.add(IdoneiLabel, gbc_IdoneiLabel);
				
		JButton IndietroButton = new JButton("Indietro");
		IndietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.setVisibleIdonei(false);
				c.setVisibleStatistiche(false);
				c.setVisibleRicercaCorso(true);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		GridBagConstraints gbc_IndietroButton = new GridBagConstraints();
		gbc_IndietroButton.anchor = GridBagConstraints.WEST;
		gbc_IndietroButton.gridx = 1;
		gbc_IndietroButton.gridy = 2;
		contentPane.add(IndietroButton, gbc_IndietroButton);
	}

}
