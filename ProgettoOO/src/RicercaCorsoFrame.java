import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RicercaCorsoFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTable CorsoTable;

	/**
	 * Create the frame.
	 */
	public RicercaCorsoFrame(Controller c) {
		setTitle("Ricerca Corso");
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 175, 600, 370);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{10, 0, 130, 130, 19, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 180, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel ricercaCorsoLabel = new JLabel("Ricerca Corso");
		ricercaCorsoLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_ricercaCorsoLabel = new GridBagConstraints();
		gbc_ricercaCorsoLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_ricercaCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ricercaCorsoLabel.gridx = 1;
		gbc_ricercaCorsoLabel.gridy = 0;
		contentPane.add(ricercaCorsoLabel, gbc_ricercaCorsoLabel);
		
		JLabel selezionaCorsoLabel = new JLabel("Selezionare un corso:");
		selezionaCorsoLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_selezionaCorsoLabel = new GridBagConstraints();
		gbc_selezionaCorsoLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_selezionaCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_selezionaCorsoLabel.gridx = 1;
		gbc_selezionaCorsoLabel.gridy = 2;
		contentPane.add(selezionaCorsoLabel, gbc_selezionaCorsoLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		CorsoTable = new JTable();
		CorsoTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(CorsoTable);
		
		JButton ModificaButton = new JButton("Modifica");
		ModificaButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_ModificaButton = new GridBagConstraints();
		gbc_ModificaButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_ModificaButton.insets = new Insets(0, 0, 0, 5);
		gbc_ModificaButton.gridx = 1;
		gbc_ModificaButton.gridy = 4;
		contentPane.add(ModificaButton, gbc_ModificaButton);
		
		JButton EliminaButton = new JButton("Elimina");
		EliminaButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_EliminaButton = new GridBagConstraints();
		gbc_EliminaButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_EliminaButton.insets = new Insets(0, 0, 0, 5);
		gbc_EliminaButton.gridx = 2;
		gbc_EliminaButton.gridy = 4;
		contentPane.add(EliminaButton, gbc_EliminaButton);
		
		JButton StatisticheButton = new JButton("Statistische");
		StatisticheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		StatisticheButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_StatisticheButton = new GridBagConstraints();
		gbc_StatisticheButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_StatisticheButton.insets = new Insets(0, 0, 0, 5);
		gbc_StatisticheButton.gridx = 3;
		gbc_StatisticheButton.gridy = 4;
		contentPane.add(StatisticheButton, gbc_StatisticheButton);
		
		JButton tornaHomeButton = new JButton("Indietro");
		tornaHomeButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tornaHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.apriHome();
				c.chiudiRicercaCorso();
			}
		});
		GridBagConstraints gbc_tornaHomeButton = new GridBagConstraints();
		gbc_tornaHomeButton.gridx = 5;
		gbc_tornaHomeButton.gridy = 4;
		contentPane.add(tornaHomeButton, gbc_tornaHomeButton);
	}

}
