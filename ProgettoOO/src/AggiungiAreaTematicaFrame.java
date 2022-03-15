import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AggiungiAreaTematicaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField areaTematicaTF;
	private Controller controller;

	/**
	 * Create the frame.
	 */
	public AggiungiAreaTematicaFrame(Controller c) {
		controller = c;
		
		AreaTematicaDAO areatematica = new AreaTematicaDAO();

		setTitle("Aggiungi Area Tematica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 287);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{27, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Aggiungi Area Tematica");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Inserisci una nuova Area Tematica");
		lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		areaTematicaTF = new JTextField();
		areaTematicaTF.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_areaTematicaTF = new GridBagConstraints();
		gbc_areaTematicaTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_areaTematicaTF.insets = new Insets(0, 0, 5, 5);
		gbc_areaTematicaTF.gridx = 1;
		gbc_areaTematicaTF.gridy = 3;
		contentPane.add(areaTematicaTF, gbc_areaTematicaTF);
		areaTematicaTF.setColumns(10);
		
		JButton confermaButton = new JButton("Conferma");
		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(areaTematicaTF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Inserire una nuova area tematica","",JOptionPane.ERROR_MESSAGE);
				}
				else {
					String categoria= areaTematicaTF.getText();
					try {
						if(areatematica.aggiungiAreaTematica(categoria)==true) {
							JOptionPane.showMessageDialog(contentPane, "Nuova area tematica aggiunta correttamente","",JOptionPane.CLOSED_OPTION);
							c.getAggiungiAreaTematicaFrame().setVisible(false);
							c.getHomeFrame().setVisible(true);
							areaTematicaTF.setText("");
						}
					} 
					catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}});
		
		JButton indietroButton = new JButton("Indietro");
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.getAggiungiAreaTematicaFrame().setVisible(false);
				c.getHomeFrame().setVisible(true);
			}
		});
		indietroButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_indietroButton = new GridBagConstraints();
		gbc_indietroButton.anchor = GridBagConstraints.WEST;
		gbc_indietroButton.insets = new Insets(0, 0, 5, 5);
		gbc_indietroButton.gridx = 1;
		gbc_indietroButton.gridy = 6;
		contentPane.add(indietroButton, gbc_indietroButton);
		confermaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_confermaButton = new GridBagConstraints();
		gbc_confermaButton.insets = new Insets(0, 0, 5, 5);
		gbc_confermaButton.gridx = 3;
		gbc_confermaButton.gridy = 6;
		contentPane.add(confermaButton, gbc_confermaButton);
	}

}
