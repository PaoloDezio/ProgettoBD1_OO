import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomepageFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	
	
	
	public HomepageFrame(Controller mainController) {
		
		controller = mainController;
		
		setTitle("Homepage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 175, 515, 240);
		
		
		//CONTENT PANE
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 40, 0, 118, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{40, 32, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		//GESTIONE CORSI BUTTON
		JButton gestioneCorsiButton = new JButton("Gestione Corsi");
		
		//GESTIONE CORSI BUTTON ACTION LISTENER
		gestioneCorsiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.getHomeFrame().setVisible(false);
				controller.getGestioneCorsiFrame().setVisible(true);
				controller.getGestioneCorsiFrame().getCorsiDTM().getDataVector().removeAllElements();
				controller.getGestioneCorsiFrame().setCorsi(controller.recuperaCorsiOrdinatiPer("codicecorso","","",""));
				controller.getGestioneCorsiFrame().setCorsiDTM(controller.setDefaultTableModel(controller.getGestioneCorsiFrame().getCorsiDTM(), controller.getGestioneCorsiFrame().getCorsi()));
				controller.getGestioneCorsiFrame().getCorsiTable().setModel(controller.getGestioneCorsiFrame().getCorsiDTM());		
			}});
		
		gestioneCorsiButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_gestioneCorsiButton = new GridBagConstraints();
		gbc_gestioneCorsiButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_gestioneCorsiButton.gridwidth = 2;
		gbc_gestioneCorsiButton.insets = new Insets(0, 0, 5, 5);
		gbc_gestioneCorsiButton.gridx = 1;
		gbc_gestioneCorsiButton.gridy = 1;
		contentPane.add(gestioneCorsiButton, gbc_gestioneCorsiButton);
		
		//HOMEPAGE LABEL
		JLabel homepageLabel = new JLabel("Homepage");
		homepageLabel.setFont(new Font("Century", Font.BOLD, 25));
		GridBagConstraints gbc_homeLabel = new GridBagConstraints();
		gbc_homeLabel.anchor = GridBagConstraints.NORTH;
		gbc_homeLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_homeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_homeLabel.gridx = 1;
		gbc_homeLabel.gridy = 0;
		contentPane.add(homepageLabel, gbc_homeLabel);
		
		
		//ISCRIZIONI STUDENTI BUTTON
		JButton iscrizioniStudentiButton = new JButton("Iscrizioni Studenti");
		
		//ISCRIZIONI STUDENTI BUTTON ACTION LISTENER
		iscrizioniStudentiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.getHomeFrame().setVisible(false);
				controller.getIscriviStudenteFrame().setVisible(true);
				
				controller.getIscriviStudenteFrame().getCorsoCBM().removeAllElements();
				String[] corsi = controller.recuperaCorsi(controller.contaCorsi());
				controller.getIscriviStudenteFrame().setCorsoCBM(controller.setDefaultComboBoxModel(controller.getIscriviStudenteFrame().getCorsoCBM(),corsi));
				controller.getIscriviStudenteFrame().getCorsoCB().setModel(controller.getIscriviStudenteFrame().getCorsoCBM());
				
			
			}
		});
		
		iscrizioniStudentiButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_iscrizioniStudentiButton = new GridBagConstraints();
		gbc_iscrizioniStudentiButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_iscrizioniStudentiButton.insets = new Insets(0, 0, 5, 5);
		gbc_iscrizioniStudentiButton.gridx = 3;
		gbc_iscrizioniStudentiButton.gridy = 1;
		contentPane.add(iscrizioniStudentiButton, gbc_iscrizioniStudentiButton);
		
		
		//TORNA AL LOGIN BUTTON
		JButton tornaAlLoginButton = new JButton("Torna al Login");
		
		//TORNA AL LOGIN BUTTON ACTION LISTENER
		tornaAlLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.getHomeFrame().setVisible(false);	
				controller.getLoginFrame().setVisible(true);
			}
		});
		
		tornaAlLoginButton.setFont(new Font("Century", Font.PLAIN, 16));
		GridBagConstraints gbc_tornaAlLoginButton = new GridBagConstraints();
		gbc_tornaAlLoginButton.anchor = GridBagConstraints.WEST;
		gbc_tornaAlLoginButton.gridwidth = 2;
		gbc_tornaAlLoginButton.insets = new Insets(0, 0, 5, 5);
		gbc_tornaAlLoginButton.gridx = 1;
		gbc_tornaAlLoginButton.gridy = 3;
		contentPane.add(tornaAlLoginButton, gbc_tornaAlLoginButton);
	}

	
	
}
