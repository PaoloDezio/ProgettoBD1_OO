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

	public AggiungiAreaTematicaFrame(Controller c) {
		controller = c;


		setTitle("Aggiungi Area Tematica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 285);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{20, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{27, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton confermaButton = new JButton("Conferma");
		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(areaTematicaTF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Inserire un'area tematica","",JOptionPane.INFORMATION_MESSAGE);
				}
				
				if(c.AreaTematicaIsPresentInDB(areaTematicaTF.getText().toUpperCase())) {
					JOptionPane.showMessageDialog(contentPane, "Questa area tematica è già presente nel database.\nInserirne una nuova","",JOptionPane.WARNING_MESSAGE);
					areaTematicaTF.setText("");
				}
				else {
					c.aggiungiAreaTematica(areaTematicaTF.getText().toUpperCase());
					JOptionPane.showMessageDialog(contentPane, "Nuova area tematica aggiunta correttamente","",JOptionPane.CLOSED_OPTION);
//					c.getAggiungiAreaTematicaFrame().setVisible(false);
//					c.getHomeFrame().setVisible(true);
					areaTematicaTF.setText("");
				}
			}});
		
		JButton indietroButton = new JButton("Indietro");
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.getAggiungiAreaTematicaFrame().setVisible(false);
				c.getHomeFrame().setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Aggiungi Area Tematica");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Inserisci una nuova Area Tematica");
		lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		areaTematicaTF = new JTextField();
		areaTematicaTF.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_areaTematicaTF = new GridBagConstraints();
		gbc_areaTematicaTF.gridwidth = 2;
		gbc_areaTematicaTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_areaTematicaTF.insets = new Insets(0, 0, 5, 5);
		gbc_areaTematicaTF.gridx = 1;
		gbc_areaTematicaTF.gridy = 4;
		contentPane.add(areaTematicaTF, gbc_areaTematicaTF);
		areaTematicaTF.setColumns(10);
		indietroButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_indietroButton = new GridBagConstraints();
		gbc_indietroButton.anchor = GridBagConstraints.WEST;
		gbc_indietroButton.insets = new Insets(0, 0, 5, 5);
		gbc_indietroButton.gridx = 1;
		gbc_indietroButton.gridy = 6;
		contentPane.add(indietroButton, gbc_indietroButton);
		confermaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_confermaButton = new GridBagConstraints();
		gbc_confermaButton.gridwidth = 2;
		gbc_confermaButton.insets = new Insets(0, 0, 5, 0);
		gbc_confermaButton.gridx = 2;
		gbc_confermaButton.gridy = 6;
		contentPane.add(confermaButton, gbc_confermaButton);
	}

}
