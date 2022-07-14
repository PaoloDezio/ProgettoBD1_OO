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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ModificaCorsoFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTF;
	private JTextField descrizioneTF;
	private Controller controller;
	private JComboBox<String> categorieCB;
	private JTextField dataTF;
	private JComboBox<String> responsabiliCB ;
	private DefaultComboBoxModel<String> responsabiliCBM;
	private DefaultComboBoxModel<String> categorieCBM;
	
	//GETTERS AND SETTERS
	public JTextField getNomeTF() {
		return nomeTF;
	}

	public JTextField getDataTF() {
		return dataTF;
	}

	public JTextField getDescrizioneTF() {
		return descrizioneTF;
	}

	public JComboBox<String> getCategoriaCB() {
		return categorieCB;
	}

	public JComboBox<String> getResponsabileCB() {
		return responsabiliCB;
	}

	public DefaultComboBoxModel<String> getCategoriaCBM() {
		return categorieCBM;
	}


	
	public ModificaCorsoFrame(Controller mainController) {
		
		controller = mainController;
		
		setTitle("ModificaCorsoFrame");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 770, 340);
		
		
		//CONTENT PANE
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 18, 19, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		//MODIFICA CORSO LABEL
		JLabel modificaCorsoLabel = new JLabel("Modifica Corso");
		modificaCorsoLabel.setFont(new Font("Century", Font.BOLD, 25));
		GridBagConstraints gbc_modificaCorsoLabel = new GridBagConstraints();
		gbc_modificaCorsoLabel.gridwidth = 2;
		gbc_modificaCorsoLabel.anchor = GridBagConstraints.WEST;
		gbc_modificaCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_modificaCorsoLabel.gridx = 1;
		gbc_modificaCorsoLabel.gridy = 0;
		contentPane.add(modificaCorsoLabel, gbc_modificaCorsoLabel);
		
		
		//NOME CORSO LABEL
		JLabel nomeCorsoLabel = new JLabel("Nome");
		nomeCorsoLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeCorsoLabel = new GridBagConstraints();
		gbc_nomeCorsoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeCorsoLabel.anchor = GridBagConstraints.EAST;
		gbc_nomeCorsoLabel.gridx = 1;
		gbc_nomeCorsoLabel.gridy = 2;
		contentPane.add(nomeCorsoLabel, gbc_nomeCorsoLabel);
		
		
		//NOME TEXT FIELD
		nomeTF = new JTextField();
		nomeTF.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_nomeTF = new GridBagConstraints();
		gbc_nomeTF.insets = new Insets(0, 0, 5, 5);
		gbc_nomeTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeTF.gridx = 2;
		gbc_nomeTF.gridy = 2;
		contentPane.add(nomeTF, gbc_nomeTF);
		nomeTF.setColumns(10);
		
		
		//DESCRIZIONE LABEL
		JLabel descrizioneLabel = new JLabel("Descrizione");
		descrizioneLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_descrizioneLabel = new GridBagConstraints();
		gbc_descrizioneLabel.anchor = GridBagConstraints.EAST;
		gbc_descrizioneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_descrizioneLabel.gridx = 1;
		gbc_descrizioneLabel.gridy = 3;
		contentPane.add(descrizioneLabel, gbc_descrizioneLabel);
		
		
		//DESCRIZIONE TEXT FIELD
		descrizioneTF = new JTextField();
		descrizioneTF.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_descrizioneTF = new GridBagConstraints();
		gbc_descrizioneTF.insets = new Insets(0, 0, 5, 5);
		gbc_descrizioneTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_descrizioneTF.gridx = 2;
		gbc_descrizioneTF.gridy = 3;
		contentPane.add(descrizioneTF, gbc_descrizioneTF);
		descrizioneTF.setColumns(10);
		
		
		//DATA LABEL
		JLabel dataLabel = new JLabel("Data");
		dataLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_dataLabel = new GridBagConstraints();
		gbc_dataLabel.anchor = GridBagConstraints.EAST;
		gbc_dataLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dataLabel.gridx = 1;
		gbc_dataLabel.gridy = 4;
		contentPane.add(dataLabel, gbc_dataLabel);
		
		
		//DATA TEXT FIELD
		dataTF = new JTextField();
		dataTF.setToolTipText("YYYY-MM-DD");
		dataTF.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_dataTF = new GridBagConstraints();
		gbc_dataTF.insets = new Insets(0, 0, 5, 5);
		gbc_dataTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_dataTF.gridx = 2;
		gbc_dataTF.gridy = 4;
		contentPane.add(dataTF, gbc_dataTF);
		dataTF.setColumns(10);
		
		
		//CATEGORIA LABEL
		JLabel categoriaLabel = new JLabel("Categoria");
		categoriaLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_categoriaLabel = new GridBagConstraints();
		gbc_categoriaLabel.anchor = GridBagConstraints.EAST;
		gbc_categoriaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_categoriaLabel.gridx = 1;
		gbc_categoriaLabel.gridy = 5;
		contentPane.add(categoriaLabel, gbc_categoriaLabel);
		
		
		//CATEGORIE DEFAULT COMBO BOX MODEL
		categorieCBM = new DefaultComboBoxModel<String>();
		
		int numeroCategorie=controller.contaCategorie();
		String[] categorie = controller.recuperaAreeTematiche(numeroCategorie);
		
		categorieCBM = controller.setDefaultComboBoxModel(categorieCBM,categorie);
		
		
		//CATEGORIE COMBO BOX
		categorieCB = new JComboBox<String>();
		categorieCB.setModel(categorieCBM);
		categorieCB.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_categoriaCB = new GridBagConstraints();		
		gbc_categoriaCB.insets = new Insets(0, 0, 5, 5);
		gbc_categoriaCB.fill = GridBagConstraints.HORIZONTAL;
		gbc_categoriaCB.gridx = 2;
		gbc_categoriaCB.gridy = 5;
		contentPane.add(categorieCB, gbc_categoriaCB);
		
		
		//AGGIUNGI AREA TEMATICA BUTTON
		JButton aggiungiAreaTematicaButton = new JButton("Aggiungi Area Tematica");
		
		//AGGIUNGI AREA TEMATICA BUTTON ACTION LISTENER
		aggiungiAreaTematicaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.getAggiungiAreaTematicaFrame().setVisible(true);
				controller.getAggiungiAreaTematicaFrame().setAlwaysOnTop(true);
				
				setAlwaysOnTop(false);
			}
		});
		
		aggiungiAreaTematicaButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_aggiungiAreaTematicaButton = new GridBagConstraints();
		gbc_aggiungiAreaTematicaButton.insets = new Insets(0, 0, 5, 5);
		gbc_aggiungiAreaTematicaButton.gridx = 3;
		gbc_aggiungiAreaTematicaButton.gridy = 5;
		contentPane.add(aggiungiAreaTematicaButton, gbc_aggiungiAreaTematicaButton);
		
		
		//RESPONSABILE LABEL
		JLabel responsabileLabel = new JLabel("Responsabile");
		responsabileLabel.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_responsabileLabel = new GridBagConstraints();
		gbc_responsabileLabel.anchor = GridBagConstraints.EAST;
		gbc_responsabileLabel.insets = new Insets(0, 0, 5, 5);
		gbc_responsabileLabel.gridx = 1;
		gbc_responsabileLabel.gridy = 6;
		contentPane.add(responsabileLabel, gbc_responsabileLabel);
		
		
		//RESPONSABILI DEFAULT COMBO BOX MODEL
		responsabiliCBM = new DefaultComboBoxModel<String>();
		
		int numeroResponsabili = controller.contaResponsabili();
		String[] responsabili = controller.salvaResponsabili(numeroResponsabili);
		
		responsabiliCBM = controller.setDefaultComboBoxModel(responsabiliCBM, responsabili);
		
		
		//RESPONSABILI COMBO BOX
		responsabiliCB = new JComboBox<String>(responsabili);
		responsabiliCB.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_responsabileCB = new GridBagConstraints();
		gbc_responsabileCB.insets = new Insets(0, 0, 5, 5);
		gbc_responsabileCB.fill = GridBagConstraints.HORIZONTAL;
		gbc_responsabileCB.gridx = 2;
		gbc_responsabileCB.gridy = 6;
		contentPane.add(responsabiliCB, gbc_responsabileCB);
		
		
		//INDIETRO BUTTON
		JButton indietroButton = new JButton("Indietro");
		
		//INDIETRO BUTTON ACTION LISTENER
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.getModificaFrame().setVisible(false);
			}
		});
		
		indietroButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_indietroButton = new GridBagConstraints();
		gbc_indietroButton.insets = new Insets(0, 0, 0, 5);
		gbc_indietroButton.gridx = 1;
		gbc_indietroButton.gridy = 8;
		contentPane.add(indietroButton, gbc_indietroButton);
		
		
		//SALVA MODIFICHE BUTTON
		JButton salvaModificheButton = new JButton("Salva Modifiche");
		
		//SALVA MODIFICHE ACTION LISTENER
		salvaModificheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codiceCorso = "";
				
				String nomecorso = nomeTF.getText().toUpperCase();
				codiceCorso = controller.recuperaCodiceCorso(controller.getGestioneCorsiFrame().getCorsiTable().getValueAt(controller.getGestioneCorsiFrame().getCorsiTable().getSelectedRow(),1).toString());
				String descrizione = descrizioneTF.getText().toUpperCase();
				String codiceResponsabile = controller.recuperaCodiceResponsabile(responsabiliCB.getSelectedItem().toString());
				String data = dataTF.getText();
				String categoria = categorieCB.getSelectedItem().toString();
				String oldCategoria= controller.getGestioneCorsiFrame().getCorsiTable().getValueAt(controller.getGestioneCorsiFrame().getCorsiTable().getSelectedRow(),4).toString().toUpperCase();
				
				controller.modificaCorso(codiceCorso,nomecorso,descrizione,data,codiceResponsabile,categoria,oldCategoria);
				controller.getModificaFrame().setVisible(false);
				
				controller.getGestioneCorsiFrame().getCorsiDTM().getDataVector().removeAllElements();
				controller.getGestioneCorsiFrame().setCorsi(controller.recuperaCorsiOrdinatiPer("codicecorso","","",""));
				controller.getGestioneCorsiFrame().setCorsiDTM(controller.setDefaultTableModel(controller.getGestioneCorsiFrame().getCorsiDTM(), controller.getGestioneCorsiFrame().getCorsi()));
				controller.getGestioneCorsiFrame().getCorsiTable().setModel(controller.getGestioneCorsiFrame().getCorsiDTM());
			}
		});
		
		salvaModificheButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_salvaButton = new GridBagConstraints();
		gbc_salvaButton.insets = new Insets(0, 0, 0, 5);
		gbc_salvaButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_salvaButton.gridx = 3;
		gbc_salvaButton.gridy = 8;
		contentPane.add(salvaModificheButton, gbc_salvaButton);
	}
	
	
	
}
