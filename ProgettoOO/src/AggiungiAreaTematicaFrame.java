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
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AggiungiAreaTematicaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField areaTematicaTF;
	private Controller controller;

	public AggiungiAreaTematicaFrame(Controller c) {
		controller = c;


		setTitle("Aggiungi Area Tematica");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 285);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{20, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{27, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel aggiungiAreaTematicaLabel = new JLabel("Aggiungi Area Tematica");
		aggiungiAreaTematicaLabel.setFont(new Font("Century", Font.PLAIN, 24));
		GridBagConstraints gbc_aggiungiAreaTematicaLabel = new GridBagConstraints();
		gbc_aggiungiAreaTematicaLabel.anchor = GridBagConstraints.WEST;
		gbc_aggiungiAreaTematicaLabel.gridwidth = 2;
		gbc_aggiungiAreaTematicaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_aggiungiAreaTematicaLabel.gridx = 1;
		gbc_aggiungiAreaTematicaLabel.gridy = 0;
		contentPane.add(aggiungiAreaTematicaLabel, gbc_aggiungiAreaTematicaLabel);
		
		JLabel nuovaAreaTematica = new JLabel("Nuova Area Tematica");
		nuovaAreaTematica.setFont(new Font("Century", Font.PLAIN, 18));
		GridBagConstraints gbc_nuovaAreaTematica = new GridBagConstraints();
		gbc_nuovaAreaTematica.gridheight = 2;
		gbc_nuovaAreaTematica.gridwidth = 2;
		gbc_nuovaAreaTematica.anchor = GridBagConstraints.WEST;
		gbc_nuovaAreaTematica.insets = new Insets(0, 0, 5, 5);
		gbc_nuovaAreaTematica.gridx = 1;
		gbc_nuovaAreaTematica.gridy = 2;
		contentPane.add(nuovaAreaTematica, gbc_nuovaAreaTematica);
		
		areaTematicaTF = new JTextField();
		areaTematicaTF.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_areaTematicaTF = new GridBagConstraints();
		gbc_areaTematicaTF.anchor = GridBagConstraints.NORTH;
		gbc_areaTematicaTF.gridwidth = 2;
		gbc_areaTematicaTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_areaTematicaTF.insets = new Insets(0, 0, 5, 5);
		gbc_areaTematicaTF.gridx = 1;
		gbc_areaTematicaTF.gridy = 4;
		contentPane.add(areaTematicaTF, gbc_areaTematicaTF);
		areaTematicaTF.setColumns(10);
		
		JButton indietroButton = new JButton("Indietro");
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getAggiungiAreaTematicaFrame().setVisible(false);
			}
		});
		indietroButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_indietroButton = new GridBagConstraints();
		gbc_indietroButton.anchor = GridBagConstraints.WEST;
		gbc_indietroButton.insets = new Insets(0, 0, 5, 5);
		gbc_indietroButton.gridx = 1;
		gbc_indietroButton.gridy = 5;
		contentPane.add(indietroButton, gbc_indietroButton);
		
		JButton confermaButton = new JButton("Conferma");
		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(areaTematicaTF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Inserire un'area tematica","",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(c.IsAreaTematicaInDB(areaTematicaTF.getText().toUpperCase())) {
					JOptionPane.showMessageDialog(contentPane, "L'area tematica '"+areaTematicaTF.getText().toUpperCase()+ "' è già presente nel database.\nInserirne una nuova.","",JOptionPane.WARNING_MESSAGE);
					areaTematicaTF.setText("");
				}
				else {
					controller.aggiungiAreaTematica(areaTematicaTF.getText().toUpperCase());
					
					controller.getModificaFrame().getCategoriaCB().removeAllItems();
					String[] categorie = controller.recuperaAreeTematiche(controller.contaCategorie());
					controller.getModificaFrame().getCategoriaCB().setModel(controller.setDefaultComboBoxModel(controller.getModificaFrame().getCategoriaCBM(),categorie));
					
					controller.getAggiungiCorsoFrame().getCategorieDTM().getDataVector().removeAllElements();
					controller.getAggiungiCorsoFrame().setCategorie(controller.recuperaAreeTematicheInVettoreDiVettoreDiStringhe(controller.contaCategorie()));
					controller.getAggiungiCorsoFrame().setCategorieDTM(controller.setDefaultTableModel(controller.getAggiungiCorsoFrame().getCategorieDTM(),controller.getAggiungiCorsoFrame().getCategorie()));
					controller.getAggiungiCorsoFrame().getCategorieTable().setModel(controller.getAggiungiCorsoFrame().getCategorieDTM());
					
					controller.getRicercaCorsoFrame().getCategorieDTM().getDataVector().removeAllElements();
					controller.getRicercaCorsoFrame().setCategorie(controller.recuperaAreeTematicheInVettoreDiVettoreDiStringhe(controller.contaCategorie()));
					controller.getRicercaCorsoFrame().setCategorieDTM(controller.setDefaultTableModel(controller.getRicercaCorsoFrame().getCategorieDTM(),controller.getRicercaCorsoFrame().getCategorie()));
					controller.getRicercaCorsoFrame().getCategorieTable().setModel(controller.getRicercaCorsoFrame().getCategorieDTM());
					
					JOptionPane.showMessageDialog(contentPane, "L'area tematica '"+areaTematicaTF.getText().toUpperCase()+"' è stata aggiunta correttamente","",JOptionPane.CLOSED_OPTION);
					areaTematicaTF.setText("");
				}
			}});
		confermaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_confermaButton = new GridBagConstraints();
		gbc_confermaButton.gridwidth = 2;
		gbc_confermaButton.insets = new Insets(0, 0, 5, 0);
		gbc_confermaButton.gridx = 3;
		gbc_confermaButton.gridy = 5;
		contentPane.add(confermaButton, gbc_confermaButton);
	}

}
