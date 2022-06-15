import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AggiungiLezioneFrame extends JFrame {
	private Controller controller;
	private JPanel contentPane;
	private JTextField titoloTF;
	private JTextField descrizioneTF;
	private JTextField textField_1;
	private JTextField dataLabel;

	public AggiungiLezioneFrame(Controller c) {
		setTitle("AggiungiLezione");
		controller=c;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 139, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 32, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Aggiungi Lezione");
		lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel titoloLabel = new JLabel("Titolo");
		titoloLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_titoloLabel = new GridBagConstraints();
		gbc_titoloLabel.anchor = GridBagConstraints.EAST;
		gbc_titoloLabel.insets = new Insets(0, 0, 5, 5);
		gbc_titoloLabel.gridx = 1;
		gbc_titoloLabel.gridy = 1;
		contentPane.add(titoloLabel, gbc_titoloLabel);
		
		titoloTF = new JTextField();
		titoloTF.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_titoloTF = new GridBagConstraints();
		gbc_titoloTF.insets = new Insets(0, 0, 5, 5);
		gbc_titoloTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_titoloTF.gridx = 2;
		gbc_titoloTF.gridy = 1;
		contentPane.add(titoloTF, gbc_titoloTF);
		titoloTF.setColumns(10);
		
		JLabel descrizioneLabel = new JLabel("Descrizione");
		descrizioneLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_descrizioneLabel = new GridBagConstraints();
		gbc_descrizioneLabel.anchor = GridBagConstraints.EAST;
		gbc_descrizioneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_descrizioneLabel.gridx = 1;
		gbc_descrizioneLabel.gridy = 2;
		contentPane.add(descrizioneLabel, gbc_descrizioneLabel);
		
		descrizioneTF = new JTextField();
		descrizioneTF.setFont(new Font("Century", Font.PLAIN, 16));
		descrizioneTF.setColumns(10);
		GridBagConstraints gbc_descrizioneTF = new GridBagConstraints();
		gbc_descrizioneTF.insets = new Insets(0, 0, 5, 5);
		gbc_descrizioneTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_descrizioneTF.gridx = 2;
		gbc_descrizioneTF.gridy = 2;
		contentPane.add(descrizioneTF, gbc_descrizioneTF);
		
		JLabel durataLabel = new JLabel("Durata");
		durataLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_durataLabel = new GridBagConstraints();
		gbc_durataLabel.anchor = GridBagConstraints.EAST;
		gbc_durataLabel.insets = new Insets(0, 0, 5, 5);
		gbc_durataLabel.gridx = 1;
		gbc_durataLabel.gridy = 3;
		contentPane.add(durataLabel, gbc_durataLabel);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 3;
		contentPane.add(comboBox, gbc_comboBox);
		
		JLabel dataOraInizioLabel = new JLabel("Data e Ora");
		dataOraInizioLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_dataOraInizioLabel = new GridBagConstraints();
		gbc_dataOraInizioLabel.anchor = GridBagConstraints.EAST;
		gbc_dataOraInizioLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dataOraInizioLabel.gridx = 1;
		gbc_dataOraInizioLabel.gridy = 4;
		contentPane.add(dataOraInizioLabel, gbc_dataOraInizioLabel);
		
		dataLabel = new JTextField();
		dataLabel.setFont(new Font("Century", Font.PLAIN, 16));
		dataLabel.setColumns(10);
		GridBagConstraints gbc_dataLabel = new GridBagConstraints();
		gbc_dataLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dataLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_dataLabel.gridx = 2;
		gbc_dataLabel.gridy = 4;
		contentPane.add(dataLabel, gbc_dataLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 3;
		gbc_comboBox_1.gridy = 4;
		contentPane.add(comboBox_1, gbc_comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 2;
		gbc_comboBox_2.gridy = 5;
		contentPane.add(comboBox_2, gbc_comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 2;
		gbc_comboBox_3.gridy = 6;
		contentPane.add(comboBox_3, gbc_comboBox_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Century", Font.PLAIN, 16));
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 7;
		contentPane.add(textField_1, gbc_textField_1);
		
	
	}

}
