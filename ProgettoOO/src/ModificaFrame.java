import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModificaFrame extends JFrame {

	private JPanel contentPane;
	private Object codiceCorso;
	private JTextField nomeTF;
	private JTextField dataTF;
	private JTextField descrizioneTF;
	private Controller controller;
	private JComboBox categoriaCB;


	public Object getCodiceCorso() {
		return codiceCorso;
	}


	public void setCodiceCorso(Object codiceCorso) {
		this.codiceCorso = codiceCorso;
	}


	public JTextField getNomeTF() {
		return nomeTF;
	}


	public void setNomeTF(String nomeTF) {
		this.nomeTF.setText(nomeTF);
	}


	public JTextField getDataTF() {
		return dataTF;
	}


	public void setDataTF(String dataTF) {
		this.dataTF.setText(dataTF);
	}


	public JTextField getDescrizioneTF() {
		return descrizioneTF;
	}


	public void setDescrizioneTF(String descrizioneTF) {
		this.descrizioneTF.setText(descrizioneTF);
	}


	public ModificaFrame(Controller c) {
		
		controller = c;
		
		setTitle("ModificaFrame");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 18, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel modificaCorsoLabel = new JLabel("Modifica Corso");
		modificaCorsoLabel.setFont(new Font("Century", Font.BOLD, 25));
		GridBagConstraints gbc_modificaCorsoLabel = new GridBagConstraints();
		gbc_modificaCorsoLabel.anchor = GridBagConstraints.WEST;
		gbc_modificaCorsoLabel.gridwidth = 2;
		gbc_modificaCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_modificaCorsoLabel.gridx = 1;
		gbc_modificaCorsoLabel.gridy = 0;
		contentPane.add(modificaCorsoLabel, gbc_modificaCorsoLabel);
		
		JLabel nomeCorsoLabel = new JLabel("Nome");
		nomeCorsoLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeCorsoLabel = new GridBagConstraints();
		gbc_nomeCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeCorsoLabel.anchor = GridBagConstraints.EAST;
		gbc_nomeCorsoLabel.gridx = 1;
		gbc_nomeCorsoLabel.gridy = 2;
		contentPane.add(nomeCorsoLabel, gbc_nomeCorsoLabel);
		
		nomeTF = new JTextField();
		nomeTF.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeTF = new GridBagConstraints();
		gbc_nomeTF.insets = new Insets(0, 0, 5, 5);
		gbc_nomeTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeTF.gridx = 2;
		gbc_nomeTF.gridy = 2;
		contentPane.add(nomeTF, gbc_nomeTF);
		nomeTF.setColumns(10);
		
		JLabel dataLabel = new JLabel("Data");
		dataLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_dataLabel = new GridBagConstraints();
		gbc_dataLabel.anchor = GridBagConstraints.EAST;
		gbc_dataLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dataLabel.gridx = 1;
		gbc_dataLabel.gridy = 3;
		contentPane.add(dataLabel, gbc_dataLabel);
		
		dataTF = new JTextField();
		dataTF.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_dataTF = new GridBagConstraints();
		gbc_dataTF.insets = new Insets(0, 0, 5, 5);
		gbc_dataTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_dataTF.gridx = 2;
		gbc_dataTF.gridy = 3;
		contentPane.add(dataTF, gbc_dataTF);
		dataTF.setColumns(10);
		
		JLabel categoriaLabel = new JLabel("Categoria");
		categoriaLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_categoriaLabel = new GridBagConstraints();
		gbc_categoriaLabel.anchor = GridBagConstraints.EAST;
		gbc_categoriaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_categoriaLabel.gridx = 1;
		gbc_categoriaLabel.gridy = 4;
		contentPane.add(categoriaLabel, gbc_categoriaLabel);
		
		Integer numeroCategorie=c.contaCategorie();
		String[] categorie = c.salvaAreeTematiche(numeroCategorie);
//		ComboBoxModel comboBoxModel;
		
		categoriaCB = new JComboBox(categorie);
		categoriaCB.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_categoriaCB = new GridBagConstraints();
		gbc_categoriaCB.insets = new Insets(0, 0, 5, 5);
		gbc_categoriaCB.fill = GridBagConstraints.HORIZONTAL;
		gbc_categoriaCB.gridx = 2;
		gbc_categoriaCB.gridy = 4;
		contentPane.add(categoriaCB, gbc_categoriaCB);
		
		JLabel descrizioneLabel = new JLabel("Descrizione");
		descrizioneLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_descrizioneLabel = new GridBagConstraints();
		gbc_descrizioneLabel.anchor = GridBagConstraints.EAST;
		gbc_descrizioneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_descrizioneLabel.gridx = 1;
		gbc_descrizioneLabel.gridy = 5;
		contentPane.add(descrizioneLabel, gbc_descrizioneLabel);
		
		descrizioneTF = new JTextField();
		descrizioneTF.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_descrizioneTF = new GridBagConstraints();
		gbc_descrizioneTF.insets = new Insets(0, 0, 5, 5);
		gbc_descrizioneTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_descrizioneTF.gridx = 2;
		gbc_descrizioneTF.gridy = 5;
		contentPane.add(descrizioneTF, gbc_descrizioneTF);
		descrizioneTF.setColumns(10);
		
		JButton salvaModificheButton = new JButton("Salva Modifiche");
		salvaModificheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codiceCorso= c.getModificaFrame().getCodiceCorso();
				c.modificaCorso(codiceCorso,nomeTF.getText(),dataTF.getText(),categoriaCB.getSelectedItem().toString(),descrizioneTF.getText());
				c.getModificaFrame().setVisible(false);
			}
		});
		salvaModificheButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_salvaButton = new GridBagConstraints();
		gbc_salvaButton.gridheight = 2;
		gbc_salvaButton.gridwidth = 2;
		gbc_salvaButton.anchor = GridBagConstraints.EAST;
		gbc_salvaButton.insets = new Insets(0, 0, 0, 5);
		gbc_salvaButton.gridx = 2;
		gbc_salvaButton.gridy = 6;
		contentPane.add(salvaModificheButton, gbc_salvaButton);
	}

}
